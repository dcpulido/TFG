import os
import logging

from app.obbj import complexRelation
from app.obbj import diagram
from app.obbj import relationship
from app.obbj import entity

#No usar// clase para debug
class showDetails:
    def toString(self,diagrams):
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

    def showDetailsDig(self,binData):
        aux=0
        for d in binData:
            print str(aux)+" "+d.name
            aux=aux+1
        print
        op=raw_input("selecciona una op o bien q para salir??: ")
        os.system("clear")
        if op!='q':
            try:
                self.showDetailsOp(binData[int(op)])
            except TypeError:
                logging.info("Dont choose comming back")
            except ValueError:
                logging.info("Dont choose comming back")


    def showDetailsOp(self,op):
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
                    if len(k)==2:self.showDetailsRel(op.complexRelations[int(k)-10])
                    if len(k)==1:self.showDetailsRel(op.extends[int(k)])
                except TypeError:
                    logging.info("Dont choose comming back")
                except ValueError:
                    logging.info("Dont choose comming back")
                except IndexError:
                    logging.info("Dont choose comming back")

    def showDetailsRel(self,rel):
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
        

    def showShellOps(self,ops):
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