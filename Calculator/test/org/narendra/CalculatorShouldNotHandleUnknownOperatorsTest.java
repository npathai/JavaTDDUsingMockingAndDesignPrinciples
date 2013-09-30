package org.narendra;

import org.junit.Test;

public class CalculatorShouldNotHandleUnknownOperatorsTest {

	private static class AlwaysFailingMathOperatorFactory implements MathOperatorFactory{
		@Override
		public MathOperator newOperator(String nameOfOperator) {
			throw new OperatorNotSupportedException();
		}

		@Override
		public void addOperatorNamed(String anyString, MathOperator any) {
		}
	}
	
	@Test(expected = OperatorNotSupportedException.class)
	public void testCalculatorFailsOnOperatorNotFound(){
		AlwaysFailingMathOperatorFactory factory = new AlwaysFailingMathOperatorFactory();
		CalculatorNew calculatorNew = new CalculatorNew(factory);
		calculatorNew.execute("+");
	}
}
