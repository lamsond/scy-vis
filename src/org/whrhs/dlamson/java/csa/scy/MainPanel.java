package org.whrhs.dlamson.java.csa.scy;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MainPanel extends JPanel implements ActionListener{

	public static final int NUM_BOXES = 50;
	public static final int W = 1001, H = 700;
	public static final int DELAY = 20;
	private Color randColor;
	private Color boxColor;
	private Box[] boxes;
	private Timer refreshTimer;
	private int xOff;
	
	public MainPanel() {
		boxes = new Box[NUM_BOXES];
		randColor = new Color((float) Math.random(), (float) Math.random(), (float) Math.random());
		System.out.println(randColor);
		boxColor = randColor.darker();
		setBackground(randColor);
		setPreferredSize(new Dimension(W, H));
		
		for(int i = 0; i < boxes.length; i++) {
			boxes[i] = new Box(boxColor);	
		}
		
		refreshTimer = new Timer(DELAY, this);
		refreshTimer.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		move();
		repaint();
	}
	
	public void move() {
		xOff+=1;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawOval(xOff, H/2, 10, 10);
		for(int i = 0; i < boxes.length; i++){
			boxes[i].drawBox(g, i*W/NUM_BOXES + xOff);
		}
	}
	
}
