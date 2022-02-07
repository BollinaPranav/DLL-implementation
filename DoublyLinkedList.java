import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

// -------------------------------------------------------------------------
/**
 *  This class contains the methods of Doubly Linked List.
 *
 *  @author  
 *  @version 09/10/18 11:13:22
 */


/**
 * Class DoublyLinkedList: implements a *generic* Doubly Linked List.
 * @param <T> This is a type parameter. T is used as a class name in the
 * definition of this class.
 *
 * When creating a new DoublyLinkedList, T should be instantiated with an
 * actual class name that extends the class Comparable.
 * Such classes include String and Integer.
 *
 * For example to create a new DoublyLinkedList class containing String data: 
 *    DoublyLinkedList<String> myStringList = new DoublyLinkedList<String>();
 *
 * The class offers a toString() method which returns a comma-separated sting of
 * all elements in the data structure.
 * 
 * This is a bare minimum class you would need to completely implement.
 * You can add additional methods to support your code. Each method will need
 * to be tested by your jUnit tests -- for simplicity in jUnit testing
 * introduce only public methods.
 */
class DoublyLinkedList<T extends Comparable<T>>
{

	/**
	 * private class DLLNode: implements a *generic* Doubly Linked List node.
	 */
	private class DLLNode
	{
		public final T data; // this field should never be updated. It gets its
		// value once from the constructor DLLNode.
		public DLLNode next;
		public DLLNode prev;

		/**
		 * Constructor
		 * @param theData : data of type T, to be stored in the node
		 * @param prevNode : the previous Node in the Doubly Linked List
		 * @param nextNode : the next Node in the Doubly Linked List
		 * @return DLLNode
		 */
		public DLLNode(T theData, DLLNode prevNode, DLLNode nextNode) 
		{
			data = theData;
			prev = prevNode;
			next = nextNode;
		}
	}

	// Fields head and tail point to the first and last nodes of the list.
	private DLLNode head, tail;


	/**
	 * Constructor of an empty DLL
	 * @return DoublyLinkedList
	 */
	public DoublyLinkedList() 
	{
		head = null;
		tail = null;

	}

	/**
	 * Tests if the doubly linked list is empty
	 * @return true if list is empty, and false otherwise
	 *
	 * Worst-case asymptotic running time cost: Theta(1)
	 *
	 * Justification:
	 *  there are only simple if-else statements in this method which run in constatnt time theta(1)
	 *  we do not call any other functions while using this method
	 *  there are no for or while loops
	 */
	public boolean isEmpty()
	{
		if(head == null)
		{
			return true;
		}
		else
		{
			return false;
		}

	}

	/**
	 * Inserts an element in the doubly linked list
	 * @param pos : The integer location at which the new data should be
	 *      inserted in the list. We assume that the first position in the list
	 *      is 0 (zero). If pos is less than 0 then add to the head of the list.
	 *      If pos is greater or equal to the size of the list then add the
	 *      element at the end of the list.
	 * @param data : The new data of class T that needs to be added to the list
	 * @return none
	 *
	 * Worst-case asymptotic running time cost: Theta(N)
	 * 
	 * Justification:
	 *  There are if and else statements which run in constant time, theta(1)
	 *  this method only uses one other function which also runs in constant time and this method isn't inside any loops.
	 *  there is only one for loop in this method which has a worst case asymptotic running time of theta(N)
	 */
	public void insertBefore( int pos, T data ) 
	{

		DLLNode newNode = new DLLNode( data, null, null );

		if(isEmpty())
		{
			head = tail = newNode;
			return;
		}

		if(pos<=0)
		{
			newNode.next = head;
			head.prev = newNode;
			newNode.prev = null;
			head = newNode;
			return;
		}

		else 
		{
			DLLNode ptr = head;
			for(int i=0; i<pos; i++)
			{
				if(ptr.next != null)
				{
					ptr = ptr.next;
				}
				else
				{
					newNode.prev = tail;
					tail.next = newNode;
					newNode.next = null;
					tail = newNode;

					return;

				}
			}

			DLLNode tempNode = ptr.prev;
			tempNode.next = newNode;
			newNode.prev = tempNode;
			ptr.prev = newNode;
			newNode.next = ptr;



		}

	}

