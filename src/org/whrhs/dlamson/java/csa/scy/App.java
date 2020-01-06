package org.whrhs.dlamson.java.csa.scy;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class App extends JFrame{
	
	public App() {
		add(new MainPanel());
		setTitle("Drawing Boxes");
		setSize(MainPanel.W, MainPanel.H);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] pizza) {
		EventQueue.invokeLater(() -> {
			App app = new App();
			app.setVisible(true);
		});
	}
}
