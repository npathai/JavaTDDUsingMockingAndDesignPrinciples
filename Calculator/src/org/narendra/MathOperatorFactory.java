package org.narendra;

public interface MathOperatorFactory {
	public MathOperator newOperator(String nameOfOperator);
	public void addOperatorNamed(String anyString, MathOperator any);
}