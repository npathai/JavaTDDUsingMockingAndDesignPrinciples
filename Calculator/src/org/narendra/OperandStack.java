package org.narendra;

import java.math.BigDecimal;
import java.util.Stack;

public class OperandStack{
	Stack<BigDecimal> values = new Stack<BigDecimal>();
	
	public BigDecimal peek() {
		if(values.size() > 0){
			return values.peek();
		}
		return BigDecimal.ZERO;
	}
	
	public void replaceTop(BigDecimal value) {
		pop();
		values.push(value);
	}
	
	public void push(BigDecimal value){
		values.push(value);
	}
	
	public BigDecimal pop(){
		if(values.isEmpty()){
			return BigDecimal.ZERO;
		}
		return values.pop();
	}

}
