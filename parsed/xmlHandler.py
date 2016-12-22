import xml.sax
import xml.etree.cElementTree as ET

#_____________________________________PARSER____________________________________________->
class diagram:
  def __init__(self,name):
    self.name=name
    self.entities=[]
    self.relations=[]
    self.abstracts=[]

class relationship:
    def __init__(self):
        self.name="none"
        self.id=0
        self.target="none"
        self.source="none"
    def set_id(self,id):
        self.id=id
    def set_name(self,name):
        self.name=name
    def set_target(self,target):
        self.target=target
    def set_source(self,source):
        self.source=source

class entity:
    def __init__(self,name):
        self.name=name
        self.nid=0
        self.abstract=False
    def set_nid(self,nid):
        self.nid=nid
    def set_abs(self,abs):
        self.abs=abs

    
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
        if tag == 'role' and self.inRelation==True:
            if attributes['roleName'][len(attributes['roleName'])-6:len(attributes['roleName'])]=="target":self.relation.set_target(attributes['idEntity'])
            if attributes['roleName'][len(attributes['roleName'])-6:len(attributes['roleName'])]=="source":self.relation.set_source(attributes['idEntity'])
        if tag == 'model':self.currentModel=attributes['id']

        if tag=='graph':self.graph=True
        #linkado de diagramas con entidades y relaciones
        if tag == 'node' and self.graph==True:
            for d in self.CurrentDiagrams:
                if d.name == self.currentModel:
                    if attributes['type'] == "UMLAssociation":
                        for r in self.CurrentRelations:
                            if attributes['id']==r.id:d.relations.append(r)
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
                self.relation.set_name(self.label)
        if self.CurrentTag == "key" and self.abstractContent==True:
            if content  == "Abstract":
                self.abs.abstract=True
                self.CurrentAbstractObjectes.append(self.abs)
                for d in self.CurrentDiagrams:
                    d.abstracts=self.CurrentAbstractObjectes
