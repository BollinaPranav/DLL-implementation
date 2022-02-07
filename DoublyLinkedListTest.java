import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for Doubly Linked List
 *
 *  @author  
 *  @version 13/10/16 18:15
 */
@RunWith(JUnit4.class)
public class DoublyLinkedListTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
      new DoublyLinkedList<Integer>();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check if the insertBefore works
     */
    @Test
    public void testInsertBefore()
    {
        // test non-empty list
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);
        

        testDLL.insertBefore(0,4);
        assertEquals( "Checking insertBefore to a list containing 3 elements at position 0", "4,1,2,3", testDLL.toString() );
        
        testDLL.insertBefore(1,5);
        assertEquals( "Checking insertBefore to a list containing 4 elements at position 1", "4,5,1,2,3", testDLL.toString() );
        testDLL.insertBefore(2,6);       
        assertEquals( "Checking insertBefore to a list containing 5 elements at position 2", "4,5,6,1,2,3", testDLL.toString() );
        testDLL.insertBefore(-1,7);        
        assertEquals( "Checking insertBefore to a list containing 6 elements at position -1 - expected the element at the head of the list", "7,4,5,6,1,2,3", testDLL.toString() );
        testDLL.insertBefore(7,8);        
        assertEquals( "Checking insertBefore to a list containing 7 elemenets at position 8 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8", testDLL.toString() );
        testDLL.insertBefore(700,9);        
        assertEquals( "Checking insertBefore to a list containing 8 elements at position 700 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8,9", testDLL.toString() );

        // test empty list
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);        
        assertEquals( "Checking insertBefore to an empty list at position 0 - expected the element at the head of the list", "1", testDLL.toString() );
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(10,1);        
        assertEquals( "Checking insertBefore to an empty list at position 10 - expected the element at the head of the list", "1", testDLL.toString() );
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(-10,1);        
        assertEquals( "Checking insertBefore to an empty list at position -10 - expected the element at the head of the list", "1", testDLL.toString() );
     }

    // TODO: add more tests here. Each line of code in DoublyLinkedList.java should
    // be executed at least once from at least one test.
    
    @Test
    public void testGet() {
 	   
 	  
 	   DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
 	   testDLL.insertBefore(0,1);
 	   testDLL.insertBefore(1,2);
 	   testDLL.insertBefore(2,3);
 	   
 	  assertEquals("Checking get to a list containing 3 elements at position 1","2", testDLL.get(1).toString());
 	 assertEquals("Checking get to a list containing 3 elements at position 1","2", testDLL.get(1).toString());
 	 assertEquals("Checking get to a list containing 3 elements at position -1",null, testDLL.get(-1));
 	assertEquals("Checking get to a list containing 3 elements at position 3",null, testDLL.get(3));
 	   
 	testDLL = new DoublyLinkedList<Integer>();
 	assertEquals(null, testDLL.get(1));
 	  
 	  
    }
    
    @Test
    public void testDeleteAt()
    {
    	
    	 DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	 
    	 testDLL.deleteAt(0);
    	 assertEquals("Checking deleteAt to a list with no elements", "", testDLL.toString());
    	 
   	   testDLL.insertBefore(0,1);
   	   testDLL.insertBefore(1,2);
   	   testDLL.insertBefore(2,3);
   	   testDLL.insertBefore(3, 4);
   	   testDLL.insertBefore(4, 5);
   	   
   
   	   testDLL.deleteAt(1);
   	  // System.out.println(testDLL.toString());
   	   assertEquals("Checking deleteAt to a list containing 3 elements at position 1", "1,3,4,5", testDLL.toString());
   	   testDLL.deleteAt(0);
   	   //System.out.println(testDLL.toString());
   	   assertEquals("Checking deleteAt to a list containing 3 elements at position 0", "3"
   	   		+ ",4,5", testDLL.toString());
   	   testDLL.deleteAt(2);
   	 assertEquals("Checking deleteAt to a list containing 3 elements at position 2", "3,4", testDLL.toString());
   	 
   	testDLL = new DoublyLinkedList<Integer>();
	   assertEquals("Checking deleteAt to a list conatining 0 element", false, testDLL.deleteAt(-1));
	   testDLL = new DoublyLinkedList<Integer>();
	   testDLL.insertBefore(0,1);
	   assertEquals("Checking deleteAt to a list containing only one element", false, testDLL.deleteAt(-2));
   	 
	   testDLL = new DoublyLinkedList<Integer>();
	   testDLL.insertBefore(0,1);
	   testDLL.insertBefore(1,2);
	   assertEquals("Checking deleteAt to a list conatining 0 element", true, testDLL.deleteAt(1));
	   
    	
    }

