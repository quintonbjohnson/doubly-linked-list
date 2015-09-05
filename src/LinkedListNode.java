/**
 * Node class used for implementing your CircularDoublyLinkedList.
 *
 * DO NOT ALTER THIS FILE!!
 *
 * @author CS 1332 TAs
 */
public class LinkedListNode<T> {

    private T data;
    private LinkedListNode<T> next;
    private LinkedListNode<T> previous;

    /**
     * Create a new LinkedListNode with the given data object, previous node,
     * and next node.
     *
     * @param data data to store in the node
     * @param previous previous node
     * @param next next node
     */
    public LinkedListNode(T data, LinkedListNode<T> previous,
            LinkedListNode<T> next) {
        this.data = data;
        this.previous = previous;
        this.next = next;
    }

    /**
     * Create a new LinkedListNode with the given data object and no previous or
     * next node.
     *
     * @param data data to store in this node
     */
    public LinkedListNode(T data) {
        this(data, null, null);
    }

    /**
     * Get the data stored in the node.
     *
     * @return data in this node.
     */
    public T getData() {
        return data;
    }

    /**
     * Get the next node.
     *
     * @return next node.
     */
    public LinkedListNode<T> getNext() {
        return next;
    }

    /**
     * Set the next node.
     *
     * @param next new next node.
     */
    public void setNext(LinkedListNode<T> next) {
        this.next = next;
    }

    /**
     * Get the previous node.
     *
     * @return previous node.
     */
    public LinkedListNode<T> getPrevious() {
        return previous;
    }

    /**
     * Set the previous node.
     *
     * @param previous new previous node.
     */
    public void setPrevious(LinkedListNode<T> previous) {
        this.previous = previous;
    }

    @Override
    public String toString() {
        return "Node containing: " + data;
    }

}
