package main.java.org.paintball.engine;

import java.awt.Dimension;
import java.awt.image.BufferStrategy;

public class GameEngine implements Runnable
{
	private static final int TARGET_FPS = 75;
	private static final int TARGET_UPS = 30;
	
	private final Window window;
	private final Thread gameLoopThread;
	private final Timer timer;
	
	public GameEngine(String title) {
		gameLoopThread = new Thread(this, "Primary_Thread");
		window = new Window(title);
		timer = new Timer();
	}

	public void start() {
		String osName = System.getProperty("os.name");
		if(osName.contains("Mac")) {
			gameLoopThread.run();
		}
		else {
			gameLoopThread.start();
		}
	}
	
	@Override
	public void run()
	{
		try {
			init();
			gameLoop();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void init() {
		timer.init();
		Window.showFrame();
	}
	
	protected void gameLoop() {
		float elapsedTime;
		float accumulator = 0f;
		float interval = 1f / TARGET_UPS;
		
		boolean running = true;
		while(running) {
			elapsedTime = timer.elapsedTime();
			accumulator += elapsedTime;
			
			while(accumulator >= interval) {
				update();
				accumulator -= interval;
			}
			
			paint();
			sync();
		}
		
	}

	private void sync()
	{
		float loopSlot = 1f / TARGET_FPS;
		double endTime = timer.getLastLoopTime() - loopSlot;
		while(timer.getTime() < endTime) {
			try {
				Thread.sleep(1);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void paint()
	{
		window.paint();	
	}
	
	private void update()
	{
		window.update();
	}
}
