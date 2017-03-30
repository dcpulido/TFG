##/////////////////////////////////////////////////////////////////////////////////////////////////////////
#CLASS COMPLEXRELATION
#Necesaria para traducir las relaciones simples en el reparseado
#
#
#
class complexRelation:
    def __init__(self,name):
        self.name=name
        self.sources=[]
        self.targets=[]
##/////////////////////////////////////////////////////////////////////////////////////////////////////////
#CLASS DIAGRAM
#Necesaria tanto en el primer parseado como en el reparseado, se almacena en la BD
#
#
#
class diagram:
  def __init__(self,name):
    self.name=name
    self.entities=[]
    self.relations=[]
    self.abstracts=[]
    self.complexRelations=[]
    self.extends=[]
##/////////////////////////////////////////////////////////////////////////////////////////////////////////
#CLASS RELATIONSHIP
#Relacion simple
#
#
#
class relationship:
    def __init__(self):
        self.name="none"
        self.id=0
        self.target="none"
        self.source="none"
        self.type=""
    def set_id(self,id):
        self.id=id
    def set_name(self,name):
        self.name=name
    def set_target(self,target):
        self.target=target
    def set_source(self,source):
        self.source=source
    def set_type(self,type):
        self.type=type

##/////////////////////////////////////////////////////////////////////////////////////////////////////////
#CLASS entity
#Entidad simple
#
#
#
class entity:
    def __init__(self,name):
        self.name=name
        self.nid=0
        self.abstract=False
    def set_nid(self,nid):
        self.nid=nid
    def set_abs(self,abs):
        self.abs=abs