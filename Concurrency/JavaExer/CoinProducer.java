package MultiThread;

import java.util.Random;

public class CoinProducer extends Thread {
	Random r = new Random();
	
	private Coin c; 
	
	private int ID; 
	
	static int counter = 0;
	
	public CoinProducer(Coin c) {
		this.c = c;
		this.ID = ++counter;
	}
	
	public void makeCoin(int amount) {
		System.out.println("Current Coin: " + Coin.amount + " CoinProducer" + ID + " makes one coin ... ");
		c.increase(amount);
	}
	
	public void run() {		
		try {
			Thread.sleep(r.nextInt(10));
			// wait for a random time
			// consume one coin
			makeCoin(1);			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
