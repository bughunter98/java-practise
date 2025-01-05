package org.example.DataStructures.Trees;

import java.util.ArrayList;

public class TreeNode {
public String data;
public ArrayList<TreeNode> children;


    public TreeNode(String data){
        this.data=data;
        this.children= new ArrayList<>();
    }

    public void addAchild(TreeNode node){
        this.children.add(node);
    }

    public String printTree(int level){
        String ret;
        ret = " ".repeat(level)+ this.data+"\n";
        for (TreeNode node : this.children){
            ret += node.printTree(level+1);
        }
        return ret;
    }
}
