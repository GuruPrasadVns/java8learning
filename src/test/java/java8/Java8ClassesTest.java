package java8;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.function.IntPredicate;

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

}
