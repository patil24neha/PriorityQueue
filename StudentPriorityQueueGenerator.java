/* Neha Ashok Patil
 * Red Id - 821545485
 * Fall 2018 - CS 635 : ADV OBJ ORIENT DSGN PROG
 * Enrolled to the course
 */

package Assignment1;
//This is main driver class(entry point of assignment). 
public class StudentPriorityQueueGenerator {

	public static void main(String[] args) {
		PriorityQueue studentQueueObject = new PriorityQueue(10);//Creates PriorityQueue object of 10.
		Student peekStudent;// To hold peek student object.
		Student student1,student2;
		try{
			student1 = new Student(1, "Neha", "neha@gmail.com", 4.2, 120);
			//Insert student1 into queue.
			studentQueueObject.insertIntoQueue(student1); 
		}
		//Handles invalid gpa value exception.
		catch(IllegalArgumentException gpaException) {
			System.out.println(gpaException.getMessage());
		}
		try{
			student2 = new Student(2, "Nikhil", "nikhil@gmail.com", 3.2, 170);
			studentQueueObject.insertIntoQueue(student2);
		}
		//Handles invalid units value exception.
		catch(IllegalArgumentException unitsException) {
			System.out.println(unitsException.getMessage());
		}
		
		Student student3 = new Student(3, "Pooja", "pooja@gmail.com", 4.0, 120);
		Student student4 = new Student(4, "Akash", "akash@gmail.com", 3.6, 100);		
		Student student5 = new Student(5, "Sushil", "sushil@gmail.com", 3.0, 40);
		Student student6 = new Student(6, "Pradip", "pradeep@gmail.com", 3.8, 50);
		Student student7 = new Student(7, "Prisha", "prisha@gmail.com", 2.5, 60);
		Student student8 = new Student(8, "Sheetal", "sheetal@gmail.com", 3.0, 120);
		Student student9 = new Student(9, "Arjan", "arjan@gmail.com", 2.0, 20);
				
		//Add student objects into priority queue.
		studentQueueObject.insertIntoQueue(student3);
		studentQueueObject.insertIntoQueue(student4);
		studentQueueObject.insertIntoQueue(student5);
		studentQueueObject.insertIntoQueue(student6);
		
		//Displays objects currently present in queue.
		studentQueueObject.displayQueueElements();
		
		//Deletes highest priority student from queue.
		studentQueueObject.deleteFromQueue();
		studentQueueObject.displayQueueElements();
		
		//Prints details of highest priority student.
		peekStudent = studentQueueObject.getPeekElement();
		System.out.println("Highest priority student details are :");
		System.out.println("Redid : " + peekStudent.getRedId() + " Name : " + peekStudent.getName()+ " \tPriority : " + peekStudent.getPriority());
		
		studentQueueObject.insertIntoQueue(student7);
		studentQueueObject.displayQueueElements();
		
		studentQueueObject.deleteFromQueue();
		studentQueueObject.displayQueueElements();
		
		peekStudent = studentQueueObject.getPeekElement();
		System.out.println("Highest priority student details are :");
		System.out.println("Redid : " + peekStudent.getRedId() + " \tName : " + peekStudent.getName()+ "\t Priority : " + peekStudent.getPriority());
		
		studentQueueObject.deleteFromQueue();
		studentQueueObject.displayQueueElements();
	}// end of main method

}// end of StudentPriorityQueueGenerator class
