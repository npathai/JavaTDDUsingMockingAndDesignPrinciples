package org.narendra;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CompositeMathOperatorTest {

	private OperandStack stack;
	
	@Before
	public void setUp(){
		stack = new OperandStack();
		stack.push(new BigDecimal(10));
		stack.push(new BigDecimal(2));
		stack.push(new BigDecimal(10));
	}
	
	@Test
	public void testShouldBeAbleToAddAndMultiply(){
		CompositeMathOperator operator = new CompositeMathOperator();
		operator.append(new Add());
		operator.append(new Multiplication());
		
		operator.execute(stack);
		
		assertEquals(new BigDecimal(120), stack.peek());
	}
}
