import unittest
import dbus
import json


class TestDbus(unittest.TestCase):
    def test_get_specs_autor(self):
        bus = dbus.SessionBus()
        helloservice = bus.get_object('tfg.pyxml.dbs', '/tfg/pyxml')
        hello = helloservice.get_dbus_method(
            'get_specs', 'tfg.pyxml.dbs.parser')
        specs = json.loads(hello())[0]
        self.assertIn("autor", specs.keys())

    def test_get_specs_input(self):
        bus = dbus.SessionBus()
        helloservice = bus.get_object('tfg.pyxml.dbs', '/tfg/pyxml')
        hello = helloservice.get_dbus_method(
            'get_specs', 'tfg.pyxml.dbs.parser')
        specs = json.loads(hello())[0]
        self.assertIn("input", specs.keys())

    def test_get_specs_output(self):
        bus = dbus.SessionBus()
        helloservice = bus.get_object('tfg.pyxml.dbs', '/tfg/pyxml')
        hello = helloservice.get_dbus_method(
            'get_specs', 'tfg.pyxml.dbs.parser')
        specs = json.loads(hello())[0]
        self.assertIn("output", specs.keys())

    def test_parse_spec(self):
        autor = "anonimo"
        xmli = "examplesXML/default2.xml"
        xmlo = "examplesXML/filename.xml"
        bus = dbus.SessionBus()
        metservice = bus.get_object('tfg.pyxml.dbs', '/tfg/pyxml')
        met = metservice.get_dbus_method(
            'parse_spec', 'tfg.pyxml.dbs.parser')
        specs = met(xmli, xmlo, autor)
        self.assertEquals(specs, "OK")

    def test_generate(self):
        bus = dbus.SessionBus()
        helloservice = bus.get_object('tfg.pyxml.dbs', '/tfg/pyxml')
        hello = helloservice.get_dbus_method(
            'generate_source', 'tfg.pyxml.dbs.generator')
        self.assertIn(hello("examplesXML/filename.xml"), "OK")

    def test_get_profiles(self):
        bus = dbus.SessionBus()
        helloservice = bus.get_object('tfg.pyxml.dbs', '/tfg/pyxml')
        hello = helloservice.get_dbus_method(
            'get_profiles', 'tfg.pyxml.dbs.compiler')
        specs = json.loads(hello())[0]
        self.assertIn(specs, "anonimo_filename")

    def test_compile(self):
        bus = dbus.SessionBus()
        helloservice = bus.get_object('tfg.pyxml.dbs', '/tfg/pyxml')
        hello = helloservice.get_dbus_method(
            'compile_profile', 'tfg.pyxml.dbs.compiler')
        specs = hello("anonimo_filename")
        self.assertIn(specs, "OK")


unittest.main()
