#!/usr/bin/python

import xml.sax
import xml.etree.cElementTree as ET

import datetime
import time

import logging
import dbus
import dbus.service
import dbus.mainloop.glib
import gobject
import glib
import dbus.glib

import threading
import sys

from flask import render_template
from flask import Flask

#_____________________________________DBUS____________________________________________->

class DBUSService(threading.Thread,dbus.service.Object):
   def run(self):
      bus_name=dbus.service.BusName("com.example.service",dbus.SessionBus())
      dbus.service.Object.__init__(self, bus_name, "/com/example/service")
      logging.info("DBUS:Starting service")
      
   @dbus.service.method("com.example.service.parse_an_element")
   def parse_an_element(self,input,output,autor):
      logging.info("DBUS:Method parse_an_element called starting the parse")
      init_the_parse(input,output,autor)
      return "Doing the parse"

   @dbus.service.method("com.example.service.Salir")
   def salir(self):
      logging.info("DBUS:shutting down")
      self._loop.quit()

#_____________________________________PARSER____________________________________________->

class XMLHandler( xml.sax.ContentHandler ):
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
   def __init__(self,diagram,entities,relations,filename):
      self.diagram=diagram
      self.entities=entities
      self.relations=relations
      self.filename=filename

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

#_____________________________________FLASK____________________________________________->

class flaskApp(threading.Thread):
   def run(self):
      app.run()


app = Flask(__name__) 

@app.route("/")
def hello():
    return render_template('index.html', name=None)


def encoding_image():
   img=open("img.png", "rb") 
   return base64.b64encode(img.read())



#_____________________________________MAIN____________________________________________->

def publish_dbus():
    loop = glib.MainLoop()
    d=DBUSService()
    d.start()
    loop.run()

def init_the_parse(input,output,autor):
   parser = xml.sax.make_parser()
   parser.setFeature(xml.sax.handler.feature_namespaces, 0)
   logging.info("sax parser")
   
   Handler = XMLHandler()
   logging.info("new Handler")
   
   parser.setContentHandler( Handler )
   
   logging.info("Parsing file: "+file)
   parser.parse(file)
   
   par=Parser(Handler.CurrentDiagrams,Handler.CurrentEntities,Handler.CurrentRelations,salida)
   par.setAuthorDate("david")
   par.toXML()

def usage():
    print "Usage:", sys.argv[0]
    print  
    print "seleccione uno de los modos"
    print 
    print " -s [ruta a xml de entrada] [autor] [ruta salida]"
    print
    print " -b habilitar dominio dbus"
    print
    print " -x habilitar interfaz web en localhost:4000"
    print
    print "-xb y -bx estan disponibles"
    sys.exit(255)


if ( __name__ == "__main__"):
   logging.basicConfig(format='%(asctime)s %(levelname)s:%(message)s', level=logging.DEBUG)
   logging.info("app init")

   logging.info("parsing args")

   if len(sys.argv)<2:
      usage()
#_____________________________________SHELL MODE____________________________________________->
   if sys.argv[1]=='-s' and len(sys.argv)==5:
      logging.info("SHELL MODE")

      file=sys.argv[2]
      autor=sys.argv[3]
      salida=sys.argv[4]

      init_the_parse(file,salida,autor)
      
      logging.info("close app")
      sys.exit(255)
#________________________________________DBUS MODE___________________________________________->
   if sys.argv[1]== '-b':
      logging.info("DBUS MODE")
      gobject.threads_init()
      dbus.glib.init_threads()
      publish_dbus()
      sys.exit(255)
#_____________________________________FLASK MODE_____________________________________________->
   if sys.argv[1]== '-x':
      logging.info("FLASK MODE")
      myapp=flaskApp()
      myapp.start()
      flag=True
      while flag:
         pass
      sys.exit(255)

   if sys.argv[1]== '-xb' or sys.argv[1]== '-bx':
      logging.info("FLASK MODE")
      myapp=flaskApp()
      myapp.start()
      logging.info("DBUS MODE")
      gobject.threads_init()
      dbus.glib.init_threads()
      publish_dbus()
      sys.exit(255)

   usage()


   