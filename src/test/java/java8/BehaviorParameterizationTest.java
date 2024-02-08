package java8;

import com.impl.AppleWeightComparator;
import com.impl.GreenApplePredicate;
import com.interfaces.ApplePredicate;
import com.model.Apple;
import com.utility.AppleUtility;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BehaviorParameterizationTest {
    private List<Apple> appleList;

    @Before
    public void setup(){
        appleList = AppleUtility.getApplesList();
    }

    @Test
    public void filterGreenApplesTest(){
        List<Apple> result = AppleUtility.filterApples(appleList, new GreenApplePredicate());
        assertEquals(6, result.size());

        for(Apple apple : result)
            assertEquals("green", apple.getColor());
    }

    @Test
    public void filterRedApplesUsingAnonymousClassTest(){
        List<Apple> result = AppleUtility.filterApples(appleList, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return "red".equals(apple.getColor());
            }
        });

        assertEquals(4, result.size());

        for(Apple apple : result)
            assertEquals("red", apple.getColor());
    }

    @Test
    public void filterGreenAndHeavyApplesUsingLambdaTest(){
        List<Apple> result = AppleUtility.filterApples(appleList, (Apple apple) -> apple.getWeight() > 150 && "red".equals(apple.getColor()));
        assertEquals(3, result.size());

        for(Apple apple : result){
            assertEquals("red", apple.getColor());
            assertTrue(apple.getWeight() > 150);
        }
    }

    @Test
    public void sortAppleByWeightTest(){
        appleList.sort(new AppleWeightComparator());
        assertEquals(75, appleList.get(0).getWeight());
        assertEquals(350, appleList.get(appleList.size() - 1).getWeight());
    }

    @Test
    public void sortAppleListByWeightUsingLambdaTest(){
        appleList.sort((Apple a1, Apple a2) -> {
            if(a1.getWeight() < a2.getWeight())
                return -1;
            if(a1.getWeight() > a2.getWeight())
                return 1;
            return 0;
        });

        assertEquals(75, appleList.get(0).getWeight());
        assertEquals(350, appleList.get(appleList.size() - 1).getWeight());
    }


}
