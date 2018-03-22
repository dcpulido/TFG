import logging

from app.obbj import complexRelation
from app.obbj import diagram

# REPARSEADO____________________________________________->
#
# Clase orientada al reparseado, una vez
# adquirida la informacion del xml de entrada es necesario
# volver a tratarla y reorganizarla a una forma mas simple
#
#


class reParser:
    def reParseDiagrams(self, diagrams):
        logging.info("REPARSING diagrams")
        toret = []
        for d in diagrams:
            di = diagram(d.name)
            di.relations = d.relations
            for e in d.entities:
                if e.name != di.name:
                    di.entities.append(e)
            # se convierten las relaciones normales en relaciones
            # complejas y se mantiene en extends las relaciones de herencia
            for r in d.relations:
                if r.name != "Extends":
                    fl = True
                    for c in di.complexRelations:
                        if r.name == c.name:

                            so = False
                            ta = False
                            # quitamos repes
                            for k in c.sources:
                                if k == r.source:
                                    so = True
                            for k in c.targets:
                                if k == r.target:
                                    ta = True
                            if so is False:
                                c.sources.append(r.source)
                            if ta is False:
                                c.targets.append(r.target)
                            fl = False
                    if fl is True:
                        xl = complexRelation(r.name)
                        xl.sources.append(r.source)
                        xl.targets.append(r.target)
                        di.complexRelations.append(xl)
                if r.name == "Extends":
                    fl = True
                    for c in di.extends:
                        if r.name == c.name:
                            c.targets.append(r.target)
                            fl = False
                    if fl:
                        xl = complexRelation(r.name)
                        # HERE al reves segun la segunda especificacion!!!!!!
                        xl.sources.append(r.target)
                        xl.targets.append(r.source)
                        di.extends.append(xl)
            # utilizamos la info de extends para
            # mejorar complexRelations y resolver los extends
            # para ello creamos una relacion compleja nueva y
            # la vamos rellenando con las sources o en caso de q la source
            # sea abstracta con sus targets y lo mismo con los targets
            totalComplex = []
            for do in di.complexRelations:
                complexParsed = complexRelation(do.name)
                for so in do.sources:
                    fl = False
                    for e in di.extends:
                        if e.sources[0] == so:
                            fl = True
                            for p in e.targets:
                                complexParsed.sources.append(p)
                    if fl is False:
                        complexParsed.sources.append(so)
                for so in do.targets:
                    fl = False
                    for e in di.extends:
                        if e.sources[0] == so:
                            fl = True
                            for p in e.targets:
                                complexParsed.targets.append(p)
                    if fl is False:
                        complexParsed.targets.append(so)

                totalComplex.append(complexParsed)
            di.entities = remove_entities_rep(di.entities)
            di.complexRelations = totalComplex
            toret.append(di)
        return toret

    def definingAbstractEntities(self, diagrams):
        logging.info("defining abstract Entities")
        toret = diagrams
        for d in toret:
            for e in d.extends:
                aux = []
                for k in d.entities:
                    if k.name == e.sources[0]:
                        k.abstract = True
                        aux.append(k)
                d.abstracts = aux
        return toret

    def redefiningTargetsAndSourcesOnComplex(self, diagrams):
        logging.info("redefining the targets and sources")
        for d in diagrams:
            for r in d.complexRelations:
                r.targets = remove_repeats(r.targets)
                for t in r.targets:
                    for e in d.extends:
                        if e.sources[0] == t:
                            r.targets.remove(t)
                r.sources = remove_repeats(r.sources)
                for t in r.sources:
                    for e in d.extends:
                        if e.sources[0] == t:
                            r.sources.remove(t)
        return diagrams

    def deletingTextNotes(self, diagrams):
        logging.info("deleting text notes entities")
        for k in diagrams:
            aux = []
            for d in k.entities:
                fl = True
                if len(d.name) > 8:
                    if d.name[0:8] == "TextNote":
                        fl = False
                if fl:
                    aux.append(d)
            k.entities = aux
        return diagrams


def remove_repeats(t):
    s = []
    for i in t:
        if i not in s:
            s.append(i)
    return s


def remove_entities_rep(l):
    aux = []
    for k in l:
        fl = False
        for a in aux:
            if k.name == a:
                fl = True
        if fl is False:
            aux.append(k.name)
        else:
            l.remove(k)
    return l
