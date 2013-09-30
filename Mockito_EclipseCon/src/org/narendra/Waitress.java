package org.narendra;

public class Waitress {
	
	private CashBox cashBox;
	
	public Waitress(CashBox cashBox) {
		this.cashBox = cashBox;
	}
	
	public void serveDrink(Drink drink) {
		cashBox.payDrink(drink, new Amount(5.00));
	}

}