	/**
	 * Returns the data stored at a particular position
	 * @param pos : the position
	 * @return the data at pos, if pos is within the bounds of the list, and null otherwise.
	 *
	 * Worst-case asymptotic running time cost: Theta(N)
	 *
	 * Justification:
	 * There are if and else statements which run in constant time, theta(1)
	 *  there is only one for loop in this method which has a worst case asymptotic running time of theta(N)
	 * this method doesnt use any other function.
	 */
	public T get(int pos) 
	{
		if(isEmpty())
		{
			return null;
		}
		T data = null;
		if(pos >= 0)
		{
			//if pos isn't negative, continue..

			DLLNode getPtr = head;
			for(int i = 0; i < pos; i++)
			{	
				if(  getPtr.next != null) 
				{
					getPtr = getPtr.next;
				}
				else
				{
					return null; //if the next node is null, we know that pos was too big and we ended up past the end of the list, so return null.
				}
			}

			if(getPtr != null) 
			{
				data = getPtr.data;		//get the data where pos is
			}
		}
		return data;	
	}



	/**
	 * Deletes the element of the list at position pos.
	 * First element in the list has position 0. If pos points outside the
	 * elements of the list then no modification happens to the list.
	 * @param pos : the position to delete in the list.
	 * @return true : on successful deletion, false : list has not been modified. 
	 *
	 * Worst-case asymptotic running time cost: Theta(N)
	 *
	 * Justification:
	 * There are if and else statements which run in constant time, theta(1)
	 *  there is only one for loop in this method which has a worst case asymptotic running time of theta(N)
	 *  this method uses only one other function which runs in constant time and this function is not a part of any loop.
	 */
	public boolean deleteAt(int pos) 
	{
		if(isEmpty())
		{
			return false;
		}
		else
		{
			boolean deleted = true; 
			boolean invalid = false;
			int t = 0;
			DLLNode count = head;
			while(count.next!=null)
			{
				count = count.next;                        // t is the index for the tail
				t++;
			}
			DLLNode del = head;
			
			for( int i = 0; i < pos; i++)
			{
				if(del.next!=null)
				{
					del = del.next;
					
				}
				else
				{
					return invalid;
				}
			}
			if(pos==0)                          // if pos is 0
			{
				head = head.next;         // then shift the head deleting the previous head
				
				return deleted;
			}
			else if(pos==t)
			{
				
				tail = del.prev;              // shift the tail deleting the previous tail
				tail.next = null;
				return deleted;
			}
			else if(del.next == null)
			{
				return false;
			}
			
			else if(del.prev == null)
			{
				return false;
			}
			
			else
			{
				del.next.prev = del.prev;              // link the previous nodes to the next node.
				del.prev.next = del.next;
				
				return deleted;
			}
			
		}

	}

	/**
	 * Reverses the list.
	 * If the list contains "A", "B", "C", "D" before the method is called
	 * Then it should contain "D", "C", "B", "A" after it returns.
	 *
	 * Worst-case asymptotic running time cost: Theta(N)
	 *
	 * Justification:
	 *  There are if and else statements which run in constant time, theta(1)
	 *  there are while loops but they arent nested in one another so the worst case asymptotic running time is theta(N).
	 *  this method doesnt use any other functions.
	 */
	public void reverse()
	{
		if(head!=tail)
		{
			DLLNode temp = null;
			DLLNode current = head;

			while (current != null)
			{
				temp = current.prev;
				current.prev = current.next;
				current.next = temp;                           // swap next and prev so that all the elements are reversed
				current = current.prev;
			}
			head = temp.prev;
			current = head;
			while(current!=null)
			{
				current = current.next;                        // current points to the last node
			}

			tail = current;                                     // tail  =  last node
		}
	}

	/**
	 * Removes all duplicate elements from the list.
	 * The method should remove the _least_number_ of elements to make all elements uniqueue.
	 * If the list contains "A", "B", "C", "B", "D", "A" before the method is called
	 * Then it should contain "A", "B", "C", "D" after it returns.
	 * The relative order of elements in the resulting list should be the same as the starting list.
	 *
	 * Worst-case asymptotic running time cost: Theta(N^2)
	 *
	 * Justification:
	 *  There are if and else statements which run in constant time, theta(1)
	 *  there are two for loops nested in one another (without any functions in them), the worst case asymptotic running time is theta(N^2)
	 *  this method doesnt use any other functions
	 */
	public void makeUnique()
	{
		if(head != tail)
		{
			DLLNode ptr1;
			DLLNode ptr2 ;

			for(ptr1 = head; ptr1 != null; ptr1 = ptr1.next)                                 // takes in each element from the list and checks it against itself
			{
				for(ptr2 = ptr1.next; ptr2!=null; ptr2 = ptr2.next)
				{
					if(ptr1.data == ptr2.data)
					{
						ptr2.prev.next = ptr2.next;
						if(ptr2.next != null)                         //if not the last element
						{	
							ptr2.next.prev = ptr2.prev;         // delete the repeated element
						}
						else
						{
							tail = ptr2;                                  // tail = last element
						}
					}
				}
			}
		}
	}



