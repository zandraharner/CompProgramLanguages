import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Test;

public class testConsumerProducer {
	
	static Random r = new Random();
	
	@Test
	public void testScenario1() {
		// test the producer and consumer
		r.setSeed(10000);
		// Define coin object 
		int COIN_AMOUNT = 100;
		
		Coin thecoin = new Coin(COIN_AMOUNT);
		
		// Define 10 coin consumers
		int numThreads = 10;
		
		int numRepeat = 100; 
		
		for (int loop = 0; loop < numRepeat; loop++) {
			CoinConsumer coinconsumers[] = new CoinConsumer[numThreads];
			CoinProducer coinproducers[] = new CoinProducer[numThreads];
			for (int i=0; i<numThreads;i++) {
				CoinConsumer curconsumerThread = new CoinConsumer(thecoin);
				coinconsumers[i] = curconsumerThread;
				
				CoinProducer curproducerThread = new CoinProducer(thecoin);
				coinproducers[i] = curproducerThread;
				
				coinconsumers[i].start();
				coinproducers[i].start();
			}
			// wait for all of the consumers producers finish
			for (int i=0; i<numThreads;i++) {
				try {
					coinconsumers[i].join();
					coinproducers[i].join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}				
			}
			System.out.println("Round " + loop + " Finished ... Final Coin Left - " + Coin.amount + "\n\n");
			assertTrue(Coin.amount == COIN_AMOUNT);		
		}
		
	}
}
