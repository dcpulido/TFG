import unittest
import sys
sys.path.insert(0, "../app")
sys.path.insert(0, "../")
from mongohandler import mongoHandler
import obbj


class TestMongoHandler(unittest.TestCase):
    def test_insertMongoDB(self):
        mng = mongoHandler()
        mng.insertMongoDB(None, "test", "test", "test")
        res = mng.get_by_arg(dict(autor="test"), "tfg")
        mng.delete_by_arg(dict(autor=res[0]["autor"]))
        self.assertEqual(res[0]["autor"], "test")

    def test_getByIdMongoDB(self):
        mng = mongoHandler()
        mng.insertMongoDB(None, "test", "test", "test")
        ops = mng.initMongoDB()
        tt = {}
        res = mng.get_by_arg(dict(autor="test"), "tfg")
        for o in ops:
            if o["autor"] == "test":
                tt = mng.getByIdMongoDB(o["id"])
        mng.delete_by_arg(dict(autor=res[0]["autor"]))
        self.assertEqual(tt["input"], res[0]["input"])

    def test_deleteByIdMongoDB(self):
        mng = mongoHandler()
        mng.insertMongoDB(None, "test", "test", "test")
        ops = mng.initMongoDB()
        for o in ops:
            if o["autor"] == "test":
                mng.deleteByIdMongoDB(o["id"])
        tt = ""
        for o in ops:
            if o["autor"] == "test":
                tt = mng.getByIdMongoDB(o["id"])
        self.assertEqual(tt, "")

    def test_initMongoDB(self):
        mng = mongoHandler()
        mng.insertMongoDB(None, "test", "test", "test")
        res = mng.get_by_arg(dict(autor="test"), "tfg")
        ops = mng.initMongoDB()
        mng.delete_by_arg(dict(autor=res[0]["autor"]))
        self.assertGreater(len(ops), 0)

    def test_delete_by_arg(self):
        mng = mongoHandler()
        mng.insertMongoDB(None, "test", "test", "test")
        res = mng.get_by_arg(dict(autor="test"), "tfg")
        mng.delete_by_arg(dict(autor=res[0]["autor"]))
        res = mng.get_by_arg(dict(autor="test"), "tfg")
        self.assertEqual(res, [])

    def test_get_by_arg(self):
        mng = mongoHandler()
        mng.insertMongoDB(None, "test", "test", "test")
        res = mng.get_by_arg(dict(autor="test"), "tfg")
        mng.delete_by_arg(dict(autor=res[0]["autor"]))
        self.assertEqual(res[0]["autor"], "test")


unittest.main()
"""if __name__ == "__main__":
    mng = mongoHandler()
    mng.insertMongoDB(None, "test","test","test")
    res = mng.get_by_arg(dict(autor="test"),"tfg")
    print res
    print dict(_id=res[0]["_id"])
    mng.delete_by_arg(dict(autor=res[0]["autor"]))
    res = mng.get_by_arg(dict(autor="test"),"tfg")
    print "BEFORE DELETE"
    print res"""
