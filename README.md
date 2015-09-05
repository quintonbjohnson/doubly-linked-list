Doubly Linked List
===================

By Quinton Johnson

A basic implementation of a doubly linked list, complete with methods for adding, removing, and referencing nodes.

Building/Compiling/Deployment
-----------------------------

- CircularDoublyLinkedList: the "main" class that implements the LinkedListInterface. Contains several methods for adding, removing, and acquiring nodes within the list.
- LinkedListInterface: the interface that the list will implement.
- LinkedListNode: represents a Node object which contains data in addition to having a previous and next node value.

Future Improvements
-----------------------------

- A tail reference could be added and kept track of throughout the methods to allow for an O(1) time complexity. The original project called for an implementation without a tail reference, to demonstrate various methods.
