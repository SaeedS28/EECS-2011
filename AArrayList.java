package a1;

public class AArrayList<E> implements List<E> {
	public static final int DEFAULT_CAPACITY=10;
	private E[] data;
	private int size=0;
	
	//cTors
	public AArrayList(){
		this(DEFAULT_CAPACITY); //Creates an ArrayList of default capacity.
	}
	
	@SuppressWarnings("unchecked")
	public AArrayList(int size){
		data = (E[]) new Object[size]; 
	}
	
	/**
	 * Returns the number of elements in this list
	 * @return size
	 */
	public int size(){
		return this.size;
		//Runs in O(1) time because the size variable is being accessed and returned, which are primitive operations.
	}
	
	/**
	 * Returns whether the list is empty
	 * @return size==0
	 */
	public boolean isEmpty(){
		return size == 0;
		//Runs in O(1) time for the same reason as above.
	}
	
	/**
	 * Returns the element at index I, without removing it.
	 * @param i 
	 * @return the element of the array at the provided index 
	 * @throws IndexOutOfBoundsException if i < 0 or i >= size
	 */
	public E get(int i) throws IndexOutOfBoundsException{
		checkIndex(i,size);//Checks if the index is within the two bounds.
		return data[i];
		//Runs in O(1) time because accessing an array element takes constant time. 
	}
	
	/**
	 * Inserts an element e to be at index I, shifting all elements after this
	 * @param i the index of the array.
	 * @param e the element being inserted in the array.
	 * @throws IndexOutOfBoundsException if i < 0 or i >= size.
	 */
	public void add(int i, E e) throws IndexOutOfBoundsException{
		checkIndex(i,size+1);
		if(size==data.length){
			resize(2*data.length);//resizes the array if we run out of space to store new objects.
		}
		for(int k=size-1;k>=i;k--){
			data[k+1]=data[k];
		}
		data[i]=e;
		size++;
		//Runs in O(n) time because in the worst-case, adding at the first index means that we would have to
		//shift the other n-1 entries to the right by 1. Resizing also takes O(n) time since moving n objects
		//from the old array to a new array also takes O(n) time.
	}
	
	/**
	 * Removes and returns the element at index I, shifting the elements after this
	 * @param i the array index from where the value is to be removed.
	 * @return the removed value
	 * @throws IndexOutOfBoundsException
	 */
	public E remove(int i)throws IndexOutOfBoundsException{
		checkIndex(i, size);
		E temp = data[i];
		for(int s=i;s<size-1;s++){
			data[s]=data[s+1];
		}
		data[size-1] = null; //sets the final index to null since everything is moved down one spot.
		size--;
		return temp;
		//Runs in O(n) time because in the worst case, removing the first element of the array means that we
		//would have to shift the remaining n-1 elements 1 to the left.
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
		E temp = data[i];
		data[i] = e;
		return temp;
		//Takes O(1) time since all entries in the array are accessible readily.
	}
	
	//Throws an exception if the index isn't within the bounds.
	private void checkIndex(int i, int n) throws IndexOutOfBoundsException{
		if(i< 0 || i>=n){
			throw new IndexOutOfBoundsException("Illegal index provided: "+ i);
		}
	}
	
	//Method that creates a bigger array and copies all the entries from the old to new.
	//Takes O(n) time.
	private void resize(int capacity){
		@SuppressWarnings("unchecked")
		E[]temp = (E[]) new Object[capacity];
		for(int j=0;j<size;j++){
			temp[j]=data[j];
		}
		data = temp;
	}
	
	public String toString(){
		StringBuilder str = new StringBuilder();
		str.append("{ ");
		for(int k=0;k<size;k++){
			str.append(data[k]+ " ");
		}
		str.append("}");
		return str.toString();
	}
}
