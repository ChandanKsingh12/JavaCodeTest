package com.java.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTest {
	
	@Test
	void testNullString() {
		Calculator calculator = new Calculator();
		String input = null;
		int expectedSum = 0;
		int actualSum = calculator.add(input);
		assertEquals(expectedSum, actualSum);
	}
	
	@Test
	void testEmptyString() {
		Calculator calculator = new Calculator();
		String input = "";
		int expectedSum = 0;
		int actualSum = calculator.add(input);
		assertEquals(expectedSum, actualSum);
	}
	
	@Test
	void testCommaSeparatedInput() {
		Calculator calculator = new Calculator();
		String input = "1,2,5";
		int expectedSum = 8;
		int actualSum = calculator.add(input);
		assertEquals(expectedSum, actualSum);
	}
	
	@Test
	void testNewLineInput() {
		Calculator calculator = new Calculator();
		String input = "1,\n2,5";
		int expectedSum = 8;
		int actualSum = calculator.add(input);
		assertEquals(expectedSum, actualSum);
	}
	
	@Test
	void testCustomDelimiter() {
		Calculator calculator = new Calculator();
		String input = "//;\n1;3;4";
		int expectedSum = 8;
		int actualSum = calculator.add(input);
		assertEquals(expectedSum, actualSum);
	}
		
	@Test
	void testLargeNumbers() {
		Calculator calculator = new Calculator();
		String input = "//;\n1;3;1001";
		int expectedSum = 4;
		int actualSum = calculator.add(input);
		assertEquals(expectedSum, actualSum);
	}
	
	@Test
	void testArbitraryLengthDelimiters() {
		Calculator calculator = new Calculator();
		String input = "//***\n1***3***1";
		int expectedSum = 5;
		int actualSum = calculator.add(input);
		assertEquals(expectedSum, actualSum);
	}
	
	@Test
	void testMultipleDelimiters() {
		Calculator calculator = new Calculator();
		String input = "//$,@\n1$3@7";
		int expectedSum = 11;
		int actualSum = calculator.add(input);
		assertEquals(expectedSum, actualSum);
	}

}
