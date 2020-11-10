package MultiThread;

public class Coin {
	static int amount = 0;
	int MAX_AMOUNT = 100;

	public Coin(int iniamount) {
		super();
		amount = Math.min(iniamount,  MAX_AMOUNT);
	}

	public int getAmount() {
		return amount;
	}

	public void increase(int increamount) {
		while (amount >= MAX_AMOUNT) {
			// WAIT HERE
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		amount += increamount;
		
	}
	
	public void decrease(int decamount) {
		while (amount <= 0) {
			// WAIT HERE
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		amount -= decamount;
		
	}
		
}
