package org.narendra;

import java.math.BigDecimal;

public class Division extends BinaryMathOperator{

	@Override
	protected BigDecimal executeImplementation(BigDecimal lhs, BigDecimal rhs) {
		return lhs.divide(rhs);
	}

}
