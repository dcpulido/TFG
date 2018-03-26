from string import Template
import logging
import sys
import os
import json
reload(sys)
sys.setdefaultencoding('utf8')


class Code_generator:

    def __init__(self, conf):
        self.conf = conf

    def get_template(self, mod_name):
        with open(self.conf["input"] +
                  "/" +
                  mod_name +
                  "_Template.txt") as f:
            template = Template(f.read())
            f.close()
        return template

    def gen_dir(self, dir):
        try:
            os.system("mkdir -p " +
                      self.gen_name +
                      dir)
        except Exception:
            logging.info("error generando: " + dir)

    def write_file(self,
                   template,
                   dir,
                   name,
                   mod_name,
                   d):
        if mod_name == "Entity":
            mod_name = ""
            print name
        toret = template.safe_substitute(d)
        with open(self.gen_name +
                  dir +
                  "/" +
                  name +
                  mod_name +
                  '.java', 'w+') as fo:
            # logging.info("Writing: " + name + mod_name + ".java")
            fo.write(toret)
            fo.close()

    def generic_gen(self, ob, mod_name, dir):
        logging.info("Generating " + dir + ">>>>>>>>>>>>>>>>>")
        template = self.get_template(mod_name)
        with open(self.conf["input"] +
                  "/json_specs/" +
                  mod_name +
                  ".json") as f:
            key_dic = json.loads(f.read())
            f.close()

        template = self.get_template(mod_name)
        self.gen_dir(dir)
        for o in ob:
            name = o.name.replace(" ", "")

            logging.info("Generating " + dir + ": " + name)
            tt = {}
            for k in key_dic.keys():
                if key_dic[k] == "":
                    fun = eval("self." + k)
                    tt[k] = fun(name, o)
                else:
                    if key_dic[k] == "name":
                        tt[k] = name
                    else:
                        nn = eval(key_dic[k])
                        tt[k] = nn
            self.write_file(template,
                            dir,
                            name,
                            mod_name,
                            tt)

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
    def create_entities(self, ob, dirent, dirview):
        template = self.get_template("Entity")
        view = self.get_template("View")
        with open(self.conf["input"] +
                  "/json_specs/" +
                  "Entity" +
                  ".json") as f:
            key_dic = json.loads(f.read())
            f.close()

        for o in ob:
            for e in o.entities:
                name = e.name
                tt = {}
                for k in key_dic.keys():
                    if key_dic[k] == "":
                        fun = eval("self." + k)
                        tt[k] = fun(name, o)
                    else:
                        if key_dic[k] == "name":
                            tt[k] = name
                        else:
                            nn = eval(key_dic[k])
                            tt[k] = nn
                """self.write_file(template,
                            dirent,
                            name,
                            "",
                            tt)"""
                print "view "+name
                self.write_file(template,
                                dirview,
                                name,
                                "View",
                                tt)


    def generate(self, ob, name):
        self.gen_name = self.conf["output"] + \
            "/" + \
            name + \
            "/"
        os.system("mkdir " + self.gen_name)
        ob = self.remove_repeats(ob)
        self.move_persistent_directories(ob)

        self.generic_gen(ob, "ModelJGraph", "models")
        self.generic_gen(ob, "Panel", "panels")
        self.generic_gen(ob, "CellViewFactory", "cellfactories")
        self.generic_gen(ob, "ActionsFactory", "actions/diagram")
        self.generic_gen(ob, "DataEntityWidgetPreferences", "widget")
        self.generic_gen(ob, "DataEntity", "entities")
        self.generic_gen(ob, "ModelEntity", "entities")

        self.create_entities(ob, "entities", "cell")

        self.generate_ObjectSave(ob)
        self.generate_ObjectManager(ob)
        self.generate_ProjectTreeRenderer(ob)
        self.generate_ProjectMenuCreator(ob)
        self.generate_Relations(ob)
        self.generate_Relations_xml(ob)
        # self.move_persistent_directories(ob)



    def move_persistent_directories(self, ob):
        logging.info(
            "copying directories >>>>>>>>>>>>>>>>>")
        os.system("cp -r persistent_directories/* " + self.gen_name)

    def generate_Relations_xml(self, ob, entDir="rendererxml"):
        logging.info(
            "Generating xml >>>>>>>>>>>>>>>>>")
        self.gen_dir(entDir)
        with open(self.conf["input"] + "/ingenias.txt") as f:
            ingenias = f.read()
            f.close()
        with open(self.conf["input"] + "/label.txt") as f:
            label = f.read()
            f.close()
        with open(self.conf["input"] + "/noicon.txt") as f:
            noicon = f.read()
            f.close()

        relations = []
        for o in ob:
            for e in o.relations:
                name = e.name.replace(" ", "")
                if name not in relations:
                    with open(self.gen_name +
                              entDir +
                              "/" +
                              name +
                              'INGENIASPanel.xml', 'w+') as fo:
                        fo.write(ingenias)
                        fo.close()

                    with open(self.gen_name +
                              entDir +
                              "/" +
                              name +
                              'NOICONPanel.xml', 'w+') as fo:
                        fo.write(noicon)
                        fo.close()

                    with open(self.gen_name +
                              entDir +
                              "/" +
                              name +
                              'LABELPanel.xml', 'w+') as fo:
                        fo.write(label)
                        fo.close()

                else:
                    relations.append(name)

    def generate_Relations(self,
                           ob,
                           entDir="entities",
                           widDir="widget",
                           cellDir="cell"):
        logging.info(
            "Generating Relations >>>>>>>>>>>>>>>>>")
        self.gen_dir(entDir)
        self.gen_dir(widDir)
        self.gen_dir(cellDir)
        with open(self.conf["input"] + "/javaRelation.txt") as f:
            java = Template(f.read())
            f.close()
        with open(self.conf["input"] + "/sourceRelation.txt") as f:
            source = Template(f.read())
            f.close()
        with open(self.conf["input"] + "/targetRelation.txt") as f:
            target = Template(f.read())
            f.close()
        with open(self.conf["input"] + "/javaWidgetRelation.txt") as f:
            widget = Template(f.read())
            f.close()
        with open(self.conf["input"] + "/sourceRoleWidgetRelation.txt") as f:
            sourcewidget = Template(f.read())
            f.close()
        with open(self.conf["input"] + "/targetRoleWidgetRelation.txt") as f:
            targetwidget = Template(f.read())
            f.close()
        with open(self.conf["input"] + "/relationCellView.txt") as f:
            cellView = Template(f.read())
            f.close()
        with open(self.conf["input"] + "/relationCellRenderer.txt") as f:
            cellRenderer = Template(f.read())
            f.close()
        with open(self.conf["input"] + "/relationCellEdge.txt") as f:
            cellEdge = Template(f.read())
            f.close()

        relations = []
        for o in ob:
            for e in o.relations:
                name = e.name.replace(" ", "")
                if name not in relations:
                    toret = ""
                    d = {"name": name}
                    toret += java.safe_substitute(d)
                    with open(self.gen_name +
                              entDir +
                              "/" +
                              name +
                              '.java', 'w+') as fo:
                        fo.write(toret)
                        fo.close()

                    toret = ""
                    d = {"namesourceRole": name + "sourceRole"}
                    toret += source.safe_substitute(d)
                    with open(self.gen_name +
                              entDir +
                              "/" +
                              name +
                              "sourceRole" +
                              '.java', 'w+') as fo:
                        fo.write(toret)
                        fo.close()

                    toret = ""
                    d = {"nametargetRole": name + "targetRole"}
                    toret += target.safe_substitute(d)
                    with open(self.gen_name +
                              entDir +
                              "/" +
                              name +
                              "targetRole" +
                              '.java', 'w+') as fo:
                        fo.write(toret)
                        fo.close()

                    toret = ""
                    d = {"nameWidgetPreferences": name + "WidgetPreferences"}
                    toret += widget.safe_substitute(d)
                    with open(self.gen_name +
                              widDir +
                              "/" +
                              name +
                              "WidgetPreferences" +
                              '.java', 'w+') as fo:
                        fo.write(toret)
                        fo.close()

                    toret = ""
                    d = {"namesourceRoleWidgetPreferences": name +
                         "sourceRoleWidgetPreferences"}
                    toret += sourcewidget.safe_substitute(d)
                    with open(self.gen_name +
                              widDir +
                              "/" +
                              name +
                              "sourceRoleWidgetPreferences" +
                              '.java', 'w+') as fo:
                        fo.write(toret)
                        fo.close()

                    toret = ""
                    d = {"nametargetRoleWidgetPreferences": name +
                         "targetRoleWidgetPreferences"}
                    toret += targetwidget.safe_substitute(d)
                    with open(self.gen_name +
                              widDir +
                              "/" +
                              name +
                              "targetRoleWidgetPreferences" +
                              '.java', 'w+') as fo:
                        fo.write(toret)
                        fo.close()

                    toret = ""
                    d = {"nameView": name + "View",
                         "nameRenderer": name + "Renderer",
                         "name": name}
                    toret += cellView.safe_substitute(d)
                    with open(self.gen_name +
                              cellDir +
                              "/" +
                              name +
                              "View" +
                              '.java', 'w+') as fo:
                        fo.write(toret)
                        fo.close()

                    toret = ""
                    d = {"nameNOICONPanel": name + "NOICONPanel",
                         "nameINGENIASPanel": name + "INGENIASPanel",
                         "nameLABELPanel": name + "LABELPanel",
                         "nameRenderer": name + "Renderer",
                         "name": name}
                    toret += cellRenderer.safe_substitute(d)
                    with open(self.gen_name +
                              cellDir +
                              "/" +
                              name +
                              "Renderer" +
                              '.java', 'w+') as fo:
                        fo.write(toret)
                        fo.close()

                    toret = ""
                    d = {"nameEdge": name + "Edge",
                         "namesource": name + "source",
                         "nametarget": name + "target",
                         "namesourceRole": name + "sourceRole()",
                         "nametargetRole": name + "targetRole()",
                         "name": name}
                    toret += cellEdge.safe_substitute(d)
                    with open(self.gen_name +
                              cellDir +
                              "/" +
                              name +
                              "Edge" +
                              '.java', 'w+') as fo:
                        fo.write(toret)
                        fo.close()
                else:
                    relations.append(name)

    def generate_ProjectMenuCreator(self, ob,
                                    mod_name="ProjectMenuCreator",
                                    dir=""):
        logging.info(
            "Generating ProjectMenuCreator >>>>>>>>>>>>>>>>>")
        with open(self.conf["input"] + "/" +
                  mod_name +
                  "_Template.txt") as f:
            template = Template(f.read())
            f.close()
        with open(self.conf["input"] + "/ProjectMenuCreatorDiagram.txt") as f:
            diag = Template(f.read())
            f.close()
        with open(self.conf["input"] + "/ProjectMenuCreatorDiagram2.txt") as f:
            diag2 = Template(f.read())
            f.close()

        toret = ""
        for o in ob:
            name = o.name.replace(" ", "")
            d = {"nameModelJGraph": name + "ModelJGraph",
                 "nameActionsFactory": name + "ActionsFactory",
                 "name": name,
                 "nameDataEntity": name + "DataEntity",
                 "image": ""}
            toret += diag.safe_substitute(d)

        toret2 = ""
        for o in ob:
            name = o.name.replace(" ", "")
            d = {"nameModelJGraph": name + "ModelJGraph",
                 "nameActionsFactory": name + "ActionsFactory",
                 "name": name,
                 "nameDataEntity": name + "DataEntity"}
            toret2 += diag2.safe_substitute(d)

        d = {"diagram": toret,
             "diagram2": toret2}
        toret = template.safe_substitute(d)
        with open(self.gen_name +
                  dir +
                  "/" +
                  mod_name +
                  '.java', 'w+') as fo:
            fo.write(toret)
            fo.close()

    def generate_ProjectTreeRenderer(self, ob,
                                     mod_name="ProjectTreeRenderer",
                                     dir=""):
        logging.info(
            "Generating ProjectTreeRenderer >>>>>>>>>>>>>>>>>")
        with open(self.conf["input"] + "/" +
                  mod_name +
                  "_Template.txt") as f:
            template = Template(f.read())
            f.close()
        with open(self.conf["input"] + "/ProjectTreeRendererDiagram.txt") as f:
            diag = Template(f.read())
            f.close()
        with open(self.conf["input"] + "/ProjectTreeRendererDiagram2.txt") as f:
            diag2 = Template(f.read())
            f.close()

        toret = ""
        for o in ob:
            name = o.name.replace(" ", "")
            d = {"nameModelJGraph": name + "ModelJGraph",
                 "image": ""}
            toret += diag.safe_substitute(d)

        toret2 = ""
        for o in ob:
            name = o.name.replace(" ", "")
            d = {"nameModelJGraph": name + "ModelJGraph",
                 "modeloname": "modelo" + name}

            # "modeloname": "modelo" + name}
            toret2 += diag2.safe_substitute(d)

        d = {"diagram": toret,
             "diagram2": toret2}
        toret = template.safe_substitute(d)
        with open(self.gen_name +
                  dir +
                  "/" +
                  mod_name +
                  '.java', 'w+') as fo:
            fo.write(toret)
            fo.close()

    def generate_ObjectManager(self, ob,
                               mod_name="ObjectManager",
                               dir=""):
        logging.info(
            "Generating ObjectManager >>>>>>>>>>>>>>>>>")
        with open(self.conf["input"] + "/" +
                  mod_name +
                  "_Template.txt") as f:
            template = Template(f.read())
            f.close()
        with open(self.conf["input"] + "/ObjectManagerDiagram.txt") as f:
            diag = Template(f.read())
            f.close()

        toret = ""
        for o in ob:
            name = o.name.replace(" ", "")
            d = {"nameModelEntity": name +
                 "ModelEntity"}
            toret += diag.safe_substitute(d)

        d = {"diagram": toret}
        toret = template.safe_substitute(d)
        with open(self.gen_name +
                  dir +
                  "/" +
                  mod_name +
                  '.java', 'w+') as fo:
            fo.write(toret)
            fo.close()

    def generate_ObjectSave(self, ob,
                            mod_name="ObjectSave",
                            dir="persistence"):
        logging.info(
            "Generating ObjectSave >>>>>>>>>>>>>>>>>")
        with open(self.conf["input"] + "/" +
                  mod_name +
                  "_Template.txt") as f:
            template = Template(f.read())
            f.close()
        with open(self.conf["input"] + "/ObjectSaveDiagram.txt") as f:
            diag = Template(f.read())
            f.close()

        toret = ""
        for o in ob:
            name = o.name.replace(" ", "")
            d = {"nameDataEntity": name +
                 "DataEntity"}
            toret += diag.safe_substitute(d)
        d = {"diagram": toret}
        toret = template.safe_substitute(d)
        os.system("mkdir " +
                  self.gen_name +
                  dir)
        with open(self.gen_name +
                  dir +
                  "/" +
                  mod_name +
                  '.java', 'w+') as fo:
            fo.write(toret)
            fo.close()

    def createChangeViewActions(self, name, ob):
        with open(self.conf["input"] + "/createChangeViewActions.txt") as f:
            template = Template(f.read())
            f.close()
        with open(self.conf["input"] + "/createChangeViewActionsEntities.txt") as f:
            entities = Template(f.read())
            f.close()
        with open(self.conf["input"] + "/"
                  "createChangeViewActionsRelations.txt") as f:
            relations = Template(f.read())
            f.close()

        toret = ""
        for k in ob.entities:
            dd = {
                "name": k.name
            }
            toret += entities.safe_substitute(dd)
        for k in ob.relations:
            dd = {
                "name": k.name
            }
            toret += relations.safe_substitute(dd)

        d = {
            "content": toret
        }
        return template.safe_substitute(d)

    def createDiagramSpecificInsertActions(self, name, ob):
        with open(self.conf["input"] + "/"
                  "createDiagramSpecificInsertActions.txt") as f:
            template = Template(f.read())
            f.close()
        with open(self.conf["input"] + "/"
                  "createDiagramSpecificInsertActionsEntities.txt") as f:
            entities = Template(f.read())
            f.close()

        toret = ""
        for k in ob.entities:
            dd = {
                "name": k.name
            }
            toret += entities.safe_substitute(dd)

        d = {"entities": toret}

        return template.safe_substitute(d)

    # CellViewFactory exclusive
    def createVertexView(self, name, ob):
        with open(self.conf["input"] + "/CellViewFactoryEntities.txt") as f:
            entities = Template(f.read())
            f.close()
        with open(self.conf["input"] + "/CellViewFactoryRelations.txt") as f:
            relations = Template(f.read())
            f.close()

        toret = ""
        for k in ob.entities:
            dd = {
                "name": k.name,
                "nameView": k.name + "View"
            }
            toret += entities.safe_substitute(dd)
        for k in ob.relations:
            dd = {
                "nameView": k.name + "View",
                "nameEdge": k.name + "Edge"
            }
            toret += relations.safe_substitute(dd)

        return toret
