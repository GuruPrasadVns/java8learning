package com.ds.array;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ArrayProgramsTest {
    @Test
    public void printLargestThreeElementsTest(){
//        int arr[] = { 12, 13, 1, 10, 34, 1 };
//        ArrayPrograms.printLargestThreeElements(arr);

        int[] arr1 = { 12, 45, 1, -1, 45, 54, 23, 5, 0, -10 };
        ArrayPrograms.printLargestThreeElements(arr1);
    }

    @Test
    public void printLargestThreeElementsOptimisedTest(){
//        int arr[] = { 12, 13, 1, 10, 34, 1 };
//        ArrayPrograms.printLargestThreeNumbersOptimised(arr);

        int[] arr1 = { 12, 45, 1, -1, 45, 54, 23, 5, 0, -10 };
        ArrayPrograms.printLargestThreeNumbersOptimised(arr1);
    }

    @Test
    public void findSecondLargestTest(){
        int arr[] = {10, 10, 10};
        assertEquals(Integer.MIN_VALUE, ArrayPrograms.findSecondLargest(arr));

        int arr1[] = { 12, 35, 1, 10, 34, 1 };

        assertEquals(34, ArrayPrograms.findSecondLargest(arr1));

        int arr2[] = {10, 5, 10};

        assertEquals(5, ArrayPrograms.findSecondLargest(arr2));
    }

    @Test
    public void findSecondLargestUsingSortingTest(){
        int arr[] = {10, 10, 10};
        assertEquals(Integer.MIN_VALUE, ArrayPrograms.findSecondLargestUsingSorting(arr));

        int arr1[] = { 12, 35, 1, 10, 34, 1 };

        assertEquals(34, ArrayPrograms.findSecondLargestUsingSorting(arr1));

        int arr2[] = {10, 5, 10};

        assertEquals(5, ArrayPrograms.findSecondLargestUsingSorting(arr2));
    }

    @Test
    public void sortArrayInReverseOrderTest(){
        int[] arr1 = { 12, 45, 1, -1, 45, 54, 23, 5, 0, -10 };
        Integer[] sortedArray = ArrayPrograms.sortArrayInReverseOrder(arr1);
        System.out.println(Arrays.toString(sortedArray));
    }

    @Test
    public void pushesZerosToEndTest(){
        int[] arr1 = { 1, 2, 0, 4, 3, 0, 5, 0 };
        ArrayPrograms.pushZerosToEnd(arr1);
        System.out.println(Arrays.toString(arr1));
    }

    @Test
    public void pushesZerosToEndSecondTest(){
        int[] arr1 = { 1, 2, 0, 4, 3, 0, 5, 0 };
        ArrayPrograms.pushZeroToEndSecond(arr1);
        System.out.println(Arrays.toString(arr1));
    }

    @Test
    public void linearSearchTest(){
        int[] arr1 ={ 12, 13, 1, 10, 34, 1 };
        assertEquals(0, ArrayPrograms.linearSearch(arr1, 12));
        assertEquals(1, ArrayPrograms.linearSearch(arr1, 13));
        assertEquals(2, ArrayPrograms.linearSearch(arr1, 1));
        assertEquals(3, ArrayPrograms.linearSearch(arr1, 10));
        assertEquals(4, ArrayPrograms.linearSearch(arr1, 34));
        assertEquals(-1, ArrayPrograms.linearSearch(arr1, 38));
    }

    @Test
    public void binarySearchRecTest(){
        int[] arr1 ={ 1, 1, 10, 12, 13, 34 };
        assertEquals(1, ArrayPrograms.binarySearchRec(arr1, 0, arr1.length, 1));
        assertEquals(2, ArrayPrograms.binarySearchRec(arr1, 0, arr1.length, 10));
        assertEquals(3, ArrayPrograms.binarySearchRec(arr1, 0, arr1.length, 12));
        assertEquals(4, ArrayPrograms.binarySearchRec(arr1, 0, arr1.length, 13));
        assertEquals(5, ArrayPrograms.binarySearchRec(arr1, 0, arr1.length, 34));
    }
}
