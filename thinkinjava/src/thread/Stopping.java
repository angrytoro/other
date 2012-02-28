package thread;

import java.util.Timer;
import java.util.TimerTask;

class CanStop extends Thread{
	private volatile boolean stop = false;
	private int counter = 0;
	public void run(){
		while(!stop && counter < 10000){
			System.out.println(counter++);
		}
		if(stop)
			System.out.println("Detected stop");
	}
	public void requestStop(){
		stop = true;
	}
}
public class Stopping {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final CanStop stoppable = new CanStop();
		stoppable.start();
		new Timer(true).schedule(new TimerTask(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Requesting stop");
				stoppable.requestStop();
			}
			
		}, 500); //run after 500 milliseconds
	}

}
