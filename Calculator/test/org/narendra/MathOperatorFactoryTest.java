package org.narendra;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

@RunWith(MockitoJUnitRunner.class)
public class MathOperatorFactoryTest {

	private MathOperatorFactory mathOperatorFactory;

	@Before
	public void setUp(){
		mathOperatorFactory = new ShortNamedOperatorsMathOperatorFactory();
	}

	@Test
	public void testSupportOfAddOperator(){
		MathOperator addOperator = mathOperatorFactory.newOperator("+");

		assertNotNull(addOperator);
	}

	@Test
	public void testSupportOfSubtractOperator(){
		MathOperator subOperator = mathOperatorFactory.newOperator("-");

		assertNotNull(subOperator);
	}

	@Test
	public void testSupportOfMultiplicationOperator(){
		MathOperator mulOperator = mathOperatorFactory.newOperator("*");

		assertNotNull(mulOperator);
	}

	@Test
	public void testSupportOfDivisionOperator(){
		MathOperator divOperator = mathOperatorFactory.newOperator("/");

		assertNotNull(divOperator);
	}

	@Test
	public void testSupportOfFactorialOperator(){
		MathOperator factOperator = mathOperatorFactory.newOperator("!");

		assertNotNull(factOperator);
	}

	@Test(expected = OperatorNotSupportedException.class)
	public void testExceptionOnBogusOperator(){
		mathOperatorFactory.newOperator("Bogus operator");
	}

	@Test
	public void testAdditionSameOperatorMultipleTimesFails(){
		mathOperatorFactory.addOperatorNamed("foo", new CompositeMathOperator());
		try{
			mathOperatorFactory.addOperatorNamed("foo", new CompositeMathOperator());
			fail();
		}catch (OperatorNameAlreadyUsed expected) {
			//success
		}
	}
}