# /////////////////////////////////////////7

    def creaToolBar(self, name, ob):
        with open(self.conf["input"] + "/creaToolBar.txt") as f:
            template = Template(f.read())
            f.close()
        with open(self.conf["input"] + "/creaToolBarEntities.txt") as f:
            ent = Template(f.read())
            f.close()

        toret = ""
        for k in ob.entities:
            dd = {
                "img_name": "img_" + k.name,
                "name_image": "",
                "name": k.name,
            }
            toret += ent.safe_substitute(dd)

        d = {"entities": toret,
             "name": name
             }

        return template.safe_substitute(d)

    def getAllowedRelationships(self, name, ob):
        with open(self.conf["input"] + "/getAllowedRelationships.txt") as f:
            template = Template(f.read())
            f.close()
        with open(self.conf["input"] + "/"
                  "getAllowedRelationshipsRelationships.txt") as f:
            ent = Template(f.read())
            f.close()

        toret = ""
        for k in ob.relations:
            dd = {
                "relationship": k.name
            }
            toret += ent.safe_substitute(dd)

        d = {"relationships": toret}

        return template.safe_substitute(d)

    def getAllowedEntities(self, name, ob):
        with open(self.conf["input"] + "/getAllowedEntities.txt") as f:
            template = Template(f.read())
            f.close()
        with open(self.conf["input"] + "/getAllowedEntitiesEntities.txt") as f:
            ent = Template(f.read())
            f.close()

        toret = ""
        for k in ob.entities:
            dd = {
                "entity": k.name
            }
            toret += ent.safe_substitute(dd)

        d = {"entities": toret}

        return template.safe_substitute(d)

    def getPossibleRelationships(self, name, ob):
        with open(self.conf["input"] + "/getPossibleRelationships.txt") as f:
            template = Template(f.read())
            f.close()
        with open(self.conf["input"] + "/getPossibleRelationshipsBinary.txt") as f:
            ent = Template(f.read())
            f.close()
        with open(self.conf["input"] + "/"
                  "getPossibleRelationshipsNoBinary.txt") as f:
            ent2 = Template(f.read())
            f.close()

        toret = ""
        tt2 = ""
        for k in ob.relations:
            dd = {
                "edge": k.name + "Edge",
                "name": k.name
            }
            toret += ent.safe_substitute(dd)
            tt2 += ent2.safe_substitute(dd)
        d = {"binary": toret,
             "noBinary": tt2}

        return template.safe_substitute(d)

    def getInstanciaNRelacion(self, name, ob):
        with open(self.conf["input"] + "/getInstanciaNRelacion.txt") as f:
            template = Template(f.read())
            f.close()
        with open(self.conf["input"] + "/"
                  "getInstanciaNRelacionRelationship.txt") as f:
            ent = Template(f.read())
            f.close()

        toret = ""
        for k in ob.relations:
            dd = {
                "edge": k.name + "Edge",
                "name": k.name
            }
            toret += ent.safe_substitute(dd)
        d = {"relations": toret}

        return template.safe_substitute(d)

    def createCell(self, name, ob):
        with open(self.conf["input"] + "/createCell.txt") as f:
            template = Template(f.read())
            f.close()
        with open(self.conf["input"] + "/createCellEntity.txt") as f:
            ent = Template(f.read())
            f.close()

        toret = ""

        for e in ob.entities:
            dd = {
                "name": e.name,
                "createname": "create" + e.name,
                "namecell": e.name + "Cell"
            }
            toret += ent.safe_substitute(dd)
        toret += '\n       throw new ingenias.exception.InvalidEntity'\
            '("Entity type "+entity+" is not allowed in this diagram"); '
        d = {"entity": toret}

        return template.safe_substitute(d)

    def createCellPanel(self, name, ob):
        with open(self.conf["input"] + "/createCell.txt") as f:
            template = Template(f.read())
            f.close()
        with open(self.conf["input"] + "/createCellPanel.txt") as f:
            ent = Template(f.read())
            f.close()

        toret = ""

        for e in ob.entities:
            dd = {
                "name": e.name,
                "cratename": "create" + e.name,
                "namecell": e.name + "Cell"
            }
            toret += ent.safe_substitute(dd)
        toret += '\n       throw new ingenias.exception.InvalidEntity'\
            '("Entity type "+entity+" is not allowed in this diagram"); '
        d = {"entity": toret}

        return template.safe_substitute(d)

    def getDefaultSize(self, name, ob):
        with open(self.conf["input"] + "/getDefaultSize.txt") as f:
            template = Template(f.read())
            f.close()
        with open(self.conf["input"] + "/getDefaultSizeEntity.txt") as f:
            ent = Template(f.read())
            f.close()

        toret = ""

        for e in ob.entities:
            dd = {
                "name": e.name,
                "nameview": e.name + "View"
            }
            toret += ent.safe_substitute(dd)
        toret += '\n       throw new ingenias.exception.InvalidEntity'\
            '("Entity type "+entity+" is not allowed in this diagram"); '
        d = {"entity": toret}

        return template.safe_substitute(d)

    def insertDuplicated(self, name, ob):
        with open(self.conf["input"] + "/insertDuplicated.txt") as f:
            template = Template(f.read())
            f.close()
        with open(self.conf["input"] + "/insertDuplicatedEntities.txt") as f:
            ent = Template(f.read())
            f.close()

        toret = ""

        for e in ob.entities:
            dd = {
                "name": e.name,
                "namecell": e.name + "Cell"
            }
            toret += ent.safe_substitute(dd)
        d = {"entities": toret}

        return template.safe_substitute(d)
