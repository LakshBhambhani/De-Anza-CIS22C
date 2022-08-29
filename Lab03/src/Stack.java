/**
 * Represents a stack
 * constructor and createStack (optional) methods,
push which takes a Currency object as parameter and adds it to the top of the stack.
pop which takes no parameter and removes and returns the Currency object from the top of the stack.
peek which takes no parameter and returns a copy of the Currency object at the top of the stack.
printStack method which returns a string signifying the contents of the stack from the top to bottom, tab spaced.
destructor and/or destroyStack (optional) methods.
Ensure that the Stack objects do not allow Linked List functions to be used on them.
 * @author lakshbhambhani
 *
 */
public class Stack extends SinglyLinkedList{
	

	public void push(Currency object) {
		addCurrency(0, object);
	}
	
	public Currency pop() {
		Currency head = getHead().data;
		try {
			removeCurrency(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return head;
	}
	
	public Currency peek() {
		return (getHead().data);
	}
	
	public void printStack() {
		printList();
	}
	
}
