/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mühproj3;

/**
 *
 * @author muratcan
 */
import java.awt.Graphics;
import java.awt.Point;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;


public abstract class Logic extends CircuitComponents{
	
	private Point xy= new Point();

    
	public Logic(int x,int y,int in1,int in2) {
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				setToolTipText(getInput1() +" ,"+getInput2());
			}
		});
        //setOpaque(false);
		setLayout(new BorderLayout(0, 0));
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				inputFlag=0;
				outputFlag=0;
				if((evt.getX()-7)<7 && (evt.getY()-15)<7 && (evt.getX()-7)>0 && (evt.getY()-15)>0){ inputFlag=1;}
				else if((evt.getX()-7)<7 && (evt.getY()-37)<7 && (evt.getX()-7)>0 && (evt.getY()-37)>0){inputFlag=2;}
				else{inputFlag=0;}
				if((evt.getX()-47)<=7 && (evt.getY()-26)<=7 && (evt.getX()-47)>0 && (evt.getY()-26)>0 && outputFlag==0){;outputFlag=1;}
				else if((evt.getX()-47)<=7 && (evt.getY()-26)<=7 && (evt.getX()-47)>0 && (evt.getY()-26)>0 && outputFlag==1){;outputFlag=0;}
				repaint();
			}
		});
		xy.x=x;
		xy.y=y;
		setInputLoc1(in1);
		setInputLoc2(in2);
		
		setBounds(x,y,60,60);
		setLayout(null);		
        repaint();
	}
	public void paintComponent(Graphics g){
	       super.paintComponent (g);

        g.setColor(new Color(0,0,255,30));
        g.fillArc(-30, 10, 80, 40, 90, -180);
        g.setColor(new Color(Integer.parseInt( "458B74",16)));
        g.fillArc(5, 10, 10, 40, 90, -180);
	           g.setColor(Color.black);           
	           g.drawArc(5, 10, 10, 40, 90, -180);
	           g.drawArc(-30, 10, 80, 40, 90, -180);
	           switch(inputFlag){
	           case 1:
		           g.fillOval(7, 37, 8, 8);
	        	   g.setColor(Color.red);
	        	   g.fillOval(7, 15,8, 8);
		           break;
	           case 2:
		           g.fillOval(7, 15,8, 8);
	        	   g.setColor(Color.red);
		           g.fillOval(7, 37, 8, 8);
		           break;
		       default:
		    	   g.setColor(Color.BLACK);
		    	   g.fillOval(7, 15,8, 8);
		           g.fillOval(7, 37, 8, 8);
	           
	           }
	           switch(outputFlag){
	           case 1:
		           g.setColor(Color.red);
		           g.fillOval(47, 26, 8, 8);
		           break;
		       default:
		    	   g.setColor(Color.BLACK);
		           g.fillOval(47, 26, 8, 8);
	           
	           }
	               
}
	public abstract boolean processGate(boolean in1, boolean in2);
	
}