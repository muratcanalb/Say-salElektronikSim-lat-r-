/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mühproj3;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import javax.swing.JPanel;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;

public class LGSpanel extends JPanel {
private int x= 0;
	
private Image image;
private Graphics2D graphics2D;
private static int tempX=123;
private static int tempY=122;
protected LinkedList<CircuitComponents> circuitComponents = new LinkedList<CircuitComponents>();
private CircuitComponents tempComp;
private toolBox toolbox;
private boolean cizilmis=false;
private boolean alreadyDeleted=false;
int flagger=0;
	public LGSpanel() {
		try {
			
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
//				System.out.println(circuitComponents.size());
				alreadyDeleted=false;
				if(flagger !=toolbox.getSelected()){
					cizilmis=false;
					tempComp.setVisible(false);
				}
				flagger =toolbox.getSelected();
				switch(toolbox.getSelected()){
				
				case 0:
					tempComp.setVisible(false);
				
					break;
				case 1:
					
					break;
				
				case 2:
					if(cizilmis==false){
						tempComp = new Input(e.getX(),e.getY());
						circuitComponents.getFirst().myStaticID--;
						add(tempComp);
						tempComp.setVisible(true);
						cizilmis=true;
					}
					tempComp.setBounds(e.getX()+20,e.getY()+20,tempComp.getHeight(),tempComp.getWidth());
					repaint();
					break;
				case 3:
					if(cizilmis==false){
						tempComp = new Or(e.getX(),e.getY(),0,0);
						circuitComponents.getFirst().myStaticID--;
						add(tempComp);
						tempComp.setVisible(true);
						cizilmis=true;
					}
					tempComp.setBounds(e.getX()+20,e.getY()+20,tempComp.getHeight(),tempComp.getWidth());
					repaint();
					break;
				case 4:
					if(cizilmis==false){
						tempComp = new Nor(e.getX(),e.getY(),0,0);
						circuitComponents.getFirst().myStaticID--;
						add(tempComp);
						tempComp.setVisible(true);
						cizilmis=true;
					}
					tempComp.setBounds(e.getX()+20,e.getY()+20,tempComp.getHeight(),tempComp.getWidth());
					repaint();
					break;
				case 5:
					if(cizilmis==false){
						tempComp = new And(e.getX(),e.getY(),0,0);
						circuitComponents.getFirst().myStaticID--;
						add(tempComp);
						tempComp.setVisible(true);
						cizilmis=true;
					}
					tempComp.setBounds(e.getX()+20,e.getY()+20,tempComp.getHeight(),tempComp.getWidth());
					repaint();
					break;
				case 6:
					if(cizilmis==false){
						tempComp = new Nand(e.getX(),e.getY(),0,0);
						circuitComponents.getFirst().myStaticID--;
						add(tempComp);
						tempComp.setVisible(true);
						cizilmis=true;
					}
					tempComp.setBounds(e.getX()+20,e.getY()+20,tempComp.getHeight(),tempComp.getWidth());
					repaint();
					break;
				case 7:
					if(cizilmis==false){
						tempComp = new Xor(e.getX(),e.getY(),0,0);
						circuitComponents.getFirst().myStaticID--;
						add(tempComp);
						tempComp.setVisible(true);
						cizilmis=true;
					}
					tempComp.setBounds(e.getX()+20,e.getY()+20,tempComp.getHeight(),tempComp.getWidth());
					repaint();
					break;
				case 8:
					if(cizilmis==false){
						tempComp = new NXor(e.getX(),e.getY(),0,0);
						circuitComponents.getFirst().myStaticID--;
						add(tempComp);
						tempComp.setVisible(true);
						cizilmis=true;
					}
					tempComp.setBounds(e.getX()+20,e.getY()+20,tempComp.getHeight(),tempComp.getWidth());
					repaint();
					break;
				case 9:
					if(cizilmis==false){
						tempComp = new Output(e.getX(),e.getY());
						circuitComponents.getFirst().myStaticID--;
						add(tempComp);
						tempComp.setVisible(true);
						cizilmis=true;
					}
					tempComp.setBounds(e.getX()+20,e.getY()+20,tempComp.getHeight(),tempComp.getWidth());
					repaint();
					break;
				}
			}
		});

		addContainerListener(new ContainerAdapter() {
			@Override
			public void componentAdded(ContainerEvent arg0) {
				addActionToComponents();
			}
		});
                
		addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(cizilmis==true){
				circuitComponents.add(tempComp);
				circuitComponents.getFirst().myStaticID++;
				add(tempComp);
				drawLines();
				}
				cizilmis=false;
			}
		});
		setDoubleBuffered(false);
		setLayout(new BorderLayout(0, 0));
		setBackground(new Color(Integer.parseInt( "DEEED4",16)));
		
		tempComp = new Input(tempX,tempY);

		tempComp.setBounds(tempX,tempY,tempComp.getHeight(),tempComp.getWidth());
		
		circuitComponents.add(tempComp);
		add(tempComp, BorderLayout.EAST);
		circuitComponents.getFirst().setVisible(false);
		repaint();
	}
