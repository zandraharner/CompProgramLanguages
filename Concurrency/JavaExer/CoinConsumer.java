import java.util.Random;

public class CoinConsumer extends Thread {
	Random r = new Random();
	
	private Coin c; 
	
	private int ID; 
	
	static int counter = 0;
	
	public CoinConsumer(Coin c) {
		this.c = c;
		this.ID = ++counter;
	}
	
	public void spendCoin(int amount) {
		System.out.println("Current Coin: " + Coin.amount + " CoinConsumer" + ID + " spends one coin ... ");
		c.decrease(amount);
	}
	
	public void run() {		
		try {
			Thread.sleep(r.nextInt(10));
			// wait for a random time
			// consume one coin
			spendCoin(1);			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
