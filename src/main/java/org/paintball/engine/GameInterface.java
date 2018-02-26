package main.java.org.paintball.engine;

import java.awt.Canvas;
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
