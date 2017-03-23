package a1;

public class LArrayList<E> implements List<E>{

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
		//All run in O(1) time
		public E getElement(){
			return this.element;
		}
		
		public Node<E> getNext(){
			return this.next;
		}
		
		public void setNext(Node<E> n){
			this.next = n;
		}
		public void setElement(E e){
			this.element = e;
		}
	}
	private int size = 0;
	Node <E> head = null; //The starting node of the LinkedList
	
	//cTors
	public LArrayList(){}
	
	//Methods
	
	/**
	 * Returns the number of elements in this list
	 * @return size
	 */
	public int size(){
		return this.size; //returns the size of the LinkedList
		//Runs in O(1) time because the size variable is being accessed and returned, which are primitive operations.
	}
	
	/**
	 * Returns whether the list is empty
	 * @return size==0
	 */
	public boolean isEmpty(){
		return size == 0;
		//Runs in O(1) time as well for the same reason above.
	}
	
	/**
	 * Inserts an element e to be at index I, by creating a new node between 2 adjacent nodes
	 * @param i the index of the array.
	 * @param e the element being inserted in the LinkedList.
	 * @throws IndexOutOfBoundsException if i < 0 or i >= size.
	 */
	public void add(int i, E e) throws IndexOutOfBoundsException{
		checkIndex(i,size+1);
		Node<E> newest = new Node<E>(e,null); //Creates a new node
		Node<E> temp = head; //for traversing purposes we set a node equal to the head.
		if(i==0){ //if the insertion point is at the start.
			newest.setNext(head);  
			head = newest; 
		}
		else{
			for(int j=1; j<i; j++){ //loops through the node until the insertion point is found.
				temp = temp.getNext();
			}
			newest.setNext(temp.getNext());
			temp.setNext(newest); //Sets the previous node equal the new node
		}
		this.size++;
		//The traversal of the array takes O(n) running time because a linked list does not have direct access to its
		//nodes. In the worst case, one can add an element at the end of the list which means that we must traverse
		//n elements. However, since the actual add operation is composed solely of primitive operation, the actual
		//add operation takes O(1) time.
	}
	
	/**
	 * Removes and returns the element at index I, by removing the required node and merging the 2 adjacent nodes
	 * @param i the  index from where the value is to be removed.
	 * @return the removed value
	 * @throws IndexOutOfBoundsException
	 */
	public E remove(int i)throws IndexOutOfBoundsException{
		checkIndex(i, size);
		Node<E> temp = head;
		E retVal;
		if(i==0){
			retVal = head.getElement();
			head=head.getNext();
		}
		else{
			for(int j=1; j<i;j++){
				temp = temp.getNext();
			}
			retVal = temp.getElement();
			temp.setNext(temp.getNext().getNext());
		}
		this.size--;
		return retVal;
		//Same reasoning as the add method. This means that it takes O(1) time for the actual remove operation.
	}
	
	/**
	 * Returns the element at index I, without removing it. Loops through each node.
	 * @param i 
	 * @return the element of the array at the provided index 
	 * @throws IndexOutOfBoundsException if i < 0 or i >= size
	 */
	public E get(int i) throws IndexOutOfBoundsException{
		checkIndex(i,size);
		Node<E> temp = head;
		for(int j=0;j<i;j++){
			temp = temp.getNext();
		}
		return temp.getElement();
		//Since linked lists don't have direct access to their nodes, we must traverse through each of them. This
		//means that the method runs in O(n) time.
	}
	
	/**
	 * Replaces the element at index I with e, returning the previous element at i.
	 * @param i the index of the array.
	 * @param e the value to be replaced.
	 * @return the previous value.
	 * @throws IndexOutOfBoundsException
	 */
	public E set(int i, E e) throws IndexOutOfBoundsException{
		checkIndex(i, size);
		Node<E> temp = head;
		E retVal;
		for(int j=0;j<i;j++){
			temp=temp.getNext();
		}
		retVal = temp.getElement();
		temp.setElement(e);
		return retVal;
		//Same reasoning as the get method,which means it takes O(n) time to run this method.
	}
	
	//Method that checks if the given index is within the defined bounds
	private void checkIndex(int i, int n) throws IndexOutOfBoundsException{
		if(i< 0 || i>=n){
			throw new IndexOutOfBoundsException("Illegal index provided: "+ i);
		}
	}
	
	public String toString(){
		StringBuilder str = new StringBuilder();
		Node<E> temp = this.head;
		str.append("{");
		while(temp != null){
			str.append(" "+temp.getElement());
			temp=temp.getNext();
		}
		str.append(" }");
		return str.toString();
		
	}
	//There are a few differences between implementing an arraylist using an array and using a linked list.
	//Firstly, accessing and setting an element in an array takes O(1) time. The same operations take O(n) time
	//in a linkedlist because we only have access to the head node and we must traverse the whole list.
	//The benefits of a linkedlist become apparent when we have to add and remove entries. Both operations take O(1)
	//time. In an array, we have to shift other elements if we want to add or remove entries. Also, arrays are fixed
	//in length, implying that if we run out of space we must make a new array of bigger length and copy the elements
	//over to the new one. Hence these operations take O(n) time.  
	//Both implementations have their uses in the real world. For example if you have a collection of data that is
	//being accessed and set most of the time, then an implementation using an array is beneficial. However, if you
	//have a collection of data that is constantly being expanded or shrunk, then a linkedlist implementation is more
	//useful.
}
