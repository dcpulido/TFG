from obbj import diagram
from obbj import relationship
from obbj import entity

import xml.sax


# _____________________________________PARSER
#
# Clase encargada de la obtencion de datos
# del xml de entrada y del primer parseado de estos
#
#

class XMLHandler(xml.sax.ContentHandler):
    def __init__(self):
        self.CurrentDiagrams = []
        self.inRelation = False
        self.CurrentTag = ""
        self.label = ""
        self.CurrentRelations = []
        self.relation = relationship()
        self.currentModel = ""
        self.graph = False
        self.CurrentAbstractObjectes = []
        self.abstract = False
        self.abstractContent = False

    # Call when an element starts
    def startElement(self, tag, attributes):
        # HERE ATENTO A MAIL COMPROBAR SI AnADIMOS
        # EL TYPE PARA TENER EN CUENTA LA DEFINICION DE EXTENDS
        self.CurrentTag = tag
        # Extraemos el nombre de los diagramas
        if tag == 'package':
            if attributes['id'] != "Project":
                self.CurrentDiagrams.append(diagram(attributes['id']))
        # lista con elementos abstractos
        if tag == 'object':
            self.abstract = True
            self.abs = entity(attributes['id'])
        if tag == 'key' and self.abstract and \
                attributes['id'] == 'CurrentValue':
            self.abstractContent = True

        if tag == 'relationship':
            self.relation = relationship()
            self.relation.set_id(attributes['id'])
            self.inRelation = True
            self.relation.set_type(attributes['type'])
        if tag == 'role' and self.inRelation:
            ln = len(attributes['roleName'])
            if attributes['roleName'][ln - 6:ln] == "target":
                self.relation.set_target(attributes['idEntity'])
            ln = len(attributes['roleName'])
            if attributes['roleName'][ln - 6:ln] == "source":
                self.relation.set_source(attributes['idEntity'])
        if tag == 'model':
            self.currentModel = attributes['id']

        if tag == 'graph':
            self.graph = True
        # linkado de diagramas con entidades y relaciones
        if tag == 'node' and self.graph:
            for d in self.CurrentDiagrams:
                if d.name == self.currentModel:
                    if attributes['type'] == "UMLAssociation" or \
                            attributes['type'] == "Extends":
                        for r in self.CurrentRelations:
                            if attributes['id'] == r.id:
                                if r.name != "NOICON":
                                    d.relations.append(r)
                    if attributes['type'] != "UMLAssociation" and \
                            len(attributes['id']) > 2:
                        d.entities.append(entity(attributes['id']))

    # Call when an elements ends
    def endElement(self, localName):
        if self.inRelation:
            if localName == 'relationship':
                self.CurrentRelations.append(self.relation)
                self.relation = relationship()
                self.inRelation = False

        if self.graph:
            if localName == 'graph':
                self.graph = False

    def characters(self, content):
        # Call when a character is read
        if self.CurrentTag == "key" and self.inRelation:
            if content != "" and \
                    content != "INGENIAS" and \
                    content != "0" and \
                    content != "\n"and \
                    content != "LABEL" and \
                    content != "Diagrams":
                aux = content.replace("(", "")
                self.label = aux.replace(")", "")
                ln = len(self.relation.type)
                if self.relation.type[ln - 7:ln] == "Extends":
                    self.relation.set_name("Extends")
                else:
                    self.relation.set_name(self.label)

        if self.CurrentTag == "key" and self.abstractContent:
            if content == "Abstract":
                self.abs.abstract = True
                self.CurrentAbstractObjectes.append(self.abs)
                for d in self.CurrentDiagrams:
                    d.abstracts = self.CurrentAbstractObjectes
