#!/usr/bin/python
#python pyxml.py ejemploMetaModelado2.xml david filename.xml
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
from flask import request

import unittest
import urllib2

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
      stop_flask()

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



##/////////////////////////////////////////////////////////////////////////////////////////////////////////
class complexRelation:
    def __init__(self,name):
        self.name=name
        self.sources=[]
        self.targets=[]
##/////////////////////////////////////////////////////////////////////////////////////////////////////////
class Parser:
    def __init__(self,diagram,filename):
      self.diagram=diagram
      self.filename=filename

    def setAuthorDate(self,autor):
      self.autor=autor
      self.date=str(datetime.datetime.today()).split()[0]

    def remove_repeats(self,ls):
        toret=[]
        for l in ls:
            fl=False
            for t in toret:
                if l == t:fl=True
            if fl==False:toret.append(l)
        return toret

    def defining_the_extends(self,relations):
        for rel in relations:
            fl=False
            for k in self.usedRelations:
                if rel.name == k.name and rel.name!='Extends':
                    fl=True
                    k.targets.append(rel.target)
                    k.sources.append(rel.source)
            if fl==False and rel.name!='Extends':
                self.currentcmplxRel=complexRelation(rel.name)
                self.currentcmplxRel.targets.append(rel.target)
                self.currentcmplxRel.sources.append(rel.source)
                self.usedRelations.append(self.currentcmplxRel)

        #definimos extends y quitamos repetidos
        for rel in relations:
            if rel.name == 'Extends':
                #extension
                source = rel.source
                #clase base
                target = rel.target

                for k in self.usedRelations:
                    sources = self.remove_repeats(k.sources)
                    targets = self.remove_repeats(k.targets)
                    for s in sources:
                        if s == target:
                            k.sources.append(source)
                    for t in targets:
                        if t == target:
                            k.targets.append(source)

        for k in self.usedRelations:
            k.sources = self.remove_repeats(k.sources)
            k.targets = self.remove_repeats(k.targets)


    def parse_relation(self,relations,diagram,di):
        self.usedRelations=[]
        self.defining_the_extends(relations)
        

        ##modificamos los targets y sources eliminando los extends
        


        for rel in self.usedRelations:

            re=ET.SubElement(diagram,"relationship",name=rel.name)
            st1=""
            st2=""
            #ewliminamos las clases abstractas de los sources y targets
            for so in rel.sources:
                fl=False
                for si in di.abstracts:
                    if si.name == so :fl=True
                if fl==False:st1+=so+", "
                
            ET.SubElement(re,"source").text=st1[0:len(st1)-2]
            for so in rel.targets:
                fl=False
                for si in di.abstracts:
                    if si.name == so :fl=True
                if fl==False:st2+=so+", "
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
            ET.SubElement(diagram,"entity").text=et.name
         ET.SubElement(diagram,"entity").text="TextNote"
         ET.SubElement(diagram,"entity").text="UMLComment"
         self.parse_relation(di.relations,diagram,di)

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

@app.route('/shutdown', methods=['GET','POST'])
def shutdown():
    shutdown_server()
    return 'Server shutting down...'

@app.route("/parse", methods=['GET', 'POST'])
def parse_xml():
   logging.info("FLASK:parse_xml")
   if request.method == 'POST':

      ou= str(request.form.get('output'))
      inp=str(request.form.get('input'))
      au=str(request.form.get('autor'))

      logging.info("FLASK: "+ou+" "+inp+" "+au)
      init_the_parse(inp,ou,au)   
   return render_template('index.html')
def stop_flask():
    urllib2.urlopen("http://localhost:5000/shutdown").read()

def shutdown_server():
    func = request.environ.get('werkzeug.server.shutdown')
    if func is None:
        raise RuntimeError('Not running with the Werkzeug Server')
    func()
#_____________________________________TESTS____________________________________________->

class readTestCase(unittest.TestCase):
# Instanciamos nuestro objeto foo antes de correr cada prueba
    def setUp(self):
        logging.info("TEST:set up parser")
        self.parser = xml.sax.make_parser()
        self.parser.setFeature(xml.sax.handler.feature_namespaces, 0)   
        self.Handler = XMLHandler()  
        self.parser.setContentHandler( self.Handler )
 
    def test_diagrams(self):
        logging.info("TEST:diagrams")
        self.parser.parse("ejemploMetaModelado2.xml")
        self.assertEqual(self.Handler.CurrentDiagrams[0].name,"WorkProductDiagram")
        self.assertEqual(self.Handler.CurrentDiagrams[1].name,"PhaseDiagram")
        self.assertEqual(self.Handler.CurrentDiagrams[2].name,"ActivityWPDiagram")

    def test_entityes(self):
        logging.info("TEST:enbtity")
        self.parser.parse("ejemploMetaModelado2.xml")
        self.assertEqual(self.Handler.CurrentDiagrams[0].entities[0].name,"WorkProduct")

    def test_rellation(self):
        logging.info("TEST:relation")
        self.parser.parse("ejemploMetaModelado2.xml")
        self.assertEqual(self.Handler.CurrentDiagrams[0].relations[0].name,"Extends")
        self.assertEqual(self.Handler.CurrentDiagrams[0].relations[0].id,"13")
        self.assertEqual(self.Handler.CurrentDiagrams[0].relations[0].source,"WorkProduct")
        self.assertEqual(self.Handler.CurrentDiagrams[0].relations[0].target,"BehaviourWP")   

    def test_autor_and_date(self):
        logging.info("TEST:autor and date")
        self.par=Parser(self.Handler.CurrentDiagrams,"test.xml")
        self.par.setAuthorDate("david")
        self.assertEqual(self.par.autor,"david")
    def testOutputnotNone(self):
        logging.info("TEST:output not none")
        self.par=Parser(self.Handler.CurrentDiagrams,"test.xml")
        self.par.setAuthorDate("david")
        self.par.toXML()
        self.assertNotEqual(open("filename.xml").read(),"")

 

class flaskTestCase(unittest.TestCase):
    def setUp(self):
        logging.info("TEST:set up flask")
        myapp=flaskApp()
        myapp.start()


    def testGet(self):
        logging.info("TEST:doing get flask")
        self.assertNotEqual(urllib2.urlopen("http://localhost:5000/").read(),"")
        stop_flask()

  

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
   
   logging.info("Parsing file: "+input)
   parser.parse(input)


   par=Parser(Handler.CurrentDiagrams,output)
   par.setAuthorDate(autor)
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

 


if ( __name__ == "__main__"):
   logging.basicConfig(format='%(asctime)s %(levelname)s:%(message)s', level=logging.DEBUG)
   logging.info("app init")
   
   logging.info("parsing args")
   
   if len(sys.argv)<2:
        usage()
        print
        logging.info("TEST MODE")
        unittest.main()
        sys.exit(255)
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
            op=raw_input("q->salir")
            if op=="q":
                flag = False
        stop_flask()

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


   