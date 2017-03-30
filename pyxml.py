#!/usr/bin/python
#Ejemplo de uso
#python pyxml.py -i default2.xml -a david -o filename.xml
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
import os

from flask import render_template
from flask import Flask
from flask import request
from flask import redirect

import unittest
import urllib2

import ConfigParser

from pymongo import MongoClient
from bson.binary import Binary
import pickle

from app.obbj import complexRelation
from app.obbj import diagram
from app.obbj import relationship
from app.obbj import entity

from app.xmlhandler import XMLHandler
from app.parser import Parser
from app.mongohandler import mongoHandler
from app.reparser import reParser


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
        self.parser.parse("examplesXML/prueba0/ejemploMetaModelado2.xml")
        self.assertEqual(self.Handler.CurrentDiagrams[0].name,"WorkProductDiagram")
        self.assertEqual(self.Handler.CurrentDiagrams[1].name,"PhaseDiagram")
        self.assertEqual(self.Handler.CurrentDiagrams[2].name,"ActivityWPDiagram")

    def test_entityes(self):
        logging.info("TEST:enbtity")
        self.parser.parse("examplesXML/prueba0/ejemploMetaModelado2.xml")
        self.assertEqual(self.Handler.CurrentDiagrams[0].entities[0].name,"WorkProduct")

    def test_rellation(self):
        logging.info("TEST:relation")
        self.parser.parse("examplesXML/prueba0/ejemploMetaModelado2.xml")
        self.assertEqual(self.Handler.CurrentDiagrams[0].relations[0].name,"Extends")
        self.assertEqual(self.Handler.CurrentDiagrams[0].relations[0].id,"13")
        self.assertEqual(self.Handler.CurrentDiagrams[0].relations[0].source,"WorkProduct")
        self.assertEqual(self.Handler.CurrentDiagrams[0].relations[0].target,"BehaviourWP")   

    def test_autor_and_date(self):
        logging.info("TEST:autor and date")
        self.par=Parser(self.Handler.CurrentDiagrams,"examplesXML/test.xml")
        self.par.setAuthorDate("david")
        self.assertEqual(self.par.autor,"david")

    def testOutputnotNone(self):
        logging.info("TEST:output not none")
        self.par=Parser(self.Handler.CurrentDiagrams,"examplesXML/test.xml")
        self.par.setAuthorDate("david")
        self.par.toXML()
        self.assertNotEqual(open("examplesXML/filename.xml").read(),"")

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

   





##////////////////////////////////////////////////////////////////////////////////////////////////
##APP
##////////////////////////////////////////////////////////////////////////////////////////////////



    
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
     
    return redirect("http://localhost:5000/")  
    

@app.route("/operations", methods=['GET'])
def exposeOperations():
    return getEncodeOps()

@app.route("/getID", methods=['POST'])
def getID():
    logging.info("FLASK:getID url from FLASk")
    if request.method == 'POST':
        data=request.json
        cc=mongohand.getByIdMongoDB(data["id"])
        finalize_parse(cc['bin-data'],cc['output'],cc['autor'])
    return render_template('index.html')

@app.route("/delID", methods=['POST'])
def delID():
    logging.info("FLASK:delID url from FLASk")
    if request.method == 'POST':
        data=request.json
        mongohand.deleteByIdMongoDB(data["id"])
    return render_template('index.html')


##ENCODE json en cascada
def getEncodeOps():
    logging.info("FLASK encoding ops")
    ops=mongohand.initMongoDB()
    toret1=[]
    for c in ops:
        toret1.append({'id':str(c['id']),'input':str(c['input']),'autor':str(c['autor']),'output':str(c['output']),'date':str(c['date']),'diagrams':getEncodeDig(c['bin-data'])})
    str1="["
    for t in toret1:
        str1+=json.dumps(t)+","
    return str1[:len(str1)-1]+"]"

def getEncodeDig(dig):
    toret=[]
    for t in dig:
        toret.append({'name':t.name,'entities':getEncodeArr(t.entities),'relations':getEncodeRel(t.complexRelations)})
    return toret

def getEncodeArr(ent):
    toret=[]
    for t in ent:
        toret.append({'name':t.name})
    return toret
    
def getEncodeArr2(ent):
    toret=[]
    for t in ent:
        toret.append({'name':t})
    return toret

def getEncodeRel(rel):
    toret=[]
    for t in rel:
        toret.append({'name':t.name,'sources':getEncodeArr2(t.sources),'targets':getEncodeArr2(t.targets)})
    return toret

def stop_flask():
    urllib2.urlopen(flaskconf['name']+"shutdown").read()

def shutdown_server():
    func = request.environ.get('werkzeug.server.shutdown')
    if func is None:
        raise RuntimeError('Not running with the Werkzeug Server')
    func()




    

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

def remove_repeats(t):
    s=[]
    for i in t:
       if i not in s:
          s.append(i)
    return s

