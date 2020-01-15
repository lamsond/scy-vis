package org.whrhs.dlamson.java.csa.scy;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class MainPanel extends JPanel implements Runnable{

	public static final int NUM_BOXES = 50;
	public static final int W = 1001, H = 700;
	public static final int FPS = 20;
	private Color randColor;
	private Color boxColor;
	private Box[] boxes;
	private Thread animation;
	private int xOff;
	
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
	
	public void move() {
		xOff+=1;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(int i = 0; i < boxes.length; i++){
			boxes[i].drawBox(g, i*W/NUM_BOXES + xOff);
		}
	}
	
	@Override
	public void addNotify() {
		super.addNotify();
		animation = new Thread(this);
		animation.start();	
	}
	
	@Override
	public void run() {
		long startTime, endTime, dt, sleepTime;
		
		while(true) {
			startTime = System.currentTimeMillis();
			
			move();
			repaint();
			
			endTime = System.currentTimeMillis();
			dt = endTime - startTime;
			System.out.println(dt);
			sleepTime = Math.max(FPS - dt, 2);
			
			try {
				Thread.sleep(sleepTime);
			}
			catch(InterruptedException e) {
				System.out.println(e);
			}
			
			
		}
		
		
	}
	
	
}
