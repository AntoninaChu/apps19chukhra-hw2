package ua.edu.ucu.collections.immutable;

public class ImmutableArrayList implements ImmutableList {

    private Object[] arr;

    private int size;

    public ImmutableArrayList() {
        this.arr = new Object[0];
        this.size = 0;
    }

    @Override
    public ImmutableArrayList add(Object e) {
        ImmutableArrayList result = new ImmutableArrayList();
        result.size = this.size + 1;
        result.arr = new Object[result.size];
        for (int i = 0; i < this.size; i++) {
            result.arr[i] = this.arr[i];
        }
        result.arr[this.size] = e;
        return result;
    }

    @Override
    public ImmutableArrayList add(int index, Object e) {
        if (index > this.size) {
            throw new IndexOutOfBoundsException();
        } else if (index == this.size) {
            return add(e);
        }
        ImmutableArrayList result = new ImmutableArrayList();
        result.size = this.size + 1;
        result.arr = new Object[result.size];
        for (int i = 0; i < result.size; i++) {
            if (i < index) {
                result.arr[i] = this.arr[i];
            } else if (i > index) {
                result.arr[i] = this.arr[i-1];
            } else {
                result.arr[i] = e;
            }
        }
        return result;
    }

    @Override
    public ImmutableArrayList addAll(Object[] c) {
        ImmutableArrayList result = new ImmutableArrayList();
        result.size = this.size + c.length;
        result.arr = new Object[result.size];
        for (int i = 0; i < result.size; i++) {
            if (i < this.size) {
                result.arr[i] = this.arr[i];
            } else {
                result.arr[i] = c[i - this.size];
            }
        }
        return result;
    }

    @Override
    public ImmutableArrayList addAll(int index, Object[] c) {
        if (index > this.size) {
            throw new IndexOutOfBoundsException();
        } else if (index == this.size) {
            return addAll(c);
        }
        ImmutableArrayList result = new ImmutableArrayList();
        result.size = this.size + c.length;
        result.arr = new Object[result.size];
        for (int i = 0; i < result.size; i++) {
            if (i < index) {
                result.arr[i] = this.arr[i];
            } else if (i < index + c.length) {
                result.arr[i] = c[i-index];
            } else {
                result.arr[i] = this.arr[i - c.length];
            }
        }
        return result;
    }

    @Override
    public Object get(int index) {
        if (index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        return this.arr[index];
    }

    @Override
    public ImmutableArrayList remove(int index) {
        if (index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        ImmutableArrayList result = new ImmutableArrayList();
        result.size = this.size - 1;
        result.arr = new Object[result.size];
        for (int i = 0; i < this.size; i++) {
            if (i < index) {
                result.arr[i] = this.arr[i];
            } else if (i > index) {
                result.arr[i-1] = this.arr[i];
            }
        }
        return result;
    }

    @Override
    public ImmutableArrayList set(int index, Object e) {
        if (index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        ImmutableArrayList result = new ImmutableArrayList();
        result.size = this.size;
        result.arr = new Object[result.size];
        for (int i = 0; i < this.size; i++) {
            if (i == index) {
                result.arr[i] = e;
            } else {
                result.arr[i] = this.arr[i];
            }
        }
        return result;
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < this.size; i++) {
            if (this.arr[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public ImmutableArrayList clear() {
        ImmutableArrayList result = new ImmutableArrayList();
        result.size = 0;
        result.arr = new Object[0];
        return result;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[this.size];
        for (int i = 0; i < this.size; i++) {
            result[i] = this.arr[i];
        }
        return result;
    }

    @Override
    public String toString() {
        if (this.size == 0) {
            return "";
        }
        String[] result = new String[this.size];
        for (int i = 0; i < this.size; i++) {
            result[i] = this.arr[i].toString();
        }
        return String.join(" , ", result);
    }
}
