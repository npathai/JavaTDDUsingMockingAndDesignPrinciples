package org.narendra;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.any;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BinaryOperatorTest {

	@Mock
	OperandStack operandStack;
	
	@Mock
	BinaryMathOperator binaryMathOperator;
	
	@Test
	public void shouldAcquireTwoParameters(){
		binaryMathOperator.execute(operandStack);

		verify(operandStack,times(2)).peek();
		verify(operandStack,times(2)).pop();
	}
	
	@Test
	public void shouldExecuteExtensionPoint(){
		BigDecimal lhs = new BigDecimal(10);
		BigDecimal rhs = new BigDecimal(10);
		when(operandStack.peek()).thenReturn(rhs).thenReturn(lhs);

		binaryMathOperator.execute(operandStack);
		
		verify(binaryMathOperator).executeImplementation(lhs,rhs);
	}
	
	@Test
	public void shouldStoreResultOnStack(){
		when(binaryMathOperator.executeImplementation(any(BigDecimal.class), any(BigDecimal.class))).thenReturn(BigDecimal.TEN);
		
		binaryMathOperator.execute(operandStack);
		
		verify(operandStack,times(1)).push(BigDecimal.TEN);
	}
}
