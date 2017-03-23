package a2;

/**An interface for positional lists */

public interface PositionalList<E> {
	
	/**
	 * Returns the number of elements in the list.
	 * @return the size of the list 
	 */
	int size();
	
	/**
	 * Tests whether the list is empty
	 * @return true if the list is empty, false otherwise.
	 */
	boolean isEmpty();
	
	/**
	 * Returns the first Position in the list (or null, if empty). 
	 * @return the first position.
	 */
	Position<E> first();

	/**
	 * Returns the last Position in the list (or null, if empty).
	 * @return the last position of the list.
	 */
	Position<E> last();
	
	/**
	 * Returns the Position immediately before Position p (or null, if p is first)
	 * @param p the position.
	 * @return the position prior to the passed position.
	 * @throws InvalidPositionException if the passed position is invalid.
	 */
	Position<E> before(Position<E> p) throws InvalidPositionException;
	
	/**
	 * Returns the Position immediately after Position p (or null, if p is last).
	 * @param p the position.
	 * @return the position that succeeds the passed position.
	 * @throws InvalidPositionException if the passed position is invalid.
	 */
	Position<E> after(Position<E> p) throws InvalidPositionException;
	
	/**
	 * Inserts element e at the front of the list and returns its new Position.
	 * @param e the element to be added to the front.
	 * @return the position of the newly added element.
	 */
	Position<E> addFirst(E e);
	
	/**
	 * Inserts element e at the back of the list and returns its new Position.
	 * @param e the element to be added at the back of the list.
	 * @return the position of the newly added element.
	 */
	Position<E> addLast(E e);
	
	/**
	 * Inserts element e immediately before Position p and returns its new Position.
	 * @param p the position. 
	 * @param e the element.
	 * @return the position of the element that was added prior to the passed position.
	 * @throws InvalidPositionException if the passed position is invalid.
	 */
	Position<E> addBefore(Position<E> p, E e) throws InvalidPositionException;
	
	/**
	 * Replaces the element stored at Position p and returns the replaced element.
	 * @param p the position.
	 * @param e the element.
	 * @return the position of the element that succeeds the passed position.
	 * @throws InvalidPositionException if the passed position is invalid.
	 */
	Position<E> addAfter(Position<E> p, E e) throws InvalidPositionException;
	
	/**
	 * Replaces the element stored at Position p and returns the replaced element.
	 * @param p the position.
	 * @param e the element.
	 * @return the element that was previously stored in the passed position.
	 * @throws InvalidPositionException if the passed position is invalid.
	 */
	E set(Position<E> p, E e) throws InvalidPositionException;
	
	/**
	 * Removes the element stored at Position p and returns it (invalidating p)
	 * @param p 
	 * @return
	 * @throws InvalidPositionException if the passed position is invalid.
	 */
	E remove(Position<E> p) throws InvalidPositionException;
	
}
