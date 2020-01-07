package org.whrhs.dlamson.java.csa.scy;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class MainPanel extends JPanel{

	public static final int NUM_BOXES = 50;
	public static final int W = 1000, H = 500;
	private Color randColor;
	private Color boxColor;
	private Box[] boxes;
	
	public MainPanel() {
		boxes = new Box[NUM_BOXES];
		randColor = new Color((float) Math.random(), (float) Math.random(), (float) Math.random());
		boxColor = randColor.darker();
		setBackground(randColor);
		setPreferredSize(new Dimension(W, H));
		
		for(int i = 0; i < boxes.length; i++) {
			boxes[i] = new Box(boxColor);	
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(int i = 0; i < boxes.length; i++){
			boxes[i].drawBox(g, i*W/NUM_BOXES);
		}
	}
}
