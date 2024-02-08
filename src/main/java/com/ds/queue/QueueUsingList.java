package com.ds.queue;

class Node{
    int data;
    Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class QueueUsingList {
    Node front;
    Node rear;
    int size;

    public QueueUsingList(){
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public boolean isEmpty(){
        return (front == null) && (rear == null);
    }

    public void enqueue(int item){
        Node node = new Node(item);

        if(front == null && rear == null){
            front =  node;
            rear = node;
            size++;
            return;
        }

        rear.next = node;
        rear = rear.next;
        size++;
    }

    public int dequeue() throws Exception{
        if(front == null && rear == null)
            throw new Exception("Queue Empty Exception");
        int item = front.data;
        front = front.next;
        size--;
        return  item;
    }

    public int front() throws Exception{
        if(front == null && rear == null)
            throw new Exception("Queue Empty Exception");

        return front.data;
    }

    public int rear() throws Exception{
        if(front == null && rear == null)
            throw new Exception("Queue Empty Exception");

        return rear.data;
    }
}
