import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class BasketTest {

	private Basket basket;

	@Before
	public void setUp(){
		basket = new Basket();
	}
	
	@Test
	public void testAddToBasket(){
		basket.add(new Product(new BigDecimal(0.0)));
		basket.add(new Product(new BigDecimal(0.0)));
		
		assertEquals(2, basket.size());
	}
	
	@Test
	public void testBasketCanCalculateTotalOfAllItems(){
		basket.add(new Product(new BigDecimal(10.00)));
		basket.add(new Product(new BigDecimal(20.00)));
		
		assertEquals(new BigDecimal(30.00), basket.totalPrice());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddShouldThrowExceptionOnNegativePricedProduct(){
		basket.add(new Product(new BigDecimal(-10.00)));
	}
	
	@Test
	public void testBasketDoesAcceptProductWithPriceZero(){
		basket.add(new Product(BigDecimal.ZERO));
		
		assertEquals(new BigDecimal(0.0), basket.totalPrice());
	}
	
	@Test
	public void testBasketAddsSalesTaxToTotal(){
		
	}
	
}
