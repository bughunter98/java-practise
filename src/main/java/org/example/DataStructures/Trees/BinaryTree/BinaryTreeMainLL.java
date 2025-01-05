package org.example.DataStructures.Trees.BinaryTree;

import java.util.Scanner;

public class BinaryTreeMainLL {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTreeLL binaryTree = new BinaryTreeLL();
        BinaryNode n1 = new BinaryNode();
        n1.value="N1";
        BinaryNode n2 = new BinaryNode();
        n2.value="N2";
        BinaryNode n3 = new BinaryNode();
        n3.value="N3";
        BinaryNode n4 = new BinaryNode();
        n4.value="N4";
        BinaryNode n5 = new BinaryNode();
        n5.value="N5";
        BinaryNode n6 = new BinaryNode();
        n6.value="N6";
        BinaryNode n7 = new BinaryNode();
        n7.value="N7";
        BinaryNode n8 = new BinaryNode();
        n8.value="N8";
        BinaryNode n9 = new BinaryNode();
        n9.value="N9";

        n1.left=n2;
        n1.right=n3;
        n2.left=n4;
        n2.right=n5;
        n3.left=n6;
        n3.right=n7;
        n4.left=n8;
        n4.right=n9;
        binaryTree.root=n1;

        System.out.println("Pre Order");
        binaryTree.preOrder(binaryTree.root);
        System.out.println();
        binaryTree.preOrderIterative(binaryTree.root);
        System.out.println();
        System.out.println("In order recursive");
        binaryTree.inOrder(binaryTree.root);
        System.out.println();
        System.out.println("In order iterative");
        binaryTree.inOrderIterative(binaryTree.root);
        System.out.println();
        System.out.println("Post Order");
        binaryTree.postOrder(binaryTree.root);
        System.out.println();
        binaryTree.postOrderIterativeUsing2Stack(binaryTree.root);
        System.out.println();
        System.out.println("Level Order");
        binaryTree.levelOrder(binaryTree.root);
        System.out.println();
       /* System.out.println("Enter the value to insert in tree..");
        String value = scanner.nextLine();
        System.out.println("Searching the value : "+value+" in Binary Tree..");
        System.out.println(value +" present in tree ? "+binaryTree.searchValueInBinaryTree(binaryTree.root,value));
        binaryTree.insertNodeinBinaryTree(value, binaryTree.root);
        System.out.println("Level Order");
        binaryTree.levelOrder(binaryTree.root);

        System.out.println("Pre Order");
        binaryTree.preOrder(binaryTree.root);*/
        System.out.println("deleting a node from binary tree");
        binaryTree.deleteNodeInBinaryTree("N3", binaryTree.root);
        System.out.println("Level Order");
        binaryTree.levelOrder(binaryTree.root);
        binaryTree.deleteEntireBinaryTree();
        System.out.println();
        System.out.println("Level Order");
        binaryTree.levelOrder(binaryTree.root);

    }
}
