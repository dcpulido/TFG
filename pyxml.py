#!/usr/bin/python
# Ejemplo de uso
# python pyxml.py -i default2.xml -a david -o filename.xml
import xml.sax
import json
import coloredlogs
import logging

from app.code_generator import Code_generator

import threading
import sys
import os

from flask import render_template
from flask import Flask
from flask import request
from flask import redirect

import urllib2

import ConfigParser

from app.xmlhandler import XMLHandler
from app.parser import Parser
from app.mongohandler import mongoHandler
from app.reparser import reParser
from app.showDetails import showDetails

# ////////////////////////////////////////////////////////////////////////////////////////////////
# APP
# ////////////////////////////////////////////////////////////////////////////////////////////////


#_____________________________________DBUS____________________________________________->
#
# Clase orientada a crear metodos accesibles mediante DBUS con el fin de proporcionar
# un metodo de comunicacion interproceso al IDE si en un futuro se quisiese implementar
#
#

# class DBUSService(threading.Thread,dbus.service.Object):
 #   def run(self):
#      bus_name=dbus.service.BusName("com.example.service",dbus.SessionBus())
#      dbus.service.Object.__init__(self, bus_name, dbusconf['name'])
#      logging.info("DBUS:Starting service")
#
#    @dbus.service.method("com.example.service.parse_an_element")
#    def parse_an_element(self,input,output,autor):
#      init_the_parse(input,output,autor)
#      return "Doing the parse"
#    @dbus.service.method("com.example.service.Salir")
#    def salir(self):
#      logging.info("DBUS:shutting down")
#      self._loop.quit()
#      stop_flask()
#

#_______________FLASK________________->
class flaskApp(threading.Thread):
    """
    Clase orientada a proporcionar una interfaz 
    web simple si no se quisiese utilizar el
    modo normal por terminal
    """

    def run(self):
        app.run()


app = Flask(__name__)


@app.route("/")
def hello():
    """
    INDEX
    :return: index.html template
    """
    return render_template('index.html', name=None)


@app.route('/shutdown', methods=['GET', 'POST'])
def shutdown():
    """
    Apagado mediante post a shutdown
    :return: 
    """
    shutdown_server()
    return 'Server shutting down...'


@app.route("/parse", methods=['GET', 'POST'])
def parse_xml():
    """
    parse xml
    :return: redirect to index
    """
    logging.info("FLASK:parse_xml")
    if request.method == 'POST':

        ou = str(request.form.get('output'))
        inp = str(request.form.get('input'))
        au = str(request.form.get('autor'))

        if ou == "":
            ou = xmls
        if inp == "":
            inp = xmli
        if au == "":
            au = autor

        logging.info("FLASK: "+ou+" "+inp+" "+au)
        init_the_parse(inp, ou, au)

    return redirect("http://localhost:5000/")


@app.route("/operations", methods=['GET'])
def exposeOperations():
    """
    get stored operations
    :return: encoded operations
    """
    return getEncodeOps()


@app.route("/getID", methods=['POST'])
def getID():
    """
    recuperar operacion por id
    :return: op
    """
    logging.info("FLASK:getID url from FLASk")
    if request.method == 'POST':
        data = request.json
        cc = mongohand.getByIdMongoDB(data["id"])
        finalize_parse(cc['bin-data'],
                       cc['output'],
                       cc['autor'])
    return render_template('index.html')


@app.route("/delID", methods=['POST'])
def delID():
    """
    eliminar operacion por ID
    """
    logging.info("FLASK:delID url from FLASk")
    if request.method == 'POST':
        data = request.json
        mongohand.deleteByIdMongoDB(data["id"])
    return render_template('index.html')


# ENCODE json en cascada
def getEncodeOps():
    """
    :return: operaciones en json
    """
    logging.info("FLASK encoding ops")
    ops = mongohand.initMongoDB()
    toret1 = []
    for c in ops:
        toret1.append({'id': str(c['id']),
                       'input': str(c['input']),
                       'autor': str(c['autor']),
                       'output': str(c['output']),
                       'date': str(c['date']),
                       'diagrams': getEncodeDig(c['bin-data'])})
    str1 = "["
    for t in toret1:
        str1 += json.dumps(t)+","
    return str1[:len(str1)-1]+"]"


