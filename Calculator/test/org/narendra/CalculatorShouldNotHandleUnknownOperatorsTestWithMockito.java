package org.narendra;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.anyString;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorShouldNotHandleUnknownOperatorsTestWithMockito {

	@Mock MathOperatorFactory factory;
	
	@Test(expected = OperatorNotSupportedException.class)
	public void testCalculatorFailsOnOperatorNotFound(){
		when(factory.newOperator(anyString())).thenThrow(new OperatorNotSupportedException());
		CalculatorNew calculatorNew = new CalculatorNew(factory);
		
		calculatorNew.execute(anyString());
	}
}