@Test
public void testReverse()
{
	
	 DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
	 
	 testDLL.reverse();
	 assertEquals("Checking reverse to a list with no elements", "", testDLL.toString());
	 
	   testDLL.insertBefore(0,1);
	   testDLL.insertBefore(1,2);
	   testDLL.insertBefore(2,3);
	   testDLL.insertBefore(3, 4);
	   testDLL.insertBefore(4, 5);
	   
	   testDLL.reverse();
	   //System.out.println();
	   assertEquals("Checking reverse to a list with 5 elements", "5,4,3,2,1", testDLL.toString());
	   DoublyLinkedList<Integer> testDLL1 = new DoublyLinkedList<Integer>();
	   testDLL1.insertBefore(0,1);
	   assertEquals("Checking reverse to a list with only one element", "1", testDLL1.toString());
	   
	
}

@Test
public void testMakeUnique()
{
	
 DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
 
 testDLL.makeUnique();
 assertEquals("Checking makeUnique to a list with no elements", "", testDLL.toString());
	
	   testDLL.insertBefore(0,1);
	   testDLL.insertBefore(1,2);
	   testDLL.insertBefore(2,3);
	   testDLL.insertBefore(3, 7);
	   testDLL.insertBefore(4, 3);
	   testDLL.insertBefore(5, 5);
	   testDLL.insertBefore(6, 2);
	   testDLL.insertBefore(7, 1);
	   testDLL.insertBefore(8, 2);
	   
	   testDLL.makeUnique();
	   assertEquals("Checking reverse to a list with 9 elements", "1,2,3,7,5", testDLL.toString());
	   
	   
	
}

@Test
public void testPush()
{
	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
	testDLL.push(6);
	testDLL.push(0);
	testDLL.push(9);
	
	assertEquals("9,0,6", testDLL.toString());
}


@Test
public void testPop()
{
	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
	testDLL.push(6);
	testDLL.push(5);
	testDLL.push(4);
	testDLL.push(3);
	
	testDLL.pop();
	
	assertEquals("4,5,6", testDLL.toString());    // check for remaining elements in the stack
	assertEquals("4", testDLL.pop().toString()); // check for the return value from pop
	assertEquals("5,6",testDLL.toString());       // check for remaining value after return value
	testDLL.pop();
	assertEquals("6", testDLL.toString());
	testDLL.pop();
	assertEquals("", testDLL.toString());
	
	testDLL = new DoublyLinkedList<Integer>();
	testDLL.push(6);
	assertEquals("6", testDLL.pop().toString());
	
}

@Test
public void testEnqueue()
{
	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
	testDLL.enqueue(6);
	testDLL.enqueue(5);
	testDLL.enqueue(4);
	testDLL.enqueue(3);
	
	assertEquals("6,5,4,3", testDLL.toString());
}

@Test
public void testDequeue()
{
	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
	testDLL.enqueue(6);
	testDLL.enqueue(5);
	testDLL.enqueue(4);
	testDLL.enqueue(3);

	assertEquals("6",	testDLL.dequeue().toString());
	assertEquals("5,4,3", testDLL.toString());
	testDLL.dequeue();
	testDLL.dequeue();
	assertEquals("3", testDLL.toString());
	
	testDLL = new DoublyLinkedList<Integer>();
	testDLL.enqueue(6);
	assertEquals("6", testDLL.dequeue().toString());
	assertEquals("", testDLL.toString());
}
}
