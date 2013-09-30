package org.narendra;

import java.math.BigDecimal;

public abstract class BinaryMathOperator implements MathOperator{

	@Override
	public final void execute(OperandStack operandStack) {
		BigDecimal rhs = operandStack.peek();
		operandStack.pop();
		BigDecimal lhs = operandStack.peek();
		operandStack.pop();
		
		BigDecimal result = executeImplementation(lhs, rhs);
		
		operandStack.push(result);
	}

	protected abstract BigDecimal executeImplementation(BigDecimal lhs, BigDecimal rhs);
	
}
