from string import Template
# diccionario para las imagenes
images = {

}


class Code_generator:

    def __init__(self):
        pass

    def generate(self, ob):
        self.generate_ModelJGraph(ob, "ModelJGraph", "models")

    def generate_ModelJGraph(self, ob, mod_name="ModelJGraph", dir="models"):
        with open("source_templates/"+mod_name+"_Template.txt") as f:
            template = Template(f.read())

        for o in ob:
            name = o.name.replace(" ", "")

            creaToolBar = self.creaToolBar(name, o)
            getAllowedRelationships= self.getAllowedRelationships(name, o)
            getAllowedEntities= self.getAllowedEntities(name, o)

            d = {"who"+mod_name: name+mod_name,
                 "whoDataEntity": name+"DataEntity",
                 "whoCellViewFactory": name + ".CellViewFactory()",
                 "who": name,
                 "creaToolBar": creaToolBar,
                 "getAllowedRelationships":getAllowedRelationships,
                 "getAllowedEntities":getAllowedEntities}
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
                "relationship":k.name
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
                "entity":k.name
            }
            toret += ent.safe_substitute(dd)

        d = {"entities": toret}

        return template.safe_substitute(d)
