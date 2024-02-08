package com.ds.queue;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class QueueUsingListTest {
    @Test
    public void basicQueueTest() throws Exception{
        QueueUsingList circularQueue =  new QueueUsingList();
        assertTrue(circularQueue.isEmpty());
        assertEquals(0, circularQueue.size);

        // enqueue
        circularQueue.enqueue(23);
        circularQueue.enqueue(25);

        assertFalse(circularQueue.isEmpty());
        assertEquals(2, circularQueue.size);
        assertEquals(23, circularQueue.front());
        assertEquals(25, circularQueue.rear());

        // enqueue
        circularQueue.enqueue(27);
        circularQueue.enqueue(29);
        circularQueue.enqueue(31);

        assertFalse(circularQueue.isEmpty());
        assertEquals(5, circularQueue.size);
        assertEquals(23, circularQueue.front());
        assertEquals(31, circularQueue.rear());

        // dequeue
        assertEquals(23, circularQueue.dequeue());
        assertFalse(circularQueue.isEmpty());
        assertEquals(4, circularQueue.size);
        assertEquals(25, circularQueue.front());
        assertEquals(31, circularQueue.rear());

        // dequeue
        assertEquals(25, circularQueue.dequeue());
        assertFalse(circularQueue.isEmpty());
        assertEquals(3, circularQueue.size);
        assertEquals(27, circularQueue.front());
        assertEquals(31, circularQueue.rear());
    }
}
