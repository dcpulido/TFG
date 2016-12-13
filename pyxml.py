#!/usr/bin/python

import xml.sax
import xml.etree.cElementTree as ET
import datetime
import logging

class MovieHandler( xml.sax.ContentHandler ):
   def __init__(self):
      self.CurrentEntities = []
      self.CurrentDiagrams = []
      self.inRelation=False
      self.CurrentTag=""
      self.label=""
      self.CurrentRelations=[]


   # Call when an element starts
   def startElement(self, tag, attributes):   
      self.CurrentTag=tag
      if tag =='object':
         if attributes["type"]=="ingenias.editor.entities.DPDFSMMel":
            self.CurrentEntities.append(attributes["id"])
         if attributes["type"]=="ingenias.editor.entities.StructuralWP":
            self.CurrentDiagrams.append(attributes["id"])
      if tag == 'relationship':
         self.inRelation=True
      if tag=='key' and attributes['id']=='Label' and self.inRelation==True:
         pass

   # Call when an elements ends
   def endElement(self, localName):
      if self.inRelation :
         if localName=='relationship':
            self.inRelation=False   
          

   # Call when a character is read
   def characters(self, content):
      if self.CurrentTag == "key" and self.inRelation==True:
         if content  != "" and content != "INGENIAS" and content != "0" and content !="\n"and content != "LABEL" and content != "Diagrams":
            aux= content.replace("(","")
            self.label=aux.replace(")","")
            flog=False
            for r in self.CurrentRelations:
               if r== self.label:
                  flog=True
            if flog==False:self.CurrentRelations.append(self.label)


class Parser:
   def __init__(self,diagram,entities,relations):
      self.diagram=diagram
      self.entities=entities
      self.relations=relations
      self.filename="filename.xml"

   def setAuthorDate(self,autor):
      self.autor=autor
      self.date=str(datetime.datetime.today()).split()[0]

   def toXML(self):
      root = ET.Element("filter")
      logging.info("Creating new root")

      name = ET.SubElement(root, "name").text="DPDF Model"
      author = ET.SubElement(root, "author").text=self.autor
      date = ET.SubElement(root, "date").text=self.date
      logging.info("Meta:name: "+ name +" autor: "+author+" date: "+date)
      diagrams = ET.SubElement(root,"diagrams")
      for di in self.diagram:
         logging.info("new diagram: "+di)
         diagram = ET.SubElement(diagrams,"diagram",name=di)
         for et in self.entities:
            ET.SubElement(diagram,"entity").text=et
         for rel in self.relations:
            ET.SubElement(diagram,"relationship").text=rel

      tree = ET.ElementTree(root)
      logging.info("writing on: "+self.filename)
      tree.write(self.filename)

  
if ( __name__ == "__main__"):
   logging.basicConfig(format='%(asctime)s %(levelname)s:%(message)s', level=logging.DEBUG)
   logging.info("app init")

   file="ejemploMetaModelado.xml"
   
   parser = xml.sax.make_parser()
   parser.setFeature(xml.sax.handler.feature_namespaces, 0)
   logging.info("sax parser")
   
   Handler = MovieHandler()
   logging.info("new Handler")
   
   parser.setContentHandler( Handler )
   
   logging.info("Parsing file: "+file)
   parser.parse(file)
   
   

   par=Parser(Handler.CurrentDiagrams,Handler.CurrentEntities,Handler.CurrentRelations)
   par.setAuthorDate("david")
   par.toXML()
   


   