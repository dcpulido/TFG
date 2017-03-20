#!/usr/bin/python
#Ejemplo de uso
#python pyxml.py -i ejemploMetaModelado2.xml -a david -o filename.xml
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

import ConfigParser

##/////////////////////////////////////////////////////////////////////////////////////////////////////////
#
#
#
#
#
class complexRelation:
    def __init__(self,name):
        self.name=name
        self.sources=[]
        self.targets=[]
##/////////////////////////////////////////////////////////////////////////////////////////////////////////
#
#
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
#
#
#
#
#
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
##/////////////////////////////////////////////////////////////////////////////////////////////////////////
#
#
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

#_____________________________________PARSER____________________________________________->
#
#
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
#
#
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

    def remove_repeats(self,ls):
        toret=[]
        for l in ls:
            fl=False
            for t in toret:
                if l == t:fl=True
            if fl==False:toret.append(l)
        return toret
    #HERE
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
        #se recorren las relaciones metiendo en used relations las q no son de extend definiendo
        #sus multiples targets y sources
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
            ET.SubElement(diagram,"entity").text=et.name
         ET.SubElement(diagram,"entity").text="TextNote"
         ET.SubElement(diagram,"entity").text="UMLComment"
         self.parse_relation(di.complexRelations,diagram,di)

      tree = ET.ElementTree(root)
      logging.info("writing on: "+self.filename)
      tree.write(self.filename)

    
#_____________________________________DBUS____________________________________________->
#
#
#
#
#

class DBUSService(threading.Thread,dbus.service.Object):
   def run(self):
      bus_name=dbus.service.BusName("com.example.service",dbus.SessionBus())
      dbus.service.Object.__init__(self, bus_name, dbusconf['name'])
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

#_____________________________________FLASK____________________________________________->
#
#
#
#
#

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
    urllib2.urlopen(flaskconf['name']+"shutdown").read()

def shutdown_server():
    func = request.environ.get('werkzeug.server.shutdown')
    if func is None:
        raise RuntimeError('Not running with the Werkzeug Server')
    func()
#_____________________________________TESTS____________________________________________->
#
#
#
#
#

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

    def testGetCOnfigData(self):
        logging.info("TEST:config not none")
        Config = ConfigParser.ConfigParser()
        Config.read("./conf/config.conf")
        myprior= {}
        for sec in Config.sections():
                if sec == "General":
                    myprior=ConfigSectionMap(sec,Config)

        self.assertNotEqual(myprior['autor'],"")


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
#
#
#
#
#

def ConfigSectionMap(section,Config):
    dict1 = {}
    options = Config.options(section)
    for option in options:
        try:
            dict1[option] = Config.get(section, option)
            if dict1[option] == -1:
                DebugPrint("skip: %s" % option)
        except:
            print("exception on %s!" % option)
            dict1[option] = None
    return dict1

def get_general_conf():
    Config = ConfigParser.ConfigParser()
    Config.read("./conf/config.conf")
    myprior= {}
    for sec in Config.sections():
            if sec == "General":
                myprior=ConfigSectionMap(sec,Config)

    return myprior

def get_flask_conf():
    Config = ConfigParser.ConfigParser()
    Config.read("./conf/config.conf")
    myprior= {}
    for sec in Config.sections():
            if sec == "Flask":
                myprior=ConfigSectionMap(sec,Config)

    return myprior

def get_dbus_conf():
    Config = ConfigParser.ConfigParser()
    Config.read("./conf/config.conf")
    myprior= {}
    for sec in Config.sections():
            if sec == "Dbus":
                myprior=ConfigSectionMap(sec,Config)

    return myprior

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

   dig=reParseDiagrams(Handler.CurrentDiagrams)
   par=Parser(dig,output)
   par.setAuthorDate(autor)
   par.toXML()

