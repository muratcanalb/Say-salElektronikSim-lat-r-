/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mühproj3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JPanel;


public class Input extends CircuitComponents{
	private Point xy= new Point();
    
	public Input(int x,int y) {
		
		super.setToolTipText("ANAHTAR");
		setBounds(x,y,60,60);
		setLayout(null);		
        repaint();
		
		
        addMouseListener(new MouseAdapter(){
        	@Override
        	public void mouseClicked(MouseEvent evt) {
				//inputFlag=0;
				outputFlag=0;
				if((evt.getX()>=10 && evt.getY()>=10 && evt.getX()<=50 && evt.getY()<=50)&& getOutput()==0){ setOutput(1);}
				else if((evt.getX()>=10 && evt.getY()>=10 && evt.getX()<=50 && evt.getY()<=50)&& getOutput()==1){ setOutput(0);}
				if((evt.getX()>=50 && evt.getY()>=25 && evt.getX()<=58 && evt.getY()<=33)&& outputFlag==0
						){outputFlag=1;}
				repaint();
        	}
        });
		setLayout(new BorderLayout(0, 0));
		xy.x=x;
		xy.y=y;
	}
	public void paintComponent(Graphics g){
	       super.paintComponent (g);
	       switch(getOutput()){
	           case 1:
	        	   g.setColor(new Color(0,255,0,100));
	        	   g.fillRect(30, 10, 20, 40);
	        	   g.fillRect(30, 10, 20, 40);
	        	   g.fillRect(30, 10, 20, 40);
	        	   
	        	   break;
	           default:
	        	   g.setColor(new Color(255,0,0,100));
	        	   g.fillRect(30, 10, 20, 40);
	        	   g.fillRect(30, 10, 20, 40);
	        	   g.fillRect(30, 10, 20, 40);
	           }
	       switch(outputFlag){
           case 1:
        	   g.setColor(Color.red);
        	   g.fillOval(50, 25, 8, 8);
        	   break;
           default:
        	   g.setColor(Color.black);
        	   g.drawOval(50, 25, 8, 8);
           }
	       g.setColor(Color.black);
	       g.drawRect(30, 10, 20, 40);
	}
	@Override
	public boolean processGate(boolean in1, boolean in2) {
		// TODO Auto-generated method stub
		return false;
	}
	
}