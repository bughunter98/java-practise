package org.example.DataStructures.Graphs;

public class GraphNode {
    public String name;
    public int index;
    public GraphNode(String name , int index){
        this.name=name;
        this.index=index;
    }
    public boolean isVisited;
}
