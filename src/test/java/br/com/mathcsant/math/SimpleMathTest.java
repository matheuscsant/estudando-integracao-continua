package br.com.mathcsant.math;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Test math operations in SimpleMath Class")
class SimpleMathTest {

	SimpleMath math;

	@BeforeAll
	static void setup() {
		System.out.println("Running method @BeforeAll");
	}

	@AfterAll
	static void cleanup() {
		System.out.println("Running method @AfterAll");
	}

	@BeforeEach
	void beforeEachMethod() {
		System.out.println("Running method @BeforeEach");
		math = new SimpleMath();
	}

	@AfterEach
	void afterEachMethod() {
		System.out.println("Running method @AfterEach");
	}

	// test[System Under Test]_[Condition or State Change_[Expected Result]
	@Test
	@DisplayName("Test 6.2 + 2 = 8.2")
	void testSum_When_SixDotTwoIsAddedByTwo_ShouldReturnEightDotTwo() {
		// AAA Arrange, Act and Assert

		System.out.println("Running method testSum_When_SixDotTwoIsAddedByTwo_ShouldReturnEightDotTwo");

		// Given / Arrange
		double firstNumber = 6.2D;
		double secondNumber = 2D;
		double expected = 8.2D;

		// When / Act
		Double actual = math.sum(firstNumber, secondNumber); // 8.2

		// Then / Assert
		assertEquals(expected, actual, () -> firstNumber + " + " + secondNumber + " did not produce " + expected + "!");
		assertNotEquals(9.2, actual);
		assertNotNull(actual, () -> "Expect value is not null.");

	}

	@Test
	@DisplayName("Test 6.2 - 2 = 4.2")
	void testSubtraction() {

		System.out.println("Running method testSubtraction");

		double firstNumber = 6.2D;
		double secondNumber = 2D;

		Double actual = math.subtraction(firstNumber, secondNumber); // 4.2
		double expected = 4.2D;
		assertEquals(expected, actual, () -> firstNumber + " - " + secondNumber + " did not produce " + expected + "!");
		assertNotEquals(9.2, actual);
		assertNotNull(actual, () -> "Expect value is not null.");

	}

	@Test
	@DisplayName("Test 6 + 2 = 12")
	void testMultiplication() {

		System.out.println("Running method testMultiplication");

		double firstNumber = 6D;
		double secondNumber = 2D;

		Double actual = math.multiplication(firstNumber, secondNumber); // 12
		double expected = 12D;
		assertEquals(expected, actual, () -> firstNumber + " * " + secondNumber + " did not produce " + expected + "!");
		assertNotEquals(9.2, actual);
		assertNotNull(actual, () -> "Expect value is not null.");

	}

	@Test
	@DisplayName("Test 6 / 2 = 3")
	void testDivision() {

		System.out.println("Running method testDivision");

		double firstNumber = 6D;
		double secondNumber = 2D;

		Double actual = math.division(firstNumber, secondNumber); // 3
		double expected = 3D;
		assertEquals(expected, actual, () -> firstNumber + " / " + secondNumber + " did not produce " + expected + "!");
		assertNotEquals(9.2, actual);
		assertNotNull(actual, () -> "Expect value is not null.");

	}

	// test[System Under Test]_[Condition or State Change_[Expected Result]
	@Test
	@DisplayName("Test division by zero")
	void testDivision_When_FirstNumberIsDividedByZero_ShouldThrowArithmeticException() {

		System.out.println("Running method testDivision_When_FirstNumberIsDividedByZero_ShouldThrowArithmeticException");

		// Given
		double firstNumber = 6D;
		double secondNumber = 0D;

		var expectedMessage = "Impossible to divide by zero!";

		// When / Then
		ArithmeticException actual = assertThrows(ArithmeticException.class, () -> math.division(firstNumber, secondNumber),
				() -> "Division by zero should throw an ArithmeticException");

		assertEquals(expectedMessage, actual.getMessage(), () -> "Unexpected exception message");

	}

	// test[System Under Test]_[Condition or State Change_[Expected Result]
	@Test
	@DisplayName("Test division by zero")
	void testDivision_When_SecondNumberIsDividedByZero_ShouldThrowArithmeticException() {

		System.out.println("Running method testDivision_When_SecondNumberIsDividedByZero_ShouldThrowArithmeticException");

		// Given
		double firstNumber = 0D;
		double secondNumber = 6D;

		var expectedMessage = "Impossible to divide by zero!";

		// When / Then
		ArithmeticException actual = assertThrows(ArithmeticException.class, () -> math.division(firstNumber, secondNumber),
				() -> "Division by zero should throw an ArithmeticException");

		assertEquals(expectedMessage, actual.getMessage(), () -> "Unexpected exception message");

	}

	@Test
	@DisplayName("Test (6 + 2) / 2 = 4")
	void testMean() {

		System.out.println("Running method testMean");

		double firstNumber = 6D;
		double secondNumber = 2D;

		Double actual = math.mean(firstNumber, secondNumber); // 4
		double expected = 4D;
		assertEquals(expected, actual,
				() -> "(" + firstNumber + " + " + secondNumber + ") / " + 2 + " did not produce " + expected + "!");
		assertNotEquals(9.2, actual);
		assertNotNull(actual, () -> "Expect value is not null.");

	}

	@Test
	@DisplayName("Test square root of 4 = 2")
	void testSquareRoot() {

		System.out.println("Running method testSquareRoot");

		double firstNumber = 4D;

		Double actual = math.squareRoot(firstNumber); // 2
		double expected = 2D;
		assertEquals(expected, actual, () -> "Square root of " + firstNumber + " did not produce " + expected + "!");
		assertNotEquals(9.2, actual);
		assertNotNull(actual, () -> "Expect value is not null.");

	}

	@DisplayName("Display name")
	@Test
	void testABCD_When_XYZ_Should() {

		System.out.println("Running method testABCD_When_XYZ_Should");

		// Given / Arrange
		// When / Act
		// Then / Assert
	}

}
