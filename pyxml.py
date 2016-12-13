#!/usr/bin/python

import xml.sax
import xml.etree.cElementTree as ET
import datetime

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

   def setAuthorDate(self,autor):
      self.autor=autor
      self.date=str(datetime.datetime.today()).split()[0]

   def toXML(self):
      root = ET.Element("filter")
      name = ET.SubElement(root, "name").text="DPDF Model"
      author = ET.SubElement(root, "author").text=self.autor
      date = ET.SubElement(root, "date").text=self.date

      diagrams = ET.SubElement(root,"diagrams")
      for di in self.diagram:
         diagram = ET.SubElement(diagrams,"diagram",name=di)
         for et in self.entities:
            ET.SubElement(diagram,"entity").text=et
         for rel in self.relations:
            ET.SubElement(diagram,"relationship").text=rel




      tree = ET.ElementTree(root)
      tree.write("filename.xml")

  
if ( __name__ == "__main__"):
   parser = xml.sax.make_parser()
   parser.setFeature(xml.sax.handler.feature_namespaces, 0)

   Handler = MovieHandler()
   parser.setContentHandler( Handler )
   
   parser.parse("ejemploMetaModelado.xml")
   
   for rel in Handler.CurrentDiagrams:
      print rel
   print
   for rel in Handler.CurrentEntities:
      print rel
   print
  
   for rel in Handler.CurrentRelations:
      print rel

   par=Parser(Handler.CurrentDiagrams,Handler.CurrentEntities,Handler.CurrentRelations)
   par.setAuthorDate("david")
   par.toXML()
   


   