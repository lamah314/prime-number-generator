package prime.number.generator;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class PrimeNumberGeneratorTest {
	PrimeNumberGenerator primeNumberGenerator;

	@Before
	public void initialize() {
		// instantiating object since interface methods are not static
		primeNumberGenerator = new PrimeNumberGenerator();
		primeNumberGenerator.generateBase(11); //for checking isPrime method
	}

	@Test
	public void primeNumberGeneratorImplementsPrimeNumberGeneratorInterface() {
		Class<PrimeNumberGenerator> classObject = PrimeNumberGenerator.class;
		assertTrue(PrimeNumberGeneratorInterface.class.isAssignableFrom(classObject));
	}

	@Test
	public void numbersUnderTwoAreNotPrime() {
		assertFalse(primeNumberGenerator.isPrime(0));
		assertFalse(primeNumberGenerator.isPrime(1));
		assertFalse(primeNumberGenerator.isPrime(-11));
	}

	@Test
	public void twoIsPrime() {
		assertTrue(primeNumberGenerator.isPrime(2));
	}

	@Test
	public void allEvenNumbersAfterTwoAreNotPrime() {
		assertFalse(primeNumberGenerator.isPrime(4));
		assertFalse(primeNumberGenerator.isPrime(6));
		assertFalse(primeNumberGenerator.isPrime(8));
		assertFalse(primeNumberGenerator.isPrime(222));
	}

	@Test
	public void threeIsPrime() {
		assertTrue(primeNumberGenerator.isPrime(3));
	}

	@Test
	public void fiveIsPrime() {
		assertTrue(primeNumberGenerator.isPrime(3));
	}
	
	@Test
	public void elevenIsPrime() {
		assertTrue(primeNumberGenerator.isPrime(11));
	}

	@Test
	public void firstThreePrimeNumbersAreTwoThreeFive() {
		List<Integer> testListBase = primeNumberGenerator.generateBase(5);
		List<Integer> testList = primeNumberGenerator.generate(0,5);
		List<Integer> expectedList = Arrays.asList(new Integer[] { 2, 3, 5 });
		assertEquals(expectedList, testList);
	}

	@Test
	public void firstTwentySixPrimeNumbersAreSameAsInstructionList() {
		List<Integer> testListBase = primeNumberGenerator.generateBase(101);
		List<Integer> testList = primeNumberGenerator.generate(0, 101);
		List<Integer> expectedList = Arrays.asList(new Integer[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43,
				47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101 });
		assertEquals(expectedList, testListBase);
		assertEquals(expectedList, testList);
	}
	
	@Test
	public void inverseOrderAchievesSameResults() {
		List<Integer> testList = primeNumberGenerator.generate(0,101);
		List<Integer> test2List = primeNumberGenerator.generate(101,0);
		assertEquals(test2List, testList);
	}
	
	@Test
	public void generatorResultsMatchInstructions() {
		List<Integer> testList = primeNumberGenerator.generate(7900, 7920);
		List<Integer> expectedList = Arrays.asList(new Integer[] { 7901, 7907, 7919 });
		assertEquals(expectedList, testList);
	}

	@Test
	public void listIndexFinderShouldReturn2() {
		List<Integer> testListBase = primeNumberGenerator.generateBase(5);
		int indexNumber = primeNumberGenerator.listIndexFinder(testListBase,6);
		assertEquals(2, indexNumber);
	}
	
	@Test
	public void listIndexFinderShouldReturn3() {
		List<Integer> testListBase = primeNumberGenerator.generateBase(7);
		int indexNumber = primeNumberGenerator.listIndexFinder(testListBase,100);
		assertEquals(3, indexNumber);
	}
	
	//These test if interface methods exist in main class. Probably not necessary.
//	@Test
//	public void primeNumberGeneratorContainsGenerateMethod() {
//		Method methodToFind = null;
//		try {
//			Class[] methodArguments = new Class[2];
//			methodArguments[0] = int.class;
//			methodArguments[1] = int.class;
//			methodToFind = PrimeNumberGenerator.class.getMethod("generate", methodArguments);
//		} catch (NoSuchMethodException | SecurityException e) {
//			System.out.println(e.toString());
//		}
//		assertNotNull(methodToFind);
//	}
//
//	@Test
//	public void primeNumberGeneratorContainsIsPrimeMethod() {
//		Method methodToFind = null;
//		try {
//			Class[] methodArguments = new Class[1];
//			methodArguments[0] = int.class;
//			methodToFind = PrimeNumberGenerator.class.getMethod("isPrime", methodArguments);
//		} catch (NoSuchMethodException | SecurityException e) {
//			System.out.println(e.toString());
//		}
//		assertNotNull(methodToFind);
//	}
}
