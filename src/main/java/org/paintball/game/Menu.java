package main.java.org.paintball.game;

import java.awt.Color;
import java.awt.Graphics;

import main.java.org.paintball.engine.GameInterface;

public class Menu extends GameInterface
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
		g.create();
		g.setColor(Color.black);
		g.fillRect(40, 40, 200, 200);
	}

}
