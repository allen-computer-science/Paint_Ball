/* The Timer.java class is the timer set for making the animations on the screen
 * run smoothly. - erikTheCleric - 2/7/2018 
 */
package main.java.org.paintball.engine;

public class Timer
{

	private double lastLoopTime;
	public void init() {
		lastLoopTime = getTime();
	}
	
	public double getTime() {
		return System.nanoTime() / 1_000_000_000.0; // 1,000,000,000 nanoseconds = 1 second
	}
	
	public float elapsedTime() {
		double time = getTime();
		float elapsedTime = (float)(time - lastLoopTime);
		lastLoopTime = elapsedTime;
		return elapsedTime;
	}
	
	public double getLastLoopTime() {
		return lastLoopTime;
	}
}
