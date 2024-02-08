package com.ds.dequeue;

public class DequeueUsingArray {
    int arr[];
    int front;
    int rear;
    int size;
    int capacity;

    public DequeueUsingArray(int capacity){
        this.capacity = capacity;
        this.size = 0;
        this.front = 0;
        this.rear = capacity - 1;
        this.arr = new int[this.capacity];
    }

    public boolean isFull(){
        return size == capacity;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void insertFront(int item) throws Exception{
        if(size == capacity)
            throw new Exception("Dequeue Overflow Exception");
        if(front + 1 == rear){
            this.front = (this.front + 2) % capacity;
        }else{
            this.rear = (this.front + 1) % this.capacity;
        }
        arr[front] = item;
        this.size = this.size + 1;
    }

    public void insertRear(int item) throws Exception{
        if(size == capacity)
            throw new Exception("Dequeue Overflow Exception");

        if(rear + 1 == front){
            this.rear = (this.rear + 2) % capacity;
        }else{
            this.rear = (this.rear + 1) % this.capacity;
        }
        arr[rear] = item;
        this.size = this.size + 1;
    }

    public int deleteFront() throws Exception{
        if(size == 0)
            throw new Exception("Dequeue Empty Exception");

        int item = arr[front];
        front = (front + 1) % capacity;
        size--;
        return item;
    }

    public int deleteRear() throws Exception{
        if(size == 0)
            throw new Exception("Dequeue Empty Exception");

        int item = arr[rear];
        rear = (rear + 1) % capacity;
        size--;
        return item;
    }

    public int front() throws Exception{
        if(size == 0)
            throw new Exception("Dequeue Empty Exception");
        return arr[front];
    }

    public int rear() throws Exception{
        if(size == 0)
            throw new Exception("Dequeue Empty Exception");
        return arr[rear];
    }
}
