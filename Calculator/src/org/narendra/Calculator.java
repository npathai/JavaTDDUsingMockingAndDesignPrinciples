package org.narendra;

import java.math.BigDecimal;

public class Calculator {
	private OperandStack values = new OperandStack();
		
	public BigDecimal accumulatorValue() {
		return values.peek();
	}

	public void accumulatorValue(BigDecimal value) {
		values.replaceTop(value);
	}
	
	public void enter(){
		values.push(accumulatorValue());
	}

	public void drop(){
		values.pop();
	}

	public void add() {
		BigDecimal rhs = values.peek();
		values.pop();
		BigDecimal lhs = values.peek();
		BigDecimal result = lhs.add(rhs);
		values.replaceTop(result);
	}

	public void subtract() {
		BigDecimal rhs = values.peek();
		values.pop();
		BigDecimal lhs = values.peek();
		BigDecimal result = lhs.subtract(rhs);
		values.replaceTop(result);
	}

	public void factorial() {
		BigDecimal result = BigDecimal.ONE;
		
		BigDecimal operand = values.peek();
		while(operand.compareTo(BigDecimal.ONE) > 0){
			result = result.multiply(operand);
			operand = operand.subtract(BigDecimal.ONE);
		}
		
		values.replaceTop(result);
	}
}
