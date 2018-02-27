package main.java.org.paintball.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import main.java.org.paintball.engine.GameEngine;
import main.java.org.paintball.engine.GameInterface;
import main.java.org.paintball.engine.Window;
import main.java.org.paintball.game.BombMode.*;
import main.java.org.paintball.game.RamMode.*;
import main.java.org.paintball.game.ShooterMode.*;

public class Menu extends GameInterface implements MouseListener
{
	private Rectangle RamMode;
	private Rectangle ShooterMode;
	private Rectangle BombMode;
	private Rectangle Exit;
	
	private Menu(Rectangle RamMode, Rectangle ShooterMode, Rectangle BombMode, Rectangle Exit) {
		this.RamMode = RamMode;
		this.ShooterMode = ShooterMode;
		this.BombMode = BombMode;
		this.Exit = Exit;
	}
	
	public Menu()
	{
		
	}

	@Override
	public void init()
	{
		this.addMouseListener(this);
	}

	@Override
	public GameInterface deepCopy()
	{
		return new Menu(this.RamMode, this.ShooterMode, this.BombMode, this.Exit);
	}

	@Override
	public void update()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void paint(Graphics g)
	{
		Point mousePoint = MouseInfo.getPointerInfo().getLocation();
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
		RamMode = new Rectangle(
				(getWidth() / 2) - (g.getFontMetrics().stringWidth("RAM MODE") * 3 / 4), 
				(getHeight() * 2 / 6) - (g.getFontMetrics().getAscent() * 4 / 3), 
				g.getFontMetrics().stringWidth("RAM MODE") * 6 / 4, 
				g.getFontMetrics().getHeight() * 4 / 3);
		g.drawRect(
				(getWidth() / 2) - (g.getFontMetrics().stringWidth("RAM MODE") * 3 / 4), 
				(getHeight() * 2 / 6) - (g.getFontMetrics().getAscent() * 4 / 3), 
				g.getFontMetrics().stringWidth("RAM MODE") * 6 / 4, 
				g.getFontMetrics().getHeight() * 4 / 3);
		if(RamMode.contains(mousePoint)) {
			g.drawRect(
					(getWidth() / 2) - (g.getFontMetrics().stringWidth("RAM MODE") * 3 / 4), 
					(getHeight() * 2 / 6) - (g.getFontMetrics().getAscent() * 4 / 3), 
					(g.getFontMetrics().stringWidth("RAM MODE") * 6 / 4) + 1, 
					(g.getFontMetrics().getHeight() * 4 / 3) + 1);
			g.drawRect(
					(getWidth() / 2) - (g.getFontMetrics().stringWidth("RAM MODE") * 3 / 4), 
					(getHeight() * 2 / 6) - (g.getFontMetrics().getAscent() * 4 / 3), 
					(g.getFontMetrics().stringWidth("RAM MODE") * 6 / 4) + 2, 
					(g.getFontMetrics().getHeight() * 4 / 3) + 2);
		}
		//endRegion
		
		//region [Shooter Mode]
		g.drawString("SHOOTER MODE", 
				getWidth() / 2 - g.getFontMetrics().stringWidth("SHOOTER MODE") / 2, 
				getHeight() * 3 / 6);
		//g.drawLine(0, getHeight() * 3/6, getWidth(), getHeight() * 3/6);
		ShooterMode = new Rectangle(
				(getWidth() / 2) - g.getFontMetrics().stringWidth("SHOOTER MODE") * 3 / 4, 
				(getHeight() * 3 / 6) - (g.getFontMetrics().getAscent() * 4 / 3), 
				g.getFontMetrics().stringWidth("SHOOTER MODE") * 6 / 4, 
				g.getFontMetrics().getHeight() * 4 / 3);
		g.drawRect(
				(getWidth() / 2) - g.getFontMetrics().stringWidth("SHOOTER MODE") * 3 / 4, 
				(getHeight() * 3 / 6) - (g.getFontMetrics().getAscent() * 4 / 3), 
				g.getFontMetrics().stringWidth("SHOOTER MODE") * 6 / 4, 
				g.getFontMetrics().getHeight() * 4 / 3);
		if(ShooterMode.contains(mousePoint)) {
			g.drawRect(
					(getWidth() / 2) - (g.getFontMetrics().stringWidth("SHOOTER MODE") * 3 / 4), 
					(getHeight() * 3 / 6) - (g.getFontMetrics().getAscent() * 4 / 3), 
					(g.getFontMetrics().stringWidth("SHOOTER MODE") * 6 / 4) + 1, 
					(g.getFontMetrics().getHeight() * 4 / 3) + 1);
			g.drawRect(
					(getWidth() / 2) - (g.getFontMetrics().stringWidth("SHOOTER MODE") * 3 / 4), 
					(getHeight() * 3 / 6) - (g.getFontMetrics().getAscent() * 4 / 3), 
					(g.getFontMetrics().stringWidth("SHOOTER MODE") * 6 / 4) + 2, 
					(g.getFontMetrics().getHeight() * 4 / 3) + 2);
		}
		//endRegion
		
		//region [Bomb Mode]

		g.drawString("BOMB MODE", 
				getWidth()/2 - g.getFontMetrics().stringWidth("BOMB MODE") / 2, 
				getHeight() * 4/6);
		//g.drawLine(0, getHeight() * 4/6, getWidth(), getHeight() * 4/6);
		BombMode = new Rectangle(
				(getWidth() / 2) - g.getFontMetrics().stringWidth("BOMB MODE") * 3 / 4, 
				(getHeight() * 4 / 6) - (g.getFontMetrics().getAscent() * 4 / 3), 
				g.getFontMetrics().stringWidth("BOMB MODE") * 6 / 4, 
				g.getFontMetrics().getHeight() * 4 / 3);
		g.drawRect(
				(getWidth() / 2) - g.getFontMetrics().stringWidth("BOMB MODE") * 3 / 4, 
				(getHeight() * 4 / 6) - (g.getFontMetrics().getAscent() * 4 / 3), 
				g.getFontMetrics().stringWidth("BOMB MODE") * 6 / 4, 
				g.getFontMetrics().getHeight() * 4 / 3);
		if(BombMode.contains(mousePoint)) {
			g.drawRect(
					(getWidth() / 2) - (g.getFontMetrics().stringWidth("BOMB MODE") * 3 / 4), 
					(getHeight() * 4 / 6) - (g.getFontMetrics().getAscent() * 4 / 3), 
					(g.getFontMetrics().stringWidth("BOMB MODE") * 6 / 4) + 1, 
					(g.getFontMetrics().getHeight() * 4 / 3) + 1);
			g.drawRect(
					(getWidth() / 2) - (g.getFontMetrics().stringWidth("BOMB MODE") * 3 / 4), 
					(getHeight() * 4 / 6) - (g.getFontMetrics().getAscent() * 4 / 3), 
					(g.getFontMetrics().stringWidth("BOMB MODE") * 6 / 4) + 2, 
					(g.getFontMetrics().getHeight() * 4 / 3) + 2);
		}
		//endRegion
		
		//region [End]
		g.drawString("EXIT", 
				getWidth() / 2 - g.getFontMetrics().stringWidth("EXIT") / 2, 
				getHeight() * 5 / 6);
		//g.drawLine(0, getHeight() * 5/6, getWidth(), getHeight() * 5/6);
		Exit = new Rectangle(
				(getWidth() / 2) - g.getFontMetrics().stringWidth("EXIT") * 3 / 4, 
				(getHeight() * 5 / 6) - (g.getFontMetrics().getAscent() * 4 / 3), 
				g.getFontMetrics().stringWidth("EXIT") * 6 / 4, 
				g.getFontMetrics().getHeight() * 4 / 3);
		g.drawRect(
				(getWidth() / 2) - g.getFontMetrics().stringWidth("EXIT") * 3 / 4, 
				(getHeight() * 5 / 6) - (g.getFontMetrics().getAscent() * 4 / 3), 
				g.getFontMetrics().stringWidth("EXIT") * 6 / 4, 
				g.getFontMetrics().getHeight() * 4 / 3);
		if(Exit.contains(mousePoint)) {
			g.drawRect(
					(getWidth() / 2) - (g.getFontMetrics().stringWidth("EXIT") * 3 / 4), 
					(getHeight() * 5 / 6) - (g.getFontMetrics().getAscent() * 4 / 3), 
					(g.getFontMetrics().stringWidth("EXIT") * 6 / 4) + 1, 
					(g.getFontMetrics().getHeight() * 4 / 3) + 1);
			g.drawRect(
					(getWidth() / 2) - (g.getFontMetrics().stringWidth("EXIT") * 3 / 4), 
					(getHeight() * 5 / 6) - (g.getFontMetrics().getAscent() * 4 / 3), 
					(g.getFontMetrics().stringWidth("EXIT") * 6 / 4) + 2, 
					(g.getFontMetrics().getHeight() * 4 / 3) + 2);
		}
		//endRegion
		g.dispose();
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0)
	{
		
		if(RamMode.contains(arg0.getPoint())){
			Window.changeGameMode(new RamMode());
		}else if(ShooterMode.contains(arg0.getPoint())) {
			Window.changeGameMode(new ShooterMode());
		}else if(BombMode.contains(arg0.getPoint())) {
			Window.changeGameMode(new BombMode());
		}else if(Exit.contains(arg0.getPoint())) {
			System.out.println("Exit clicked");
			GameEngine.stop();
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0)
	{
		
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