def getEncodeDig(dig):
    toret = []
    for t in dig:
        toret.append({'name': t.name, 'entities': getEncodeArr(
            t.entities), 'relations': getEncodeRel(t.complexRelations)})
    return toret


def getEncodeArr(ent):
    toret = []
    for t in ent:
        toret.append({'name': t.name})
    return toret


def getEncodeArr2(ent):
    toret = []
    for t in ent:
        toret.append({'name': t})
    return toret


def getEncodeRel(rel):
    toret = []
    for t in rel:
        toret.append({'name': t.name, 'sources': getEncodeArr2(
            t.sources), 'targets': getEncodeArr2(t.targets)})
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
# Hilo principal y metodos de proposito general y control de la aplicacion
#
#
#

def ConfigSectionMap(section, Config):
    """
    :param section: seccion de archivo de conf
    :param Config: archivo conf
    :return: diccionario con valores de conf
    """
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
    """
    recupera seccion General de conf
    :return: diccionario
    """
    Config = ConfigParser.ConfigParser()
    Config.read("./conf/config.conf")
    myprior = {}
    for sec in Config.sections():
        if sec == "General":
            myprior = ConfigSectionMap(sec, Config)
    return myprior


def get_flask_conf():
    """
    recupera seccion Flask de conf
    :return: diccionario
    """
    Config = ConfigParser.ConfigParser()
    Config.read("./conf/config.conf")
    myprior = {}
    for sec in Config.sections():
        if sec == "Flask":
            myprior = ConfigSectionMap(sec, Config)
    return myprior


def get_dbus_conf():
    """
    recupera seccion Dbus de conf
    :return: diccionario
    """
    Config = ConfigParser.ConfigParser()
    Config.read("./conf/config.conf")
    myprior = {}
    for sec in Config.sections():
        if sec == "Dbus":
            myprior = ConfigSectionMap(sec, Config)
    return myprior

def init_the_parse(input, output, autor):
    """
    inicia parseo de xml
    :param input: archivo de entrada
    :param output: nombre archivo salida
    :param autor: autor de parseo
    :return: output parseado
    """
    parser = xml.sax.make_parser()
    parser.setFeature(xml.sax.handler.feature_namespaces, 0)
    logging.info("sax parser")

    Handler = XMLHandler()
    logging.info("new Handler")

    parser.setContentHandler(Handler)

    logging.info("Parsing file: "+input)
    parser.parse(input)

    # HERE printar relaciones y relaciones complejas
    dig = reparser.reParseDiagrams(Handler.CurrentDiagrams)
    # hmiDetails.toString(dig)
    dig = reparser.definingAbstractEntities(dig)
    dig = reparser.deletingTextNotes(dig)
    dig = reparser.redefiningTargetsAndSourcesOnComplex(dig)

    mongohand.insertMongoDB(dig, input, output, autor)

    finalize_parse(dig, output, autor)

def init_code_generation(obj):
    """
    inicia la generacion de codigo
    :param xmls: 
    :return: 
    """
    logging.info("Generating sources")
    ccdg=Code_generator()
    ccdg.generate(obj)


def finalize_parse(dig, output, autor):
    par = Parser(dig, output)
    par.setAuthorDate(autor)
    par.toXML()


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


if (__name__ == "__main__"):
    coloredlogs.install()
    os.system("clear")
    logging.basicConfig(
        format='%(asctime)s %(levelname)s:%(message)s', level=logging.DEBUG)
    logging.info("app init")
    mongohand = mongoHandler()
    reparser = reParser()
    hmiDetails = showDetails()
    logging.info("get conf from conf/config.conf")
    generalconf = get_general_conf()
    dbusconf = get_dbus_conf()
    flaskconf = get_flask_conf()

    logging.info("parsing args")
    dbusMode = False
    flaskMode = False
    shellMode = False
    testMode = False
    interactiveShell = False
    na = False
    ns = False
    ni = False

    xmls = ""
    xmli = ""
    autor = ""

    if len(sys.argv) < 2:
        usage()

    for a in sys.argv:
        if na:
            na = False
            autor = a
        if ni:
            ni = False
            xmli = a
        if ns:
            ns = False
            xmls = a
        if a[0] == "-":
            for k in a:
                if k == "o":
                    ns = True
                if k == "b":
                    dbusMode = True
                if k == "x":
                    flaskMode = True
                if k == "c":
                    testMode = True
                if k == "a":
                    na = True
                if k == "s":
                    interactiveShell = True
                if k == "i":
                    shellMode = True
                    ni = True
    if xmli == "":
        xmli = generalconf['xmli']
    if xmls == "":
        xmls = generalconf['xmlo']
    if autor == "":
        autor = generalconf['autor']
    # _____________________________________TEST
    # MODE____________________________________________->
    # if testMode:
    #     usage()
    #     print
    #     logging.info("TEST MODE")
    #     unittest.main()
    #     sys.exit(255)
