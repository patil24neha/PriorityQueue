/* Neha Ashok Patil
 * Red Id - 821545485
 * Fall 2018 - CS 635 : ADV OBJ ORIENT DSGN PROG
 * Enrolled to the course
 */

package Assignment1;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PriorityQueueTest {
	Student student1 = new Student(1, "Neha", "neha@gmail.com", 4.0, 150);
	Student student2 = new Student(2, "Nikhil", "nikhil@gmail.com", 3.8, 120);
	Student student3 = new Student(3, "Pooja", "pooja@gmail.com", 3.2, 80);
	Student student4 = new Student(4, "Akash", "akash@gmail.com", 3.6, 100);

	/* To test insert into queue method. Also checks if insert method is called on
	full queue.*/
	@Test
	void testInsertIntoQueue() {
		PriorityQueue insertTestObject = new PriorityQueue(3);
		insertTestObject.insertIntoQueue(student1);
		insertTestObject.insertIntoQueue(student2);
		try {
			assertTrue(insertTestObject.insertIntoQueue(student3));
			System.out.println("Passed : New student is successfully added to the Queue.");
		} catch (AssertionError e) {
			System.out.println("Failed : Student Queue is full.");
		}
		try {
			assertTrue(insertTestObject.insertIntoQueue(student4));
			System.out.println("Passed : New student is successfully added to Queue.");
		} catch (AssertionError e) {
			System.out.println("Failed : Student Queue is full.");
		}
	}// end of testInsertIntoQueue method

	
	/*To test delete from queue operation. Also checks for delete from empty queue
	condition.*/
	@Test
	void testDeleteFromQueue() {
		PriorityQueue deleteTestObject = new PriorityQueue(5);
		Student removedStudent;
		deleteTestObject.insertIntoQueue(student1);
		deleteTestObject.insertIntoQueue(student2);
		removedStudent = deleteTestObject.deleteFromQueue();
		removedStudent = deleteTestObject.deleteFromQueue();
		removedStudent = deleteTestObject.deleteFromQueue();

		try {
			assertEquals(null, removedStudent);
			System.out.println("Passed : Student Queue is empty.");
		} catch (AssertionError e) {
			System.out.println("Failed : Student Queue is  not empty.");
		}
		try {
			assertNull(removedStudent);
			System.out.println("Passed : Student Queue is empty.");
		} catch (AssertionError e) {
			System.out.println("Failed : Student Queue is  not empty.");
		}
		deleteTestObject.insertIntoQueue(student3);
		removedStudent = deleteTestObject.deleteFromQueue();
		try {
			assertNotNull(removedStudent);
			System.out.println("Passed : Deleted student object is not null.");
		} catch (AssertionError e) {
			System.out.println("Failed : Deleted student object is null.");
		}
		try {
			assertTrue(removedStudent instanceof Student);
			System.out.println("Passed : Deleted Object is of Student class.");

		} catch (AssertionError e) {
			System.out.println("Failed : Object is not of Student class.");
		}
	}// end of testDeleteFromQueue method

	
	// To test print elements method. Also checks for empty queue.
	@Test
	void testDisplayQueueElements() {
		PriorityQueue displayTestObject = new PriorityQueue(3);
		try {
			assertTrue(displayTestObject.displayQueueElements());
			System.out.println(
					"Passed : Student queue has " + displayTestObject.getQueuesize() + " elements to display.");
		} catch (AssertionError e) {
			System.out.println("Failed : Student Queue is empty. There is nothing in queue to display.");
		}
		displayTestObject.insertIntoQueue(student1);
		displayTestObject.insertIntoQueue(student2);
		try {
			assertTrue(displayTestObject.displayQueueElements());
			System.out.println(
					"Passed : Student queue has " + displayTestObject.getQueuesize() + " elements to display.");
		} catch (AssertionError e) {
			System.out.println("Failed : Student Queue is empty. There is nothing in queue to display.");
		}
	}// end of testDisplayQueueElements method

	
	// To test get peek element method. Also checks for empty queue.
	@Test
	void testGetPeekElement() {
		PriorityQueue peekTestObject = new PriorityQueue(3);
		Student peekStudent;
		peekTestObject.insertIntoQueue(student1);
		peekTestObject.insertIntoQueue(student2);
		peekStudent = peekTestObject.getPeekElement();
		try {
			assertNotNull(peekStudent);
			System.out.println("Passed : Red Id of peek student is " + peekStudent.getRedId() + ".");
		} catch (AssertionError e) {
			System.out.println("Failed : Student Queue is  empty.");
		}
		try {
			assertNotEquals(null, peekStudent);
			System.out.println("Passed : Peek student object is not null.");
		} catch (AssertionError e) {
			System.out.println("Failed : Peek student object is null.");
		}
		try {
			peekStudent = peekTestObject.deleteFromQueue();
			peekStudent = peekTestObject.deleteFromQueue();
			peekStudent = peekTestObject.deleteFromQueue();
			assertTrue(peekStudent instanceof Student);
			System.out.println("Passed : Peek Object is of Student class.");
		} catch (AssertionError e) {
			System.out.println("Failed : Peek object is not of Student class.");
		}
	}// end of testGetPeekElement method

	
	/* To test get queue size method. Verify number of students inserted equals to
	queue size or not.*/
	@Test
	void testQueueSize() {
		PriorityQueue sizeTestObject = new PriorityQueue(2);
		try {
			assertEquals(2, sizeTestObject.getQueuesize());
			System.out.println("Passed : Queue size is " + sizeTestObject.getQueuesize() + ".");
		} catch (AssertionError e) {
			System.out.println("Failed : Queue size is " + sizeTestObject.getQueuesize() + ".");
		}
		sizeTestObject.insertIntoQueue(student1);
		sizeTestObject.insertIntoQueue(student2);
		try {
			assertEquals(2, sizeTestObject.getQueuesize());
			System.out.println("Passed : Queue size is " + sizeTestObject.getQueuesize() + ".");
		} catch (AssertionError e) {
			System.out.println("Failed : Queue size is " + sizeTestObject.getQueuesize() + ".");
		}
	}// end of testQueueSize method

}// end of PriorityQueueTest class