	/*----------------------- STACK API 
	 * If only the push and pop methods are called the data structure should behave like a stack.
	 */

	/**
	 * This method adds an element to the data structure.
	 * How exactly this will be represented in the Doubly Linked List is up to the programmer.
	 * @param item : the item to push on the stack
	 *
	 * Worst-case asymptotic running time cost: Theta(1)
	 * 
	 * Justification:
	 * This method doesnt have any for / while loops
	 * this method only contains operations in constant time theta(1).
	 * this method doesnt use any other function.
	 *  TODO
	 */
	public void push(T item) 
	{
		DLLNode newNode = new DLLNode(item, null, null);
		newNode.next = head;
		head = newNode;
	}

	/**
	 * This method returns and removes the element that was most recently added by the push method.
	 * @return the last item inserted with a push; or null when the list is empty.
	 *
	 * Worst-case asymptotic running time cost: Theta(1)
	 *
	 * Justification:
	 *  This method doesnt have any for / while loops
	 * this method only contains operations in constant time theta(1).
	 * this method doesnt use only one other function which is also a constant time operation theta(1).
	 */
	public T pop() 
	{
		if(isEmpty())
		{
			return null;
		}
		else
		{
			DLLNode newNode;
			if(head.next!=null)
			{
				newNode = head;
				head = head.next;
				head.prev = null;
			}
			else
			{
				newNode = head;
				head =  null;
				return newNode.data;

			}

			return newNode.data;
		}
	}

	/*----------------------- QUEUE API
	 * If only the enqueue and dequeue methods are called the data structure should behave like a FIFO queue.
	 */

	/**
	 * This method adds an element to the data structure.
	 * How exactly this will be represented in the Doubly Linked List is up to the programmer.
	 * @param item : the item to be enqueued to the stack
	 *
	 * Worst-case asymptotic running time cost: Theta(1)
	 *
	 * Justification:
	 *  This method doesnt have any for / while loops
	 * this method only contains operations in constant time theta(1).
	 * this method doesnt use only one other function which is also a constant time operation theta(1).
	 */
	public void enqueue(T item) 
	{
		DLLNode newNode = new DLLNode(item, null, null);
		if(isEmpty())
		{
			head = tail = newNode;
		}
		else
		{
			tail.next = newNode;
			tail = newNode;
		}

	}

	/**
	 * This method returns and removes the element that was least recently added by the enqueue method.
	 * @return the earliest item inserted with an equeue; or null when the list is empty.
	 *
	 * Worst-case asymptotic running time cost: Theta(1)
	 *
	 * Justification:
	 *  This method doesnt have any for / while loops
	 * this method only contains operations in constant time theta(1).
	 * this method doesnt use only one other function which is also a constant time operation theta(1).
	 */
	public T dequeue() 
	{
		if(isEmpty())
		{
			return null;
		}
		else
		{

			DLLNode newNode;
			newNode = head;
			if(head == tail)
			{
				head = tail = null;
			}
			else
			{
				head = head.next;
				head.prev = null;
			}


			return newNode.data;
		}
	}


	/**
	 * @return a string with the elements of the list as a comma-separated
	 * list, from beginning to end
	 *
	 * Worst-case asymptotic running time cost:   Theta(n)
	 *
	 * Justification:
	 *  We know from the Java documentation that StringBuilder's append() method runs in Theta(1) asymptotic time.
	 *  We assume all other method calls here (e.g., the iterator methods above, and the toString method) will execute in Theta(1) time.
	 *  Thus, every one iteration of the for-loop will have cost Theta(1).
	 *  Suppose the doubly-linked list has 'n' elements.
	 *  The for-loop will always iterate over all n elements of the list, and therefore the total cost of this method will be n*Theta(1) = Theta(n).
	 */
	public String toString() 
	{
		StringBuilder s = new StringBuilder();
		boolean isFirst = true; 

		// iterate over the list, starting from the head
		for (DLLNode iter = head; iter != null; iter = iter.next)
		{
			if (!isFirst)
			{
				s.append(",");
			} else {
				isFirst = false;
			}
			s.append(iter.data.toString());
		}

		return s.toString();
	}


}