package main.java.org.paintball.engine;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

public class KeyHandler extends KeyAdapter
{
	
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_ESCAPE) {
			Window.hideFrame();
			Window.frame.dispatchEvent(new WindowEvent(Window.frame, WindowEvent.WINDOW_CLOSING));
		}
	}
}
