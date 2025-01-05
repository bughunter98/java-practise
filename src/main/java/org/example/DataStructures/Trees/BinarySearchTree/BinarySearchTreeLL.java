package org.example.DataStructures.Trees.BinarySearchTree;

import org.example.DataStructures.Trees.BinarySearchTree.BinaryNode;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTreeLL {
    BinaryNode root;
    BinarySearchTreeLL(){
        root=null;
    }

    public void insert(int value){
        root = insertNode(root,value);
    }
    public BinaryNode insertNode(BinaryNode currentNode, int value){
        if (currentNode==null){
            BinaryNode node = new BinaryNode();
            node.value= value;
            System.out.println("The value is successfully inserted");
            return node;
        }
        else if (value<=currentNode.value){
            currentNode.left= insertNode(currentNode.left,value);
            return currentNode;
        } else {
            currentNode.right = insertNode(currentNode.right,value);
            return currentNode;
        }
    }

    public void preOrderTraversal(BinaryNode node){
        if (node!=null){
            System.out.print(node.value+" ");
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }
    public void inOrderTraversal(BinaryNode node){
        if (node!=null){
            inOrderTraversal(node.left);
            System.out.print(node.value+" ");
            inOrderTraversal(node.right);
        }
    }
    public void postOrderTraversal(BinaryNode node){
        if (node!=null){
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            System.out.print(node.value+" ");
        }
    }

    public void levelOrderTraversal(BinaryNode node){
        if (node!=null){
            Queue<BinaryNode> queue = new LinkedList<>();
            queue.add(node);
            while (!queue.isEmpty()){
                BinaryNode current = queue.remove();
                System.out.print(current.value+" ");
                if (current.left!=null){
                    queue.add(current.left);
                }
                if (current.right!=null){
                    queue.add(current.right);
                }
            }
        }
    }

    public void search(int val){ // this is general approach for a binary tree .. for BST as tree is in sorted way , we can implement that way
        System.out.println();
        if (root!=null){
            Queue<BinaryNode> queue = new LinkedList<>();
            queue.add(root);
            boolean isValFound = false;
            while (!queue.isEmpty()){
                BinaryNode current = queue.remove();
                if (current.value==val){
                    isValFound = true;
                    break;
                }
                if (current.left!=null){
                    queue.add(current.left);
                }
                if (current.right!=null){
                    queue.add(current.right);
                }
            }
            if (isValFound){
                System.out.println("Value :"+val+" is present in the tree..");
            }
            else {
                System.out.println("Value :"+val+" not found in the tree..");
            }
        }
    }

    public void searchBST(BinaryNode node , int value){
        System.out.println();
        if (node==null){
            System.out.println("Value :"+value+" not found in the tree..");
        } else if (node.value==value) {
            System.out.println("Value :"+value+" found in the tree..");
        } else if (value< node.value) {
            searchBST(node.left,value);
        }
        else {
            searchBST(node.right,value);
        }
    }

    public BinaryNode minimumNode(BinaryNode node){
        if (node!=null){
            if (node.left==null){
                return node;
            }
            else {
                return minimumNode(node.left);
            }
        }
        else {
            return null;
        }
    }

    public BinaryNode deleteNode(BinaryNode node , int val){
        if (node==null){
            System.out.println("Value not found in BST");
            return null;
        }
        if (val<node.value) {
            node.left = deleteNode(node.left,val);
        }
        else if (val>node.value) {
            node.right = deleteNode(node.right,val);
        } else {
            if (node.left!=null && node.right!=null){
                BinaryNode temp = node;
                BinaryNode minNodeForRight = minimumNode(temp.right);
                node.value=minNodeForRight.value;
                node.right=deleteNode(node.right,minNodeForRight.value);
            } else if (node.left!=null) {
                node =  node.left;
            } else if (node.right!=null) {
                node=node.right;
            }
            else {
                node=null;
            }
        }
        return node;
    }

    public BinaryNode deleteNodeIteratively(BinaryNode root, int key) {
        BinaryNode parent = null;
        BinaryNode current = root;

        // Find the node to delete
        while (current != null && current.value != key) {
            parent = current;
            if (key < current.value) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        // If the node was not found
        if (current == null) {
            return root;
        }

        // Case 1: Node has no children (leaf node)
        if (current.left == null && current.right == null) {
            if (current != root) {
                if (parent.left == current) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            } else {
                root = null;
            }
        }
        // Case 2: Node has only one child
        else if (current.left == null || current.right == null) {
            BinaryNode child = (current.left != null) ? current.left : current.right;

            if (current != root) {
                if (parent.left == current) {
                    parent.left = child;
                } else {
                    parent.right = child;
                }
            } else {
                root = child;
            }
        }
        // Case 3: Node has two children
        else {
            BinaryNode successorParent = current;
            BinaryNode successor = current.right;

            // Find the successor (leftmost child of the right subtree)
            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }

            // Replace the node's data with the successor's data
            current.value = successor.value;

            // Delete the successor
            if (successorParent.left == successor) {
                successorParent.left = successor.right;
            } else {
                successorParent.right = successor.right;
            }
        }

        return root;
    }


}
