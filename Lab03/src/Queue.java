/**
 * Represents a Queue
 * @author lakshbhambhani
 *
 */
public class Queue extends SinglyLinkedList{
	

	public void enqueue(Currency object) {
		addCurrency(countCurrency()-1, object);
	}
	
	public Currency dequeue() {
		Currency head = getHead().data;
		try {
			removeCurrency(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return head;
	}
	
	public Currency peekFront() {
		return (getHead().data);
	}
	
	public Currency peekRear() {
		return (getCurrency(countCurrency()-1));
	}
	
	public void printQueue() {
		printList();
	}
	
}
