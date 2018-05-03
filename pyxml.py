#!/usr/bin/python
# -*- coding: utf-8 -*-
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

import dbus.service
import dbus.glib
import gobject
import dbus

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
from app.compiler import Compiler
from app.dbusIface import DbusIface

# ////////////////////////////////////////////////////////////////////////////////////////////////
# APP
# ////////////////////////////////////////////////////////////////////////////////////////////////


def catchall_handler(*args, **kwargs):
    """Catch all handler.
    Catch and print information about all singals.
    """
    if kwargs['dbus_interface'] == "tfg.pyxml.dbs.parser":
        print('%s:%s' % (kwargs['dbus_interface'], kwargs['member']))


def quit_handler():
    """Signal handler for quitting the receiver."""
    print 'Quitting....'
    loop.quit()

# _______________FLASK________________->


class flaskApp(threading.Thread):
    """
    Clase orientada a proporcionar una interfaz
    web simple si no se quisiese utilizar el
    modo normal por terminal
    """

    def run(self):
        app.run()


app = Flask(__name__, static_url_path='/static')


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


@app.route("/generate", methods=['POST'])
def generate():
    try:
        logging.info("FLASK:generate url from FLASk")
        if request.method == 'POST':
            print request.json
            data = request.json
            cc = mongohand.get_by_arg(data,
                                      "tfg",
                                      one_result=True)
            ex = ""
            if "/" in cc["output"]:
                ex = cc["output"].split("/")[1].split(".")[0]
            else:
                ex = cc["output"]
            name = cc["autor"] + \
                "_" + \
                ex
            init_code_generation(generatorconf,
                                 cc['bin-data'],
                                 name)
        return render_template('index.html')
    except Exception,e:
        raise e
        print "rompe"
        return "ko"


@app.route("/compile", methods=['POST'])
def compile_fl():
    """
    parse xml
    :return: redirect to index
    """
    logging.info("FLASK:compile url")
    try:
        if request.method == 'POST':
            data = request.json
            logging.info("FLASK:compile " + data["id"])
            cmp.compile(data["id"])
        return "ok"
    except Exception,e:
        return "ko"


@app.route("/start", methods=['POST'])
def start_prof():
    """
    parse xml
    :return: redirect to index
    """
    logging.info("FLASK:start url")
    try:
        if request.method == 'POST':
            data = request.json
            logging.info("FLASK:start " + data["id"])
            cmp.start_prof(data["id"])
        return "ok"
    except Exception,e:
        return "ko"


@app.route("/delete_prof", methods=['POST'])
def delete_prof():
    """
    parse xml
    :return: redirect to index
    """
    logging.info("FLASK:delete_prof url")
    if request.method == 'POST':
        data = request.json
        logging.info("FLASK:delete_prof " + data["id"])
        cmp.remove_prof(data["id"])
    return redirect("http://localhost:5000/")


@app.route("/parse", methods=['POST'])
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


        if ou == "" or ou == "None":
            ou = xmls
        if inp == "" or inp == "None":
            inp = xmli
        if au == "" or au == "None":
            au = autor


        logging.info("FLASK: " +
                     ou +
                     " " +
                     inp +
                     " " +
                     au)
        init_the_parse(inp,
                       ou,
                       au)

    return render_template('index.html')


@app.route("/operations", methods=['GET'])
def exposeOperations():
    """
    get stored operations
    :return: encoded operations
    """
    return getEncodeOps()


@app.route("/profiles", methods=['GET'])
def exposeProfiles():
    """
    get stored profiles
    :return: encoded profiles
    """
    return getEncodeProf()


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

# entre getEncodeOps y getEncodeProf hay un año y medio de diferencia...
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
    
    return json.dumps(toret1)


def getEncodeProf():
    """
    :return: operaciones en json
    """
    logging.info("FLASK encoding profiles")
    return json.dumps(cmp.get_profiles())


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
    urllib2.urlopen(flaskconf['name'] + "shutdown").read()


def shutdown_server():
    func = request.environ.get('werkzeug.server.shutdown')
    if func is None:
        raise RuntimeError('Not running with the Werkzeug Server')
    func()


# MAIN____________________________________________->
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
                logging.info("skip: %s" % option)
        except Exception:
            logging.info("exception on %s!" % option)
            dict1[option] = None
    return dict1


def get_conf(conf):
    """
    recupera seccion General de conf
    :return: diccionario
    """
    Config = ConfigParser.ConfigParser()
    Config.read("./conf/config.conf")
    myprior = {}
    for sec in Config.sections():
        if sec == conf:
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

    logging.info("Parsing file: " + input)
    parser.parse(input)

    # HERE printar relaciones y relaciones complejas
    dig = reparser.reParseDiagrams(Handler.CurrentDiagrams)
    # hmiDetails.toString(dig)
    dig = reparser.definingAbstractEntities(dig)
    dig = reparser.deletingTextNotes(dig)
    dig = reparser.redefiningTargetsAndSourcesOnComplex(dig)

    mongohand.insertMongoDB(dig, input, output, autor)

    finalize_parse(dig, output, autor)


def init_code_generation(conf,
                         obj,
                         name):
    """
    inicia la generacion de codigo
    :param xmls:
    :return:
    """
    logging.info("Generating sources")
    ccdg = Code_generator(conf)
    ccdg.generate(obj, name)


def finalize_parse(dig,
                   output,
                   autor):
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
    print " -x habilitar interfaz web en " + flaskconf['name']
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
    generalconf = get_conf("General")
    dbusconf = get_conf("Dbus")
    flaskconf = get_conf("Flask")
    generatorconf = get_conf("Generator")
    compilerconf = get_conf("Compiler")

    cmp = Compiler(generatorconf, compilerconf)
    gen = Code_generator(generatorconf)

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
        loop = gobject.MainLoop()
        bus = dbus.SessionBus()
        bus_name = dbus.service.BusName('tfg.pyxml.dbs', bus=bus)
        obj = DbusIface(bus_name,
                        '/tfg/pyxml',
                        loop,
                        mongohand,
                        cmp,
                        gen)
        bus.add_signal_receiver(catchall_handler,
                                interface_keyword='dbus_interface',
                                member_keyword='member')
        bus.add_signal_receiver(quit_handler,
                                dbus_interface='ctag.pyxml.sub.event',
                                signal_name='quit_signal')
        loop.run()
        flag = True
        while flag:
            op = raw_input("q->salir")
            if op == "q":
                flag = False
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
                print "         l_Generar código"
                print "         c_Perfiles"
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
                            "x(eliminar)/d(parsear)/"
                            "dd(detalles)/q(retroceder)??:")
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
                            ex = ""
                            if "/" in dig["output"]:
                                ex = dig["output"].split("/")[1].split(".")[0]
                            else:
                                ex = dig["output"]
                            name = dig["autor"] + \
                                "_" + \
                                ex
                            init_code_generation(generatorconf,
                                                 dig['bin-data'],
                                                 name)
                if op == "c":
                    os.system("clear")
                    profs = cmp.get_profiles()
                    dig = hmiDetails.showShellProfs(profs)
                    if dig != "nope":
                        op2 = raw_input(
                            "d(compilar)/l(lanzar)/r(borrar)q(retroceder)??:")
                        os.system("clear")
                        if op2 == "d":
                            cmp.compile(dig)
                        if op2 == "l":
                            cmp.start_prof(dig)
                        if op2 == "r":
                            cmp.remove_prof(dig)

                if op == "x":
                    os.system("clear")
                    mongohand.deleteMongoDB()
        except KeyboardInterrupt:
            logging.critical("KeyboardInterrupt")
            sys.exit(255)
