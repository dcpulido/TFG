package ingenias.editor.widget;

import ingenias.editor.models.*;
import ingenias.editor.IDEState;
import ingenias.editor.Model;
import ingenias.editor.cell.MentalInstanceSpecificationCell;
import ingenias.editor.entities.AgentModelDataEntity;
import ingenias.editor.entities.DeployDiagramDataEntity;
import ingenias.editor.entities.FrameFact;
import ingenias.editor.entities.MentalInstanceSpecification;
import ingenias.editor.entities.MentalState;
import ingenias.editor.entities.ModelDataEntity;
import ingenias.editor.entities.Slot;
import ingenias.editor.entities.SlotValueSpecification;
import ingenias.editor.entities.ViewPreferences.ViewType;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import org.jgraph.JGraph;
import org.jgraph.graph.BasicMarqueeHandler;

public class WrapFlowPanel extends JPanel  {

	private Vector<JLabel> labels=new Vector<JLabel>();
	public WrapFlowPanel(){
		super(new FlowLayout());
		this.addComponentListener(new ComponentListener(){

			public void componentHidden(ComponentEvent arg0) {}

			public void componentMoved(ComponentEvent arg0) {}

			public void componentResized(ComponentEvent arg0) {
				System.out.println("resizing");
				Runnable run=new Runnable(){
					public void run(){
						Dimension dim=getSize();
						int width=0;						
						Vector<JLabel> nlabel=new Vector<JLabel>(labels);
						Vector<JLabel> oldLabels=new Vector<JLabel>(labels);
						int oldSize=0;
						System.out.println("finish1");						
						while (nlabel.size()!=oldSize){
							oldSize=nlabel.size();
							nlabel=obtainNewLabels(dim, nlabel);							
						}
						System.out.println("finish2");
						for (JLabel label:oldLabels){
							remove(label);
						}
						labels.clear();
						for (JLabel label:nlabel){
							System.out.print(label.getText()+"-");
							add(label);
						}
						System.out.println("");
					}
				};

				SwingUtilities.invokeLater(run);


			}

			private Vector<JLabel> obtainNewLabels(Dimension dim,Vector<JLabel> labels) {
				int width=0;
				Vector<JLabel> nlabels=new Vector<JLabel>();						
				for (JLabel label:labels){
					Dimension ldim=label.getSize();
					if (ldim.getWidth()+width > dim.getWidth()){
						int remWidth=(int) (dim.getWidth()-width);
						String text=label.getText();
						Font f=label.getFont();
						FontMetrics metrics = label.getFontMetrics(f);
						String allowed="";
						int length=0;
						System.out.println(text);
						while (metrics.stringWidth(allowed)<remWidth  
								&& length<text.length()){
							length=length+1;
							allowed=text.substring(0,length);										
						}
						nlabels.add(new JLabel(allowed));
						nlabels.add(new JLabel(text.substring(length,text.length())));								
					} else {
						nlabels.add(label);
					}

				}
				return nlabels;
			}

			public void componentShown(ComponentEvent arg0) {}				
		});
	}

	@Override
	public Component add(Component comp) {
		// TODO Auto-generated method stub
		if (comp instanceof JLabel){			
			labels.add((JLabel) comp);
			System.out.println(((JLabel) comp).getText());
		}
		return super.add(comp);
	}




	public static void main(String args[]){
		
		JFrame main=new JFrame();
		IDEState empty = IDEState.emptyIDEState();
		
		AgentModelModelJGraph jg=new AgentModelModelJGraph(
				new AgentModelDataEntity("2"),"",empty.om, 
				new Model(empty),new BasicMarqueeHandler(), 
				empty.prefs);
		main.getContentPane().setLayout(new BorderLayout());
		main.getContentPane().add(jg,BorderLayout.CENTER);
		
		MentalInstanceSpecification mis=new MentalInstanceSpecification("1");
		mis.getPrefs().setView(ViewType.INGENIAS);
		FrameFact ff=new FrameFact("2");		
		mis.setInstanceType(ff);
		SlotValueSpecification sl1=new SlotValueSpecification("3");
		sl1.setValue("hoasdadadsasda asd as dasd ");
		Slot s=new Slot("4");
		s.setName("hola");
		s.setType("adios");
		sl1.setSlot(s);		
		mis.addSlotsValues(sl1);
		mis.addSlotsValues(sl1);
		MentalInstanceSpecificationCell c=new MentalInstanceSpecificationCell(mis);
		jg.insertDuplicated(new Point(20,20), mis);
		System.err.println(GridBagConstraints.BOTH);
		
		MentalState ms=new MentalState("hay que ver que identificador mas largo");
		jg.insertDuplicated(new Point(20,100), ms);
		main.pack();
		main.setVisible(true);
		
//		final JFrame jf=new JFrame();
//		jf.addMouseListener(new MouseListener(){
//
//			public void mouseClicked(MouseEvent arg0) {
//				System.out.println("replainted");
//				jf.repaint();
//				
//			}
//
//			public void mouseEntered(MouseEvent arg0) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			public void mouseExited(MouseEvent arg0) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			public void mousePressed(MouseEvent arg0) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			public void mouseReleased(MouseEvent arg0) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//		});
//		JPanel jp = createPanel();
//		
//		
//		jf.getContentPane().setLayout(new BorderLayout());
//		Box vbox = Box.createVerticalBox();
//		vbox.add(jp);
//		vbox.add(createPanel());
//		vbox.add(createPanel());
//		
//		jf.getContentPane().add(vbox,BorderLayout.SOUTH);
//	
//		jf.pack();
//		jf.setVisible(true);
	}

	private static JPanel createPanel() {
		JPanel jp=new JPanel(new GridBagLayout());
		JTextArea jta1=new JTextArea("aaaaaaaaaaaaa aaaaaaaaaa aaaaaaaaaaaa");
		jta1.setLineWrap(true);
		jta1.setWrapStyleWord(true);
		jta1.setEditable(false);		
		JTextArea jta2=new JTextArea("bbbbbbbbbbb bbbbbbbb");
		jta2.setLineWrap(true);
		jta2.setWrapStyleWord(true);
		jta2.setEditable(false);
		GridBagConstraints gbc1=new GridBagConstraints();
		GridBagConstraints gbc2=new GridBagConstraints();
		GridBagConstraints gbc3=new GridBagConstraints();		
		gbc1.gridx=0;
		gbc1.gridy=0;
		gbc1.weightx=1;
		gbc1.ipadx=20;
		gbc2.gridx=1;
		gbc2.gridy=0;
		gbc3.gridx=2;
		gbc3.weightx=1;
		gbc3.ipadx=20;
		gbc3.gridy=0;		
		JLabel jl1=new JLabel("asdasda asdadad");
		JLabel jl2=new JLabel("asdasda asdadad");
		jp.add(jta1,gbc1);
		jp.add(jl1,gbc2);
		jp.add(jta2,gbc3);
		return jp;
	}
}
