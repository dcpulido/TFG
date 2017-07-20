from string import Template
import logging
import sys
reload(sys)
sys.setdefaultencoding('utf8')
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
        self.generate_Panel(ob)
        self.generate_CellViewFactory(ob)
        self.generate_ActionsFactory(ob)
        self.generate_DataEntityWidgetPreferences(ob)
        self.generate_DataEntity(ob)
        self.generate_ModelEntity(ob)
        self.generate_ObjectSave(ob)
        self.generate_ObjectManager(ob)
        self.generate_ProjectTreeRenderer(ob)
        self.generate_ProjectMenuCreator(ob)
        self.generate_Relations(ob)

    def generate_Relations(self, ob, dir="entities"):
        logging.info(
            "Generating Relations >>>>>>>>>>>>>>>>>")
        with open("source_templates/javaRelation.txt") as f:
            java = Template(f.read())
            f.close()
        with open("source_templates/sourceRelation.txt") as f:
            source = Template(f.read())
            f.close()
        with open("source_templates/targetRelation.txt") as f:
            target = Template(f.read())
            f.close()

        relations = []
        for o in ob:
            for e in o.relations:
                name = e.name.replace(" ", "")
                if name not in relations:
                    toret = ""
                    d = {"name": name}
                    toret += java.safe_substitute(d)
                    with open("source_output/" +
                              dir +
                              "/" +
                              name +
                              '.java', 'w+') as fo:
                        fo.write(toret)
                        fo.close()

                    toret = ""
                    d = {"namesourceRole": name + "sourceRole"}
                    toret += java.safe_substitute(d)
                    with open("source_output/" +
                              dir +
                              "/" +
                              name +
                              "sourceRole" +
                              '.java', 'w+') as fo:
                        fo.write(toret)
                        fo.close()

                    toret = ""
                    d = {"nametargetRole": name + "targetRole"}
                    toret += java.safe_substitute(d)
                    with open("source_output/" +
                              dir +
                              "/" +
                              name +
                              "targetRole" +
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
        with open("source_templates/"+mod_name+"_Template.txt") as f:
            template = Template(f.read())
            f.close()
        with open("source_templates/ProjectMenuCreatorDiagram.txt") as f:
            diag = Template(f.read())
            f.close()
        with open("source_templates/ProjectMenuCreatorDiagram2.txt") as f:
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
        with open("source_output/" +
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
        with open("source_templates/"+mod_name+"_Template.txt") as f:
            template = Template(f.read())
            f.close()
        with open("source_templates/ProjectTreeRendererDiagram.txt") as f:
            diag = Template(f.read())
            f.close()
        with open("source_templates/ProjectTreeRendererDiagram2.txt") as f:
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
                 "modeloname": "modelo"+name}
            toret2 += diag2.safe_substitute(d)

        d = {"diagram": toret,
             "diagram2": toret2}
        toret = template.safe_substitute(d)
        with open("source_output/" +
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
        with open("source_templates/"+mod_name+"_Template.txt") as f:
            template = Template(f.read())
            f.close()
        with open("source_templates/ObjectManagerDiagram.txt") as f:
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
        with open("source_output/" +
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
        with open("source_templates/"+mod_name+"_Template.txt") as f:
            template = Template(f.read())
            f.close()
        with open("source_templates/ObjectSaveDiagram.txt") as f:
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
        with open("source_output/" +
                  dir +
                  "/" +
                  mod_name +
                  '.java', 'w+') as fo:
            fo.write(toret)
            fo.close()

    def generate_DataEntity(self, ob,
                            mod_name="DataEntity",
                            dir="entities"):
        logging.info(
            "Generating DataEntity >>>>>>>>>>>>>>>>>")
        with open("source_templates/"+mod_name+"_Template.txt") as f:
            template = Template(f.read())
            f.close()
        for o in ob:
            name = o.name.replace(" ", "")
            logging.info("Generating DataEntity: "+name)
            d = {"nameDataEntity": name +
                 "DataEntity"}
            toret = template.safe_substitute(d)
            with open("source_output/" +
                      dir +
                      "/" +
                      name +
                      mod_name +
                      '.java', 'w+') as fo:
                fo.write(toret)
                fo.close()

    def generate_ModelEntity(self, ob,
                             mod_name="ModelEntity",
                             dir="entities"):
        logging.info(
            "Generating ModelEntity >>>>>>>>>>>>>>>>>")
        with open("source_templates/"+mod_name+"_Template.txt") as f:
            template = Template(f.read())
            f.close()
        for o in ob:
            name = o.name.replace(" ", "")
            logging.info("Generating ModelEntity: "+name)
            d = {"nameModelEntity": name + "ModelEntity",
                 "name": name}
            toret = template.safe_substitute(d)
            with open("source_output/" +
                      dir +
                      "/" +
                      name +
                      mod_name +
                      '.java', 'w+') as fo:
                fo.write(toret)
                fo.close()

    def generate_DataEntityWidgetPreferences(self, ob,
                                             mod_name="DataEntityWidgetPreferences",
                                             dir="widget"):
        logging.info(
            "Generating DataEntityWidgetPreferences >>>>>>>>>>>>>>>>>")
        with open("source_templates/"+mod_name+"_Template.txt") as f:
            template = Template(f.read())
            f.close()
        for o in ob:
            name = o.name.replace(" ", "")
            logging.info("Generating DataEntityWidgetPreferences: "+name)
            d = {"nameDataEntityWidgetPreferences": name +
                 "DataEntityWidgetPreferences"}
            toret = template.safe_substitute(d)
            with open("source_output/" +
                      dir +
                      "/" +
                      name +
                      mod_name +
                      '.java', 'w+') as fo:
                fo.write(toret)
                fo.close()

    def generate_ActionsFactory(self, ob, mod_name="ActionsFactory", dir="actions/diagram"):
        logging.info("Generating ActionsFactory >>>>>>>>>>>>>>>>>")
        with open("source_templates/"+mod_name+"_Template.txt") as f:
            template = Template(f.read())
            f.close()
        for o in ob:
            name = o.name.replace(" ", "")
            logging.info("Generating ActionsFactory: "+name)
            createChangeViewActions = self.createChangeViewActions(name, o)
            createDiagramSpecificInsertActions = self.createDiagramSpecificInsertActions(
                name, o)

            d = {"nameActionsFactory": name+"ActionsFactory",
                 "createChangeViewActions": createChangeViewActions,
                 "createDiagramSpecificInsertActions": createDiagramSpecificInsertActions}
            toret = template.safe_substitute(d)
            with open("source_output/" +
                      dir +
                      "/" +
                      name +
                      mod_name +
                      '.java', 'w+') as fo:
                fo.write(toret)
                fo.close()

    def generate_CellViewFactory(self, ob, mod_name="CellViewFactory", dir="cellfactories"):
        logging.info("Generating cellfactories >>>>>>>>>>>>>>>>>")
        with open("source_templates/"+mod_name+"_Template.txt") as f:
            template = Template(f.read())
            f.close()

        for o in ob:
            name = o.name.replace(" ", "")
            logging.info("Generating cellfactorie: "+name)
            createVertexView = self.createVertexView(name, o)

            d = {"nameCellViewFactory": name + "CellViewFactory",
                 "content": createVertexView}
            toret = template.safe_substitute(d)
            with open("source_output/" +
                      dir +
                      "/" +
                      name +
                      mod_name +
                      '.java', 'w+') as fo:
                fo.write(toret)
                fo.close()

    def generate_Panel(self, ob, mod_name="Panel", dir="panels"):
        logging.info("Generating panels >>>>>>>>>>>>>>>>>")
        with open("source_templates/"+mod_name+"_Template.txt") as f:
            template = Template(f.read())
            f.close()
        for o in ob:
            name = o.name.replace(" ", "")
            logging.info("Generating Panel: "+name)
            getAllowedEntities = self.getAllowedEntities(name, o)
            createCell = self.createCellPanel(name, o)
            getDefaultSize = self.getDefaultSize(name, o)
            insertDuplicated = self.insertDuplicated(name, o)
            d = {"who"+mod_name: name+mod_name,
                 "whoDataEntity": name+"DataEntity",
                 "whoCellViewFactory": name + "CellViewFactory()",
                 "who": name,
                 "createCell": createCell,
                 "getDefaultSize": getDefaultSize,
                 "insertDuplicated": insertDuplicated,
                 "getAllowedEntities": getAllowedEntities}
            toret = template.safe_substitute(d)
            with open("source_output/" +
                      dir +
                      "/" +
                      name +
                      mod_name +
                      '.java', 'w+') as fo:
                fo.write(toret)
                fo.close()

    def generate_ModelJGraph(self, ob, mod_name="ModelJGraph", dir="models"):
        logging.info("Generating models >>>>>>>>>>>>>>>>>")
        with open("source_templates/"+mod_name+"_Template.txt") as f:
            template = Template(f.read())
            f.close()

        for o in ob:
            name = o.name.replace(" ", "")
            logging.info("Generating Model: "+name)
            creaToolBar = self.creaToolBar(name, o)
            getAllowedRelationships = self.getAllowedRelationships(name, o)
            getAllowedEntities = self.getAllowedEntities(name, o)
            getPossibleRelationships = self.getPossibleRelationships(name, o)
            getInstanciaNRelacion = self.getInstanciaNRelacion(name, o)
            createCell = self.createCell(name, o)
            getDefaultSize = self.getDefaultSize(name, o)
            insertDuplicated = self.insertDuplicated(name, o)

            d = {"who"+mod_name: name+mod_name,
                 "whoDataEntity": name+"DataEntity",
                 "whoCellViewFactory": name + ".CellViewFactory()",
                 "who": name,
                 "creaToolBar": creaToolBar,
                 "getAllowedRelationships": getAllowedRelationships,
                 "getPossibleRelationships": getPossibleRelationships,
                 "getInstanciaNRelacion": getInstanciaNRelacion,
                 "createCell": createCell,
                 "getDefaultSize": getDefaultSize,
                 "insertDuplicated": insertDuplicated,
                 "getAllowedEntities": getAllowedEntities}
            toret = template.safe_substitute(d)

            with open("source_output/" +
                      dir +
                      "/" +
                      name +
                      mod_name +
                      '.java', 'w+') as fo:
                fo.write(toret)
                fo.close()

    # ActionsFactory exclusive
    def createChangeViewActions(self, name, ob):
        with open("source_templates/createChangeViewActions.txt") as f:
            template = Template(f.read())
            f.close()
        with open("source_templates/createChangeViewActionsEntities.txt") as f:
            entities = Template(f.read())
            f.close()
        with open("source_templates/createChangeViewActionsRelations.txt") as f:
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
        with open("source_templates/createDiagramSpecificInsertActions.txt") as f:
            template = Template(f.read())
            f.close()
        with open("source_templates/createDiagramSpecificInsertActionsEntities.txt") as f:
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
        with open("source_templates/CellViewFactoryEntities.txt") as f:
            entities = Template(f.read())
            f.close()
        with open("source_templates/CellViewFactoryRelations.txt") as f:
            relations = Template(f.read())
            f.close()

        toret = ""
        for k in ob.entities:
            dd = {
                "name": k.name,
                "nameView": k.name+"View"
            }
            toret += entities.safe_substitute(dd)
        for k in ob.relations:
            dd = {
                "nameView": k.name+"View",
                "nameEdge": k.name+"Edge"
            }
            toret += relations.safe_substitute(dd)

        return toret
#/////////////////////////////////////////7

    def creaToolBar(self, name, ob):
        with open("source_templates/creaToolBar.txt") as f:
            template = Template(f.read())
            f.close()
        with open("source_templates/creaToolBarEntities.txt") as f:
            ent = Template(f.read())
            f.close()

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
            f.close()
        with open("source_templates/getAllowedRelationshipsRelationships.txt") as f:
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
        with open("source_templates/getAllowedEntities.txt") as f:
            template = Template(f.read())
            f.close()
        with open("source_templates/getAllowedEntitiesEntities.txt") as f:
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
        with open("source_templates/getPossibleRelationships.txt") as f:
            template = Template(f.read())
            f.close()
        with open("source_templates/getPossibleRelationshipsBinary.txt") as f:
            ent = Template(f.read())
            f.close()
        with open("source_templates/getPossibleRelationshipsNoBinary.txt") as f:
            ent2 = Template(f.read())
            f.close()

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
             "noBinary": tt2}

        return template.safe_substitute(d)

    def getInstanciaNRelacion(self, name, ob):
        with open("source_templates/getInstanciaNRelacion.txt") as f:
            template = Template(f.read())
            f.close()
        with open("source_templates/getInstanciaNRelacionRelationship.txt") as f:
            ent = Template(f.read())
            f.close()

        toret = ""
        for k in ob.relations:
            dd = {
                "edge": k.name+"Edge",
                "name": k.name
            }
            toret += ent.safe_substitute(dd)
        d = {"relations": toret}

        return template.safe_substitute(d)

    def createCell(self, name, ob):
        with open("source_templates/createCell.txt") as f:
            template = Template(f.read())
            f.close()
        with open("source_templates/createCellEntity.txt") as f:
            ent = Template(f.read())
            f.close()

        toret = ""

        for e in ob.entities:
            dd = {
                "name": e.name,
                "cratename": "create"+e.name,
                "namecell": e.name+"Cell"
            }
            toret += ent.safe_substitute(dd)
        toret += '\n       throw new ingenias.exception.InvalidEntity("Entity type "+entity+" is not allowed in this diagram"); '
        d = {"entity": toret}

        return template.safe_substitute(d)

    def createCellPanel(self, name, ob):
        with open("source_templates/createCell.txt") as f:
            template = Template(f.read())
            f.close()
        with open("source_templates/createCellPanel.txt") as f:
            ent = Template(f.read())
            f.close()

        toret = ""

        for e in ob.entities:
            dd = {
                "name": e.name,
                "cratename": "create"+e.name,
                "namecell": e.name+"Cell"
            }
            toret += ent.safe_substitute(dd)
        toret += '\n       throw new ingenias.exception.InvalidEntity("Entity type "+entity+" is not allowed in this diagram"); '
        d = {"entity": toret}

        return template.safe_substitute(d)

    def getDefaultSize(self, name, ob):
        with open("source_templates/getDefaultSize.txt") as f:
            template = Template(f.read())
            f.close()
        with open("source_templates/getDefaultSizeEntity.txt") as f:
            ent = Template(f.read())
            f.close()

        toret = ""

        for e in ob.entities:
            dd = {
                "name": e.name,
                "nameview": e.name+"View"
            }
            toret += ent.safe_substitute(dd)
        toret += '\n       throw new ingenias.exception.InvalidEntity("Entity type "+entity+" is not allowed in this diagram"); '
        d = {"entity": toret}

        return template.safe_substitute(d)

    def insertDuplicated(self, name, ob):
        with open("source_templates/insertDuplicated.txt") as f:
            template = Template(f.read())
            f.close()
        with open("source_templates/insertDuplicatedEntities.txt") as f:
            ent = Template(f.read())
            f.close()

        toret = ""

        for e in ob.entities:
            dd = {
                "name": e.name,
                "namecell": e.name+"Cell"
            }
            toret += ent.safe_substitute(dd)
        d = {"entities": toret}

        return template.safe_substitute(d)
