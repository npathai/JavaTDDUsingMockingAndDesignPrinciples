package org.narendra;

import java.math.BigDecimal;

public class CalculatorNew {
	private MathOperatorFactory mathOperatorFactory;
	private OperandStack values = new OperandStack();
	private CompositeMathOperator currentProgram;
	
	public CalculatorNew(MathOperatorFactory mathOperatorFactory) {
		this.mathOperatorFactory = mathOperatorFactory;
	}
	
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

	public void execute(String nameOfOperator) {
		MathOperator op = findOperator(nameOfOperator);
		op.execute(values);
	}

	private MathOperator findOperator(String nameOfOperator) {
		return mathOperatorFactory.newOperator(nameOfOperator);
	}

	public void startProgram() {
		currentProgram = new CompositeMathOperator();
	}

	public void addToProgram(String operatorName) {
		currentProgram.append(findOperator(operatorName));
	}

	public void saveProgram(String nameOfOperator) {
		mathOperatorFactory.addOperatorNamed(nameOfOperator, currentProgram);
	}
}
