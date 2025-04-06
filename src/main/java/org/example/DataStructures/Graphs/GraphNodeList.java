package org.example.DataStructures.Graphs;

import java.util.ArrayList;

public class GraphNodeList {
    public String name ;
    public int index;
    public ArrayList<GraphNodeList> neighbours = new ArrayList<>();
    public boolean isVisited;

    public GraphNodeList(String name , int index){
        this.name=name;
        this.index=index;
    }
}
