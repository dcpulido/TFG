from string import Template
# diccionario para las imagenes
images = {

}


class Code_generator:

    def __init__(self):
        pass

    def remove_repeats(self, ob):

        for d in ob:
            entities = []
            relations = []
            for e in d.entities:
                fl = False
                for e2 in entities:
                    if e2.name == e.name:
                        fl = True
                if not fl:
                    entities.append(e)

            for r in d.relations:
                fl = False
                for r2 in relations:
                    if r2.name == r.name:
                        fl = True
                if not fl:
                    relations.append(r)

            d.entities = entities
            d.relations = relations
        return ob

    def generate(self, ob):
        ob = self.remove_repeats(ob)
        self.generate_ModelJGraph(ob, "ModelJGraph", "models")

    def generate_ModelJGraph(self, ob, mod_name="ModelJGraph", dir="models"):
        with open("source_templates/"+mod_name+"_Template.txt") as f:
            template = Template(f.read())

        for o in ob:
            name = o.name.replace(" ", "")

            creaToolBar = self.creaToolBar(name, o)
            getAllowedRelationships = self.getAllowedRelationships(name, o)
            getAllowedEntities = self.getAllowedEntities(name, o)
            getPossibleRelationships = self.getPossibleRelationships(name, o)
            getInstanciaNRelacion = self.getInstanciaNRelacion(name, o)
            createCell = self.createCell(name, o)

            d = {"who"+mod_name: name+mod_name,
                 "whoDataEntity": name+"DataEntity",
                 "whoCellViewFactory": name + ".CellViewFactory()",
                 "who": name,
                 "creaToolBar": creaToolBar,
                 "getAllowedRelationships": getAllowedRelationships,
                 "getPossibleRelationships": getPossibleRelationships,
                 "getInstanciaNRelacion": getInstanciaNRelacion,
                 "createCell": createCell,
                 "getAllowedEntities": getAllowedEntities}
            toret = template.safe_substitute(d)

            with open("source_output/"+dir+"/"+name+mod_name+'.java', 'w+') as fo:
                fo.write(toret)
                fo.close()
        f.close()

    def creaToolBar(self, name, ob):
        with open("source_templates/creaToolBar.txt") as f:
            template = Template(f.read())
        with open("source_templates/creaToolBarEntities.txt") as f:
            ent = Template(f.read())

        toret = ""
        for k in ob.entities:
            dd = {
                "img_name": "img_"+k.name,
                "name_image": "",
                "name": k.name,
            }
            toret += ent.safe_substitute(dd)


        d = {"entities": toret,
             "name": name
             }

        return template.safe_substitute(d)

    def getAllowedRelationships(self, name, ob):
        with open("source_templates/getAllowedRelationships.txt") as f:
            template = Template(f.read())
        with open("source_templates/getAllowedRelationshipsRelationships.txt") as f:
            ent = Template(f.read())

        toret = ""
        for k in ob.relations:
            dd = {
                "relationship": k.name
            }
            toret += ent.safe_substitute(dd)

        d = {"relationships": toret}

        return template.safe_substitute(d)

    def getAllowedEntities(self, name, ob):
        with open("source_templates/getAllowedEntities.txt") as f:
            template = Template(f.read())
        with open("source_templates/getAllowedEntitiesEntities.txt") as f:
            ent = Template(f.read())

        toret = ""
        for k in ob.entities:
            dd = {
                "entity": k.name
            }
            toret += ent.safe_substitute(dd)

        d = {"entities": toret}

        return template.safe_substitute(d)

    def getPossibleRelationships(self, name, ob):
        with open("source_templates/getPossibleRelationships.txt") as f:
            template = Template(f.read())
        with open("source_templates/getPossibleRelationshipsBinary.txt") as f:
            ent = Template(f.read())
        with open("source_templates/getPossibleRelationshipsNoBinary.txt") as f:
            ent2 = Template(f.read())

        toret = ""
        tt2 = ""
        for k in ob.relations:
            dd = {
                "edge": k.name+"Edge",
                "name": k.name
            }
            toret += ent.safe_substitute(dd)
            tt2 += ent2.safe_substitute(dd)
        d = {"binary": toret,
             "noBinary": tt2
             }

        return template.safe_substitute(d)

    def getInstanciaNRelacion(self, name, ob):
        with open("source_templates/getInstanciaNRelacion.txt") as f:
            template = Template(f.read())
        with open("source_templates/getInstanciaNRelacionRelationship.txt") as f:
            ent = Template(f.read())

        toret = ""
        for k in ob.relations:
            dd = {
                "edge": k.name+"Edge",
                "name": k.name
            }
            toret += ent.safe_substitute(dd)
        d = {"relations": toret
             }

        return template.safe_substitute(d)

    def createCell(self, name, ob):
        with open("source_templates/createCell.txt") as f:
            template = Template(f.read())
        with open("source_templates/createCellEntity.txt") as f:
            ent = Template(f.read())

        toret = ""

        for e in ob.entities:
            dd={
                "name":e.name,
                "cratename":"create"+e.name,
                "namecell":e.name+"Cell"
            }
            toret += ent.safe_substitute(dd)
        toret +='\n       throw new ingenias.exception.InvalidEntity("Entity type "+entity+" is not allowed in this diagram"); '
        d = {"entity": toret
             }

        return template.safe_substitute(d)

  