package org.narendra;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorNewOperatorRegistrationTest {

	private CalculatorNew calculator;

	@Before
	public void setUp(){
		calculator = new CalculatorNew(new ShortNamedOperatorsMathOperatorFactory());
	}
	
	@Test
	public void foo(){
		calculator.startProgram();
		calculator.addToProgram("+");
		calculator.addToProgram("*");
		calculator.saveProgram("AddThenMultiply");
		
		calculator.accumulatorValue(new BigDecimal(10));
		calculator.enter();
		calculator.accumulatorValue(new BigDecimal(2));
		calculator.enter();
		calculator.accumulatorValue(new BigDecimal(10));
		
		calculator.execute("AddThenMultiply");
		
		assertEquals(new BigDecimal(120), calculator.accumulatorValue());
	}
}
