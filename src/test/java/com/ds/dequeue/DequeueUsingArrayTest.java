package com.ds.dequeue;

import org.junit.Test;

import static org.junit.Assert.*;

public class DequeueUsingArrayTest {

    @Test
    public void basicDequeueTest() throws Exception{
        DequeueUsingArray dequeue = new DequeueUsingArray(5);
        assertTrue(dequeue.isEmpty());
        assertFalse(dequeue.isFull());
        assertEquals(0, dequeue.size);

        dequeue.insertRear(3);
        assertFalse(dequeue.isEmpty());
        assertFalse(dequeue.isFull());
        assertEquals(1, dequeue.size);
        assertEquals(3, dequeue.rear());

        dequeue.insertFront(5);
        assertFalse(dequeue.isEmpty());
        assertFalse(dequeue.isFull());
        assertEquals(2, dequeue.size);
        assertEquals(3, dequeue.rear());
        assertEquals(5, dequeue.front());

        dequeue.insertRear(7);
        assertFalse(dequeue.isEmpty());
        assertFalse(dequeue.isFull());
        assertEquals(3, dequeue.size);
        assertEquals(7, dequeue.rear());
        assertEquals(5, dequeue.front());

    }
}
