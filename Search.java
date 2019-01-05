package com.ericsson.jive.edm.jivetests.autogen.eventposting;

import java.util.Arrays;

public class Search
{

    public static void main(String[] args)
    {
        int[] array = new int[]
        { 1, 2, 3, 4, 6, 5, 7, 8 };
        linearSearch(array);
        // For Binary Search input array needs to be sorted
        Sort.selectionSort(array);
        System.out.println(Arrays.toString(array));

        System.out.println(binarySearch(array, 0, array.length - 1));

    }

    private static void linearSearch(int[] array)
    {
        int n = 3;
        Arrays.stream(array).asLongStream().forEach(a -> {
            if (a == n)
            {
                System.out.println(a);
            }
        });
    }

    private static int binarySearch(int[] array, int lowIndex, int highIndex)
    {
        int n = 3;
        if (highIndex >= 1)
        {
            int mid = lowIndex + highIndex - 1 / 2;
            if (array[mid] == n)
            {
                System.out.println(array[mid] + "index is " + mid);
                return array[mid];
            }
            if (array[mid] > n)
            {
                return binarySearch(array, lowIndex, mid - 1);
            }
            
            return binarySearch(array, mid + 1, highIndex);
        }
        return -1;
    }
}
