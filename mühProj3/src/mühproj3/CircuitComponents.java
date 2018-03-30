/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mühproj3;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JPanel;



public abstract class CircuitComponents extends JPanel {
	protected int inputFlag =0;
	protected int outputFlag =0;
	private int input1Loc=0;
	private int input2Loc=0;
	private int input1=0;
	private int input2=0;
	private int output=0;
	protected int myID=0;
	protected static int myStaticID=0;
	protected static int cuRRStaticID=0;
    private int draggedAtX, draggedAtY;
	public CircuitComponents() {
		myID=myStaticID;
		myStaticID++;
		setOpaque(false);
        addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
                draggedAtX = e.getX();
                draggedAtY = e.getY();
            }
        	@Override
        	public void mouseClicked(MouseEvent arg0) {
        		cuRRStaticID=myID;
        	}
        });

        addMouseMotionListener(new MouseMotionAdapter(){
            public void mouseDragged(MouseEvent e){
                setLocation(e.getX() - draggedAtX + getLocation().x,
                        e.getY() - draggedAtY + getLocation().y);
            }
        });
		
	}
	
	
	public int getID(){
		return myID;
	}
	public int getOutput(){
		return output;
	}
	public void setOutput(int i){
		output = i;
	}
	public int getInputLoc1(){
		return input1Loc;
	}
	public void setInputLoc1(int in){
		input1Loc=in;
	}
	public int getInputLoc2(){
		return input2Loc;
	}
	public void setInputLoc2(int in){
		input2Loc=in;
	}
	public int getInputFlag(){
		return inputFlag;
	}
	public void setInputFlag(int in){
		inputFlag=in;
	}
	public int getOutputFlag(){
		return outputFlag;
	}
	public void setOutputFlag(int in){
		outputFlag=in;
	}
	public int getInput1(){
		return input1;
	}
	public void setInput1(int in){
		input1=in;
	}
	public int getInput2(){
		return input2;
	}
	public void setInput2(int in){
		input2=in;
	}
	public abstract boolean processGate(boolean in1, boolean in2);
}