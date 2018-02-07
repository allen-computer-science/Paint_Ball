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
	
	public GameEngine(String title, int width, int height, GameInterface game) {
		gameLoopThread = new Thread(this, "Primary_Thread");
		Dimension dim = new Dimension(width, height);
		window = new Window(title, dim);
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
			
			render();
			sync();
		}
		
		private void sync() {
			float loopSlot = 1f / TARGET_FPS;
			double endTime = timer.getLastLoopTime();
			while(timer.getTime() < endTime) {
				try {
					Thread.sleep(1);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		protected void update() {
			window.update();
		}
		
		protected void render() {
			window.render();
		}
	}
}
