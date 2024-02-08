package com.ds.array;

import java.util.Arrays;
import java.util.Collections;

public class ArrayPrograms {

    // Time Complextity : O(N)
    // Auxiliary Space : O(1)
    public static void printLargestThreeElements(int[] arr){
        int n = arr.length;
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        if(n < 3){
            System.out.println("Invalid Input");
            return;
        }

        for(int i = 0; i < n; i++){
            if(arr[i] != first && arr[i] != second && arr[i] != third){
                if(arr[i] > first){
                    third = second;
                    second = first;
                    first = arr[i];
                }

                else if(arr[i] > second){
                    third = second;
                    second = arr[i];
                }

                else if(arr[i] > third){
                    third = arr[i];
                }
            }
        }
        System.out.println("The Three Largest Elements are :" + first + " , " + second + " , " + third);
    }


    public static void printLargestThreeNumbersOptimised(int[] arr){
        Arrays.sort(arr); // sorted using tuned quicksort
        int n = arr.length;
        int check = 0;
        int count = 1;

        for(int i = 1; i <=n ; i++){
            if(count < 4){
                if(check != arr[n - i]){
                    System.out.print(arr[n - i] + " ");
                    check = arr[n - i];
                    count++;
                }
            }
            else
                break;
        }

    }

    public static int findSecondLargest(int[] arr){
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            if(arr[i] != max && arr[i] != secondMax){
                if(arr[i] > max){
                    secondMax = max;
                    max= arr[i];
                }
                else if(arr[i] > secondMax){
                    secondMax = arr[i];
                }
            }
        }

        return secondMax;
    }

    public static int findSecondLargestUsingSorting(int[] arr){
        int n = arr.length;
        Arrays.sort(arr);
        for(int i = n - 2; i >= 0; i--){
            if(arr[i] != arr[n - 1])
                return arr[i];
        }
        return Integer.MIN_VALUE;
    }


    public static Integer[] sortArrayInReverseOrder(int[] arr){
       Integer[] boxedArray = Arrays.stream(arr).boxed().toArray(Integer[]::new);
       Arrays.sort(boxedArray, Collections.reverseOrder());
       return boxedArray;
    }

    public static void pushZerosToEnd(int arr[])
    {
        int n = arr.length;
        int count = 0;  // Count of non-zero elements

        // Traverse the array. If element encountered is
        // non-zero, then replace the element at index 'count'
        // with this element
        for (int i = 0; i < n; i++)
            if (arr[i] != 0)
                arr[count++] = arr[i]; // here count is
        // incremented

        // Now all non-zero elements have been shifted to
        // front and 'count' is set as index of first 0.
        // Make all elements 0 from count to end.
        while (count < n)
            arr[count++] = 0;
    }

    public static void pushZeroToEndSecond(int[] arr){
            int n = arr.length;
            int j = 0;

            for(int i = 0; i < n; i++){
                if(arr[i] != 0){
                    swap(arr, i , j++);
                }
            }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int linearSearch(int[] arr, int searchKey){
        int n = arr.length;

        for(int i = 0; i < n; i++){
            if(arr[i] == searchKey)
                return i;
        }

        return -1;
    }

    
    public static int binarySearchRec(int[] arr, int low, int high, int searchKey){
        int mid = low + ( high - low )/ 2;
        if(searchKey == arr[mid])
            return mid;
        else if (searchKey > arr[mid]){
            return binarySearchRec(arr, mid + 1, high, searchKey);
        }
        return binarySearchRec(arr, low, mid -1 , searchKey);
    }

}
