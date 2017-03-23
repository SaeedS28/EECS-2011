package a1;

public class AQueue<E> implements Queue<E>{
	public static final int DEFAULT_CAPACITY = 10; 
	private int size=0; //current number of elements in the array
	private int front=0; //index of the front element
	private E[] data;
	
	//cTors
	/** Initializes the queue with default space. */
	public AQueue(){
		this(DEFAULT_CAPACITY); //Creates an array of default length 
	}
	
	@SuppressWarnings("unchecked")
	public AQueue(int capacity){
		data = (E[]) new Object[capacity];
	}
	
	//methods
	
	/**
	 * Returns the number of elements in the queue. 
	 * @return an integer value which corresponds to the size of the array
	 */
	public int size(){
		return this.size;
		//Runs in O(1) time because the size variable is being accessed and returned, which are primitive operations.
	}
	
	/**
	 * Tests whether the array is empty.
	 * @return a boolean value.
	 */
	public boolean isEmpty(){
		return this.size == 0;
		//Runs in O(1) time as well for the same reason above.
	}

	/**
	 * Inserts an element at the rear of the queue by using modular arithmetic to find the end of queue. 
	 * @param e the object to be inserted in the back.
	 */
	public void enqueue(E e){
		if(this.size == data.length){
			throw new IllegalStateException("Cannot add element. Queue is full");//Throws an exception if queue is full
		}
		int back = (front + size)%data.length; //uses modular arithmetic to choose where to put the last element. Makes it more efficient to use this than shift every element like the standard approach
		data[back] = e;
		this.size++;
		//Takes O(1) time because we already calculated the final index for storing data by using modular arithmetic. 
		//Accessing and storing an element in an array takes constant time in this case.
	}
		
	/**
	 * Removes and returns the first element of the queue (null if empty).
	 * @return the first element of the queue
	 */
	public E dequeue(){
		if(this.size == 0){
			return null;
		}
		E temp = data[front];
		data[front] = null;
		front = (front + 1)%data.length; //uses modular arithmetic to redefine the front of the queue. This is more efficient in terms of the run time.
		this.size--;
		return temp;
		//Classical implementation of this method would've taken O(n) time as we would've had to shift n-1 elements
		//to the left one spot after removing the previous first element. With the use of modular arithmetic,
		//the running time shrinks to O(1) since all it does is move the front variable of the list by 1 to the right
		//which we can reference.
	}
	
	/**
	 * Returns, but does not remove, the first element of the queue (null if empty)
	 * @return first element
	 */
	public E front(){
		if(isEmpty()){
			return null;
		}
		return data[front];
		//Runs in O(1) time since we can access an array's element readily, which takes constant time.
	}

	public String toString(){
		StringBuilder str = new StringBuilder();
		str.append("{ ");
		for(E element:data){
			str.append(element + " ");
		}
		str.append("}");
		return str.toString();
	}
}