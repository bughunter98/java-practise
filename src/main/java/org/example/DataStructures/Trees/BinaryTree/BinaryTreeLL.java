package org.example.DataStructures.Trees.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeLL {
    // can be created using linkedList as well as arrays
    /*
    // Note  :   Using Arrays-----------------
    * 1 ) Using Array ignore zeroth index nd start from first index to avoid complexity
    * left node value will be added at 2x(where x is the index of root node) and
    * right node value will be added at 2x+1(where x is the index of root node)*/

    BinaryNode root;
    public BinaryTreeLL(){
        // this will initialize empty LL
        this.root=null;
    }
    public void preOrder(BinaryNode node){
        if (node!=null){
            System.out.print(node.value + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void inOrder(BinaryNode node){
        if (node!=null){
            inOrder(node.left);
            System.out.print(node.value + " ");
            inOrder(node.right);

        }
    }

    public void postOrder(BinaryNode node){
        if (node==null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }

    public void levelOrder(BinaryNode node){
        if (node==null){
            System.out.println("Tree is Empty..");
            return;
        }
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
    public void inOrderIterative(BinaryNode node){
        Stack<BinaryNode> stack = new Stack<>();
        BinaryNode current = node;
        while (current!=null || !stack.isEmpty()){
            while (current!=null){
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            System.out.print(current.value+" ");
            current = current.right;
        }
    }

    public void preOrderIterative(BinaryNode node) {
        if (node == null) {
            return;
        }
        Stack<BinaryNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            BinaryNode current = stack.pop();
            System.out.print(current.value + " ");

            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
    }

    public void postOrderIterativeUsing2Stack(BinaryNode root){
        if (root==null){
            return;
        }
        Stack<BinaryNode> stack1 = new Stack<>();
        Stack<BinaryNode> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()){
            BinaryNode top1 = stack1.pop();
            stack2.push(top1);
            BinaryNode top2 = stack2.peek();
            if (top2.left!=null){
                stack1.push(top2.left);
            }
            if (top2.right!=null){
                stack1.push(top2.right);
            }
        }
        System.out.println("post Order Iterative Using 2 Stack");
        while (!stack2.isEmpty()){
            System.out.print(stack2.pop().value+" ");
        }
    }

    public void postOrderIterativeUsing1Stack(BinaryNode root){ // this is tricky logic
        BinaryNode current = root;
        Stack<BinaryNode> stack = new Stack<>();
        while (current!=null || !stack.isEmpty()){
            if (current!=null){
                stack.push(current);
                current = current.left;
            }
            else {
                BinaryNode temp = stack.peek().right;
                if (temp==null){
                    temp=stack.pop();
                    System.out.print(temp.value+" ");
                    while (!stack.isEmpty() && temp == stack.peek().right){
                        temp=stack.pop();
                        System.out.print(temp+" ");
                    }
                }
                else {
                    current=temp;
                }
            }
        }
    }

public boolean searchValueInBinaryTree(BinaryNode root,String value){
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            BinaryNode current = queue.remove();
            if (value.equalsIgnoreCase(current.value)){
                return true;
            }
            if (current.left!=null){
                queue.add(current.left);
            }
            if (current.right!=null){
                queue.add(current.right);
            }
        }
        return false;
    }

    public void insertNodeinBinaryTree(String value,BinaryNode root){
        BinaryNode newNode = new BinaryNode();
        newNode.value=value;
        Queue<BinaryNode> queue = new LinkedList<>();
        if (root==null){  // if the newNode is the first element to be added in the tree then root would be null . so we are doing this check.
            root =newNode;
        }
        queue.add(root);
        while (!queue.isEmpty()){
            BinaryNode current = queue.remove();
            if (current.left!=null){
                queue.add(current.left);
            }
            if (current.right!=null){
                queue.add(current.right);
            }
            if (current.left==null){
                current.left = newNode;
                break;
            }
            if (current.right==null){
                current.right=newNode;
                break;
            }
        }
    }

    public BinaryNode getDeepestNode(BinaryNode root){
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        BinaryNode presentNode = null;
        while (!queue.isEmpty()){
            presentNode =  queue.remove();
            if (presentNode.left!=null){
                queue.add(presentNode.left);
            }
            if (presentNode.right!=null){
                queue.add(presentNode.right);
            }
        }
        return presentNode;
    }

    public void deleteNodeInBinaryTree(String value , BinaryNode root){
      if (root==null){
          System.out.println("Tree is Empty");
          return;
      }
        // Initialize variables for targetNode (node to be deleted), parent, and deepestNode
        BinaryNode targetNode = null;
        BinaryNode parent = null;
        BinaryNode current = null;

        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            current = queue.poll();

            // If the current node has a left child, add it to the queue and update parent
            if (current.left!=null){
                queue.add(current.left);
                parent=current; // Set the parent to the current node
            }
            // If the current node has a right child, add it to the queue and update parent
            if (current.right!=null){
                queue.add(current.right);
                parent=current; // Set the parent to the current node
            }

            // If we find the node to be deleted (targetNode), store it
            if (value.equalsIgnoreCase(current.value)){
                targetNode = current;// here we cannot do targetNode.val = current.val because target.val is null .
                //targetNode.value= getDeepestNode(root).value; // this will give time complexity as O(n*n)
                //targetNode.value= current.value; this is not correcet because if we do it also targetNode value will be N3 only
                // so we should iterate the loop unitil the currentNode value will be the last Node value.
            }
        }

        if (targetNode!=null){
            //targetNode.value = current.value; // Replace targetNode's data with deepestNode's data
            if (parent!=null){ // parent will have the last but one node value
                // Check if currentNode was the left child or right child of the parent
                if (parent.left == current){
                    parent.left = null;
                }
                else {
                    parent.right=null;
                }
            }
        }

    }

    public void deleteEntireBinaryTree(){
        this.root=null;
        System.out.println("Binary Tree has been deleted successfully");
    }

    /*
1 2 4 8 9 5 3 6 7
8 4 9 2 5 1 6 3 7
8 9 4 5 2 6 7 3 1

    *
*/
}
