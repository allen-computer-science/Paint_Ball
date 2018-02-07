package main.java.org.paintball.game;

import main.java.org.paintball.engine.GameEngine;

public class Main
{

	public static void main(String[] args)
	{
		new GameEngine("Paint_Ball", 1000 / 12 * 9, 1000).start();;
	}

}
