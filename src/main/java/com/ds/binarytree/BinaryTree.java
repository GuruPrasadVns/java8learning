package com.ds.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
public class BinaryTree {
    Node root;

    public BinaryTree(){
        root = null;
    }

    public int heightRec(Node root){
        if(root == null) return 0;

        int leftSubTreeHeight = heightRec(root.left);
        int rightSubTreeHeight = heightRec(root.right);

        return Math.max(leftSubTreeHeight, rightSubTreeHeight) + 1;
    }

    public void levelOrder(){
        int height = heightRec(root);

        for(int i = 1; i <= height; i++)
            printCurrentLevel(root, i);
    }

    private void printCurrentLevel(Node root, int level) {
        if(root == null) return;

        if(level == 1){
            System.out.print(root.data + " ");
        }else if (level > 1){
            printCurrentLevel(root.left, level - 1);
            printCurrentLevel(root.right, level - 1);
        }
    }

    public void inorder(Node root){
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public void preorder(Node root){
        if(root == null) return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public void postorder(Node root){
        if(root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    public void inorderIterative(){
        if(root == null)
            return;

        Stack<Node> stack = new Stack<>();
        Node current = root;

        while(current != null || !stack.isEmpty()){

            while(current != null){
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            System.out.print(current.data + " ");
            current = current.right;
        }
    }

    public int diameter(Node root){
        if(root == null) return 0;

        int leftSubTreeHeight = heightRec(root.left);
        int rightSubTreeHeight = heightRec(root.right);

        int leftSubTreeDiameter = diameter(root.left);
        int rightSubTreeDiameter = diameter(root.right);

        return Math.max(leftSubTreeHeight + rightSubTreeHeight + 1, Math.max(leftSubTreeDiameter, rightSubTreeDiameter));
    }

    public void insertInLevelOrder(int key){
        if(root == null){
            root = new Node(key);
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node temp = null;

        while(!queue.isEmpty()){
            temp = queue.poll();

            if(temp.left == null){
                temp.left = new Node(key);
                return;
            }else{
                queue.add(temp.left);
            }

            if(temp.right == null){
                temp.right = new Node(key);
                return;
            }else{
                queue.add(temp.right);
            }
        }
    }

    public void delete(int key){
        if(root == null) return;
        if(root.left == null && root.right == null){
            if(root.data == key){
                root = null;
            }
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node delNode = null;
        Node temp = null;

        while(!queue.isEmpty()){
            temp = queue.poll();

            if(temp.data == key){
                delNode = temp;
            }

            if(temp.left != null){
                queue.add(temp.left);
            }

            if(temp.right != null){
                queue.add(temp.right);
            }
        }

        if(delNode != null){
            int x = temp.data;
            deleteDeepeset(root, temp);
            delNode.data = x;
        }
    }

    private void deleteDeepeset(Node root, Node deepestNode) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node temp = null;

        while(!queue.isEmpty()){
            temp = queue.poll();

            if(temp == deepestNode){
                temp = null;
                return;
            }

            if(temp.right != null){
                if(temp.right == deepestNode){
                    temp.right = null;
                    return;
                }else{
                    queue.add(temp.right);
                }
            }

            if(temp.left != null){
                if(temp.left == deepestNode){
                    temp.left = null;
                    return;
                }else{
                    queue.add(temp.left);
                }
            }
        }
    }
}
