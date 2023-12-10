package com.ds.binarytree;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinaryTreeTest {
	
//				1
//				
//		2                 3
//		
//	
//	4
	
	@Test
	public void basicBinaryTreeConstructionTest() {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		
		assertEquals(3, tree.height(tree.root));
		
		System.out.println("\nlevleorder Traversal is :");
		
		tree.levelOrder();
		
		System.out.println("\nInorder Traversal is :");
		
		tree.inorder(tree.root);
		
		System.out.println("\nInorder Iterative Traversal is :");
		
		tree.inorderIterative();
		
		System.out.println("\nPreorder Traversal is :");
		
		tree.preorder(tree.root);
		
		System.out.println("\nPostorder Traversal is :");
		
		tree.postorder(tree.root);
		
		assertEquals(4, tree.diameter(tree.root));
	}
//						
//												        25
//												
//										15					           50
//										
//								10				22              35			 70
//								
//						4 			12       18      24     31       44   66      90
	
	@Test
	public void advancedBinaryTreeConstructionTest() {
		BinaryTree tree = new BinaryTree();
		
		tree.root = new Node(25);
		
		tree.root.left = new Node(15);
		tree.root.right = new Node(50);
		
		tree.root.left.left = new Node(10);
		tree.root.left.right = new Node(22);
		
		tree.root.right.left = new Node(35);
		tree.root.right.right = new Node(70);
		
		tree.root.left.left.left = new Node(4);
		tree.root.left.left.right = new Node(12);
		
		tree.root.left.right.left = new Node(18);
		tree.root.left.right.right = new Node(24);
		
		tree.root.right.left.left = new Node(31);
		tree.root.right.left.right = new Node(44);
		
		tree.root.right.right.left = new Node(66);
		tree.root.right.right.right = new Node(90);
		
		System.out.println("\nInorder Traversal is :");
		
		tree.inorder(tree.root);
		
		System.out.println("\nInorder Iterative Traversal is :");
		
		tree.inorderIterative();
		
		System.out.println("\nPreorder Traversal is :");
		
		tree.preorder(tree.root);
		
		System.out.println("\nPostorder Traversal is :");
		
		tree.postorder(tree.root);
			
		System.out.println("\nDiameter or width of tree is :");
		
		tree.diameter(tree.root);
		
		assertEquals(7, tree.diameter(tree.root));
	}
	
//									1
//								
//							2				3
//							
//						4		5					8
//						
//							6		7						9
//												
//														10		11
//														
//															12
	@Test
	public void diameterSecondTest() {
		
		BinaryTree tree = new BinaryTree();
		
		tree.root = new Node(1);
		
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		
		tree.root.left.right.left = new Node(6);
		tree.root.left.right.right = new Node(7);
		
		tree.root.right.right = new Node(8);
		
		tree.root.right.right.right = new Node(9);
		
		tree.root.right.right.right.left = new Node(10);
		tree.root.right.right.right.right = new Node(11);
		
		tree.root.right.right.right.right.left = new Node(12);
		
		assertEquals(9, tree.diameter(tree.root));
		
	}
	
//							1
//							
//						2		3
//						
//					4		5
//					
//				6		7		 11
//				
//				     8        10     12
//				     
//				     	9           13
				     	
				     			
	@Test
	public void diameterThirdTest() {
		BinaryTree tree = new BinaryTree();
		
		tree.root = new Node(1);
		
		tree.root.left = new Node(2);
		tree.root.left = new Node(3);
		
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		
		tree.root.left.left.left = new Node(6);
		tree.root.left.left.right = new Node(7);
		
		tree.root.left.left.right.left = new Node(8);
		
		tree.root.left.left.right.left.right = new Node(9);
		
		tree.root.left.right.right = new Node(11);
		
		tree.root.left.right.right.left = new Node(10);
		tree.root.left.right.right.right = new Node(12);
		
		tree.root.left.right.right.right.left = new Node(13);
		
		assertEquals(9, tree.diameter(tree.root));
	}

}
