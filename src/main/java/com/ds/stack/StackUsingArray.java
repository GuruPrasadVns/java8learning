package com.ds.stack;

public class StackUsingArray {
    private int[] arr;
    private int size;

    private int top;

    public StackUsingArray(){
        this.arr = new int[10];
        this.size = 0;
        this.top = -1;
    }

    public StackUsingArray(int capacity){
        this.arr = new int[capacity];
        this.size = 0;
        this.top = -1;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void push(int item) throws Exception{
        if(size == arr.length)
            throw new Exception("Stack overflow");

        arr[++top] = item;
        size++;
    }

    public int pop() throws Exception{
        if(top == -1)
            throw new Exception("Stack Underflow");

        int item = arr[top--];
        size--;
        return item;
    }

    public int getSize(){
        return size;
    }

    public int peek() throws Exception{
        if(top == -1)
            throw new Exception("Stack Underflow");

        return arr[top];
    }

    public void print(){
        for(int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }
}
