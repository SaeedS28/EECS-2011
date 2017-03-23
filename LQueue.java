package a1;

public class LQueue<E> implements Queue<E>{
	
	//Node class responsible for creating the nodes of the LinkedList.
	private static class Node<E>{
		private E element; //the element part of the node
		private Node<E> next; //the address to the next node
		
		//Creates a node with user-defined object and links it to another node. 
		public Node(E e, Node<E> n){
			this.element = e;
			this.next = n;
		}
		
		//setters and getters
		//All run in O(1) time.
		public E getElement(){
			return this.element;
		}
		
		public Node<E> getNext(){
			return this.next;
		}
		
		public void setNext(Node<E> n){
			this.next = n;
		}
	}
	
	private Node<E> head = null; //The starting node of the LinkedList
	private Node<E> tail; //The last node of the LinkedList which serves as the end of the list
	private int size = 0;
	
	//cTor
	public LQueue(){}
	
	//methods
	
	/**
	 * Returns the number of elements in the queue. 
	 * @return an integer value which corresponds to the size of the List.
	 */
	public int size(){
		return this.size;
		//Runs in O(1) time since we are returning an already defined variable, which takes constant time.
	}
	
	/**
	 * Tests whether the array is empty.
	 * @return a boolean value.
	 */
	public boolean isEmpty(){
		return this.size == 0;
		//Runs in O(1) time as well for the same reason as above.
	}
	
	/**
	 * Returns, but does not remove, the first element of the queue (null if empty) by referencing the head node.
	 * @return the element stored in the head node.
	 */
	public E front(){
		if(this.isEmpty()){
			return null;
		}
		return this.head.getElement();
		//Runs in O(1) time since we already have the reference to the head node, which means that we can access its data
		//by calling the accessor method and returning this to the client. Calling methods and returning values
		//to the client are primitive operations which take constant amount of time.
	}
	
	/**
	 * Inserts an element at the rear of the queue by using tail node as the reference point.. 
	 * @param e the object to be inserted in the back.
	 */
	public void enqueue(E e){
		Node<E> last = new Node<E>(e, null);
		if(this.isEmpty()){
			head = last;
		}
		else{
			tail.setNext(last);
		}
		tail = last;
		this.size++;
		//Runs in O(1) time as we have both references to the head and tail of the Linked List. This means that we
		//can use the setters and getters on either one of them depending on the situation, which takes constant time
		//since they are all primitive operations.
	}
	
	/**
	 * Removes and returns the first element of the queue (null if empty) and assigns a new head node.
	 * @return the value stored in the first node of the Linked List
	 */
	public E dequeue(){
		if(this.isEmpty()){
			return null;
		}
		E temp = head.getElement();
		head = head.getNext();
		this.size--;
		if(this.size==0){
			tail=null;
		}
		return temp;
		//All these operations are primitive, hence this method runs in O(1) time.
	}
	
	public String toString(){
		StringBuffer str = new StringBuffer();
		Node<E> temp = this.head;
		str.append("{");
		while(temp != null){
			str.append(" "+temp.getElement());
			temp=temp.getNext();
		}
		str.append(" }");
		return str.toString();
		
	}
	//The only advantage the LinkedQueue has over ArrayQueue is that we can add as many nodes and elements to
	//the queue. All methods run in O(1) time, which is very efficient. If we wanted, we could make an extendible 
	//array whenever we ran out of space to store data. However, that'll take O(n) running time as previous values
	//would have to be copied to the new array along with the new element being added.
}
