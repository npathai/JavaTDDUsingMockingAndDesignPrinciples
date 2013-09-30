package org.narendra;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ShortNamedOperatorsMathOperatorFactory implements MathOperatorFactory {
	
	private Map<String, MathOperator> operatorsByName;
	
	public ShortNamedOperatorsMathOperatorFactory() {
		operatorsByName = new ConcurrentHashMap<String, MathOperator>();
		registerOperators();
	}
	
	private void registerOperators() {
		operatorsByName.put("+", new Add());
	    operatorsByName.put("-",new Subtract());
		operatorsByName.put("!",new Factorial());
		operatorsByName.put("/", new Division());
		operatorsByName.put("*", new Multiplication());
	}

	/* (non-Javadoc)
	 * @see org.narendra.MathOperatorFactory#newOperator(java.lang.String)
	 */
	@Override
	public MathOperator newOperator(String nameOfOperator){
		MathOperator mathOperator = operatorsByName.get(nameOfOperator);
		if(mathOperator == null)	
			throw new OperatorNotSupportedException();
		
		return mathOperator;
	}

	@Override
	public void addOperatorNamed(String anyString, MathOperator any) {
		MathOperator op = operatorsByName.get(anyString);
		if(op != null)
			throw new OperatorNameAlreadyUsed();
		
		operatorsByName.put(anyString, any);
	}
}
