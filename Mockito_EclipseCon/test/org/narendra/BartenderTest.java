package org.narendra;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.eq;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BartenderTest {
	
	@Mock 
	private Bar bar;
	@Mock 
	private CashBox cashBox;
	@Mock 
	private Drink drink;
	@Mock 
	private Ingredients ingredients;
	
	@Spy @InjectMocks 
	private Waitress waitress;
	
	private Bartender bartender;
	
	@Before
	public void setUp(){
		bartender = new Bartender(bar);
		when(bar.getWaitress()).thenReturn(waitress);
	}
	
	
	@Test
	public void testUsesIngredients(){
		bartender.mixDrink(drink, ingredients);
		
		verify(ingredients).getIngredients();	
	}
	
	@Test
	public void testShakesDrink(){
		bartender.mixDrink(drink, ingredients);
		
		verify(drink).shake();	
	}
	
	@Test
	public void testNotifiesWaitress(){
		bartender.mixDrink(drink, ingredients);
		
		verify(waitress).serveDrink(drink);
	}
	
	@Test
	public void testWaitressPaysInCashBox(){
		bartender.mixDrink(drink, ingredients);
		
		ArgumentCaptor<Amount> captor = ArgumentCaptor.forClass(Amount.class);
		
		verify(cashBox).payDrink(eq(drink), captor.capture());
		assertEquals(5.00, captor.getValue().getBucks(),0);
	}
	
	@Test
	public void testRespectsOrder(){
		bartender.mixDrink(drink, ingredients);
		
		InOrder order = inOrder(ingredients,drink,waitress);
		order.verify(ingredients).getIngredients();
		order.verify(drink).shake();	
		order.verify(waitress).serveDrink(drink);
	}
}
