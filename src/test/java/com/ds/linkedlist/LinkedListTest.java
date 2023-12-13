package com.ds.linkedlist;

import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedListTest {
	
	@Test	
	public void addAtIndexTest() {
		LinkedList list = new LinkedList();
		
		assertTrue(list.isEmpty());
		assertEquals(0, list.size);
		
		list.addAtIndex(0, 2);
		
		assertFalse(list.isEmpty());
		assertEquals(1, list.size);
		
		list.addAtIndex(0, 1);
		
		assertFalse(list.isEmpty());
		assertEquals(2, list.size);
		
		list.addAtIndex(2, 3);
		
		assertFalse(list.isEmpty());
		assertEquals(3, list.size);
		
		list.addAtIndex(4, 3);
		
		assertFalse(list.isEmpty());
		assertEquals(3, list.size);
		
		list.addAtIndex(1, 10);
		
		list.addAtIndex(2, 20);
		
		list.addAtIndex(5, 50);
		
		assertEquals(6, list.size);
		
	}
	
	@Test
	public void reverseIterativeTest() {
		LinkedList list = new LinkedList();
		list.addAtIndex(0, 1);
		list.addAtIndex(1, 2);
		list.addAtIndex(2, 3);
		list.addAtIndex(3, 4);
		list.addAtIndex(4, 5);
		
		list.print();
		
		list.reverseIterative();
		
		list.print();
	}
	
	@Test
	public void revrseRecursiveTest() {
		LinkedList list = new LinkedList();
		list.addAtIndex(0, 1);
		list.addAtIndex(1, 2);
		list.addAtIndex(2, 3);
		list.addAtIndex(3, 4);
		list.addAtIndex(4, 5);
		
		list.print();
		
		list.head = list.reverseRecursive(list.head);
		
		list.print();
	}

	@Test
	public void getTest(){
		LinkedList list = new LinkedList();
		assertEquals(Integer.MIN_VALUE, list.get(0));

		list.addAtIndex(0, 1);
		assertEquals(1, list.get(0));
		assertEquals(Integer.MIN_VALUE, list.get(1));

		list.addAtIndex(1,2);
		assertEquals(1, list.get(0));
		assertEquals(2, list.get(1));
		assertEquals(Integer.MIN_VALUE, list.get(2));
		assertEquals(Integer.MIN_VALUE, list.get(3));
	}

}
