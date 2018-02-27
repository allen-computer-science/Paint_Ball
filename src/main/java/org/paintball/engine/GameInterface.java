package main.java.org.paintball.engine;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

@SuppressWarnings("serial")
public abstract class GameInterface extends Canvas
{	
	private BufferStrategy bs;
	
	public abstract void init();
	
	public abstract GameInterface deepCopy();
	
	public abstract void update();
	
	public abstract void paint(Graphics g);
	
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, Window.windowDim.width, Window.windowDim.height);
		paint(g);
		g.dispose();
		show();
	}
	
	public Graphics getGraphics() {
		bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			bs = this.getBufferStrategy();
		}
		return bs.getDrawGraphics();
	}
	
	public void show() {
		bs.show();
	}
}
