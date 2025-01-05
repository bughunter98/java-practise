package org.example.DataStructures.Trees.BinaryTree;

import java.util.Stack;

public class BinaryTreeArray {
    String[] arr;
    int lastUsedIndex;

    public BinaryTreeArray(int size) {
        arr = new String[size + 1]; // we dont use zeroth index that is why we are adding one extra
        this.lastUsedIndex=0;
        System.out.println("Blank Tree of size "+size+" has been created..");
    }

    public boolean isTreeFull(){
        return  ((arr.length-1)==lastUsedIndex);
    }

    public void insertNodeInBinaryTree(String value){
        if (!isTreeFull()){
            arr[lastUsedIndex+1]=value;
            lastUsedIndex++;
            System.out.println("Node with value "+value+" has been created");
        }
        else {
            System.out.println("Tree Size is Full.");
        }
    }

    public void preOrderTraversal(int index){
        if (index>lastUsedIndex){
            return;
        }
        if (arr[index]!=null){
            System.out.print(arr[index]+" ");
            preOrderTraversal(2*index);
            preOrderTraversal(index*2+1);
        }
    }

    public void inOrderTraversal(int index){
        if (index>lastUsedIndex){
            return;
        }
        if (arr[index]!=null){
            inOrderTraversal(index*2);
            System.out.print(arr[index]+" ");
            inOrderTraversal(index*2+1);
        }
    }
    public void postOrderTraversal(int index){
        if (index>lastUsedIndex){
            return;
        }
        if (arr[index]!=null){
            postOrderTraversal(index*2);
            postOrderTraversal(index*2+1);
            System.out.print(arr[index]+" ");
        }
    }
    public void levelOrderTraversal(){
        for (int i=1;i<=lastUsedIndex;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public boolean searchBinaryTree(String value){
        for (int i=1;i<=lastUsedIndex;i++){
            if (value.equalsIgnoreCase(arr[i])){
                return true;
            }
        }
        return false;
    }

    public void deleteNodeInBinaryTree(String val){
        for (int i=1;i<=lastUsedIndex;i++){
            if (val.equalsIgnoreCase(arr[i])){
                arr[i]=arr[lastUsedIndex];
                lastUsedIndex--;
                return;
            }
        }
        System.out.println("Node cannot be deleted as its not found in Tree");
    }
    public void deleteEntireTree(){
        try {
            arr=null;
            System.out.println("Deleted entire tree");
        }
        catch (Exception e){
            System.out.println("Error deleting tree");
        }
    }


}
