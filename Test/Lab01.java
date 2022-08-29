/* 
CIS22C
Author:  Laksh Bhambhani
Lab 1: This program checks if a number is prime using both iterative and recursive function
Pseudocode: 
Ask user for number of array elements 
get elements and add to array
sort through iteratively to see if all numbers are prime, true if they are false otherwise
sort through recursively to see if all numbers are prime, true if they are false otherwise
Pause
Exit
*/

package Test;

import java.util.Scanner;

public class Lab01 {

    private static final int SORT_MAX_SIZE = 16;
    private static int arraySize;
    private static int[] array;
    private static Scanner sc;

    int[] arr = {};

    public static void main(String[] args) {
       test(3);
    }

    public static void test(int n){
        System.out.print("A");
        if(n>0){
            test(n-1);
            System.out.print("Z");
        }
    }

    int binarySearch(int arr[], int l, int r, int x)
    {
        if (r >= l) {
            int mid = l + (r - l) / 2;
 
            // If the element is present at the
            // middle itself
            if (arr[mid] == x)
                return mid;
 
            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 1, x);
 
            // Else the element can only be present
            // in right subarray
            return binarySearch(arr, mid + 1, r, x);
        }
 
        // We reach here when element is not present
        // in array
        return -1;
    }
}
