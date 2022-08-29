/**
 * @author lakshbhambhani
 * Represents the main class
 */

import java.util.Scanner;

public class Lab3main {
			
	private static Scanner input = new Scanner(System.in); 
	
	static Currency[] currency = new Currency[20];
	
	private static SinglyLinkedList list;
	private static Stack stack;
	private static Queue queue;
	
	public static void main(String[] args) {
		
		list = new SinglyLinkedList();
		stack = new Stack();
		queue = new Queue();
		
		currency[0] = new Dollar(57.12);
		currency[1] = new Dollar(23.44);
		currency[2] = new Dollar(87.43);
		currency[3] = new Dollar(68.99);
		currency[4] = new Dollar(111.22);
		currency[5] = new Dollar(44.55);
		currency[6] = new Dollar(77.77);
		currency[7] = new Dollar(18.36);
		currency[8] = new Dollar(543.21);
		currency[9] = new Dollar(20.21);
		currency[10] = new Dollar(345.67);
		currency[11] = new Dollar(36.18);
		currency[12] = new Dollar(48.48);
		currency[13] = new Dollar(101.00);
		currency[14] = new Dollar(11.00);
		currency[15] = new Dollar(21.00);
		currency[16] = new Dollar(51.00);
		currency[17] = new Dollar(1.00);
		currency[18] = new Dollar(251.00);
		currency[19] = new Dollar(151.00);
		
		list.addCurrency(0, currency[6]);
		list.addCurrency(1, currency[5]);
		list.addCurrency(2, currency[4]);
		list.addCurrency(3, currency[3]);
		list.addCurrency(4, currency[2]);
		list.addCurrency(5, currency[1]);
		list.addCurrency(6, currency[0]);

		list.printList();

		System.out.println(list.findCurrency(new Dollar(87.43)));
		System.out.println(list.findCurrency(new Dollar(44.56)));
		
		try {
			list.removeCurrency(new Dollar(111.22));
			list.removeCurrency(2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		list.printList();
		
		for(int i = 8; i <= 11; i++) {
			list.addCurrency(i%5, currency[i]);
		}
		
		try {
			list.removeCurrency(list.countCurrency()%6);
			list.removeCurrency(list.countCurrency()/7);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		list.printList();
		
		
		for(int i = 13; i < 20; i++) {
			stack.push(currency[i]);
		}
				
		System.out.println(stack.peek().getValue());
		
		for(int i = 0; i < 3; i++) {
			stack.pop();
		}
		
		stack.printStack();
		
		for(int i = 0; i < 5; i++) {
			stack.push(currency[i]);
		}
		
		for(int i = 0; i < 2; i++) {
			stack.pop();
		}
		
		stack.printStack();
		
		for(int i = 5; i < 18; i+=2) {
			queue.enqueue(currency[i]);
		}
		
		System.out.println(queue.peekFront().getValue());
		System.out.println(queue.peekRear().getValue());
		
		queue.dequeue();
		queue.dequeue();
		
		queue.printQueue();
		
		for(int i = 10; i < 15; i++) {
			queue.enqueue(currency[i]);
		}
		
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();

		queue.printQueue();
		
		


						
		
		
	}

}