def remove_entities_rep(l):
    aux=[]
    for k in l:
        fl=False
        for a in aux:
            if k.name==a:fl=True
        if fl==False:
            aux.append(k.name)
        else:
            l.remove(k)
    return l

def init_the_parse(input,output,autor):
   parser = xml.sax.make_parser()
   parser.setFeature(xml.sax.handler.feature_namespaces, 0)
   logging.info("sax parser")
   
   Handler = XMLHandler()
   logging.info("new Handler")
   
   parser.setContentHandler( Handler )
   
   logging.info("Parsing file: "+input)
   parser.parse(input)
   #HERE printar relaciones y relaciones complejas
   dig=reparser.reParseDiagrams(Handler.CurrentDiagrams)

   
   #toString(dig)
   dig=reparser.definingAbstractEntities(dig)
   dig=reparser.deletingTextNotes(dig)
   dig=reparser.redefiningTargetsAndSourcesOnComplex(dig)
   mongohand.insertMongoDB(dig,input,output,autor)
   finalize_parse(dig,output,autor)

def finalize_parse(dig,output,autor):
   par=Parser(dig,output)
   par.setAuthorDate(autor)
   par.toXML()


#No usar// clase para debug
def toString(diagrams):
    for d in diagrams:
        print "//////////////////////////////NEW DIAGRAM////////////////////////////////"
        print "name "+d.name
        print
        print "relations///////////////////////////////////"
        for r in d.relations:
            print "     "+r.name
        print
        print
        print "complex////////////////////////////////////"
        for k in d.complexRelations:
            print "     "+k.name

        print
        print
        print "extends///////////////////////////////////"
        for j in d.extends:
            print "     "+j.name
            print "sources//////"
            for s in j.sources:
                print "         "+s
            print "targets//////"
            for s in j.targets:
                print "         "+s

def showDetailsDig(binData):
    aux=0
    for d in binData:
        print str(aux)+" "+d.name
        aux=aux+1
    print
    op=raw_input("selecciona una op o bien q para salir??: ")
    os.system("clear")
    if op!='q':
        try:
            showDetailsOp(binData[int(op)])
        except TypeError:
            logging.info("Dont choose comming back")
        except ValueError:
            logging.info("Dont choose comming back")


def showDetailsOp(op):
    k=""
    while k!="q":
        print "ENTITIES"
        print
        for e in op.entities:
            print "     "+e.name
        print
        print
        print "EXTENDS"
        print
        aux=0
        for r in op.extends:
            print "     "+str(aux)+" "+r.name
            aux=aux+1
        print 
        print
        print "RELATIONS"
        print
        aux=10
        for r in op.complexRelations:
            print "     "+str(aux)+" "+r.name
            aux=aux+1
        print
        k=raw_input("selecciona una op o bien q para salir??: ")
        os.system("clear")
        if k!='q':
            try:
                if len(k)==2:showDetailsRel(op.complexRelations[int(k)-10])
                if len(k)==1:showDetailsRel(op.extends[int(k)])
            except TypeError:
                logging.info("Dont choose comming back")
            except ValueError:
                logging.info("Dont choose comming back")
            except IndexError:
                logging.info("Dont choose comming back")

def showDetailsRel(rel):
    print "SOURCES"
    print
    for e in rel.sources:
        print "     "+e
    print
    print
    print "TARGETS"
    print
    for r in rel.targets:
        print "     "+r
    print
    raw_input("q??:")    
    os.system("clear")
    

def showShellOps(ops):
    logging.info("show operations on DB")
    print
    aux=0
    for o in ops:
        print str(aux)+"    "+str(o['id'])+" "+str(o['date'])+" "+str(o['autor'])+" "+str(o['input'])+" "+str(o['output'])
        aux=aux+1
    print
    op=raw_input("selecciona una op o bien q para salir??: ")
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
    os.system("clear")
    logging.basicConfig(format='%(asctime)s %(levelname)s:%(message)s', level=logging.DEBUG)
    logging.info("app init")
    mongohand=mongoHandler()
    reparser=reParser()
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
            print " "
            
            op=raw_input("op?:")
            os.system("clear")


            if op=="1":
                oper=mongohand.initMongoDB()
                dig=showShellOps(oper)
                if dig!="nope":
                    op2=raw_input("x(eliminar)/d(parsear)/dd(detalles)/q(retroceder)??:")
                    os.system("clear")
                    if op2=="d":finalize_parse(dig['bin-data'],dig['output'],dig['autor'])
                    if op2=="x":mongohand.deleteByIdMongoDB(dig['id'])
                    if op2=="dd":showDetailsDig(dig['bin-data'])
            if op=="2":
                autor=raw_input('Autor??: ')
                os.system("clear")
            if op=="3":
                xmli=raw_input('Entrada??: ')
                os.system("clear")
            if op=="4":
                xmls=raw_input('Salida??: ')
                os.system("clear")
            if op=="d":
                os.system("clear")
                init_the_parse(xmli,xmls,autor)
            if op=="x":
                os.system("clear")
                mongohand.deleteMongoDB()


        
        

