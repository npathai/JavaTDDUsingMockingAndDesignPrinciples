package org.narendra;

import java.math.BigDecimal;

public class Multiplication extends BinaryMathOperator {

	@Override
	protected BigDecimal executeImplementation(BigDecimal lhs, BigDecimal rhs) {
		return lhs.multiply(rhs);
	}
}