def reParseDiagrams(diagrams):
    toret=[]
    for d in diagrams:
        di=diagram(d.name)
        for e in d.entities:
            if e.name!=di.name:di.entities.append(e)
        #se convierten las relaciones normales en relaciones complejas y se mantiene en extends las relaciones de herencia
        for r in d.relations:
            if r.name!="Extends":
                fl=True
                for c in di.complexRelations:
                    if r.name == c.name:
                        so=False
                        ta=False
                        #quitamos repes
                        for k in c.sources: 
                            if k==r.source:so=True
                        for k in c.targets: 
                            if k==r.target:ta=True
                        if so==False:c.sources.append(r.source)
                        if ta==False:c.targets.append(r.target)
                        fl=False
                if fl==True:
                    xl=complexRelation(r.name)
                    xl.sources.append(r.source)
                    xl.targets.append(r.target)
                    di.complexRelations.append(xl)
            if r.name=="Extends":
                fl=True
                for c in di.extends:
                    if r.name == c.name:
                        c.targets.append(r.target)
                        fl=False
                if fl==True:
                    xl=complexRelation(r.name)
                    xl.sources.append(r.source)
                    xl.targets.append(r.target)
                    di.extends.append(xl)
        #utilizamos la info de extends para mejorar complexRelations y resolver los extends
        #para ello creamos una relacion compleja nueva y la vamos rellenando con las sources o en caso de q la source 
        #sea abstracta con sus targets y lo mismo con los targets
        totalComplex=[]
        for do in di.complexRelations:
            complexParsed=complexRelation(do.name)
            for so in do.sources:
                fl=False
                for e in di.extends:
                    if e.sources[0]==so:
                        fl=True
                        for p in e.targets:
                            complexParsed.sources.append(p)
                if fl==False:complexParsed.sources.append(so)
            for so in do.targets:
                fl=False
                for e in di.extends:
                    if e.sources[0]==so:
                        fl=True
                        for p in e.targets:
                            complexParsed.targets.append(p)
                if fl==False:complexParsed.targets.append(so)

            totalComplex.append(complexParsed)
        di.complexRelations=totalComplex
        toret.append(di)
    return toret


#No usar// clase para debug
def toString(diagrams):
    for d in diagrams:
        print d.name
        for e in d.entities:
            print "      "+e.name
        print "/////////////"
        for r in d.relations:
            print "      "+r.name+"  "+r.source+"   "+r.target

        print "////UUUUUUU"
        for x in d.complexRelations:
            print  "             "+x.name
            print "targets"
            for k in x.targets:
                print "                       "+k
            print "sources"
            for k in x.sources:
                print "                       "+k
        print "////EXTENDS"
        for x in d.extends:
            print  "             "+x.name+"   "+x.sources[0]
            for k in x.targets:
                print k

def usage():
    print "Usage:", sys.argv[0]
    print  
    print "seleccione uno de los modos"
    print 
    print " -i [ruta a xml de entrada] -s [ruta salida] -a [autor] "
    print
    print " -b habilitar dominio dbus"
    print
    print " -x habilitar interfaz web en "+flaskconf['name']
    print
    print " -c Modo test"

 


if ( __name__ == "__main__"):
    logging.basicConfig(format='%(asctime)s %(levelname)s:%(message)s', level=logging.DEBUG)
    logging.info("app init")

    logging.info("get conf form conf/config.conf")
    generalconf=get_general_conf()
    dbusconf=get_dbus_conf()
    flaskconf=get_flask_conf()

    logging.info("parsing args")
    dbusMode=False
    flaskMode=False
    shellMode=False
    testMode=False
    na=False
    ns=False
    ni=False

    xmls=""
    xmli=""
    autor=""

    if len(sys.argv)<2:usage()

    for a in sys.argv:
      if na:
        na=False
        autor=a
      if ni:
        ni=False
        xmli=a
      if ns:
        ns=False
        xmls=a
      if a[0]=="-":
        for k in a:
          if k=="s":
            ns=True
          if k=="b":
            dbusMode=True
          if k=="x":
            flaskMode=True
          if k=="c":
            testMode=True
          if k=="a":
            na=True
          if k=="i":
            shellMode=True
            ni=True
    if xmli=="":xmli=generalconf['xmli']
    if xmls=="":xmls=generalconf['xmlo']
    if autor=="":autor=generalconf['autor']
    #_____________________________________TEST MODE____________________________________________->
    if testMode:
      usage()
      print
      logging.info("TEST MODE")
      unittest.main()
      sys.exit(255)
#_____________________________________SHELL MODE____________________________________________->
    if shellMode:
      logging.info("SHELL MODE")
      file=sys.argv[2]
      autor=sys.argv[4]
      salida=sys.argv[6]
      init_the_parse(file,salida,autor)   
      logging.info("close app")
      sys.exit(255)
#________________________________________DBUS MODE___________________________________________->
    if dbusMode and not flaskMode:
      logging.info("DBUS MODE")
      gobject.threads_init()
      dbus.glib.init_threads()
      publish_dbus()
      sys.exit(255)
#_____________________________________FLASK MODE_____________________________________________->
    if flaskMode and not dbusMode:
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

    if flaskMode and dbusMode:
      logging.info("FLASK MODE")
      myapp=flaskApp()
      myapp.start()
      logging.info("DBUS MODE")
      gobject.threads_init()
      dbus.glib.init_threads()
      publish_dbus()
      sys.exit(255)



   