package prime.number.generator;

import java.util.List;

public interface PrimeNumberGeneratorInterface {

	List<Integer> generate(int startingValue, int endingValue);
	boolean isPrime(int value);
	
}
