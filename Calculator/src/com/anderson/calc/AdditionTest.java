package com.anderson.calc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AdditionTest {

	@Test
	void test() {
		Addition addition = new Addition();
		int sum = addition.addNumbers(1, 2);
		assertEquals(3, sum);
	}

}
