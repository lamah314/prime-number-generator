package prime.number.generator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class PrimeNumberGenerator implements PrimeNumberGeneratorInterface {

	List<Integer> primeListBase = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		PrimeNumberGenerator primeNumberGenerator = new PrimeNumberGenerator();
		Scanner input = new Scanner(System.in);
		int startingValue;
		int endingValue;
		
		while(true) {
			System.out.println("Please pick your starting value");
			startingValue = Integer.parseInt(input.nextLine());
			System.out.println("Please pick your ending value");
			endingValue = Integer.parseInt(input.nextLine());
			
			if (primeNumberGenerator.generate(startingValue, endingValue).isEmpty()) {
				System.out.println("There are no prime numbers between " + startingValue + " and " + endingValue);
				System.out.println("-------------------------");
			} else {
			System.out.println("The prime numbers between " + startingValue + " and " + endingValue +":");
			System.out.println(primeNumberGenerator.generate(startingValue, endingValue));
			System.out.println("-------------------------");
			}
		}
	}
	
	@Override
	public List<Integer> generate(int startingValue, int endingValue) {
		List<Integer> primeList = new ArrayList<Integer>();
		int a = Math.min(startingValue, endingValue);
		int b = Math.max(startingValue, endingValue);
		generateBase((int) Math.round(Math.sqrt(b))); //find all relevant primes
		for (int i = a; i <= b; i++) {
			if (isPrime(i)) {
				primeList.add(i);
			}
		}
		return primeList;
	}

	@Override
	public boolean isPrime(int value) {
		List<Integer> unitPlacePrimes = Arrays.asList(new Integer[]{1,3,7,9}); //prime numbers after 5 can only have these values in unit place
		if (value < 2) {
			return false;
		} else if (value == 2) { //since we won't be checking even numbers onwards
			return true;	
		} else if (value == 5) { //since we won't be checking unit place 5's onwards
			return true;	
		} else if (unitPlacePrimes.contains(value%10)) { //checking if unit value is in array
			boolean isPrimeChecker = true;
			//only check prime numbers between 3 and highest relevant prime
			for(int i = 1; i <= listIndexFinder(primeListBase,Math.max(2, Math.sqrt(value))); i++) { 
				if (value%primeListBase.get(i) == 0) { 
					isPrimeChecker = false;
				}
			}
			return isPrimeChecker;
		} else return false;
	}
	
	//collect primes to use for checking other primes in order to reduce processing
	public List<Integer> generateBase(int endingValue) {
		primeListBase = new ArrayList<Integer>();
		primeListBase.add(2);
		for (int i = 3; i <= endingValue; i++) {
			if (isPrime(i)) {
				primeListBase.add(i);
			}
		}
		return primeListBase;
	}
	
	//given a value, find the index of the value in a sorted list that is closest without going over. 
	public int listIndexFinder(List<Integer> primeList, double value ) { 
		for (int i = (int) Math.round(value); i >=  2; i--) {
			if (primeList.contains(i)) {
				return primeList.indexOf(i);
			}
		}
		
		return 2;
	}
}
