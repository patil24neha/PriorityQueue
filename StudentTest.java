/* Neha Ashok Patil
 * Red Id - 821545485
 * Fall 2018 - CS 635 : ADV OBJ ORIENT DSGN PROG
 * Enrolled to the course
 */
package Assignment1;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StudentTest {
	Student student1 = new Student(1, "Neha", "neha@gmail.com", 4.0, 150);
	Student student2 = new Student(2, "Nikhil", "nikhil@gmail.com", 3.8, 120);
	Student student3 = new Student(3, "Pooja", "pooja@gmail.com", 3.2, 80);

//This is to test getter methods of student class. Checks if value returned by getter method and value given while object creation is same or not.
	@Test
	void testGetStudentProperty() {
		try {
			assertEquals("Neha", student1.getName());
			System.out.println("Passed : getName method of class is returning correct value.");
		} catch (AssertionError e) {
			System.out.println("Failed : getName method of class is not behaving as expected.");
		}
		try {
			assertEquals(3, student2.getRedId());
			System.out.println("Passed : getRedid method of class is returning correct value.");
		} catch (AssertionError e) {
			System.out.println("Failed : getRedid method of class is not behaving as expected.");
		}
	} // end of testGetStudentProperty method

	
	// To test setter method of Student class. Checks value set using setter method
	// equals to value returned by getter or not.
	@Test
	void testSetStudentProperty() {
		try {
			student3.setRedId(33);
			assertEquals(33, student3.getRedId());
			System.out.println("Passed : setRedid method of class is working fine.");
		} catch (AssertionError e) {
			System.out.println("Failed : setRedid method of class is not behaving as expected.");
		}
	}// end of testSetStudentProperty method

	
	/* To test GPA validation method. Checks if exception is thrown or not in case
	of invalid GPA value.*/
	@Test
	void testCheckGpa() {
		try {
			Assertions.assertThrows(IllegalArgumentException.class,
					() -> new Student(5, "Sushil", "sushil@gmail.com", 4.0, 90));
			System.out.println("Passed : checkGpa() threw an IllegalArgumentException");
		} catch (AssertionError e) {
			System.out.println("Failed : Exception is not thrown, GPA value is correct");
		}
		try {
			Assertions.assertThrows(IllegalArgumentException.class,
					() -> new Student(5, "Sushil", "sushil@gmail.com", 4.4, 90));
			System.out.println("Passed : checkGpa() threw an IllegalArgumentException because of invalid GPA value.");
		} catch (AssertionError e) {
			System.out.println("Failed : Exception is not thrown, GPA value is correct.");
		}
	}// end of testCheckGpa method

	
	// To test Units validation method. Checks if exception is thrown or not in case
	// of invalid units value.
	@Test
	void testCheckUnits() {
		try {
			Assertions.assertThrows(IllegalArgumentException.class,
					() -> new Student(6, "Sushil", "sushil@gmail.com", 4.0, 190));
			System.out.println("Passed : checkUnits() threw an IllegalArgumentException");
		} catch (AssertionError e) {
			System.out.println("Failed : Exception is not thrown, Units value is correct");
		}
	} // end of testCheckUnits method

	// To test calculate priority method. Verify values calculated by method for
	// given object.
	@Test
	void testCalculatePriority() {
		try {
			student1.calculatePriority(4.0, 150);
			assertEquals(100, student1.getPriority());
			System.out.println("Passed : calculatePriority is setting correct value.");
		} catch (AssertionError e) {
			System.out.println("Failed : calculatePriority is setting incorrect value.");
		}
		try {
			student1.calculatePriority(4.0, 150);
			assertEquals(20, student1.getPriority());
			System.out.println("Passed : calculatePriority is setting incorrect value.");
		} catch (AssertionError e) {
			System.out.println("Failed : calculatePriority is setting correct value.");
		}
	}// end of testCalculatePriority method

} // end of StudentTest class
