package org.narendra;

public class Bartender {
	private Bar bar;
	
	public Bartender(Bar bar) {
		this.bar = bar;
	}
	
	public void mixDrink(Drink drink, Ingredients ingredients) {
		ingredients.getIngredients();
		drink.shake();
		notifyWaitress(drink);
	}

	private void notifyWaitress(Drink drink) {
		bar.getWaitress().serveDrink(drink);
	}
}
