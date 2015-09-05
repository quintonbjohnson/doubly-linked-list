/**
 * This interface describes the public methods needed for
 * CircularDoublyLinkedList, which should be circular, doubly linked, and
 * have a head pointer.
 *
 * We've given you the expected Big-O for each method this time around.
 *
 * DO NOT ALTER THIS FILE!!
 *
 * @author CS 1332 TAs
 * @version 1.1
 */
public interface LinkedListInterface<T> {

    /**
     * Adds the element to the index specified.
     * Adding to index 0 and (size) should be O(1), all other adds are O(n).
     *
     * Throw {@code java.lang.IndexOutOfBoundsException} if index is negative or
     * index > size.
     * Throw {@code java.lang.IllegalArgumentException} if data is null.
     *
     * @param index The index where you want the new element.
     * @param data Any object of type T.
     * @throws java.lang.IndexOutOfBoundsException if
     *         index is negative or index > size
     * @throws java.lang.IllegalArgumentException if data is null.
     */
    public void addAtIndex(int index, T data);

    /**
     * Add a new node to the front of your linked list
     * that holds the given data. Make sure to update head.
     *
     * Must be O(1).
     *
     * Throw {@code java.lang.IllegalArgumentException} if data is null.
     *
     * @param data The data that the new node should hold.
     * @throws java.lang.IllegalArgumentException if data is null.
     */
    public void addToFront(T data);

    /**
     * Add a new node to the back of your linked list that holds the given data.
     *
     * Must be O(1).
     *
     * Throw {@code java.lang.IllegalArgumentException} if data is null.
     *
     * @param data The data that the new node should hold.
     * @throws java.lang.IllegalArgumentException if data is null.
     */
    public void addToBack(T data);

    /**
     * Returns the element at the given index.
     * This method must be O(1) for index 0 and (size - 1).
     * O(n) is expected for all other indices.
     *
     * Throw {@code java.lang.IndexOutOfBoundsException} if index < 0 or
     * index >= size.
     *
     * @param index The index of the element
     * @return The object stored at that index.
     * @throws java.lang.IndexOutOfBoundsException if
     *         index < 0 or index >= size.
     */
    public T get(int index);

    /**
     * Removes and returns the element at index.
     * This method should be O(1) for index 0 and (size - 1), and O(n) in all
     * other cases.
     *
     * Throw {@code java.lang.IndexOutOfBoundsException} if index < 0 or
     * index >= size.
     *
     * @param index The index of the element
     * @return The object that was formerly at that index.
     * @throws java.lang.IndexOutOfBoundsException if
     *         index < 0 or index >= size.
     */
    public T removeAtIndex(int index);

    /**
     * Remove the front node from the list and return the data from it. If the
     * list is empty, return null.
     *
     * Must be O(1).
     *
     * @return The data from the front node or null.
     */
    public T removeFromFront();

    /**
     * Remove the back node from the list and return the data from it. If the
     * list is empty, return null.
     *
     * Must be O(1).
     *
     * @return The data from the last node or null.
     */
    public T removeFromBack();

    /**
     * Remove the first occurrence of data in the linked list.
     *
     * Must be O(n).
     *
     * Throw {@code java.util.NoSuchElementException} if data is not in the
     * list.
     * Throw {@code java.lang.IllegalArgumentException} if data is null.
     *
     * @param data The data to be removed from the list.
     * @return the index of the occurrence that was removed from the list.
     * @throws java.util.NoSuchElementException if data is not in the list.
     * @throws java.lang.IllegalArgumentException if data is null.
     */
    public int removeFirstOccurrence(T data);

    /**
     * Remove all occurrences of data in the linked list.
     *
     * Must be O(n).
     *
     * Throw {@code java.lang.IllegalArgumentException} if data is null.
     *
     * @param data The data to be removed from the list.
     * @return true if anything was removed from the list; otherwise, false.
     * @throws java.lang.IllegalArgumentException if data is null.
     */
    public boolean removeAllOccurrences(T data);

    /**
     * Return the linked list represented as an array of objects. If the list is
     * empty, return an empty array.
     *
     * Must be O(n).
     *
     * @return A copy of the linked list data as an array.
     */
    public Object[] toArray();

    /**
     * Return a boolean value representing whether or not the list is empty.
     *
     * Must be O(1).
     *
     * @return True if empty. False otherwise.
     */
    public boolean isEmpty();

    /**
     * Return the size of the list as an integer.
     *
     * Must be O(1).
     *
     * @return The size of the list.
     */
    public int size();

    /**
     * Clear the list.
     *
     * Must be O(1).
     */
    public void clear();

    /**
     * Reference to the head node of the linked list.
     * Normally, you would not do this, but we need it for grading your work.
     *
     * @return Node representing the head of the linked list.
     */
    public LinkedListNode<T> getHead();
}
