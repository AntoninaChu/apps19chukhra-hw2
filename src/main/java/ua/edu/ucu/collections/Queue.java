package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {

    private ImmutableLinkedList linkedList;

    public Queue() {
        this.linkedList = new ImmutableLinkedList();
    }

    public Object peek() {
        return this.linkedList.getFirst();
    }

    public Object dequeue() {
        Object res = this.peek();
        this.linkedList = linkedList.removeFirst();
        return res;
    }

    public void enqueue(Object e) {
        this.linkedList = this.linkedList.add(e);
    }
}
