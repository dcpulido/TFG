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


##/////////////////////////////////////////////////////////////////////////////////////////////////////////
#
#Parseador encargado de traducir los diagramas en xml
#
#
#
class Parser:
    def __init__(self,diagram,filename):
      self.diagram=diagram
      self.filename=filename

    def setAuthorDate(self,autor):
      self.autor=autor
      self.date=str(datetime.datetime.today()).split()[0]


    def parse_relation(self,relations,diagram,di):
    
        
        ##modificamos los targets y sources eliminando los extends
        for rel in relations:
            re=ET.SubElement(diagram,"relationship",name=rel.name)
            st1=""
            st2=""
            
            for so in rel.sources:
                st1+=so+", "     
            ET.SubElement(re,"source").text=st1[0:len(st1)-2]
            for so in rel.targets:
                st2+=so+", "      
            ET.SubElement(re,"target").text=st2[0:len(st2)-2]

    def toXML(self):
      root = ET.Element("filter")
      logging.info("Creating new root")

      name = ET.SubElement(root, "name").text="DPDF Model"
      author = ET.SubElement(root, "author").text=self.autor
      date = ET.SubElement(root, "date").text=self.date
      logging.info("Meta:name: "+ name +" autor: "+author+" date: "+date)
      diagrams = ET.SubElement(root,"diagrams")


      for di in self.diagram:

         logging.info("new diagram: "+di.name)
         diagram = ET.SubElement(diagrams,"diagram",name=di.name)
         for et in di.entities:
            if et.abstract!=True:
                ET.SubElement(diagram,"entity").text=et.name
         ET.SubElement(diagram,"entity").text="TextNote"
         ET.SubElement(diagram,"entity").text="UMLComment"
         self.parse_relation(di.complexRelations,diagram,di)

      tree = ET.ElementTree(root)
      logging.info("writing on: "+self.filename)
      tree.write(self.filename)
