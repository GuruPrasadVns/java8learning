package com.ds.stack;

import org.junit.Test;

import static org.junit.Assert.*;

public class StackUsingArrayTest {

    @Test
    public void basicStackOperationTests(){
        StackUsingArray stack = new StackUsingArray();
        assertEquals(0, stack.getSize());
        assertTrue(stack.isEmpty());
        try {
            stack.push(1);
            assertEquals(1, stack.getSize());
            assertFalse(stack.isEmpty());
            assertEquals(1, stack.peek());

            assertEquals(1, stack.pop());
            assertEquals(0, stack.getSize());
            assertTrue(stack.isEmpty());

            stack.push(1);
            stack.push(2);
            stack.push(3);

            assertEquals(3, stack.getSize());
            assertFalse(stack.isEmpty());
            assertEquals(3, stack.peek());

            assertEquals(3, stack.pop());
            assertEquals(2, stack.getSize());
            assertEquals(2, stack.peek());
            assertFalse(stack.isEmpty());

            assertEquals(2, stack.pop());
            assertEquals(1, stack.getSize());
            assertEquals(1, stack.peek());
            assertFalse(stack.isEmpty());

            assertEquals(1, stack.pop());
            assertEquals(0, stack.getSize());
            assertTrue(stack.isEmpty());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
