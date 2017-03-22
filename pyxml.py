#!/usr/bin/python
#Ejemplo de uso
#python pyxml.py -i ejemploMetaModelado2.xml -a david -o filename.xml
import xml.sax
import xml.etree.cElementTree as ET
import json
from bson.objectid import ObjectId

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

###BD

from pymongo import MongoClient
from bson.binary import Binary
import pickle

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
    def set_id(self,id):
        self.id=id
    def set_name(self,name):
        self.name=name
    def set_target(self,target):
        self.target=target
    def set_source(self,source):
        self.source=source
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

    def remove_repeats(self,ls):
        toret=[]
        for l in ls:
            fl=False
            for t in toret:
                if l == t:fl=True
            if fl==False:toret.append(l)
        return toret


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
#Clase orientada a crear metodos accesibles mediante DBUS con el fin de proporcionar
#un metodo de comunicacion interproceso al IDE si en un futuro se quisiese implementar
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
#Clase orientada a proporcionar una interfaz web simple si no se quisiese utilizar el
#modo normal por terminal
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

      if ou=="":ou=xmls
      if inp=="":inp=xmli
      if au=="":au=autor

      logging.info("FLASK: "+ou+" "+inp+" "+au)
      init_the_parse(inp,ou,au)   
   return render_template('index.html')

@app.route("/operations", methods=['GET'])
def exposeOperations():
    return getEncodeOps()

@app.route("/getID", methods=['POST'])
def getID():
    logging.info("FLASK:postOperation url from FLASk")
    if request.method == 'POST':
        data=request.json
        cc=getByIdMongoDB(data["id"])
        finalize_parse(cc['bin-data'],cc['output'],cc['autor'])
    return render_template('index.html')

def getEncodeOps():
    logging.info("FLASK encoding ops")
    ops=initMongoDB()
    toret1=[]
    for c in ops:
        toret1.append({'id':str(c['id']),'input':str(c['input']),'autor':str(c['autor']),'output':str(c['output'])})
    str1="["
    for t in toret1:
        str1+=json.dumps(t)+","
    return str1[:len(str1)-1]+"]"

def stop_flask():
    urllib2.urlopen(flaskconf['name']+"shutdown").read()

def shutdown_server():
    func = request.environ.get('werkzeug.server.shutdown')
    if func is None:
        raise RuntimeError('Not running with the Werkzeug Server')
    func()
#_____________________________________TESTS____________________________________________->
#
# Tests
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

#_____________________________________REPARSEADO____________________________________________->
#
#Clase orientada al reparseado, una vez adquirida la informacion del xml de entrada es necesario
#volver a tratarla y reorganizarla a una forma mas simple
#
#

def reParseDiagrams(diagrams):
    logging.info("REPARSING diagrams")
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

#_____________________________________DB____________________________________________->
#
#Metodos para gestionar la interaccion con la base de datos
#
#
#

def insertMongoDB(ob,input,output,autor):
    logging.info("MONGO inserting parsed document on DB")
    client = MongoClient()
    db = client.tfg
    bytes=pickle.dumps(ob)
    result=db.ob.insert_one({'bin-data': bytes,'input':input,'autor':autor,'output':output})
    logging.info("MONGO elemnt inserted id:"+str(result.inserted_id))

def getByIdMongoDB(id):
    logging.info("MONGO get element by id")
    client = MongoClient()
    db = client.tfg
    print id
    cursor=db.ob.find({'_id':ObjectId(id)})
    toret=""
    for c in cursor:
        toret={'id':c['_id'],'bin-data':pickle.loads(c['bin-data']),'input':c['input'],'autor':c['autor'],'output':c['output']}
    return toret
    
def initMongoDB():
    logging.info("MONGO initializing DB")
    client = MongoClient()
    db = client.tfg
    cursor=db.ob.find({})
    toret=[]
    aux=0
    for c in cursor:
        aux=aux+1
        toret.append({'id':c['_id'],'bin-data':pickle.loads(c['bin-data']),'input':c['input'],'autor':c['autor'],'output':c['output']})
    logging.info("MONGO get "+ str(aux) +" elements from DB")
    return toret


def deleteMongoDB():
    logging.info("MONGO deleting instances on DB")
    client = MongoClient()
    db = client.tfg
    db.ob.delete_many({})
  

#_____________________________________MAIN____________________________________________->
#
#Hilo principal y metodos de proposito general y control de la aplicacion
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
   insertMongoDB(dig,input,output,autor)
   finalize_parse(dig,output,autor)

def finalize_parse(dig,output,autor):
   par=Parser(dig,output)
   par.setAuthorDate(autor)
   par.toXML()




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


def showShellOps(ops):
    logging.info("show operations on DB")
    print
    aux=0
    for o in ops:
        print str(aux)+"    "+str(o['id'])+" "+str(o['autor'])+" "+str(o['input'])+" "+str(o['output'])
        aux=aux+1
    print
    op=raw_input("selecciona una op o bien q para salir ")
    print
    if op!='q':
        try:
            return ops[int(op)]
        except TypeError:
            logging.info("Dont choose comming back")
        except ValueError:
            logging.info("Dont choose comming back")
    else:return "nope"

def usage():
    print "Usage:", sys.argv[0]
    print  
    print "seleccione uno de los modos"
    print 
    print " -i [ruta a xml de entrada] -s [ruta salida] -a [autor] "
    print
    print " -s modo shell interactivo (lanzar solo python pyxml.py -s)"
    print
    print " -b habilitar dominio dbus"
    print
    print " -x habilitar interfaz web en "+flaskconf['name']
    print
    print " -c Modo test"

 


if ( __name__ == "__main__"):
    logging.basicConfig(format='%(asctime)s %(levelname)s:%(message)s', level=logging.DEBUG)
    logging.info("app init")

    logging.info("get conf from conf/config.conf")
    generalconf=get_general_conf()
    dbusconf=get_dbus_conf()
    flaskconf=get_flask_conf()

    logging.info("parsing args")
    dbusMode=False
    flaskMode=False
    shellMode=False
    testMode=False
    interactiveShell=False
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
          if k=="o":ns=True
          if k=="b":dbusMode=True
          if k=="x":flaskMode=True
          if k=="c":testMode=True
          if k=="a":na=True
          if k=="s":interactiveShell=True
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
      init_the_parse(xmli,xmls,autor)   
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


#_____________________________________INTERACTIVE SHELL MODE____________________________________________->
    if interactiveShell:
        op=""
        while op!='q':
            print
            print "Si no se indica algun campo se utilizaran valores por defecto indicados en conf/config.conf"
            print
            print "         1_Seleccionar operacion guardada"
            print "         2_Indicar Autor"
            print "         3_Indicar Entrada"
            print "         4_Indicar Salida"
            print "         d_Iniciar Parseado"
            print "         x_Borrar DB"
            print "         q_Salir"
            print
            
            op=raw_input("op?:")

            if op=="1":
                oper=initMongoDB()
                dig=showShellOps(oper)
                if dig!="nope":
                    finalize_parse(dig['bin-data'],dig['output'],dig['autor'])
            if op=="2":
                autor=raw_input('Autor??: ')
            if op=="3":
                xmli=raw_input('Entrada??: ')
            if op=="4":
                xmls=raw_input('Salida??: ')
            if op=="d":
                init_the_parse(xmli,xmls,autor)
            if op=="x":
                deleteMongoDB()


        
        



   