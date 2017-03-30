import datetime
import time
import logging

from pymongo import MongoClient
from bson.binary import Binary
import pickle

from app.objs import complexRelation
from app.objs import diagram
from app.objs import relationship
from app.objs import entity



#_____________________________________DB____________________________________________->
#
#Metodos para gestionar la interaccion con la base de datos
#
#
#
class mongoHandler:
    def insertMongoDB(self,ob,input,output,autor):
      logging.info("MONGO inserting parsed document on DB")
      client = MongoClient()
      db = client.tfg
      bytes=pickle.dumps(ob)
      result=db.ob.insert_one({'bin-data': bytes,'input':input,'autor':autor,'output':output, 'date':unicode(datetime.datetime.now())})
      logging.info("MONGO elemnt inserted id:"+str(result.inserted_id))

    def getByIdMongoDB(self,id):
      logging.info("MONGO get element by id")
      client = MongoClient()
      db = client.tfg
      cursor=db.ob.find({'_id':ObjectId(id)})
      toret=""
      for c in cursor:
          toret={'id':c['_id'],'bin-data':pickle.loads(c['bin-data']),'input':c['input'],'autor':c['autor'],'output':c['output'],'date':c['date']}
      return toret

    def deleteByIdMongoDB(self,id):
      logging.info("MONGO delete element by id")
      client = MongoClient()
      db = client.tfg
      db.ob.delete_many({'_id':ObjectId(id)})


    def initMongoDB(self):
      logging.info("MONGO initializing DB")
      client = MongoClient()
      db = client.tfg
      cursor=db.ob.find({})
      toret=[]
      aux=0
      for c in cursor:
          aux=aux+1
          toret.append({'id':c['_id'],'bin-data':pickle.loads(c['bin-data']),'input':c['input'],'autor':c['autor'],'output':c['output'],'date':c['date']})
      logging.info("MONGO get "+ str(aux) +" elements from DB")
      return toret


    def deleteMongoDB(self):
      logging.info("MONGO deleting instances on DB")
      client = MongoClient()
      db = client.tfg
      db.ob.delete_many({})