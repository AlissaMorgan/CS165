import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class TestCases {

	//Switch which line is commented out in order to test the correct vs broken code
	//TestingFunctions functions = new BlackBoxCorrect();
	//TestingFunctions functions = new BlackBoxIncorrect();
	TestingFunctions functions = new MyFunctions();
	
	/**
	 * This is a simple validity check for the method greatestCommonDivisor. Checks that the method
	 * returns the correct result for a known GCD problem gcd(2,4) = 2
	 */
	@Test
	public void testGCD() {
		assertEquals("Error: should return 2", 2, functions.greatestCommonDivisor(2, 4));
	}

	@Test
	public void testGCDZero() {assertEquals("Zero: Should return 0", 1, functions.greatestCommonDivisor(0, 1));}

	@Test
	public void testGCDNegatives() {
		assertEquals("Negatives: Should return -1", -1, functions.greatestCommonDivisor(-4, -2));
	}

	@Test
	public void testGCDPrime(){
		assertEquals("Prime: Should return 1", 1, functions.greatestCommonDivisor(3, 7));
	}

	@Test
	public void testGCDEquals(){
		assertEquals("Equals: Should return 3", 3, functions.greatestCommonDivisor(3, 6));
	}
	/**
	 * This is a simple check of the reverseWindow method. Checks if the method will reverse the entire contents
	 * of the passed array correctly.
	 */
	@Test
	public void testReverseWindow() {
		int[] actual = {1, 2, 3, 4};
		functions.reverseWindow(actual, 0, 3);
		int[] expected = {3, 2, 1, 4};
		assertArrayEquals("The whole array should be revered.", expected, actual);
	}

	@Test (expected = IndexOutOfBoundsException.class)
	public void testRWIndexOutBounds(){
		int[] actual = {1, 2, 3, 4};
		int[] expected = {4, 3, 2, 1};
		functions.reverseWindow(actual, 3, 7);
		assertEquals("Should throw Index out of Bounds Error", expected, actual);
	}

	@Test
	public void testRWAtBounds(){
		int[] actual = {1, 2, 3, 4};
		int[] expected = {4, 3, 2, 1};
		functions.reverseWindow(actual, 0, 4);
		assertArrayEquals("AtBounds: Should reverse whole array", expected, actual);
	}

	@Test
	public void testRWReverseIndices(){
		int[] actual = {1, 2, 3, 4};
		int[] expected = {4, 3, 2, 1};
		functions.reverseWindow(actual, 4, 0);
		assertArrayEquals("ReverseIndices: Indices should be swapped and whole array reversed", expected, actual);
	}

	@Test (expected = IndexOutOfBoundsException.class)
	public void testRWEmptyArr(){
		int[] actual = {};
		int[] expected = {};
		functions.reverseWindow(actual, 0, 1);
		assertArrayEquals("EmptyArr: Should return empty array", expected, actual);
	}
	@Test
	public void testRWEqualIndices(){
		int[] actual = {1, 2, 3, 4};
		int[] expected = {1, 2, 3, 4};
		functions.reverseWindow(actual, 1, 1);
		assertArrayEquals("EqualIndices: Should throw Index out of Bounds Error", expected, actual);
	}


	//For completion, write additonal tests as described in the lab documentation.
}
