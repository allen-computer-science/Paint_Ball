package main.java.org.paintball.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import main.java.org.paintball.engine.GameInterface;

public class Menu extends GameInterface implements MouseListener
{
	@Override
	public void init()
	{
		// TODO Auto-generated method stub

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
		System.out.println(getWidth() * getHeight() / 10000);
		g.setFont(new Font("Centaur", Font.PLAIN, getWidth() * getHeight() / 10000));
		g.drawString("Paintball", (getWidth() / 2) - (g.getFontMetrics().stringWidth("Paintball") / 2), (getHeight() / 4) - (g.getFontMetrics().getHeight() / 2));
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
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
