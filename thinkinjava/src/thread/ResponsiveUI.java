package thread;

import java.io.IOException;

class UnresponsiveUI{
	private volatile double d = 1;
	public UnresponsiveUI() throws Exception{
		while(d > 0){
			d = d + (Math.PI + Math.E) / d;
			System.in.read();//Never gets here
		}
	}
}
public class ResponsiveUI extends Thread{

	private static volatile double d = 1;
	public ResponsiveUI(){
		setDaemon(true);
		start();
	}
	public void run(){
		while(true){
			d = d + (Math.PI + Math.E) / d;
		}
	}
	/**
	 * @param args
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		new ResponsiveUI();
		Thread.sleep(300);
		System.in.read();
		System.out.println(d);
	}

}
