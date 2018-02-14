package main.java.org.paintball.engine;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Window
{
	private String title;
	private Dimension dim;
	public static JFrame frame;

	private ArrayList<GameInterface> games;

	static GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];
	
	private static boolean fullScreen;
	
	private KeyHandler keyHandler;
	
	public Window(String title)
	{
		this.title = title;

		games = new ArrayList<GameInterface>();
		frame = new JFrame(title);
		
		keyHandler = new KeyHandler();
		
		frame.addKeyListener(keyHandler);
		
		if(device.isFullScreenSupported()) {
			frame.setUndecorated(true);
			fullScreen = true;
		}
		else {
			System.err.println("Full screen not supported");
			fullScreen = false;
	        frame.setSize(1000 / 12 * 9, 1000); // just something to let you see the window
		}
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
	}
	
	public void addGame(GameInterface game) {
		games.add(game);
	}

	public static void showFrame() {
		if(fullScreen) {
			device.setFullScreenWindow(frame);
		}else {
			frame.setVisible(true);
		}
	}
	
	public static void hideFrame() {
		if(fullScreen) {
			device.setFullScreenWindow(null);
		}else {
			frame.setVisible(false);
		}
	}
	
	public Dimension getDim()
	{
		return dim;
	}
	
	public String getTitle()
	{
		return title;
	}

	public void setDim(Dimension dim)
	{
		this.dim = dim;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public void init() {
		for(int i = 0; i < games.size(); i++) {
			games.get(i).init();
		}
	}
	
	public void paint() {
		for(int i = 0; i < games.size(); i++) {
			games.get(i).paint(games.get(i).getGraphics());
		}
	}
	
	public void update() {
		for(int i = 0; i < games.size(); i++) {
			games.get(i).update();
		}
	}
}
