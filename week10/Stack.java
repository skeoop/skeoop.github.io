package ku.util;

/**
 * A stack with LIFO access and a fixed capacity.
 * @author jim
 *
 * @param <T> the type of element the stack can hold
 */
public interface Stack<T> {

	/**
	 * Remove the top element from stack and return it.
	 * @return the top element from stack.
	 * @throws java.util.EmptyStackException if stack is empty
	 */
	public T pop();

	/**
	 * Return the top element from stack without removing it.
	 * @return the top element from stack, or null if empty.
	 */
	public T peek();

	/**
	 * Push an element onto the stack.
	 * @param obj an item to push onto the top of the stack.
	 * @throws IllegalStateException if stack is full
	 * @throws InvalidArgumentException if obj is null
	 */
	public void push(T obj);

	/**
	 * Test if stack is empty.
	 * @return true if the stack is empty, false otherwise.
	 */
	public boolean isEmpty();

	/**
	 * Test if stack is full.
	 * @return true if the stack is full, false otherwise.
	 */
	public boolean isFull();

	/**
	 * Get the capacity of the stack.
	 * @return capacity of the stack
	 */
	public int capacity();

	/**
	 * Get the number of elements in the stack.
	 * @return number of elements currently in stack.
	 */
	public int size();

}
