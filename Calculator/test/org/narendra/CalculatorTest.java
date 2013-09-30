package org.narendra;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

	private Calculator calculator;

	@Before
	public void setUp(){
		calculator = new Calculator();
	}
	
	@Test
	public void testAccumulatorAs0InitialValue(){
		assertEquals(new BigDecimal(0.0), calculator.accumulatorValue());
	}
	
	@Test
	public void testCalculatorShouldAllowToSetAccumulator(){
		calculator.accumulatorValue(new BigDecimal(10.0));
		
		assertEquals(new BigDecimal(10.0), calculator.accumulatorValue());
	}
	
	@Test
	public void testAddition(){
		calculator.accumulatorValue(new BigDecimal(3));
		calculator.enter();
		calculator.accumulatorValue(new BigDecimal(4));
		calculator.add();
		
		assertEquals(new BigDecimal(7),calculator.accumulatorValue());
	}
	
	@Test
	public void testSubtraction(){
		calculator.accumulatorValue(new BigDecimal(3));
		calculator.enter();
		calculator.accumulatorValue(new BigDecimal(4));
		calculator.subtract();
		
		assertEquals(new BigDecimal(-1),calculator.accumulatorValue());
	}
	
	@Test
	public void testFactorialOf0is1(){
		calculator.factorial();
		
		assertEquals(BigDecimal.ONE,calculator.accumulatorValue());
	}
	
	@Test
	public void testFactorialOf5is120(){
		calculator.accumulatorValue(new BigDecimal(5));
		
		calculator.factorial();
		
		assertEquals(new BigDecimal(120), calculator.accumulatorValue());
	}
}
