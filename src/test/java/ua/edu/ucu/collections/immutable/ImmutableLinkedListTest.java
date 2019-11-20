package ua.edu.ucu.collections.immutable;

import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableLinkedListTest {
    
    @Test
    public void testAdd() {
        ImmutableLinkedList ll = new ImmutableLinkedList();
        ll = ll.add(4);
        ll = ll.add(5);
        ll = ll.add(6);
        String expResult = "4 , 5 , 6";
        String actualResult = ll.toString();
        assertEquals(expResult, actualResult);
    }

    @Test
    public void testAddWithIndex() {
        ImmutableLinkedList ll = new ImmutableLinkedList();
        ll = ll.add(4);
        ll = ll.add(1 ,5);
        ll = ll.add(6);
        ll = ll.add(2, 100);
        String expResult = "4 , 5 , 100 , 6";
        String actualResult = ll.toString();
        assertEquals(expResult, actualResult);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddWithWrongIndex() {
        ImmutableLinkedList ll = new ImmutableLinkedList();
        ll = ll.add(4);
        ll = ll.add(5);
        ll = ll.add(6);
        ImmutableLinkedList res = ll.add(7, 8);
    }

    @Test
    public void testAddAll() {
        Object[] c = {1,67};
        ImmutableLinkedList ll = new ImmutableLinkedList();
        ll = ll.add(4);
        ll = ll.add(5);
        ll = ll.add(6);
        ll = ll.addAll(c);
        String expResult = "4 , 5 , 6 , 1 , 67";
        String actualResult = ll.toString();
        assertEquals(expResult, actualResult);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllWithWrongIndex() {
        Object[] a = {1,4,"you", "with"};
        ImmutableLinkedList ll = new ImmutableLinkedList();
        ImmutableLinkedList res = ll.addAll(7, a);
    }

    @Test
    public void testAddAllWithIndex() {
        Object[] a = {1,4,"you", "with"};
        ImmutableLinkedList myLl = new ImmutableLinkedList();
        myLl = myLl.add(7);
        myLl = myLl.addAll(1, a);
        myLl = myLl.addAll(2, a);
        String expResult = "7 , 1 , 1 , 4 , you , with , 4 , you , with";
        String actualResult = myLl.toString();
        assertEquals(expResult, actualResult);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetWithWrongIndex() {
        Object[] a = {1,4,"you", "with"};
        ImmutableLinkedList myLl = new ImmutableLinkedList();
        myLl = myLl.add(7);
        myLl = myLl.addAll(1, a);
        myLl = myLl.addAll(2, a);
        Object res = myLl.get(15);
    }

    @Test
    public void testGet() {
        Object[] a = {1,4,"you", "with"};
        ImmutableLinkedList myLl = new ImmutableLinkedList();
        myLl = myLl.add(7);
        myLl = myLl.addAll(1, a);
        myLl = myLl.addAll(2, a);
        Object expResult = "you";
        Object actualResult = myLl.get(4);
        assertEquals(expResult, actualResult);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveWithWrongIndex() {
        Object[] a = {1,4,"you", "with"};
        ImmutableLinkedList myLl = new ImmutableLinkedList();
        myLl = myLl.add(7);
        myLl = myLl.addAll(1, a);
        myLl = myLl.addAll(2, a);
        Object actualResult = myLl.remove(35);
    }

    @Test
    public void testRemove() {
        Object[] a = {1,4,"you", "with"};
        ImmutableLinkedList myLl = new ImmutableLinkedList();
        myLl = myLl.add(7);
        myLl = myLl.addAll(1, a);
        myLl = myLl.remove(3);
        String expResult = "7 , 1 , 4 , with";
        Object actualResult = myLl.toString();
        assertEquals(expResult, actualResult);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetWithWrongIndex() {
        Object[] a = {1,4,"you", "with"};
        ImmutableLinkedList myLl = new ImmutableLinkedList();
        myLl = myLl.add(7);
        myLl = myLl.addAll(1, a);
        Object actualResult = myLl.set(5, 90);
    }

    @Test
    public void testSet() {
        Object[] a = {1,4,"you", "with"};
        ImmutableLinkedList myLl = new ImmutableLinkedList();
        myLl = myLl.add(7);
        myLl = myLl.addAll(1, a);
        myLl = myLl.set(3, 272727);
        String expResult = "7 , 1 , 4 , 272727 , with";
        Object actualResult = myLl.toString();
        assertEquals(expResult, actualResult);
    }

    @Test
    public void testIndexOf() {
        Object[] a = {1,4,1,"you", "with"};
        ImmutableLinkedList myLl = new ImmutableLinkedList();
        myLl = myLl.add(7);
        myLl = myLl.addAll(1, a);
        int expResult = 1;
        int actualResult = myLl.indexOf(1);
        assertEquals(expResult, actualResult);
    }

    @Test
    public void testIndexOfWithoutElem() {
        Object[] a = {1,4,"you", "with"};
        ImmutableLinkedList myLl = new ImmutableLinkedList();
        myLl = myLl.add(7);
        myLl = myLl.addAll(1, a);
        int expResult = -1;
        int actualResult = myLl.indexOf(9);
        assertEquals(expResult, actualResult);
    }

    @Test
    public void testSize() {
        Object[] a = {1,4,"you", "with"};
        ImmutableLinkedList myLl = new ImmutableLinkedList();
        myLl = myLl.add(7);
        myLl = myLl.addAll(1, a);
        int expResult = 5;
        int actualResult = myLl.size();
        assertEquals(expResult, actualResult);
    }

    @Test
    public void testClear() {
        Object[] a = {1,4,"you", "with"};
        ImmutableLinkedList myLl = new ImmutableLinkedList();
        myLl = myLl.add(7);
        myLl = myLl.addAll(1, a);
        ImmutableLinkedList res = myLl.clear();
        String expResult = "";
        String actualResult = res.toString();
        assertTrue(expResult == actualResult);
    }

    @Test
    public void testIsEmpty() {
        ImmutableLinkedList myArray = new ImmutableLinkedList();
        ImmutableLinkedList myArray2 = myArray.add(6);
        boolean actualResult = myArray.isEmpty();
        boolean actualRes2 = myArray2.isEmpty();
        assertTrue(actualResult != actualRes2);
    }

    @Test
    public void testToArray() {
        Object[] a = {1, 4,"you", "with"};
        ImmutableLinkedList myArray = new ImmutableLinkedList();
        ImmutableLinkedList res = myArray.addAll(a);
        Object[] expResult = {1, 4,"you", "with"};
        Object[] actualResult = res.toArray();
        assertArrayEquals(expResult, actualResult);
    }

    @Test
    public void testAddFirst() {
        ImmutableLinkedList ll = new ImmutableLinkedList();
        ll = ll.add(4);
        ll = ll.add(5);
        ll = ll.add(6);
        ll = ll.addFirst(45);
        String expResult = "45 , 4 , 5 , 6";
        String actualResult = ll.toString();
        assertEquals(expResult, actualResult);
    }

    @Test
    public void testAddLast() {
        ImmutableLinkedList ll = new ImmutableLinkedList();
        ll = ll.add(4);
        ll = ll.add(5);
        ll = ll.add(6);
        ll = ll.addLast(45);
        String expResult = "4 , 5 , 6 , 45";
        String actualResult = ll.toString();
        assertEquals(expResult, actualResult);
    }

    @Test
    public void testRemoveFirst() {
        Object[] a = {1,4,"you", "with"};
        ImmutableLinkedList myLl = new ImmutableLinkedList();
        myLl = myLl.add(7);
        myLl = myLl.addAll(1, a);
        myLl = myLl.removeFirst();
        String expResult = "1 , 4 , you , with";
        Object actualResult = myLl.toString();
        assertEquals(expResult, actualResult);
    }

    @Test
    public void testRemoveLast() {
        Object[] a = {1,4,"you", "with"};
        ImmutableLinkedList myLl = new ImmutableLinkedList();
        myLl = myLl.add(7);
        myLl = myLl.addAll(1, a);
        myLl = myLl.removeLast();
        String expResult = "7 , 1 , 4 , you";
        Object actualResult = myLl.toString();
        assertEquals(expResult, actualResult);
    }

    @Test
    public void testGetFirst() {
        Object[] a = {1,4,"you", "with"};
        ImmutableLinkedList myLl = new ImmutableLinkedList();
        myLl = myLl.add(7);
        myLl = myLl.addAll(1, a);
        Object expResult = 7;
        Object actualResult = myLl.getFirst();
        assertEquals(expResult, actualResult);
    }

    @Test
    public void testGetLast() {
        Object[] a = {1,4,"you", "with"};
        ImmutableLinkedList myLl = new ImmutableLinkedList();
        myLl = myLl.add(7);
        myLl = myLl.addAll(1, a);
        Object expResult = "with";
        Object actualResult = myLl.getLast();
        assertEquals(expResult, actualResult);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetFirstWithEmpty() {
        ImmutableLinkedList myLl = new ImmutableLinkedList();
        Object res = myLl.getFirst();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetLastWithEmpty() {
        ImmutableLinkedList myLl = new ImmutableLinkedList();
        Object res = myLl.getLast();
    }
}
