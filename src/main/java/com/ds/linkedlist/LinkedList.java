package com.ds.linkedlist;

class Node{
	int data;
	Node next;
	
	public Node(int data) {
		this.data = data;
		this.next = null;
	}
}

public class LinkedList {
	
	Node head;
	int size;
	
	public LinkedList() {
		this.head = null;
		this.size = 0;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public void print() {
		Node current = head;
		
		while(current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		
		System.out.println("");
	}
	
	public void addAtIndex(int index, int data) {
		if(index < 0)
			throw new IllegalArgumentException("index cannot be negative");
		
		if(head == null && index == 0) {
			head = new Node(data);
			size++;
			return;
		}
		
		if(head == null && index > 0) {
			return;
		}
		
		if(head != null && index == 0) {
			Node node = new Node(data);
			node.next = head;
			head = node;
			size++;
			return;
		}
		
		Node current = head;
		Node previous = null;
		int currIndex = 0;
		
		while(current != null && currIndex < index) {
			previous = current;
			current = current.next;
			currIndex++;
		}
		
		if(current == null && currIndex == index) {
			Node node = new Node(data);
			previous.next  = node;
			size++;
			return;
		}
		
		if(current != null) {
			Node node = new Node(data);
			node.next = previous.next;
			previous.next = node;
			size++;
		}
		
	}
	
	public void reverseIterative() {
		Node current = head;
		Node next = null;
		Node previous = null;
		
		while(current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		
		head = previous;
	}
	
	
	public Node reverseRecursive(Node head) {
		
		if(head == null || head.next == null)
			return head;
		
		Node rest = reverseRecursive(head.next);
		head.next.next = head;
		head.next = null;
		
		return rest;
	}
	
	public void printReverse(Node head) {
		if(head == null)
			return;
		
		printReverse(head.next);
		System.out.print(head.data + " ");
	}

	public int get(int index){
		if(index < 0)
			throw new IllegalArgumentException("Index cannot be negative");

		if(head == null)
			return Integer.MIN_VALUE;

		Node current = head;
		int currentIndex = 0;

		while(current != null && currentIndex < index){
			current = current.next;
			currentIndex++;
		}

		if(current != null)
			return current.data;

		return Integer.MIN_VALUE;
	}

}
