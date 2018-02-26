package main.java.org.paintball.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;

import main.java.org.paintball.engine.GameEngine;
import main.java.org.paintball.engine.GameInterface;

public class Menu extends GameInterface implements MouseListener
{
	private HashMap<String, Rectangle> options;
	
	@Override
	public void init()
	{
		options = new HashMap<String, Rectangle>();
	}

	@Override
	public GameInterface deepCopy()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void paint(Graphics g)
	{

		g.setColor(Color.black);
		g.setFont(new Font("Centaur", Font.PLAIN, getWidth() * getHeight() / 10000));
		
		//region [Title]
		g.drawString("Paintball", (getWidth() / 2) - (g.getFontMetrics().stringWidth("Paintball") / 2), (getHeight() / 6));
		//endRegion
	
		g.setFont(new Font("Centaur", Font.PLAIN, getWidth() * getHeight() / 20000));
	
		//region [Ram Mode]
		g.drawString("RAM MODE", 
				getWidth()/2 - g.getFontMetrics().stringWidth("RAM MODE") / 2, 
				getHeight() * 2/6);
		//g.drawLine(0, getHeight() * 2/6, getWidth(), getHeight() * 2/6);
		
		g.drawRect(
				(getWidth() / 2) - (g.getFontMetrics().stringWidth("RAM MODE") * 3 / 4), 
				(getHeight() * 2 / 6) - (g.getFontMetrics().getAscent() * 4 / 3), 
				g.getFontMetrics().stringWidth("RAM MODE") * 6 / 4, 
				g.getFontMetrics().getHeight() * 4 / 3);
		//endRegion
		
		//region [Shooter Mode]
		g.drawString("SHOOTER MODE", 
				getWidth() / 2 - g.getFontMetrics().stringWidth("SHOOTER MODE") / 2, 
				getHeight() * 3 / 6);
		//g.drawLine(0, getHeight() * 3/6, getWidth(), getHeight() * 3/6);
		
		g.drawRect(
				(getWidth() / 2) - g.getFontMetrics().stringWidth("SHOOTER MODE") * 3 / 4, 
				(getHeight() * 3 / 6) - (g.getFontMetrics().getAscent() * 4 / 3), 
				g.getFontMetrics().stringWidth("SHOOTER MODE") * 6 / 4, 
				g.getFontMetrics().getHeight() * 4 / 3);
		//endRegion
		
		//region [Bomb Mode]

		g.drawString("BOMB MODE", 
				getWidth()/2 - g.getFontMetrics().stringWidth("BOMB MODE") / 2, 
				getHeight() * 4/6);
		//g.drawLine(0, getHeight() * 4/6, getWidth(), getHeight() * 4/6);
		
		g.drawRect(
				(getWidth() / 2) - g.getFontMetrics().stringWidth("BOMB MODE") * 3 / 4, 
				(getHeight() * 4 / 6) - (g.getFontMetrics().getAscent() * 4 / 3), 
				g.getFontMetrics().stringWidth("BOMB MODE") * 6 / 4, 
				g.getFontMetrics().getHeight() * 4 / 3);
		//endRegion
		
		//region [End]
		g.drawString("EXIT", 
				getWidth() / 2 - g.getFontMetrics().stringWidth("EXIT") / 2, 
				getHeight() * 5 / 6);
		//g.drawLine(0, getHeight() * 5/6, getWidth(), getHeight() * 5/6);
		
		g.drawRect(
				(getWidth() / 2) - g.getFontMetrics().stringWidth("EXIT") * 3 / 4, 
				(getHeight() * 5 / 6) - (g.getFontMetrics().getAscent() * 4 / 3), 
				g.getFontMetrics().stringWidth("EXIT") * 6 / 4, 
				g.getFontMetrics().getHeight() * 4 / 3);
		//endRegion
	}

	@Override
	public void mouseClicked(MouseEvent arg0)
	{
		
		if(options.get("SHOOTER MODE").contains(arg0.getPoint())) {
			
		}else if(options.get("RAM MODE").contains(arg0.getPoint())) {
			
		}else if(options.get("BOMB MODE").contains(arg0.getPoint())) {
			
		}else if(options.get("EXIT").contains(arg0.getPoint())) {
			GameEngine.stop();
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0)
	{
		if(options.get("SHOOTER MODE").contains(arg0.getPoint())) {
			
		}else if(options.get("RAM MODE").contains(arg0.getPoint())) {
			
		}else if(options.get("BOMB MODE").contains(arg0.getPoint())) {
			
		}else if(options.get("EXIT").contains(arg0.getPoint())) {
			
		}
	}

	@Override
	public void mouseExited(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}
	
}
