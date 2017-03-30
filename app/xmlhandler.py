from objs import complexRelation
from objs import diagram
from objs import relationship
from objs import entity

from bson.binary import Binary
import pickle

import datetime
import time
import logging

import xml.sax
import xml.etree.cElementTree as ET
import json
from bson.objectid import ObjectId


#_____________________________________PARSER____________________________________________->
#
#Clase encargada de la obtencion de datos del xml de entrada y del primer parseado de estos
#
#
#
    
class XMLHandler( xml.sax.ContentHandler ):
   def __init__(self):
      self.CurrentDiagrams = []
      self.inRelation=False
      self.CurrentTag=""
      self.label=""
      self.CurrentRelations=[]
      self.relation=relationship()
      self.currentModel=""
      self.graph=False
      self.CurrentAbstractObjectes=[]
      self.abstract=False
      self.abstractContent=False


   # Call when an element starts
   def startElement(self, tag, attributes):   
        #HERE ATENTO A MAIL COMPROBAR SI AnADIMOS EL TYPE PARA TENER EN CUENTA LA DEFINICION DE EXTENDS
        self.CurrentTag=tag
        #Extraemos el nombre de los diagramas
        if tag =='package':
            if attributes['id']!="Project":self.CurrentDiagrams.append(diagram(attributes['id']))
        #lista con elementos abstractos
        if tag == 'object':
            self.abstract=True
            self.abs=entity(attributes['id'])
        if tag == 'key' and self.abstract==True and attributes['id']=='CurrentValue':self.abstractContent=True

        if tag == 'relationship':
            self.relation=relationship()
            self.relation.set_id(attributes['id'])
            self.inRelation=True
            self.relation.set_type(attributes['type'])
        if tag == 'role' and self.inRelation==True:
            if attributes['roleName'][len(attributes['roleName'])-6:len(attributes['roleName'])]=="target":self.relation.set_target(attributes['idEntity'])
            if attributes['roleName'][len(attributes['roleName'])-6:len(attributes['roleName'])]=="source":self.relation.set_source(attributes['idEntity'])
        if tag == 'model':self.currentModel=attributes['id']

        if tag=='graph':self.graph=True
        #linkado de diagramas con entidades y relaciones
        if tag == 'node' and self.graph==True:
            for d in self.CurrentDiagrams:
                if d.name == self.currentModel:
                    if attributes['type'] == "UMLAssociation" or attributes['type'] == "Extends":
                        for r in self.CurrentRelations:
                            if attributes['id']==r.id:
                                if r.name!="NOICON":d.relations.append(r)
                    if attributes['type']!="UMLAssociation" and len(attributes['id'])>2:
                        d.entities.append(entity(attributes['id']))


   # Call when an elements ends
   def endElement(self, localName):
        if self.inRelation :
            if localName=='relationship':
                self.CurrentRelations.append(self.relation)
                self.relation=relationship()
                self.inRelation=False  
                
        if self.graph:
            if localName=='graph':
                self.graph=False  

   # Call when a character is read
   def characters(self, content):
        if self.CurrentTag == "key" and self.inRelation==True:
            if content  != "" and content != "INGENIAS" and content != "0" and content !="\n"and content != "LABEL" and content != "Diagrams":
                aux= content.replace("(","")
                self.label=aux.replace(")","")
                if self.relation.type[len(self.relation.type)-7:len(self.relation.type)]=="Extends":self.relation.set_name("Extends")
                else:self.relation.set_name(self.label)
                
        if self.CurrentTag == "key" and self.abstractContent==True:
            if content  == "Abstract":
                self.abs.abstract=True
                self.CurrentAbstractObjectes.append(self.abs)
                for d in self.CurrentDiagrams:
                    d.abstracts=self.CurrentAbstractObjectes