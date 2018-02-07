package main.java.org.paintball.engine;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Window
{
	private Dimension dim;
	private JFrame frame;

	private ArrayList<GameInterface> games;

	private String title;

	public Window(String title, Dimension dim)
	{
		this.title = title;
		this.dim = dim;

		games = new ArrayList<GameInterface>();
		frame = new JFrame(title);

		frame.setPreferredSize(dim);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
	}
	
	public void addGame(GameInterface game) {
		games.add(game);
	}

	public void setVisible() {
		frame.setVisible(true);
	}
	
	public void hideFrame() {
		frame.setVisible(false);
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
