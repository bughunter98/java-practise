package org.example.DataStructures.Trees.AVLTree;

public class AVLTreeMain {
    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();
        avlTree.insert(5);
        System.out.println("Height of the tree"+avlTree.root.height);
        avlTree.insert(10);
        System.out.println("Height of the tree"+avlTree.root.height);
        avlTree.insert(15);
        System.out.println("Height of the tree"+avlTree.root.height);
        avlTree.insert(20);
        System.out.println("Height of the tree"+avlTree.root.height);
        avlTree.levelOrderTraversal();
        avlTree.delete(10);
        avlTree.delete(15);
        System.out.println();
        System.out.println("Height of the tree"+avlTree.root.height);
        avlTree.levelOrderTraversal();
        avlTree.deleteAVLTree();
        avlTree.levelOrderTraversal();

    }
}
