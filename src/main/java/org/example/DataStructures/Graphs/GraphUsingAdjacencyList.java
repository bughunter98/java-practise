package org.example.DataStructures.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;

public class GraphUsingAdjacencyList {
    ArrayList<GraphNodeList> nodeList = new ArrayList<>();

    public GraphUsingAdjacencyList(ArrayList<GraphNodeList> nodeList){
        this.nodeList=nodeList;
    }
    public void addUnDirectedEdge(int firstIndx , int secondIndx ){
        GraphNodeList first = nodeList.get(firstIndx);
        GraphNodeList second = nodeList.get(secondIndx);

        first.neighbours.add(second);
        second.neighbours.add(first);

    }
    public String printAdjacencyList(){
        StringBuilder s = new StringBuilder();
        for (int i=0;i<nodeList.size();i++){
            s.append(nodeList.get(i).name).append(": ");
            for (int j=0;j<nodeList.get(i).neighbours.size();j++){
                if (j== nodeList.get(i).neighbours.size()-1){ // if its last index just print without arrow
                    s.append(nodeList.get(i).neighbours.get(j).name);
                }
                else {
                    s.append(nodeList.get(i).neighbours.get(j).name).append(" -> ");

                }
            }
            s.append("\n");
        }
        return s.toString();
    }

    public void bfs(){
        for (GraphNodeList node : nodeList){
            if (!node.isVisited){
                bfsVisit(node);
            }
        }
    }

    private void bfsVisit(GraphNodeList node) {
        LinkedList<GraphNodeList> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            GraphNodeList currentNode = queue.remove();
            currentNode.isVisited=true;
            System.out.print(currentNode.name+" ");
            ArrayList<GraphNodeList> neighBours = currentNode.neighbours;
            for (GraphNodeList neighBour : neighBours){
                if (!neighBour.isVisited){
                    queue.add(neighBour);
                    neighBour.isVisited=true;
                }
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<GraphNodeList> nodeList = new ArrayList<>();
        nodeList.add(new GraphNodeList("A",0));
        nodeList.add(new GraphNodeList("B",1));
        nodeList.add(new GraphNodeList("C",2));
        nodeList.add(new GraphNodeList("D",3));
        nodeList.add(new GraphNodeList("E",4));

        GraphUsingAdjacencyList graph = new GraphUsingAdjacencyList(nodeList);
        graph.addUnDirectedEdge(0,1);
        graph.addUnDirectedEdge(0,2);
        graph.addUnDirectedEdge(0,3);
        graph.addUnDirectedEdge(2,3);
        graph.addUnDirectedEdge(1,4);
        graph.addUnDirectedEdge(3,4);

        System.out.println(graph.printAdjacencyList());
        graph.bfs();
    }
}
