package com.ds.binarytree;

import java.util.Stack;

class Node{
	int data;
	Node left;
	Node right;
	
	public Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

public class BinaryTree {
	
	Node root;
	
	
	public BinaryTree() {
		this.root = null;
	}
	
	
	public int height(Node root) {
		if(root == null)
			return 0;
		
		int leftSubTreeHeight = height(root.left);
		int rightSubTreeHeight = height(root.right);
		
		return Math.max(leftSubTreeHeight, rightSubTreeHeight) + 1;
	}
	
	public void levelOrder() {
		int height = height(root);
		
		for(int i = 0; i <= height; i++)
			printCurrentLevel(i, root);
	}


	private void printCurrentLevel(int level, Node root) {
		if(root == null)
			return;
		
		if(level == 1)
			System.out.print(root.data + " ");
		
		else if(level > 1) {
			printCurrentLevel(level - 1, root.left);
			printCurrentLevel(level - 1, root.right);
		}
		
	}
	
	public void inorder(Node root) {
		if(root == null)
			return;
		
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}
	
	public void preorder(Node root) {
		if(root == null)
			return;
		
		System.out.print(root.data + " ");
		preorder(root.left);
		preorder(root.right);
	}
	
	public void postorder(Node root) {
		if(root == null)
			return;
				
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.data + " ");
		
	}
	
	
	public void inorderIterative() {
		Stack<Node> stack = new Stack<>();
		Node current = root;
		
		while(current != null || !stack.isEmpty()) {
			
			while(current != null) {
				stack.push(current);
				current = current.left;
			}
			
			current = stack.pop();
			System.out.print(current.data + " ");
			current = current.right;
		}
	}
	
	
	public int diameter(Node root) {
		if(root == null)
			return 0;
		
		int leftSubTreeHeight = height(root.left);
		int rightSubTreeHeight = height(root.right);
		
		int leftSubTreeDiameter = diameter(root.left);
		int rightSubTreeDiameter = diameter(root.right);
		
		return Math.max(leftSubTreeHeight + rightSubTreeHeight + 1, Math.max(leftSubTreeDiameter, rightSubTreeDiameter));
	}

}
