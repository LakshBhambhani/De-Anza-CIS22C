/**
 * Represents a list of LinkNodes, in this case, pointers to currency
 * @author lakshbhambhani
 *
 */

public class SinglyLinkedList {    
  
	private int count = 0;
    
    //Represent the head and tail of the singly linked list    
    private LinkNode head;   
    private LinkNode tail;
    
    protected void finalize()  {  
		System.out.println("Object is destroyed by the Garbage Collector");  
	}  
    
    public LinkNode getHead() {
    	return head;
    }
    
    public LinkNode getTail() {
    	return tail;
    }
    
    /* This function is in LinkedList class.
    Inserts a new node after the given prev_node. This method is
    defined inside LinkedList class shown above */
    protected void addCurrency(int prev, Currency newData)
    {
        LinkNode prevNode;
        LinkNode newNode = new LinkNode(newData);

        		
        /* 1. Check if the given Node is null */
        if (isListEmpty()) {
           head = newNode;
        }
        else {
        	int currentIndex = 0;
        	prevNode = head;
        	
        	while(currentIndex < prev) {
        		if(prevNode.next != null) {
        			prevNode = prevNode.next;
        		}
        		currentIndex++;
        	}
        	/* 2. Allocate the Node &
            3. Put in the data*/
         
            /* 4. Make next of new Node as next of prev_node */
            newNode.next = prevNode.next;
            prevNode.next = newNode;
         
            /* 5. make next of prev_node as new_node */
        }
        count++;
    }
    
    public void removeCurrency(Currency currency) throws Exception {
    	int index = findCurrency(currency);
    	removeCurrency(index);
    }
    
    public void removeCurrency(int index) throws Exception {
    	int currentIndex = 0;
    	if(index == -1) {
    		throw new Exception("Element Not Found");
    	}
    	LinkNode currentNode = head;
    	LinkNode prevNode = null;
    	while(currentIndex < index) {
    		prevNode = currentNode;
    		currentNode = currentNode.next;
    		currentIndex++;
    	}
    	if(prevNode != null) {
        	prevNode.next = currentNode.next;
    	}
    	else {
    		if(head.next != null) {
        		head = head.next;
    		}
    		else {
    			head = null;
    		}
    	}
    	
    	count--;
    	
    }
    
    public Currency getCurrency(int index) {
    	int currentIndex = 0;
    	LinkNode currentNode = head;
    	while(currentIndex < index) {
    		currentNode = currentNode.next;
    		currentIndex++;
    	}
    	return currentNode.data;
    }
    
    public int findCurrency(Currency target)
    {
    	int scan = 0, result = -1;
    	LinkNode currentScan = head;
    	boolean found = false;
    	if (!isListEmpty()) {
    		while(!found && scan < count) {
    			if(target.getValue() == currentScan.data.getValue()) {
    				found = true;
    				result = scan;
    		    	return result;
    			}
    			else {
    				scan++;
    				currentScan = currentScan.next;
    			}
    		}
    	}
    	return result;
    }
	
    //display() will display all the LinkNodes present in the list    
    protected void printList() {    
        //LinkNode current will point to head    
        LinkNode current = head;    
            
        if(head == null) {    
            System.out.println("List is empty");    
            return;    
        }    
        System.out.println("LinkNodes of singly linked list: ");    
        while(current != null) {    
            //Prints each LinkNode by incrementing pointer    
            System.out.print(current.data.getValue() + " ");    
            current = current.next;    
        }    
        System.out.println();    
    }  
    
    public int countCurrency() {
    	return count;
    }
    
    public boolean isListEmpty() {
    	return count == 0;
    }
        
}  