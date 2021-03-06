import datetime
import logging

from pymongo import MongoClient
from bson.objectid import ObjectId
import pickle

# DB____________________________________________->
#
# Metodos para gestionar la interaccion con la base de datos
#
#
#


class mongoHandler:

    def insertMongoDB(self, ob, input, output, autor):
        logging.info("MONGO inserting parsed document on DB")
        client = MongoClient()
        db = client.tfg
        bytes = pickle.dumps(ob)
        result = db.ob.insert_one({'bin-data': bytes,
                                   'input': input,
                                   'autor': autor,
                                   'output': output,
                                   'date': unicode(datetime.datetime.now())})
        logging.info("MONGO elemnt inserted id:" +
                     str(result.inserted_id))


    def getByIdMongoDB(self, id):
        logging.info("MONGO get element by id")
        client = MongoClient()
        db = client.tfg
        cursor = db.ob.find({'_id': ObjectId(id)})
        toret = ""
        for c in cursor:
            toret = {'id': c['_id'],
                     'bin-data': pickle.loads(c['bin-data']),
                     'input': c['input'],
                     'autor': c['autor'],
                     'output': c['output'],
                     'date': c['date']}
        return toret

    def deleteByIdMongoDB(self, id):
        logging.info("MONGO delete element by id")
        client = MongoClient()
        db = client.tfg
        db.ob.delete_many({'_id': ObjectId(id)})

    def delete_by_arg(self, arg):
        client = MongoClient()
        db = client.tfg
        db.ob.delete_many(arg)

    def initMongoDB(self):
        logging.info("MONGO initializing DB")
        client = MongoClient()
        db = client.tfg
        cursor = db.ob.find({})
        toret = []
        aux = 0
        for c in cursor:
            aux = aux + 1
            toret.append({'id': c['_id'],
                          'bin-data': pickle.loads(c['bin-data']),
                          'input': c['input'],
                          'autor': c['autor'],
                          'output': c['output'],
                          'date': c['date']})
        logging.info("MONGO get " +
                     str(aux) +
                     " elements from DB")
        return toret

    def deleteMongoDB(self):
        logging.info("MONGO deleting instances on DB")
        client = MongoClient()
        db = client.tfg
        db.ob.delete_many({})
        
    def get_by_arg(self,
                   arg,
                   collection,
                   one_result=False):
        client = MongoClient()
        db = eval("client."+collection)
        cursor = db.ob.find(arg)
        toret = []
        for c in cursor:
            if "bin-data" in c.keys():
                c["bin-data"] = pickle.loads(c['bin-data'])
            toret.append(c)
        if one_result:
            if len(toret) >= 1:
                print "entra"
                return toret[0]
            else:
                return {}
        return toret
