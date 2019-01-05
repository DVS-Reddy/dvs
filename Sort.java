package com.ericsson.jive.edm.jivetests.autogen.eventposting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sort
{

    public static void main(String[] args)
    {
        int[] i =
        { 1, 4, 3, 6, 2, 7, 0, 10 };
        mergeSort(i, i.length);
        quickSort(i, 0, 7);
        selectionSort(i);
        System.out.println(Arrays.toString(i));
    }

    public static void mergeSort(int[] a, int n)
    {
        if (n < 2)
        {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++)
        {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++)
        {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);
        merge(a, l, r, mid, n - mid);
    }

    //Time Complexity is O(n)
    //Space Complexity is O(n)
    public static void merge(int[] a, int[] l, int[] r, int left, int right)
    {
        int leftpointer = 0, rightpointer = 0, finalpointer = 0;
        while (leftpointer < left || rightpointer < right)
        {
            if (leftpointer < left && rightpointer < right)
            {
                if (l[leftpointer] < r[rightpointer])
                {
                    a[finalpointer++] = l[leftpointer++];
                }
                else
                {
                    a[finalpointer++] = r[rightpointer++];
                }
            }
            else if (leftpointer < left)
                a[finalpointer++] = l[leftpointer++];
            else
                a[finalpointer++] = r[rightpointer++];
        }
    }

    public static void quickSort(int[] a, int low, int high)
    {
        if (low < high)
        {
            int pi = partition(a, low, high);
            quickSort(a, low, pi - 1);
            quickSort(a, pi + 1, high);
        }
    }

    //Time Complexity is O(n)
    public static int partition(int[] a, int low, int high)
    {
        int pivot = a[high];
        int i = low - 1;
        for (int j = low; j < high; j++)
        {
            if (a[j] < a[high])
            {
                i++;
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        int temp = a[i + 1];
        a[i + 1] = a[high];
        a[high] = temp;

        return i + 1;

    }

    public static void selectionSort(int[] arr)
    {
        for (int i = 0; i < arr.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < arr.length; j++)
            {
                if (arr[j] < arr[i])
                {
                    index = j;
                }
            }
            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
    }
}
