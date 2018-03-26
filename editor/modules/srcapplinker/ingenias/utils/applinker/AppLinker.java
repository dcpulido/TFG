package ingenias.utils.applinker;

import ingenias.exception.NotInitialised;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Vector;

import javacc.parser.JavaParser;
import javacc.parser.ParseException;
import javacc.parser.ast.CompilationUnit;


import ingenias.editor.Editor;
import ingenias.editor.Log;
import ingenias.editor.ProjectProperty;
import ingenias.editor.extension.BasicToolImp;
import ingenias.exception.CannotLoad;
import ingenias.exception.DamagedFormat;
import ingenias.exception.InvalidAttribute;
import ingenias.exception.InvalidColection;
import ingenias.exception.InvalidEntity;
import ingenias.exception.InvalidGraph;
import ingenias.exception.NotFound;
import ingenias.exception.NullEntity;
import ingenias.exception.UnknowFormat;
import ingenias.generator.browser.Browser;
import ingenias.generator.browser.Graph;
import ingenias.generator.browser.GraphAttribute;
import ingenias.generator.browser.GraphAttributeFactory;
import ingenias.generator.browser.GraphCollection;
import ingenias.generator.browser.GraphEntity;
import ingenias.generator.browser.GraphEntityFactory;
import ingenias.generator.browser.GraphFactory;
import ingenias.javacc.java.ApplicationVisitor;


public class AppLinker extends BasicToolImp {
	private boolean parserAlreadyInitialized=false;
	private JavaParser jp=null;

	public AppLinker(Browser browser) {
		super(browser);

	}

	public AppLinker(String file) throws UnknowFormat, DamagedFormat,
	CannotLoad {
		super(file);
	}

	@Override
	public String getDescription() {
		return "It updates Application entities with the methods of Java classes";
	}

	@Override
	public String getName() {
		return "AppLinker";
	}

	@Override
	public void run() {
		try {
			String folderForComponents=((ProjectProperty) this.getProperties().get("Ingenias Agent Framework generator:jadeproject")).value+"/"+
			((ProjectProperty) this.getProperties().get("Ingenias Agent Framework generator:jadeperm")).value+"/ingenias/jade/components/";
			
			GraphFactory gf=null;
			GraphEntityFactory gef=null;
			GraphAttributeFactory  gaf=null; 
			try {
				gf = GraphFactory.createDefaultGraphFactory(browser);
				gef=GraphEntityFactory.createDefaultGraphFactory(browser);
				gaf=GraphAttributeFactory.createDefaultGraphFactory(browser);
			} catch (NotInitialised ex) {
				ex.printStackTrace();
			}			

			GraphEntity[] entities = this.getBrowser().getAllEntities();


			Vector<GraphEntity> ge=new Vector<GraphEntity>();
			Vector<Graph> associatedgraphs=new Vector<Graph>();
			for (int k=0;k<entities.length;k++){
				if (entities[k].getType().toLowerCase().equals("ingeniascomponent")){
					GraphAttribute atts;
					atts = entities[k].getAttributeByName("Files");
					GraphCollection gc=atts.getCollectionValue();
					for (int i=0;i<gc.size();i++){
						ge.add(gc.getElementAt(i));						
					}    		  
				}
			}
			for (int k=0;k<ge.size();k++){
				GraphEntity fspec=ge.elementAt(k);
				GraphAttribute attfile = fspec.getAttributeByName("File");
				GraphAttribute attentity = fspec.getAttributeByName("Entity");
				GraphEntity entity=attentity.getEntityValue();
				if (entity.getType().toLowerCase().equals("application")||
						entity.getType().toLowerCase().equals("internalapplication")||
						entity.getType().toLowerCase().equals("environmentapplication")){
					try {
						String file=attfile.getSimpleValue();
						if (file==null || file.length()==0){
							file=folderForComponents+entity.getID()+"App.java";
						}
						insertNewMethodsInApplication(gf,gef,gaf,entity,
								
								file);
					} catch (InvalidGraph e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvalidEntity e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvalidAttribute e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvalidColection e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		} catch (NotFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullEntity e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void insertNewMethodsInApplication(GraphFactory gf, GraphEntityFactory gef, GraphAttributeFactory  gaf, 
			GraphEntity entity, String filename) throws InvalidGraph, InvalidEntity, InvalidAttribute, InvalidColection, IOException, NullEntity, NotFound {

		FileInputStream fis=null;
		try {
			fis=new FileInputStream(filename);

			jp=new JavaParser(fis);				


			CompilationUnit root = jp.CompilationUnit();

			ApplicationVisitor av=new ApplicationVisitor();
			root.accept(av,"");
			fis.close();
			Vector<String> methods=av.getMethodnames();
			Vector<String> methodType=av.getMethodtype();

			Graph[] gs=this.getBrowser().getGraphs();
			for (int k=0;k<methods.size();k++){
				this.insertNewMethod(gf,gef,gaf, gs[0],entity,methods.elementAt(k),methodType.elementAt(k));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.getInstance().logERROR("File "+filename+" not found. Cannot link the application "+entity.getID());			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			Log.getInstance().logERROR("File "+filename+" could not parsed due to syntax errors.\nCannot link the application "+entity.getID()+".\n"+e.getMessage());			
			fis.close();
		}

	}

	private boolean exists( GraphEntity ent, String mname, String result) throws NullEntity, NotFound{
		GraphCollection methods = ent.getAttributeByName("Methods").getCollectionValue();
		boolean found=false;
		for (int k=0;k<methods.size() &&!found;k++){
			GraphEntity method=methods.getElementAt(k);
			found=mname.equals(method.getAttributeByName("Name").getSimpleValue());
		}
		return found;
	}

	/**
	 * This test creates an entity with collection attributes
	 * and initializes them
	 * 
	 * @param gf The graph factory created to manage instances
	 * @param result 
	 * @throws InvalidGraph
	 * @throws InvalidEntity
	 * @throws InvalidAttribute
	 * @throws InvalidColection
	 * @throws NotFound 
	 * @throws NullEntity 
	 */
	private void insertNewMethod(GraphFactory gf, GraphEntityFactory gef, GraphAttributeFactory  gaf, Graph g, GraphEntity ent, String mname, String result) throws InvalidGraph, InvalidEntity, InvalidAttribute, InvalidColection, NullEntity, NotFound {
		if (!exists(ent,mname,result)){
			String methodid=((ingenias.editor.Model)g.getGraph().getModel()).getNewId();
			GraphEntity nmethod=gef.createEntity("Method",methodid,g);
			Vector<GraphEntity> nv=new Vector<GraphEntity>(); 		
			GraphAttribute att1=gaf.createAttribute("Name",mname,g);
			GraphAttribute att2=gaf.createAttribute("Result",result,g);				
			nmethod.setAttribute(att1);
			nmethod.setAttribute(att2);
			nv.add(nmethod);		
			GraphCollection gc=gaf.createCollection(nv,g);
			GraphAttribute methods=gaf.createAttribute("Methods",gc,g);	
			ent.setAttribute(methods);		
		}
	}

	@Override
	protected Vector<ProjectProperty> defaultProperties() {
		return new Vector<ProjectProperty>();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception  {
		ingenias.editor.Log.initInstance(new PrintWriter(System.out));
		AppLinker html = new AppLinker(args[0]);
		html.run();
		System.err.println(ingenias.editor.Log.getInstance().getErrors());	}



}
