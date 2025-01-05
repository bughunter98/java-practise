package org.example.DataStructures.Trees;

import java.util.ArrayList;

public class BasicTree {

    public static void main(String[] args) {

        TreeNode maintree = new TreeNode("Drinks");
        TreeNode hotDrinks = new TreeNode("Hot");
        TreeNode hotDrinks1 = new TreeNode("Coffee");
        TreeNode hotDrinks2 = new TreeNode("Tea");
        TreeNode coolDrinks = new TreeNode("Cool");
        TreeNode coolDrinks1 = new TreeNode("Coke");
        TreeNode coolDrinks2 = new TreeNode("Pepsi");
        maintree.addAchild(hotDrinks);
        maintree.addAchild(coolDrinks);
        hotDrinks.addAchild(hotDrinks1);
        hotDrinks.addAchild(hotDrinks2);
        coolDrinks.addAchild(coolDrinks1);
        coolDrinks.addAchild(coolDrinks2);
        System.out.println(maintree.printTree(0));
    }

}