package org.example.DataStructures.Trees.BinarySearchTree;

public class BinarySearchTreeLLMain {
    public static void main(String[] args) {
        BinarySearchTreeLL binarySearchTree = new BinarySearchTreeLL();
        binarySearchTree.insert(70);
        binarySearchTree.insert(50);
        binarySearchTree.insert(30);
        binarySearchTree.insert(90);
        binarySearchTree.insert(60);
        binarySearchTree.insert(80);
        binarySearchTree.insert(100);
        binarySearchTree.insert(20);
        binarySearchTree.insert(40);
        System.out.println("Pre Order Traversal");
        binarySearchTree.preOrderTraversal(binarySearchTree.root);
        System.out.println();
        System.out.println("In Order Traversal");
        binarySearchTree.inOrderTraversal(binarySearchTree.root);
        System.out.println();
        System.out.println("Post Order Traversal");
        binarySearchTree.postOrderTraversal(binarySearchTree.root);
        System.out.println();
        System.out.println("Level Order Traversal");
        binarySearchTree.levelOrderTraversal(binarySearchTree.root);
        binarySearchTree.search(5);
        binarySearchTree.search(50);
        binarySearchTree.searchBST(binarySearchTree.root, 50);
        //binarySearchTree.deleteNode(binarySearchTree.root, 90);
        binarySearchTree.deleteNodeIteratively(binarySearchTree.root,30);
        binarySearchTree.inOrderTraversal(binarySearchTree.root);

    }
}
