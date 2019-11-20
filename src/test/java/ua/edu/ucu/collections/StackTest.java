package ua.edu.ucu.collections;

import org.junit.Test;
import static org.junit.Assert.*;

public class StackTest {

    @Test
    public void testQueue() {
        Stack myStack = new Stack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        myStack.pop();
        Object expResult = 4;
        Object actualResult = myStack.peek();
        assertEquals(expResult, actualResult);
    }
    
}
