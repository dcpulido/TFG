#!/usr/bin/python
"""Receiver related functionality."""
import dbus.service
import dbus.glib
import gobject
import dbus
import json
import xml.sax
from parser import Parser
from xmlhandler import XMLHandler
from reparser import reParser


class DbusIface(dbus.service.Object):
    """Reciever test class."""

    loop = None

    def __init__(self,
                 bus_name,
                 object_path,
                 loop,
                 mongoHandler,
                 compiler,
                 generator):
        """Initialize the DBUS service object."""
        dbus.service.Object.__init__(self, bus_name, object_path)
        self.loop = loop
        self.mongoHandler = mongoHandler
        self.cmp = compiler
        self.gen = generator

    @dbus.service.method('tfg.pyxml.dbs.parser')
    def parse_spec(self,
                   input,
                   autor,
                   output):
        try:
            input = str(input)
            autor = str(autor)
            output = str(output)
            reparser = reParser()
            parser = xml.sax.make_parser()
            parser.setFeature(xml.sax.handler.feature_namespaces, 0)
            Handler = XMLHandler()
            parser.setContentHandler(Handler)
            parser.parse(input)
            dig = reparser.reParseDiagrams(Handler.CurrentDiagrams)
            dig = reparser.definingAbstractEntities(dig)
            dig = reparser.deletingTextNotes(dig)
            dig = reparser.redefiningTargetsAndSourcesOnComplex(dig)
            self.mongoHandler.insertMongoDB(dig, input, output, autor)
            par = Parser(dig, output)
            par.setAuthorDate(autor)
            par.toXML()
            return str("OK")
        except Exception, e:
            raise e
            return "KO"

    @dbus.service.method('tfg.pyxml.dbs.parser')
    def get_specs(self):
        ops = self.mongoHandler.initMongoDB()
        for c in ops:
            del c["bin-data"]
            del c["id"]
        return json.dumps(ops)

    @dbus.service.method('tfg.pyxml.dbs.generator')
    def generate_source(self, output):
        try:
            output = str(output)
            dig = self.mongoHandler.get_by_arg(dict(output=output),
                                               "tfg",
                                               one_result=True)
            ex = ""
            if "/" in dig["output"]:
                ex = dig["output"].split("/")[1].split(".")[0]
            else:
                ex = dig["output"]
            name = dig["autor"] + \
                "_" + \
                ex
            self.gen.generate(dig["bin-data"], name)
            return "OK"
        except:
            return "KO"

    @dbus.service.method('tfg.pyxml.dbs.compiler')
    def get_profiles(self):
        return json.dumps(self.cmp.get_profiles())

    @dbus.service.method('tfg.pyxml.dbs.compiler')
    def compile_profile(self, prof):
        try:
            self.cmp.compile(prof)
            return "OK"
        except:
            return "KO"

    # Stop the main loop
    @dbus.service.method('tfg.pyxml.dbs.system')
    def stop(self):
        """Stop the receiver."""
        self.loop.quit()
        return 'Quit loop'


if __name__ == "__main__":
    pass
