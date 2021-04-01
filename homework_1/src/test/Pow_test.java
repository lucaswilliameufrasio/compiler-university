package test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import homework_1.Pow;

public class Pow_test {
	@Test
	@DisplayName("Should execute the syntax analyzer correctly")
	public void shouldExecuteCorrectly() {
		String[] testCases = { "((a**a))", "a", "a+((a+a)**a)+(a)", "a+a**a", "(a+((a+a)))", "((a+a+a))+((a))",
				"a**(a+(a)+(a))", "(((a))+(a))+(a)", "a+a**(a+a+(a))", "a+a+a+(a+a)", "(a+(a**(a+(a**a))))",
				"a+a+(a**a)", "a+(a**a)" };

		for (int index = 0; index < testCases.length; index++) {
			Assert.assertEquals(new Pow(testCases[index]).parse(), true);
		}
	}
}
