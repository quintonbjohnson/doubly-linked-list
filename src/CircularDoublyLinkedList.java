import java.util.NoSuchElementException;

/**
 * Your implementation of a CircularDoublyLinkedList
 *
 * @author Quinton Johnson
 * @version 1.0
 */
public class CircularDoublyLinkedList<T> implements LinkedListInterface<T> {

    // Do not add new instance variables.
    private LinkedListNode<T> head;
    private int size;

    /**
     * Creates an empty circular doubly-linked list.
     */
    public CircularDoublyLinkedList() {
        head = null;
        size = 0;
    }

    /**
     * Creates a circular doubly-linked list with
     * {@code data} added to the list in order.
     * @param data The data to be added to the LinkedList.
     * @throws java.lang.IllegalArgumentException if {@code data} is null or any
     * item in {@code data} is null.
     */
    public CircularDoublyLinkedList(T[] data) {
        for (int i = 0; i < data.length; i++) {
            addAtIndex(i, data[i]);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addAtIndex(int index, T data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index not in list.");
        }
        if (data == null) {
            throw new IllegalArgumentException("Data given is null.");
        }
        LinkedListNode<T> current = head;
        LinkedListNode<T> newNode = new LinkedListNode<T>(data);
        if (head == null) {
            head = newNode;
            head.setPrevious(head);
            head.setNext(head);
            size++;
        } else if (index == 0) {
            head.getPrevious().setNext(newNode);
            newNode.setPrevious(head.getPrevious());
            head.setPrevious(newNode);
            newNode.setNext(head);
            head = newNode;
            size++;

        } else {
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
            current.getPrevious().setNext(newNode);
            newNode.setPrevious(current.getPrevious());
            current.setPrevious(newNode);
            newNode.setNext(current);
            size++;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T get(int index) {
        LinkedListNode<T> current = head;
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index not in list.");
        }
        if (index == 0) {
            return head.getData();
        }
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getData();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T removeAtIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index not in list.");
        }
        LinkedListNode<T> current = head;
        LinkedListNode<T> newNode = null;
        if (index == 0) {
            head.getPrevious().setNext(head.getNext());
            head.getNext().setPrevious(head.getPrevious());
            T data = head.getData();
            head = head.getNext();
            size--;
            return data;
        } else {
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
            current.getPrevious().setNext(current.getNext());
            current.getNext().setPrevious(current.getPrevious());
            T data = current.getData();
            current = null;
            size--;
            return data;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addToFront(T data) {
        LinkedListNode<T> newNode = new LinkedListNode<T>(data);
        if (data == null) {
            throw new IllegalArgumentException("Data given is null.");
        }
        if (head == null) {
            head = newNode;
            head.setPrevious(head);
            head.setNext(head);
            size++;
        } else {
            head.getPrevious().setNext(newNode);
            newNode.setPrevious(head.getPrevious());
            head.setPrevious(newNode);
            newNode.setNext(head);
            head = newNode;
            size++;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addToBack(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Data given is null.");
        }
        LinkedListNode<T> newNode = new LinkedListNode<T>(data);
        LinkedListNode<T> current = head;
        if (head == null) {
            head = newNode;
            head.setPrevious(head);
            head.setNext(head);
            size++;
        } else {
            for (int i = 0; i < size; i++) {
                current = current.getNext();
            }
            current.getPrevious().setNext(newNode);
            newNode.setPrevious(current.getPrevious());
            current.setPrevious(newNode);
            newNode.setNext(current);
            size++;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T removeFromFront() {
        if (isEmpty()) {
            return null;
        }
        if (size == 1) {
            T data = head.getData();
            head = null;
            size--;
            return data;
        } else {
            head.getPrevious().setNext(head.getNext());
            head.getNext().setPrevious(head.getPrevious());
            T data = head.getData();
            head = head.getNext();
            size--;
            return data;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T removeFromBack() {
        LinkedListNode<T> current = head;
        if (isEmpty()) {
            return null;
        }
        if (size == 1) {
            T data = head.getData();
            head = null;
            size--;
            return data;
        } else {
            for (int i = 0; i < size - 1; i++) {
                current = current.getNext();
            }
            current.getPrevious().setNext(current.getNext());
            current.getNext().setPrevious(current.getPrevious());
            size--;
            return current.getData();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int removeFirstOccurrence(T data) {
        int count = 0;
        if (data == null) {
            throw new IllegalArgumentException("Data given is null.");
        }
        if (head == null) {
            throw new NoSuchElementException("Head is null.");
        }
        if (head.getData().equals(data)) {
            head.getPrevious().setNext(head.getNext());
            head.getNext().setPrevious(head.getPrevious());
            head = head.getNext();
            size--;
            return 0;
        } else {
            LinkedListNode<T> current = head;
            boolean found = false;
            for (int i = 0; i < size; i++) {
                if (current.getData().equals(data)) {
                    current.getPrevious().setNext(current.getNext());
                    current.getNext().setPrevious(current.getPrevious());
                    size--;
                    found = true;
                    return count;
                } else {
                    current = current.getNext();
                    count++;
                }
            }
            if (!found) {
                throw new NoSuchElementException("Search element not found.");
            }
        }
        return count;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean removeAllOccurrences(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Data given is null.");
        }
        LinkedListNode<T> current = head;
        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (current.getData().equals(data)) {
                if (i == 0) {
                    head = head.getNext();
                }
                current.getPrevious().setNext(current.getNext());
                current.getNext().setPrevious(current.getPrevious());
                size--;
                i--;
                found = true;
            }
            current = current.getNext();
        }
        return found;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object[] toArray() {
        Object[] dataArray = new Object[size];
        LinkedListNode<T> current = head;
        for (int i = 0; i < size; i++) {
            dataArray[i] = current.getData();
            current = current.getNext();
        }
        return dataArray;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LinkedListNode<T> getHead() {
        return head;
    }
}
