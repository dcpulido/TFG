#!/usr/bin/python

import xml.sax

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