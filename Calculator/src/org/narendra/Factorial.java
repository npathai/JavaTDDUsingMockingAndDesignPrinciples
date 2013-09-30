package org.narendra;

import java.math.BigDecimal;

public class Factorial implements MathOperator{

	@Override
	public void execute(OperandStack operandStack) {
		BigDecimal result = BigDecimal.ONE;

		BigDecimal operand = operandStack.peek();
		while(operand.compareTo(BigDecimal.ONE) > 0){
			result = result.multiply(operand);
			operand = operand.subtract(BigDecimal.ONE);
		}

		operandStack.replaceTop(result);		
	}

}