# _____________________________________SHELL
# MODE____________________________________________->
    if shellMode:
        logging.info("SHELL MODE")
        init_the_parse(xmli, xmls, autor)
        logging.info("close app")
        sys.exit(255)
# ________________________________________DBUS
# MODE___________________________________________->
    if dbusMode and not flaskMode:
        logging.info("DBUS MODE")
#      gobject.threads_init()
#      dbus.glib.init_threads()
#      publish_dbus()
        sys.exit(255)
# _____________________________________FLASK
# MODE_____________________________________________->
    if flaskMode and not dbusMode:
        try:
            logging.info("FLASK MODE")
            myapp = flaskApp()
            myapp.start()
            flag = True
            while flag:
                op = raw_input("q->salir")
                if op == "q":
                    flag = False
            stop_flask()

            sys.exit(255)
        except KeyboardInterrupt:
            logging.critical("KeyboardInterrupt")
            stop_flask()
            sys.exit(255)

    if flaskMode and dbusMode:
        try:
            logging.info("FLASK MODE")
            myapp = flaskApp()
            myapp.start()
            logging.info("DBUS MODE")
#          gobject.threads_init()
#          dbus.glib.init_threads()
#          publish_dbus()
            sys.exit(255)
        except KeyboardInterrupt:
            logging.critical("KeyboardInterrupt")
            stop_flask()
            sys.exit(255)


# _____________________________________INTERACTIVE SHELL
# MODE____________________________________________->
    if interactiveShell:
        try:
            op = ""
            while op != 'q':
                print
                print "Si no se indica algun campo se utilizaran"
                print "valores por defecto indicados en conf/config.conf"
                print
                print "         1_Seleccionar operacion guardada"
                print "         2_Indicar Autor"
                print "         3_Indicar Entrada"
                print "         4_Indicar Salida"
                print "         d_Iniciar Parseado"
                print "         l_Lanzar Parseado"
                print "         x_Borrar DB"
                print "         q_Salir"
                print " "

                op = raw_input("op?:")
                os.system("clear")

                if op == "1":
                    oper = mongohand.initMongoDB()
                    dig = hmiDetails.showShellOps(oper)
                    if dig != "nope":
                        op2 = raw_input(
                            "x(eliminar)/d(parsear)/dd(detalles)/q(retroceder)??:")
                        os.system("clear")
                        if op2 == "d":
                            finalize_parse(dig['bin-data'],
                                           dig['output'], dig['autor'])
                        if op2 == "x":
                            mongohand.deleteByIdMongoDB(dig['id'])
                        if op2 == "dd":
                            hmiDetails.showDetailsDig(dig['bin-data'])
                if op == "2":
                    autor = raw_input('Autor??: ')
                    os.system("clear")
                if op == "3":
                    xmli = raw_input('Entrada??: ')
                    os.system("clear")
                if op == "4":
                    xmls = raw_input('Salida??: ')
                    os.system("clear")
                if op == "d":
                    os.system("clear")
                    init_the_parse(xmli, xmls, autor)
                if op == "l":
                    os.system("clear")
                    oper = mongohand.initMongoDB()
                    dig = hmiDetails.showShellOps(oper)
                    if dig != "nope":
                        op2 = raw_input(
                            "d(generar)/q(retroceder)??:")
                        os.system("clear")
                        if op2 == "d":
                            init_code_generation(dig['bin-data'])

                if op == "x":
                    os.system("clear")
                    mongohand.deleteMongoDB()
        except KeyboardInterrupt:
            logging.critical("KeyboardInterrupt")
            sys.exit(255)
