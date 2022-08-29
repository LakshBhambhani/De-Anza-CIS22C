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

package Lab01;

import java.util.Scanner;

public class Lab01 {

    private static final int SORT_MAX_SIZE = 16;
    private static int arraySize;
    private static int[] array;
    private static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        System.out.print("Enter the number of elements you want to store: ");
        arraySize = sc.nextInt();
        if (arraySize > SORT_MAX_SIZE) {
            arraySize = SORT_MAX_SIZE;
        }
        array = new int[arraySize];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < arraySize; i++) {
            array[i] = sc.nextInt();
        }

        if (IsArrayPrimeIter(arraySize, array)) {
            System.out.println("Prime Array Using Iteration");
        } else {
            System.out.println("Not a Prime Array Using Iteration");
        }

        if (IsArrayPrimeRecur(arraySize, array)) {
            System.out.println("Prime Array Using Recursion");
        } else {
            System.out.println("Not a Prime Array Using Recursion");
        }

        System.out.print("Press 1 to exit");
        if(sc.nextInt() == 1){
            System.exit(0);
        }
    }

    public static boolean IsArrayPrimeIter(int arraySize, int[] array) {
        System.out.println("Entering IsArrayPrimeIter");
        for (int i = 0; i < arraySize; i++) {
            int n = array[i];
            if (n <= 1) {
                return false;
            }
            for (int j = 2; j < n; j++) {
                if (n % j == 0) {
                    return false;
                }
            }
        }
        System.out.println("Leaving IsArrayPrimeIter");
        return true;
    }

    public static boolean IsArrayPrimeRecur(int arraySize, int[] array) {
        System.out.println("Entering IsArrayPrimeRecur");
        if (arraySize == 0) {
            System.out.println("Leaving IsArrayPrimeRecur");
            return true;
        }
        if (IsPrimeRecur(array[arraySize - 1], 2)) {
            return IsArrayPrimeRecur(arraySize - 1, array);
        } else {
            System.out.println("Leaving IsArrayPrimeRecur");
            return false;
        }
    }

    public static boolean IsPrimeRecur(int n, int i) {
        System.out.println("Entering isPrimeRecur");
        // Base cases
        if (n <= 2)
            return (n == 2) ? true : false;
        if (n % i == 0) {
            System.out.println("Leaving isPrimeRecur");
            return false;
        }
        if (i * i > n) {
            System.out.println("Leaving isPrimeRecur");
            return true;
        }

        // Check for next divisor
        return IsPrimeRecur(n, i + 1);
    }
}
