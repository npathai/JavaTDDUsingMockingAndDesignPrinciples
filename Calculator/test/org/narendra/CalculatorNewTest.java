package org.narendra;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorNewTest {

	private CalculatorNew calculator;

	@Before
	public void setUp(){
		calculator = new CalculatorNew(new ShortNamedOperatorsMathOperatorFactory());
	}
	
	@Test
	public void testAddition(){
		calculator.accumulatorValue(new BigDecimal(10));
		calculator.enter();
		calculator.accumulatorValue(new BigDecimal(10));
		
		calculator.execute("+");
		
		assertEquals(new BigDecimal(20), calculator.accumulatorValue());
	}
	
	@Test
	public void testSubtraction(){
		calculator.accumulatorValue(new BigDecimal(10));
		calculator.enter();
		calculator.accumulatorValue(new BigDecimal(10));
		
		calculator.execute("-");
		
		assertEquals(BigDecimal.ZERO, calculator.accumulatorValue());
	}
	
	@Test
	public void testFactorial(){
		calculator.accumulatorValue(new BigDecimal(5));
		
		calculator.execute("!");
		
		assertEquals(new BigDecimal(120), calculator.accumulatorValue());
	}

	@Test(expected = OperatorNotSupportedException.class)
	public void testExceptionThrownOnAnUnknownOperator(){
		calculator.execute("bogus operator");
	}
	
	@Test
	public void testMultiplication(){
		calculator.accumulatorValue(new BigDecimal(100));
		calculator.enter();
		calculator.accumulatorValue(new BigDecimal(100));
		
		calculator.execute("*");
		
		assertEquals(new BigDecimal(10000), calculator.accumulatorValue());
	}
	
	@Test
	public void testDivide(){
		calculator.accumulatorValue(new BigDecimal(20));
		calculator.enter();
		calculator.accumulatorValue(new BigDecimal(2));
		
		calculator.execute("/");
		
		assertEquals(new BigDecimal(10), calculator.accumulatorValue());
	}
}
