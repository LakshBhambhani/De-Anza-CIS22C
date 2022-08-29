import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Program takes in integers and checks all integers in array (Up to 8) to see if they are a
 * palindrome
 * 
 * PSEUDOCODE:
 * program start
 * read integers in uptil -1 or 8 ints whichever comes first
 * Circle through array checking each integer for palindrome
 * Print all palindrome numbers
 * 
 * @author lakshbhambhani
 *
 */

public class palindrome {
	
	private static int[] array = new int[8];
	private static Scanner sc;
	private static int num, read;
	
	private static Comparator<Integer> comparator = new Comparator<Integer>() {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    };
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
        System.out.print("Enter all your elements in: ");
        int input = sc.nextInt();
        while(num <= 7 && input != -1) {
        	if(input > 0 && input < 99999) {
        		array[read] = input;
        		read++;
        	}
        	num++;
        	input = sc.nextInt();
        }
        Arrays.sort(array);
        System.out.println("Parsed Array: " + Arrays.toString(array));
        for(int i = 7; i >= 0; i--) {
        	int x = array[i];
        	if(x != 0 && isPalindrome(x)) {
        		System.out.print(x + " ");
        	}
        }
        System.out.println();
	}
	
	public static boolean isPalindrome(int n) {
	
		int reversedNum = 0, remainder;
	    
	    // store the number to originalNum
	    int originalNum = n;
	    
	    // get the reverse of originalNum
	    // store it in variable
	    while (n != 0) {
	      remainder = n % 10;
	      reversedNum = reversedNum * 10 + remainder;
	      n /= 10;
	    }
	    
	    // check if reversedNum and originalNum are equal
	    if (originalNum == reversedNum) {
	      return true;
	    }
	    else {
	      return false;
	    }
	}

}
