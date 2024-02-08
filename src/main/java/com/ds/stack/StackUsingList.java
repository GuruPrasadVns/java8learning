package com.ds.stack;

class Node{
    int data;
    Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }
}
public class StackUsingList {
    private Node top;
    private int size;

    public StackUsingList(){
        this.top = null;
        this.size = 0;
    }

    public boolean isEmpty(){
        return top == null;
    }

    public void push(int item){
        Node node = new Node(item);
        node.next = top;
        top = node;
        size++;
    }

    public int pop() throws Exception{
        if(top == null)
            throw new Exception("Stack Underflow");
        int item = top.data;
        top = top.next;
        size--;
        return item;
    }

    public int peek() throws Exception{
        if(top == null)
            throw new Exception("Stack Underflow");

        return top.data;
    }

    public int getSize(){
        return size;
    }

    public void print(){
        Node current = top;

        while(current != null){
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}
