package org.example.DataStructures.Trees.AVLTree;

import java.util.LinkedList;
import java.util.Queue;

public class AVLTree {
    AVLNode root;

    AVLTree(){
        root=null;
    }

    public void preOrderTraversal(AVLNode node){
        if (node==null){
            return;
        }
        System.out.print(node.value+" ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }
    public void inOrderTraversal(AVLNode node){
        if (node==null){
            return;
        }
        inOrderTraversal(node.left);
        System.out.print(node.value+" ");
        inOrderTraversal(node.right);
    }
    public void postOrderTraversal(AVLNode node){
        if (node==null){
            return;
        }
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.value+" ");
    }
    public void levelOrderTraversal(){
        if (this.root==null){
            System.out.println("AVL Tree is Empty");
            return;
        }
        Queue<AVLNode> queue = new LinkedList<>();
        queue.add(this.root);
        while (!queue.isEmpty()){
            AVLNode current = queue.remove();
            System.out.print(current.value+" ");
            if (current.left!=null){
                queue.add(current.left);
            }
            if (current.right!=null){
                queue.add(current.right);
            }
        }
    }
    public AVLNode search(AVLNode node , int value){
        if (node==null){
            System.out.println("Value: "+value+" not found in AVL Tree");
            return null;
        }
        else if (node.value==value) {
            System.out.println("Value: "+value+"found in AVL Tree");
            return node;
        }
        else if (value<node.value) {
            return search(node.left,value);
        }
        else {
            return search(node.right,value);
        }

    }

    // Helper methods.

    //getHeight
    public int getHeight(AVLNode node){
        if (node==null){
            return 0;
        }
        return node.height;
    }

    private AVLNode rotateRight(AVLNode disbalancedNode){

            AVLNode newRoot = disbalancedNode.left;

            disbalancedNode.left = disbalancedNode.left.right;
            newRoot.right = disbalancedNode;

            disbalancedNode.height = 1+ Math.max(getHeight(disbalancedNode.left),getHeight(disbalancedNode.right));
            newRoot.height = 1 + Math.max(getHeight(newRoot.left),getHeight(newRoot.right));
            return newRoot;
    }
    private AVLNode rotateLeft(AVLNode disbalancedNode){
            AVLNode newRoot = disbalancedNode.right;

            disbalancedNode.right = disbalancedNode.right.left;
            newRoot.left=disbalancedNode;

            disbalancedNode.height = 1 + Math.max(getHeight(disbalancedNode.left),getHeight(disbalancedNode.right));
            newRoot.height = 1 + Math.max(getHeight(newRoot.left),getHeight(newRoot.right));
            return newRoot;
    }

    public  int getBalance(AVLNode node){
        if (node==null){
            return 0;
        }
        return getHeight(node.left)-getHeight(node.right);
    }

    private AVLNode insertNode(AVLNode node ,  int nodeValue){
        if (node==null){
            AVLNode newNode = new AVLNode();
            newNode.value=nodeValue;
            newNode.left=null;
            newNode.right=null;
            newNode.height=1;
            return newNode;
        } else if (nodeValue<node.value) {
            node.left = insertNode(node.left,nodeValue);
        }
        else if(nodeValue>node.value){
            node.right = insertNode(node.right,nodeValue);
        }
        else {
            return node;
        }
        node.height = 1+Math.max(getHeight(node.left),getHeight(node.right));
        int balance = getBalance(node);

        // LL
        if (balance > 1 && nodeValue<node.left.value){
            return rotateRight(node);
        }
        //LR
        if (balance > 1 && nodeValue > node.left.value){
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        // RR
        if (balance < -1 && nodeValue>node.right.value){
            return rotateLeft(node);
        }
        //RL
        if (balance < -1 && nodeValue < node.right.value){
            node.right = rotateRight(node.left);
            return rotateLeft(node);
        }
        return node;
    }
    public void insert(int value){
        root = insertNode(root,value);
    }

    // to find min value of left sub tree
    public AVLNode minimumNode(AVLNode node){
        if (node.left==null){
            return node;
        }
        return minimumNode(node.left);
    }
    //Delete node
    private AVLNode deleteNode(AVLNode node , int value){
        if (node==null){
            System.out.println("Value not found...");
            return node;
        }

        if (value < node.value){
            node.left = deleteNode(node.left,value);
        }
        else if (value > node.value) {
            node.right = deleteNode(node.right,value);
        }
        else {
            // we have 3 cases.
            // 1) if the node has 2 children
            // 2) if the node has one child
            // 3) if the node is a leaf node


            // logic for 1st case
            if (node.left!=null && node.right!=null){
                AVLNode temp = node;
                AVLNode minNodeForRight = minimumNode(temp.right);
                node.value = minNodeForRight.value;
                node.right= deleteNode(node.right,minNodeForRight.value);
            }
            // the below 2 else if conditions are for 2nd case
            else if (node.left!=null) {
                node = node.left;
            }
            else if (node.right!=null) {
                node = node.right;
            }
            else {
                // 3rd case if the node is leaf node
                node = null;
            }
        }
        // now node is deleted from above conditions
        // we need to check the balancing now
        int balance = getBalance(node);
        if (node!=null) {
            if (balance > 1 && getBalance(node.left) >= 0) {
                return rotateRight(node); // LL
            }
            if (balance > 1 && getBalance(node.left)<0){
                node.left = rotateLeft(node.left);
                return rotateRight(node); // LR
            }
            if (balance < -1 && getBalance(node.right)<=0){
                return rotateLeft(node); //RR
            }
            if (balance < -1 && getBalance(node.right)>0){
                node.right = rotateLeft(node.right);
                return rotateLeft(node); // RL
            }
            // after deletion we need to update the height of the tree
                node.height = Math.max(getHeight(node.left),
                        getHeight(node.right)) + 1;
        }
        return node;
    }

    public void delete(int value){
        root = deleteNode(root,value);
    }
    public void deleteAVLTree(){
        root=null;
        System.out.println("AVL Tree Successfully Deleted");
    }

}
