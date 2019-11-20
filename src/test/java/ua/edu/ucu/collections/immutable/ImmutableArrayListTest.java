package ua.edu.ucu.collections.immutable;

import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableArrayListTest {
    
    @Test
    public void testAdd() {
        ImmutableArrayList myArray = new ImmutableArrayList();
        ImmutableArrayList res = myArray.add(7);
        res = res.add(8);
        String expResult = "7 , 8";
        String actualResult = res.toString();
        assertEquals(expResult, actualResult);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddWithWrongIndex() {
        ImmutableArrayList myArray = new ImmutableArrayList();
        ImmutableArrayList res = myArray.add(7, 8);
    }

    @Test
    public void testAddWithIndex() {
        ImmutableArrayList myArray = new ImmutableArrayList();
        ImmutableArrayList res = myArray.add(7);
        res = res.add(1,8);
        res = res.add(1, "with");
        String expResult = "7 , with , 8";
        String actualResult = res.toString();
        assertEquals(expResult, actualResult);
    }

    @Test
    public void testAddAll() {
        Object[] a = {1,4,"you", "with"};
        ImmutableArrayList myArray = new ImmutableArrayList();
        ImmutableArrayList res = myArray.add(7);
        res = res.addAll(a);
        String expResult = "7 , 1 , 4 , you , with";
        String actualResult = res.toString();
        assertEquals(expResult, actualResult);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllWithWrongIndex() {
        Object[] a = {1,4,"you", "with"};
        ImmutableArrayList myArray = new ImmutableArrayList();
        ImmutableArrayList res = myArray.addAll(7, a);
    }

    @Test
    public void testAddAllWithIndex() {
        Object[] a = {1,4,"you", "with"};
        ImmutableArrayList myArray = new ImmutableArrayList();
        ImmutableArrayList res = myArray.add(7);
        res = res.addAll(1, a);
        res = res.addAll(2, a);
        String expResult = "7 , 1 , 1 , 4 , you , with , 4 , you , with";
        String actualResult = res.toString();
        assertEquals(expResult, actualResult);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetWithWrongIndex() {
        Object[] a = {1,4,"you", "with"};
        ImmutableArrayList myArray = new ImmutableArrayList();
        ImmutableArrayList res = myArray.addAll(a);
        Object actualResult = res.get(35);
    }

    @Test
    public void testGet() {
        Object[] a = {1,4,"you", "with"};
        ImmutableArrayList myArray = new ImmutableArrayList();
        ImmutableArrayList res = myArray.addAll(a);
        Object expResult = 4;
        Object actualResult = res.get(1);
        assertEquals(expResult, actualResult);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveWithWrongIndex() {
        Object[] a = {1,4,"you", "with"};
        ImmutableArrayList myArray = new ImmutableArrayList();
        ImmutableArrayList res = myArray.addAll(a);
        Object actualResult = res.remove(35);
    }

    @Test
    public void testRemove() {
        Object[] a = {1,4,"you", "with"};
        ImmutableArrayList myArray = new ImmutableArrayList();
        ImmutableArrayList res = myArray.addAll(a);
        res = res.remove(2);
        String expResult = "1 , 4 , with";
        Object actualResult = res.toString();
        assertEquals(expResult, actualResult);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetWithWrongIndex() {
        Object[] a = {1,4,"you", "with"};
        ImmutableArrayList myArray = new ImmutableArrayList();
        ImmutableArrayList res = myArray.addAll(a);
        Object actualResult = res.set(35, "!");
    }

    @Test
    public void testSet() {
        Object[] a = {1,4,"you", "with"};
        ImmutableArrayList myArray = new ImmutableArrayList();
        ImmutableArrayList res = myArray.addAll(a);
        res = res.set(2, "hello");
        String expResult = "1 , 4 , hello , with";
        Object actualResult = res.toString();
        assertEquals(expResult, actualResult);
    }

    @Test
    public void testIndexOf() {
        Object[] a = {1, 4,"you", "with"};
        ImmutableArrayList myArray = new ImmutableArrayList();
        ImmutableArrayList res = myArray.addAll(a);
        int expResult = 2;
        int actualResult = res.indexOf("you");
        assertEquals(expResult, actualResult);
    }

    @Test
    public void testIndexOfWithoutElem() {
        Object[] a = {1, 4,"you", "with"};
        ImmutableArrayList myArray = new ImmutableArrayList();
        ImmutableArrayList res = myArray.addAll(a);
        int expResult = -1;
        int actualResult = res.indexOf(9);
        assertEquals(expResult, actualResult);
    }

    @Test
    public void testSize() {
        Object[] a = {1, 4,"you", "with"};
        ImmutableArrayList myArray = new ImmutableArrayList();
        ImmutableArrayList res = myArray.addAll(a);
        int expResult = 4;
        int actualResult = res.size();
        assertEquals(expResult, actualResult);
    }

    @Test
    public void testClear() {
        Object[] a = {1, 4,"you", "with"};
        ImmutableArrayList myArray = new ImmutableArrayList();
        myArray = myArray.addAll(a);
        ImmutableArrayList res = myArray.clear();
        String expResult = "";
        String actualResult = res.toString();
        assertTrue(expResult == actualResult);
    }

    @Test
    public void testIsEmpty() {
        ImmutableArrayList myArray = new ImmutableArrayList();
        boolean actualResult = myArray.isEmpty();
        assertTrue(actualResult);
    }

    @Test
    public void testToArray() {
        Object[] a = {1, 4,"you", "with"};
        ImmutableArrayList myArray = new ImmutableArrayList();
        ImmutableArrayList res = myArray.addAll(a);
        Object[] expResult = {1, 4,"you", "with"};
        Object[] actualResult = res.toArray();
        assertArrayEquals(expResult, actualResult);
    }

}
