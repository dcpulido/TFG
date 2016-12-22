class Parser:
    def __init__(self,diagram,filename):
      self.diagram=diagram
      self.filename=filename

    def setAuthorDate(self,autor):
      self.autor=autor
      self.date=str(datetime.datetime.today()).split()[0]

    def remove_repeats(self,ls):
        toret=[]
        for l in ls:
            fl=False
            for t in toret:
                if l == t:fl=True
            if fl==False:toret.append(l)
        return toret

    def defining_the_extends(self,relations):
        for rel in relations:
            fl=False
            for k in self.usedRelations:
                if rel.name == k.name and rel.name!='Extends':
                    fl=True
                    k.targets.append(rel.target)
                    k.sources.append(rel.source)
            if fl==False and rel.name!='Extends':
                self.currentcmplxRel=complexRelation(rel.name)
                self.currentcmplxRel.targets.append(rel.target)
                self.currentcmplxRel.sources.append(rel.source)
                self.usedRelations.append(self.currentcmplxRel)

        #definimos extends y quitamos repetidos
        for rel in relations:
            if rel.name == 'Extends':
                #extension
                source = rel.source
                #clase base
                target = rel.target

                for k in self.usedRelations:
                    sources = self.remove_repeats(k.sources)
                    targets = self.remove_repeats(k.targets)
                    for s in sources:
                        if s == target:
                            k.sources.append(source)
                    for t in targets:
                        if t == target:
                            k.targets.append(source)

        for k in self.usedRelations:
            k.sources = self.remove_repeats(k.sources)
            k.targets = self.remove_repeats(k.targets)


    def parse_relation(self,relations,diagram,di):
        self.usedRelations=[]
        self.defining_the_extends(relations)
        

        ##modificamos los targets y sources eliminando los extends
        


        for rel in self.usedRelations:

            re=ET.SubElement(diagram,"relationship",name=rel.name)
            st1=""
            st2=""
            #ewliminamos las clases abstractas de los sources y targets
            for so in rel.sources:
                fl=False
                for si in di.abstracts:
                    if si.name == so :fl=True
                if fl==False:st1+=so+", "
                
            ET.SubElement(re,"source").text=st1[0:len(st1)-2]
            for so in rel.targets:
                fl=False
                for si in di.abstracts:
                    if si.name == so :fl=True
                if fl==False:st2+=so+", "
            ET.SubElement(re,"target").text=st2[0:len(st2)-2]

    def toXML(self):
      root = ET.Element("filter")
      logging.info("Creating new root")

      name = ET.SubElement(root, "name").text="DPDF Model"
      author = ET.SubElement(root, "author").text=self.autor
      date = ET.SubElement(root, "date").text=self.date
      logging.info("Meta:name: "+ name +" autor: "+author+" date: "+date)
      diagrams = ET.SubElement(root,"diagrams")


      for di in self.diagram:

         logging.info("new diagram: "+di.name)
         diagram = ET.SubElement(diagrams,"diagram",name=di.name)
         for et in di.entities:
            ET.SubElement(diagram,"entity").text=et.name
         ET.SubElement(diagram,"entity").text="TextNote"
         ET.SubElement(diagram,"entity").text="UMLComment"
         self.parse_relation(di.relations,diagram,di)

      tree = ET.ElementTree(root)
      logging.info("writing on: "+self.filename)
      tree.write(self.filename)

    
