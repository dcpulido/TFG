package ingenias.generator.interpreter;

import java.io.File;
import java.util.Iterator;
import java.util.Vector;

public class TemplateTree {
	private Object root=null;	
	
	private Vector<TemplateTree> children=new Vector<TemplateTree>();
	
	public TemplateTree(Tag root){
		this.root=root;
		if (root==null)
			throw new RuntimeException("Error: template tree initialized with null root");
	}
	
	public TemplateTree(File file){
		this.root=file;
		if (root==null)
			throw new RuntimeException("Error: template tree initialized with null root");
	}
	
	public boolean isFile(){
		return root!=null && (root instanceof File);
	}
	
	
	public File getFile(){
		return (File)root; 
	}
	
	public void addChildren(TemplateTree tt){
		children.add(tt);
	}
	
	public Iterator iterateChildren(){
		return children.iterator();
	}
	
	public Tag getTag(){
		return (Tag)this.root;
	}
	
	public Object getRoot(){
		return this.root;
	}
	
	public static void visit(TemplateTree tt, Visitor v){
		v.analyze(tt.getRoot());
		Iterator it=tt.iterateChildren();
		while (it.hasNext()){
			TemplateTree child=(TemplateTree)it.next();
			visit(child,v);
		}
	}
	
	public static void visit(TemplateTree tt, VisitorWithTreeAccess v){
		v.analyze(tt.getRoot(),tt);
		Iterator it=tt.iterateChildren();
		while (it.hasNext()){
			TemplateTree child=(TemplateTree)it.next();
			visit(child,v);
		}
	}
	
	public static void multiplevisit(TemplateTree tt, Visitor[] v){
		for (int k=0;k<v.length;k++){
			v[k].analyze(tt.getRoot());		
		}
		
		Iterator it=tt.iterateChildren();
		while (it.hasNext()){
			TemplateTree child=(TemplateTree)it.next();
			multiplevisit(child,v);
		}
	}

	
	public Tag[] getRepeatPath(Tag repeat) {
		Vector<Tag> result=new Vector<Tag>();
		Iterator it=this.iterateChildren();
		Tag[] subpath=null;		
		if (this.getTag()!=repeat){
			while (it.hasNext() && (subpath==null||subpath.length==0) && result.size()==0){
				TemplateTree current=(TemplateTree) it.next();
				subpath=current.getRepeatPath(repeat);
				if (subpath!=null && subpath.length!=0){
					for (int k=0;k<subpath.length;k++)
						result.add(subpath[k]);
					result.insertElementAt(this.getTag(),0);
				}
			}
			
			return result.toArray(new Tag[result.size()]);
		} else
			return new Tag[]{repeat};			
	}

	
	
	
}
