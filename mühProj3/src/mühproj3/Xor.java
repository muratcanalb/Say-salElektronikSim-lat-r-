/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mühproj3;

import java.awt.Color;
import java.awt.Graphics;
public class Xor extends Logic {
	public Xor(int x, int y, int in1, int in2) {		
		super(x, y, in1, in2);
	}
	public void paintComponent(Graphics g){
	       super.paintComponent (g);
	           g.setColor(Color.black); 
	           g.drawString("XOR", 25, 35);

}

	@Override
	public boolean processGate(boolean in1, boolean in2) {
		boolean x = in1^in2;
		setOutput(x==false?0:1);
		return x;
	}

}