import logging
import unittest
import sys
import threading

import xmlHandler


def init_the_parse(input,output,autor):
   parser = xml.sax.make_parser()
   parser.setFeature(xml.sax.handler.feature_namespaces, 0)
   logging.info("sax parser")
   
   Handler = xmlHandler.XMLHandler()
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
    print " -i [ruta a xml de entrada] -s [ruta salida] -a [autor] "
    print
    print " -b habilitar dominio dbus"
    print
    print " -x habilitar interfaz web en localhost:4000"
    print
    print " -c Modo test"

 


if ( __name__ == "__main__"):
    logging.basicConfig(format='%(asctime)s %(levelname)s:%(message)s', level=logging.DEBUG)
    logging.info("app init")

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

    if xmls=="":xmls="output.xml"
    if autor=="":autor="autor"

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
      sys.exit(255)
    """
    file=sys.argv[2]
    autor=sys.argv[3]
    salida=sys.argv[4]

    init_the_parse(file,salida,autor)

    logging.info("close app")
      sys.exit(255)"""
    #________________________________________DBUS MODE___________________________________________->
    if dbusMode and not flaskMode:
      logging.info("DBUS MODE")
    """
    gobject.threads_init()
    dbus.glib.init_threads()
    publish_dbus()
    sys.exit(255)"""
    #_____________________________________FLASK MODE_____________________________________________->
    if flaskMode and not dbusMode:
      logging.info("FLASK MODE")
    """ myapp=flaskApp()
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
    sys.exit(255)"""

    if flaskMode and dbusMode:
      logging.info("FLASK MODE")
      logging.info("DBUS MODE")
      sys.exit(255)
  # usage()