package java8;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntPredicate;

import com.java8.Java8Utiltiy;
import org.junit.Test;

public class Java8ClassesTest {
	
	@Test
	public void intPredicateTest() {
		IntPredicate evenNumberPredicate = i -> i % 2 == 0;
		assertTrue(evenNumberPredicate.test(24));
		assertFalse(evenNumberPredicate.test(23));
		
		IntPredicate divisibleByThree = i -> i % 3 == 0;
		assertTrue(divisibleByThree.test(60));
		assertFalse(divisibleByThree.test(91));
		
		IntPredicate evenAndDivisibleByThree = evenNumberPredicate.and(divisibleByThree);
		
		assertTrue(evenAndDivisibleByThree.test(60));
		assertFalse(evenAndDivisibleByThree.test(9));
		assertFalse(evenAndDivisibleByThree.test(80));
		
		IntPredicate evenOrDivisibleByThree = evenNumberPredicate.or(divisibleByThree);
		
		assertTrue(evenOrDivisibleByThree.test(60));
		assertTrue(evenOrDivisibleByThree.test(9));
		assertTrue(evenOrDivisibleByThree.test(80));
		assertFalse(evenOrDivisibleByThree.test(11));
		
		IntPredicate notDivisibleByThree = divisibleByThree.negate();
		assertFalse(notDivisibleByThree.test(60));
		assertTrue(notDivisibleByThree.test(91));
	}

	@Test
	public void consumerInterfaceTest(){
		Consumer<Integer> displayInteger = i -> System.out.println(i);
		displayInteger.accept(5);

		Consumer<List<Integer>> doubledList = list -> {
			for(int i = 0; i < list.size(); i++){
				list.set(i, 2 * list.get(i));
			}
		};

		Consumer<List<Integer>> displayList = list -> list.stream().forEach( i -> System.out.println(i));

		List<Integer> numbers = Arrays.asList(23, 56, 73, 54);

		doubledList.accept(numbers);
		displayList.accept(numbers);
 	}

	@Test
	public void consumerInterfaceAndThenTest(){

		Consumer<List<Integer>> doubledList = list -> {
			for(int i = 0; i < list.size(); i++){
				list.set(i, 2 * list.get(i));
			}
		};

		Consumer<List<Integer>> displayList = list -> list.stream().forEach( i -> System.out.println(i));

		List<Integer> numbers = Arrays.asList(23, 56, 73, 54);

		doubledList.andThen(displayList).accept(numbers);
	}

	@Test
	public void predicateTest(){
		List<String> strings = Arrays.asList(
				"Guru Prasad Pandey",
				"Shree Krishna Pandey",
				"Sandhya Pandey",
				"Nitya Pandey",
				"Shweta Tripathi"
		);

		List<String> stringStartsWithS = Java8Utiltiy.processStringUsingPredicate(strings, s -> s.startsWith("S"));
		System.out.println(stringStartsWithS);
	}

	@Test
	public void consumerTest(){
		List<String> strings = Arrays.asList(
				"Guru Prasad Pandey",
				"Shree Krishna Pandey",
				"Sandhya Pandey",
				"Nitya Pandey",
				"Shweta Tripathi"
		);

		Java8Utiltiy.printStringUsingConsumer(strings, s -> System.out.println(s + " " +s.length()));
	}

	@Test
	public void functionTest(){
		List<String> strings = Arrays.asList(
				"Guru Prasad Pandey",
				"Shree Krishna Pandey",
				"Sandhya Pandey",
				"Nitya Pandey",
				"Shweta Tripathi"
		);
		List<Integer> stringLengthsList = Java8Utiltiy.processStringsUsingFunction(strings, s -> s.length());
		System.out.println(stringLengthsList);
	}
}
