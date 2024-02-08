package com.ds.queue;

public class QueueUsingArray {
    int front, rear, size;
    int capacity;
    int[] array;

    public QueueUsingArray(int capacity)
    {
        this.capacity = capacity;
        this.front = 0;
        this.size = 0;
        rear = capacity - 1;
        array = new int[this.capacity];
    }

    boolean isFull()
    {
        return (this.size == this.capacity);
    }

    boolean isEmpty()
    {
        return (this.size == 0);
    }

    void enqueue(int item) throws Exception
    {
        if (this.size == this.capacity)
            throw new Exception("Queue Overflow Exception!");

        this.rear = (this.rear + 1) % this.capacity;
        this.array[this.rear] = item;
        this.size = this.size + 1;
    }

    int dequeue() throws Exception
    {
        if (this.size == 0)
            throw new Exception("Queue Empty Exception!");

        int item = this.array[this.front];
        this.front = (this.front + 1) % this.capacity;
        this.size = this.size - 1;
        return item;
    }

    int front() throws Exception
    {
        if (this.size == 0)
            throw new Exception("Queue Empty Exception!");

        return this.array[this.front];
    }

    // Method to get rear of queue
    int rear() throws Exception
    {
        if (this.size == 0)
            throw new Exception("Queue Empty Exception!");

        return this.array[this.rear];
    }
}
