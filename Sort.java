package com.ericsson.jive.edm.jivetests.autogen.eventposting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * O - Worst Case, Omega - Best, Case Theta - Avg Case
 * 
 */
public class Sort
{

    public static void main(String[] args)
    {
        int[] i =
        { 1, 4, 3, 6, 2, 7, 0, 10 };
        mergeSort(i, i.length);
        quickSort(i, 0, 7);
        selectionSort(i);
        bubbleSort(i);
        insertionSort(i);
        System.out.println(Arrays.toString(i));
    }

    /*
     * Time complexity is O(nLogn) Auxiliary Space: O(n) Algorithmic Paradigm: Divide and Conquer Sorting In Place: No in a typical implementation
     * Stable: Yes Merge Sort is useful for sorting linked lists in O(nLogn) time. Inversion Count Problem Used in External Sorting
     * 
     */
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

    // Time Complexity is O(n)
    // Space Complexity is O(n)
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

    /*
     * Worst Case : O(n*2) - occurs when the partition process always picks as highest or smallest element Best Case : Omega(nlogn) - occurs when the
     * partition process always picks the middle element as pivot. Following is recurrence for best case. Avg Case : Theta(nlogn) - occurs when
     * partition puts O(n/9) elements in one set and O(9n/10) elements in other set. Divide and Conquer algorithm
     * 
     * Why Quick Sort is preferred over MergeSort for sorting Arrays ?
     * 
     * Quick Sort in its general form is an in-place sort (i.e. it doesn’t require any extra storage) whereas merge sort requires O(N) extra storage,
     * N denoting the array size which may be quite expensive. Allocating and de-allocating the extra space used for merge sort increases the running
     * time of the algorithm. Comparing average complexity we find that both type of sorts have O(NlogN) average complexity but the constants differ.
     * For arrays, merge sort loses due to the use of extra O(N) storage space. Most practical implementations of Quick Sort use randomized version.
     * The randomized version has expected time complexity of O(nLogn). The worst case is possible in randomized version also, but worst case doesn’t
     * occur for a particular pattern (like sorted array) and randomized Quick Sort works well in practice.
     * 
     * Quick Sort is also a cache friendly sorting algorithm as it has good locality of reference when used for arrays.
     * 
     * Quick Sort is also tail recursive, therefore tail call optimizations is done.
     * 
     * 
     * Why MergeSort is preferred over QuickSort for Linked Lists?
     * 
     * In case of linked lists the case is different mainly due to difference in memory allocation of arrays and linked lists. Unlike arrays, linked
     * list nodes may not be adjacent in memory. Unlike array, in linked list, we can insert items in the middle in O(1) extra space and O(1) time.
     * Therefore merge operation of merge sort can be implemented without extra space for linked lists. In arrays, we can do random access as elements
     * are continuous in memory. Let us say we have an integer (4-byte) array A and let the address of A[0] be x then to access A[i], we can directly
     * access the memory at (x + i*4). Unlike arrays, we can not do random access in linked list. Quick Sort requires a lot of this kind of access. In
     * linked list to access i’th index, we have to travel each and every node from the head to i’th node as we don’t have continuous block of memory.
     * Therefore, the overhead increases for quick sort. Merge sort accesses data sequentially and the need of random access is low.
     * 
     */
    public static void quickSort(int[] a, int low, int high)
    {
        if (low < high)
        {
            int pi = partition(a, low, high);
            quickSort(a, low, pi - 1);
            quickSort(a, pi + 1, high);
        }
    }

    // Time Complexity is O(n)
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

    /*
     * Time Complexity: O(n2) Auxiliary Space: O(1) The good thing about selection sort is it never makes more than O(n) swaps and can be useful when
     * memory write is a costly operation. In Place : Yest, it does not require extra space.
     * 
     */
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

    /*
     * Worst and Average Case Time Complexity: O(n*n). Worst case occurs when array is reverse sorted. Best Case Time Complexity: O(n). Best case
     * occurs when array is already sorted. Auxiliary Space: O(1) Boundary Cases: Bubble sort takes minimum time (Order of n) when elements are
     * already sorted. Sorting In Place: Yes
     *
     */

    private static void bubbleSort(int[] a)
    {
        for (int i = 0; i < a.length - 1; i++)
        {
            for (int j = 0; j < a.length - 1; j++)
            {
                if (a[j] > a[j + 1])
                {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    /*
     * Time Complexity: O(n*2) Auxiliary Space: O(1) Sorting In Place: Yes Insertion sort takes maximum time to sort if elements are sorted in reverse
     * order. It takes minimum time O(n) when elements are already sorted
     * 
     */
    private static void insertionSort(int arr[])
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i)
        {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key)
            {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
}
