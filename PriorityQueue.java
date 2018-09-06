/* Neha Ashok Patil
 * Red Id - 821545485
 * Fall 2018 - CS 635 : ADV OBJ ORIENT DSGN PROG
 * Enrolled to the course
 */
package Assignment1;
/**
 * Assumption : Student with highest calculated priority value has the highest
 * priority in the queue. Eg. Student 1's priority value is 2 and Student 2's
 * priority value is 4 then Student 2 will have more priority than student 1.
 * The implementation is based on max heap logic. At any point of time parent
 * student node will have priority greater than or equal to it's child nodes.
 * Array is used to store tree nodes. Index of root node will be always 1, which
 * is the highest priority student. For an element at ith position in array,
 * parent will be at i/2, left child at (2*i) and right child at (2*i+1)
 */

public class PriorityQueue {
	/**
	 * studentQueue is to hold Student objects. All queue operations are performed
	 * on it. queueMaxCapacity tells the maximum number of students queue can hold.
	 * currentQueueSize gives the count of students, queue has at that point of
	 * program.
	 */
	private Student[] studentQueue;
	private int currentQueueSize, queueMaxCapacity;

	/**
	 * Public constructor is used to initialize queue array with max capacity and
	 * queueSize to 0, which is then incremented after every insert.
	 */
	public PriorityQueue(int queueCapacity) {
		this.queueMaxCapacity = queueCapacity;
		studentQueue = new Student[this.queueMaxCapacity + 1];
		currentQueueSize = 0;
	}// end of public constructor

	
	/**This method is used to get the current size of student queue at that point of program.*/
	public int getQueuesize() {
		return currentQueueSize;
	}
	

	/** This method is to add new student in priority queue. */
	public boolean insertIntoQueue(Student studentToBeInserted) {
		int rootNodeIndex = 1;
		// Gets priority of new student to decide it's position in an array.
		Double priorityOfNewStudent = studentToBeInserted.getPriority();
		// Checks if queue has reached it's maximum capacity or not.
		if (currentQueueSize >= queueMaxCapacity) {
			System.out.println("Student Queue is Full.");
			return false;
		}	
		// Increment the array index and add element to be inserted in queue.
		studentQueue[++currentQueueSize] = studentToBeInserted;
		int position = currentQueueSize;

		/*Checks if element to be added is not 1st (root) and it's priority is greater
		 * than it's parent node. If child's priority is greater than parent, move
		 * parent node at child's position.*/
		while (position != rootNodeIndex && priorityOfNewStudent > studentQueue[position / 2].getPriority()) {
			studentQueue[position] = studentQueue[position / 2];
			position /= 2;
		}
		/* If element is 1st one or priority is less than parent's priority, directly
		add it at next available position.*/
		studentQueue[position] = studentToBeInserted;
		return true;
	}// end of insert method

	
	/** This method deletes a highest priority student from queue. */
	public Student deleteFromQueue() {
		int rootNodeIndex = 1, subNodeIndex = 2;
		Student removedStudent, swapStudent; // to hold deleted and temporary student object

		// Check if queue has any elements to delete or not.
		if (currentQueueSize == 0) {
			System.out.println("Student Queue is empty.");
			return null;
		}

		// take out the 1st element of an array since it's the highest priority element.
		removedStudent = studentQueue[1];
		// Take out last element from an array for swapping with highest element.
		swapStudent = studentQueue[currentQueueSize--];

		/* From 2nd element till last check if each element has lower priority than it's
		 * next element in array. If you don't get any element(while traversing tree)
		 * greater than last element(swapStudent), break the code. */
		while (subNodeIndex <= currentQueueSize) {
			if (subNodeIndex < currentQueueSize
					&& studentQueue[subNodeIndex].getPriority() < studentQueue[subNodeIndex + 1].getPriority())
				subNodeIndex++;
			if (swapStudent.getPriority() >= studentQueue[subNodeIndex].getPriority())
				break;
			// Assign child index and node to parent index and respective node.
			studentQueue[rootNodeIndex] = studentQueue[subNodeIndex];
			rootNodeIndex = subNodeIndex;
			subNodeIndex *= 2; // update the new index value.
		}
		
		// put the element at it's correct position in array.
		studentQueue[rootNodeIndex] = swapStudent;
		return removedStudent;
	}// end of delete method

	
	/**This method prints the queue students in their priority order(Descending order).*/
	public boolean displayQueueElements() {
		/* Since queueSize=0 (no elements are added to queue), this condition checks if
		display is called on empty queue.*/
		if (currentQueueSize == 0) {
			System.out.println("Student Queue is empty. There is nothing in queue to display.");
			return false;
		}

		/*Since the student queue array doesn't keep elements in proper order , I am
		 * display all elements by performing delete for queue size times, which will
		 * always give me highest priority element. So printing students in descending
		 * order. In order to avoid impact on main queue , I am copying queue array size
		 * and elements into temporary ones. And after display again putting them back
		 * in their original variables.*/
		int newQueueSize = currentQueueSize;
		Student removedStudent[] = studentQueue.clone();
		System.out.println("Below are student objects currently present in queue.");

		// Iterate through original queue and delete highest priority element one by one everytime.
		for (int queueIndex = 1; queueIndex <= newQueueSize; queueIndex++) {
			Student deletedStudent = deleteFromQueue();
			// this prints last deleted(highest priority) students details every time for loop runs.
			System.out.println("Redid : " + deletedStudent.getRedId() + "\tName : " + deletedStudent.getName()
					+ "  \tPriority : " + deletedStudent.getPriority());
		}
		// Assigning back values from temporary variable to original one.
		studentQueue = removedStudent;
		currentQueueSize = newQueueSize;
		return true;
	}// end of display method

	
	/**This method always returns highest priority student object. It does not delete it from queue. */
	public Student getPeekElement() {
		Student peekStudent;
		// Check if queue has any elements or not.
		if (currentQueueSize == 0) {
			System.out.println("Student Queue is empty.");
			return null;
		}

		// Since highest priority element always be at 1st position in array.
		peekStudent = studentQueue[1];
		return peekStudent;
	}// end of peek method

}// end of PriorityQueue class
