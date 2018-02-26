package main.java.org.paintball.engine;

import java.awt.Canvas;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import main.java.org.paintball.game.Menu;
import main.java.org.paintball.game.BombMode.BombMode;

public class Window
{
	private String title;
	private Dimension dim;
	public static JFrame frame;
	private static JPanel contentPane;

	private static GameInterface currentGame;

	static GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];
	
	private static boolean fullScreen;
	
	private KeyHandler keyHandler;
	
	public Window(String title){
		this.title = title;

		frame = new JFrame(title);
		
		keyHandler = new KeyHandler();
		contentPane = new JPanel();
		currentGame = new Menu();
		
		contentPane.setFocusable(false);
		
		if(device.isFullScreenSupported()) {
			frame.setUndecorated(true);
			fullScreen = true;
			contentPane.setSize(device.getDefaultConfiguration().getBounds().width, device.getDefaultConfiguration().getBounds().height);
			currentGame.setSize(device.getDefaultConfiguration().getBounds().width, device.getDefaultConfiguration().getBounds().height);
		}
		else {
			System.out.println("Full screen not supported");
			fullScreen = false;
	        frame.setSize(1000 / 12 * 9, 1000); // just something to let you see the window
	        contentPane.setSize(1000 / 12 * 7
	        		, 1000);
	        currentGame.setSize(1000 / 12 * 7, 1000);
		}		
		
		contentPane.add(currentGame);
		//System.out.println("Game Canvas - " + currentGame.getBounds().getHeight() + " : " + currentGame.getBounds().getWidth());
		//System.out.println("Content Pane - " + contentPane.getBounds().getHeight() + " : " + contentPane.getBounds().getWidth());

		currentGame.setFocusable(true);
		currentGame.addKeyListener(keyHandler);
		
		frame.setContentPane(contentPane);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setFocusable(false);
	}
	
	public void changeGameMode(GameInterface game) {
		currentGame = game.deepCopy();
		contentPane.removeAll();
		contentPane.add(currentGame);
		currentGame.setFocusable(true);
		currentGame.setSize(device.getDefaultConfiguration().getBounds().width, device.getDefaultConfiguration().getBounds().height);
		currentGame.addKeyListener(keyHandler);
	}

	public static void showFrame() {
		frame.setVisible(true);
		if(fullScreen) {
			device.setFullScreenWindow(frame);
			//System.out.println("Frame - " + frame.getSize().getHeight() + " : " + frame.getSize().getWidth());
		}
	}
	
	public static void hideFrame() {
		frame.setVisible(false);
		if(fullScreen) {
			device.setFullScreenWindow(null);
		}
	}
	
	public Dimension getDim(){
		return dim;
	}
	
	public String getTitle(){
		return title;
	}

	public void setDim(Dimension dim){
		this.dim = dim;
	}

	public void setTitle(String title){
		this.title = title;
	}
	
	public void init() {
		currentGame.init();
	}
	
	public void paint() {
		currentGame.paint(currentGame.getGraphics());
		currentGame.show();
	}
	
	public void update() {
		currentGame.update();
	}
}
