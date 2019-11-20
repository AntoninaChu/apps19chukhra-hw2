package ua.edu.ucu.collections.immutable;

public class ImmutableLinkedList implements ImmutableList {
    private static final int MIN_INDEX = 0;
    private static class Node {
        private Object data;
        private Node next;
        private Node(Object data) {
            this.data = data;
            this.next = null;
        }
    }
    private Node head;
    private int size;
    private Node tail;
    public ImmutableLinkedList() {
        this.head = null;
        this.size = 0;
        this.tail = null;
    }

    private void addTailInCurLl(Object e) {
        if (this.tail == null) {
            Node temp = new Node(e);
            this.head = temp;
            this.tail = temp;
        } else {
            Node temp = new Node(e);
            this.tail.next = temp;
            this.tail = temp;
        }
        this.size++;
    }

    @Override
    public ImmutableLinkedList add(Object e) {
        ImmutableLinkedList result = new ImmutableLinkedList();
        if (this.head == null) {
            result.addTailInCurLl(e);
            return result;
        }
        Node cur = this.head;
        for (int i = 0; i < this.size; i++) {
            result.addTailInCurLl(cur.data);
            cur = cur.next;
        }
        result.addTailInCurLl(e);
        return result;
    }

    @Override
    public ImmutableLinkedList add(int index, Object e) {
        if (index < MIN_INDEX || index > this.size) {
            throw new IndexOutOfBoundsException();
        } else if (index == this.size) {
            return this.add(e);
        }
        ImmutableLinkedList result = new ImmutableLinkedList();
        Node cur = this.head;
        for (int i = 0; i < this.size; i++) {
            if (index == i) {
                result.addTailInCurLl(e);
            }
            result.addTailInCurLl(cur.data);
            cur = cur.next;
        }
        return result;
    }

    @Override
    public ImmutableLinkedList addAll(Object[] c) {
        ImmutableLinkedList result = new ImmutableLinkedList();
        Node cur = this.head;
        while (cur != null) {
            result.addTailInCurLl(cur.data);
            cur = cur.next;
        }
        for (int i = 0; i < c.length; i++) {
            result.addTailInCurLl(c[i]);
        }
        return result;
    }

    @Override
    public ImmutableLinkedList addAll(int index, Object[] c) {
        if (index < MIN_INDEX || index > this.size) {
            throw new IndexOutOfBoundsException();
        } else if (index == this.size) {
            return addAll(c);
        }
        ImmutableLinkedList result = new ImmutableLinkedList();
        Node cur  = this.head;
        for (int i = 0; i < this.size + c.length; i++) {
            if (i >= index && (i - index) < c.length) {
                result.addTailInCurLl(c[i - index]);
            } else {
                result.addTailInCurLl(cur.data);
                cur = cur.next;
            }
        }
        return result;
    }

    @Override
    public Object get(int index) {
        if (index < MIN_INDEX || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        Object result = -1;
        Node cur = this.head;
        for (int i = 0; i < this.size; i++) {
            if (i == index) {
                result = cur.data;
            }
            cur = cur.next;
        }
        return result;
    }

    @Override
    public ImmutableLinkedList remove(int index) {
        if (index < MIN_INDEX || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        ImmutableLinkedList result = new ImmutableLinkedList();
        Node cur = this.head;
        for (int i = 0; i < this.size; i++) {
            if (index != i) {
                result.addTailInCurLl(cur.data);
            }
            cur = cur.next;
        }
        return result;
    }

    @Override
    public ImmutableLinkedList set(int index, Object e) {
        if (index < MIN_INDEX || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        ImmutableLinkedList result = new ImmutableLinkedList();
        Node cur = this.head;
        for (int i = 0; i < this.size; i++) {
            if (index != i) {
                result.addTailInCurLl(cur.data);
            } else {
                result.addTailInCurLl(e);
            }
            cur = cur.next;
        }
        return result;
    }

    @Override
    public int indexOf(Object e) {
        int result = -1;
        Node cur = this.head;
        for (int i = 0; i < this.size; i++) {
            if (cur.data.equals(e)) {
                result = i;
                return result;
            }
            cur = cur.next;
        }
        return result;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public ImmutableLinkedList clear() {
        return new ImmutableLinkedList();
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Object[] toArray() {
        Node cur = this.head;
        Object[] result = new Object[this.size];
        for (int i = 0; i < this.size; i++) {
            result[i] = cur.data;
            cur = cur.next;
        }
        return result;
    }

    @Override
    public String toString() {
        if (this.size == 0) {
            return "";
        }
        Node cur = this.head;
        String[] result = new String[this.size];
        for (int i = 0; i < this.size; i++) {
            result[i] = cur.data.toString();
            cur = cur.next;
        }
        return String.join(" , ", result);
    }

    public ImmutableLinkedList addFirst(Object e) {
        return this.add(0, e);
    }

    public ImmutableLinkedList addLast(Object e) {
        return this.add(this.size, e);
    }

    public ImmutableLinkedList removeFirst() {
        return this.remove(0);
    }

    public ImmutableLinkedList removeLast() {
        return this.remove(this.size-1);
    }

    public Object getFirst() {
        return this.get(0);
    }

    public Object getLast() {
        return this.get(this.size-1);
    }
}