private void addActionToComponents(){
	if(circuitComponents.size()>1){
		circuitComponents.get(circuitComponents.size()-1).addMouseListener(new MouseAdapter() {
			@SuppressWarnings("static-access")
			@Override
			public void mouseClicked(MouseEvent evt) {
				if(toolbox.getSelected()==1){
					if(alreadyDeleted==false&&circuitComponents.getFirst().cuRRStaticID !=0){
					deleteComponent(circuitComponents.getFirst().cuRRStaticID);
					alreadyDeleted=true;
					}
					
				}

				refresh();
				
			
			}
		});
		circuitComponents.get(circuitComponents.size()-1).addComponentListener(new ComponentAdapter() {
			@Override
			public void componentMoved(ComponentEvent arg0) {
				drawLines();
			}
		});
	}
}
protected void refresh() {
	System.out.println(x++);
	//Çıktıları Çalıştırmak için
	for(int h =0;h<circuitComponents.size() ;h++){
		for(int i =0;i<circuitComponents.size() ;i++){
			if(circuitComponents.get(i) instanceof Logic){
				circuitComponents.get(i).setInput1(circuitComponents.get(circuitComponents.get(i).getInputLoc1()).getOutput());
				circuitComponents.get(i).setInput2(circuitComponents.get(circuitComponents.get(i).getInputLoc2()).getOutput());
				circuitComponents.get(i).processGate((circuitComponents.get(i).getInput1()==0?false:true), (circuitComponents.get(i).getInput2()==0?false:true));
		}
	}
}
	//for setting Input location
for(int h =0;h<circuitComponents.size() ;h++){
	for(int i =0;i<circuitComponents.size() ;i++){
		if(circuitComponents.get(i).outputFlag==1 && circuitComponents.get(i) instanceof Logic && 
				circuitComponents.get(h).inputFlag==1 && circuitComponents.get(h) instanceof Output 
				 ){
			
			circuitComponents.get(h).setInputLoc1(i);
			drawLines();
		}
		 if(circuitComponents.get(i).inputFlag==2 &&  circuitComponents.get(i) instanceof Logic
				 && circuitComponents.get(h).outputFlag==1
				 && ((circuitComponents.get(h) instanceof Logic)|| (circuitComponents.get(h) instanceof Input))){
			 circuitComponents.get(i).setInput2(circuitComponents.get(h).getOutput());
			 circuitComponents.get(i).setInputLoc2(h);
			 drawLines();
		}
		 if(circuitComponents.get(i).inputFlag==1 &&  circuitComponents.get(i) instanceof Logic
				 && circuitComponents.get(h).outputFlag==1 
				 && ((circuitComponents.get(h) instanceof Logic)|| (circuitComponents.get(h) instanceof Input))){
			 circuitComponents.get(i).setInput1(circuitComponents.get(h).getOutput());
			circuitComponents.get(i).setInputLoc1(h);
			drawLines();
		}
		 
	}
	}
//Ampule bağlı Kapı değerini almak için
for(int h =0;h<circuitComponents.size() ;h++){
	for(int i =0;i<circuitComponents.size() ;i++){
		if(circuitComponents.get(i) instanceof Logic 
				&& circuitComponents.get(h) instanceof Output 
				&& circuitComponents.get(h).getInputLoc1()==i
				){
			int a = circuitComponents.get(i).getInput1();
			int b = circuitComponents.get(i).getInput2();
			circuitComponents.get(i).processGate((a==0?false:true), (b==0?false:true));
			circuitComponents.get(h).setOutput(circuitComponents.get(i).getOutput());
			circuitComponents.get(h).repaint();
		}
	}
	}
	
}
@SuppressWarnings("static-access")
private void deleteComponent(int nTh) {
	circuitComponents.get(nTh).setVisible(false);
	for(int i =1;i<circuitComponents.size() ;i++){
		if(circuitComponents.get(i) instanceof Output )
		{
			circuitComponents.get(i).setOutput(0);
		}
		if(circuitComponents.get(i).getInputLoc1()==nTh){
			circuitComponents.get(i).setInputLoc1(0);
			circuitComponents.get(i).setInput1(0);
		}
		if(circuitComponents.get(i).getInputLoc2()==nTh){
			circuitComponents.get(i).setInputLoc2(0);
			circuitComponents.get(i).setInput2(0);
		}
		if(circuitComponents.get(i).getInputLoc1()>nTh){
			circuitComponents.get(i).setInputLoc1(circuitComponents.get(i).getInputLoc1()-1);
		}
		if(circuitComponents.get(i).getInputLoc2()>nTh){
			circuitComponents.get(i).setInputLoc2(circuitComponents.get(i).getInputLoc2()-1);
		}
		if(i>nTh){
			circuitComponents.get(i).myID--;
		}
	}
	circuitComponents.remove(nTh);
	circuitComponents.getFirst().myStaticID--;
	circuitComponents.getFirst().cuRRStaticID=0;
	refresh();
	drawLines();
}
		private void drawLines() {
			clear();
			for(int i =0;i<circuitComponents.size() ;i++){
				graphics2D.setColor(Color.black);
				if(circuitComponents.get(i) instanceof Logic
						&& circuitComponents.get(i).getInputLoc1()!=0 
						){
					

					 graphics2D.drawLine(circuitComponents.get(i).getLocation().x+12, circuitComponents.get(i).getLocation().y+20,
							 circuitComponents.get(circuitComponents.get(i).getInputLoc1()).getLocation().x+50, 
							 circuitComponents.get(circuitComponents.get(i).getInputLoc1()).getLocation().y+30);
			}if(circuitComponents.get(i) instanceof Logic
					&& circuitComponents.get(i).getInputLoc2()!=0 
					){				
				
				 graphics2D.drawLine(circuitComponents.get(i).getLocation().x+12, circuitComponents.get(i).getLocation().y+40,
						 circuitComponents.get(circuitComponents.get(i).getInputLoc2()).getLocation().x+50, 
						 circuitComponents.get(circuitComponents.get(i).getInputLoc2()).getLocation().y+30);
		}
				if(circuitComponents.get(i) instanceof Output 
						&& circuitComponents.get(i).getInputLoc1()!=0 ){
					
					 graphics2D.drawLine(circuitComponents.get(i).getLocation().x, circuitComponents.get(i).getLocation().y+25,
							 circuitComponents.get(circuitComponents.get(i).getInputLoc1()).getLocation().x+50, 
							 circuitComponents.get(circuitComponents.get(i).getInputLoc1()).getLocation().y+30);
			}
				circuitComponents.get(i).inputFlag=0;
				circuitComponents.get(i).outputFlag=0;
				circuitComponents.get(i).repaint();
		}
			repaint();
	}
	
	@Override
	public void paintComponent(Graphics g){

        super.paintComponent (g);
    if(image == null){
        image = createImage(getSize().width, getSize().height);
        graphics2D = (Graphics2D)image.getGraphics();
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.setFont(new Font("Tahoma",Font.PLAIN,14));
        graphics2D.setColor(Color.black);
        clear();


    }
    g.drawImage(image, 0, 0, null);
}
	
	public void clear(){
	    graphics2D.setPaint(new Color(Integer.parseInt( "DEEED4",16)));
	    graphics2D.fillRect(0, 0, getSize().width, getSize().height);
	    repaint();
	}
	public void setToolbox(toolBox tool){
	toolbox = tool;
	}
}