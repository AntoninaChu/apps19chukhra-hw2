package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    private ImmutableLinkedList linkedList;
    public Stack() {
        this.linkedList = new ImmutableLinkedList();
    }

    public Object peek() {
        return this.linkedList.getLast();
    }

    public Object pop() {
        Object result = this.peek();
        this.linkedList = this.linkedList.removeLast();
        return result;
    }

    public void push(Object e) {
        this.linkedList = this.linkedList.addLast(e);
    }
}
