package org.whrhs.dlamson.java.csa.scy;

import java.awt.Color;
import java.awt.Graphics;

public class Box {
	
	public static final int W = MainPanel.W / MainPanel.NUM_BOXES;
	private int height;
	private Color color;
	
	public Box(Color color) {
		this.height = (int) (MainPanel.H * Math.random());
		this.color = color;
	}
	
	public void drawBox(Graphics g, int x) {
		g.setColor(color);
		g.fillRect(x, MainPanel.H - height, W, height);
	}

}
