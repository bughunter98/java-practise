package org.example.DataStructures.Trees.BinaryTree;

public class BinaryTreeMainArray {
    public static void main(String[] args) {
        BinaryTreeArray binaryTreeArray = new BinaryTreeArray(9);
        binaryTreeArray.insertNodeInBinaryTree("1");
        binaryTreeArray.insertNodeInBinaryTree("2");
        binaryTreeArray.insertNodeInBinaryTree("3");
        binaryTreeArray.insertNodeInBinaryTree("4");
        binaryTreeArray.insertNodeInBinaryTree("5");
        binaryTreeArray.insertNodeInBinaryTree("6");
        binaryTreeArray.insertNodeInBinaryTree("7");
        binaryTreeArray.insertNodeInBinaryTree("8");
        binaryTreeArray.insertNodeInBinaryTree("9");

        binaryTreeArray.preOrderTraversal(1);
        System.out.println();
        binaryTreeArray.inOrderTraversal(1);
        System.out.println();
        binaryTreeArray.postOrderTraversal(1);
        System.out.println();
        binaryTreeArray.levelOrderTraversal();
        System.out.println();
        System.out.println("Searching for 5 in binary tree : "+binaryTreeArray.searchBinaryTree("5"));
        System.out.println("Searching for 50 in binary tree : "+binaryTreeArray.searchBinaryTree("50"));
        binaryTreeArray.deleteNodeInBinaryTree("3");
        binaryTreeArray.deleteNodeInBinaryTree("4");
        System.out.println();
        binaryTreeArray.levelOrderTraversal();
        binaryTreeArray.deleteEntireTree();
    }
}
