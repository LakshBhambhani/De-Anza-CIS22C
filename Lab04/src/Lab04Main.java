/**
 * @author laksh bhambhani
 * Represents the main class to run and test the adt for a bst for lab4
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Lab04Main {
	
	private static Scanner input = new Scanner(System.in); 
	
	// Driver Code
    public static void main(String[] args)
    {
    	File outputFile = new File("out.txt");
    	System.setOut(new DoublePrintStream(System.out, "../out.txt"));
        
        BST tree = new BST();
 
        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 */
        tree.insert(new Dollar(57.12));
        tree.insert(new Dollar(23.44));
        tree.insert(new Dollar(87.43));
        tree.insert(new Dollar(68.99));
        tree.insert(new Dollar(111.22));
        tree.insert(new Dollar(44.55));
        tree.insert(new Dollar(77.77));
        tree.insert(new Dollar(18.36));
        tree.insert(new Dollar(543.21));
        tree.insert(new Dollar(20.21));
        tree.insert(new Dollar(345.67));
        tree.insert(new Dollar(36.18));
        tree.insert(new Dollar(48.48));
        tree.insert(new Dollar(101.00));
        tree.insert(new Dollar(11.00));
        tree.insert(new Dollar(21.00));
        tree.insert(new Dollar(51.00));
        tree.insert(new Dollar(1.00));
        tree.insert(new Dollar(251.00));
        tree.insert(new Dollar(151.00));
 
        // print inorder traversal of the BST
        printTraversals(tree);
        
        String operation;
        
        printMenu();
        
        do {
        	operation = input.nextLine();
			if(operation.equals("4")) {
				System.out.println("Output logs saved at " + outputFile.getAbsolutePath());
				System.exit(0);
			}
			if(operation.equals("1")) {
				System.out.println("What do you want to insert?");
				String value = input.nextLine();
				tree.insert(new Dollar(Double.parseDouble(value)));
			}
			if(operation.equals("2")) {
				System.out.println("Which key do you want to delete?");
				String value = input.nextLine();
				tree.deleteKey(new Dollar(Double.parseDouble(value)));
			}
			if(operation.equals("3")) {
				printTraversals(tree);
			}
			printMenu();
        } while(operation != "4");
        
		System.out.println("Output logs saved at " + outputFile.getAbsolutePath());
        
        
    }
    
    public static void printTraversals(BST tree) {
    	System.out.println("Breadth First: ");
    	tree.printLevelOrder();
    	System.out.println("\nIn Order: ");
    	tree.printInorder();
    	System.out.println("\nPre Order: ");
    	tree.printPreorder();
    	System.out.println("\nPost Order: ");
    	tree.printPostorder();
    }
    
    public static void printMenu() {
    	System.out.println("Menu: \n1. Insert \n2. Delete \n3. Print \n4. Exit \nEnter Number of Option to Proceed");
    }
    
    static class DoublePrintStream extends PrintStream {
        private final OutputStream fos;

        DoublePrintStream(OutputStream out, String filename){
            super(out);

            try {
                fos = new FileOutputStream(new File(filename));
            } catch (FileNotFoundException e) {
                throw new AssertionError("cant create file", e);
            }
        }

        @Override
        public void write(byte[] buf, int off, int len) {
            super.write(buf, off, len);

            try {
                fos.write(buf, off, len);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public void close() {
            try {
                fos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                super.close();
            }
        }
    }

}
