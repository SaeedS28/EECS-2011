import java.util.Comparator;

/**
 * The default comparator class for priority queues.
 * @author Saad
 *
 */
public class DefaultComparator<E> implements Comparator<E> {

	/**
	 * Compares two objects of the same class and returns an integer depicting the ordering.
	 */
	@Override
	public int compare(E a, E b) throws ClassCastException{
		return((Comparable<E>)a).compareTo(b);
	}

}
