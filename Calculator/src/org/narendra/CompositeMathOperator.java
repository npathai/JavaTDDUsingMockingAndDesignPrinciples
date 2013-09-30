package org.narendra;

import java.util.LinkedList;
import java.util.List;

public class CompositeMathOperator implements MathOperator{

	List<MathOperator> operators = new LinkedList<MathOperator>();
	
	@Override
	public void execute(OperandStack operandStack) {
		for(MathOperator op : operators){
			op.execute(operandStack);
		}
	}

	public void append(MathOperator op) {
		operators.add(op);
	}

	
}
