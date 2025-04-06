package org.example.DataStructures.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GraphUsingAdjacencyMatrix {
    List<GraphNode> nodeList;
    int[][] adjacencyMatrix ;

    public GraphUsingAdjacencyMatrix(List<GraphNode> nodeList){
        this.nodeList=nodeList;
        this.adjacencyMatrix= new int[nodeList.size()][nodeList.size()];
    }

    public void addUndirectedEdge(int i , int j){
        adjacencyMatrix[i][j]=1;
        adjacencyMatrix[j][i]=1;
    }

    public String printAdjacencyMatrix(){
        StringBuilder str = new StringBuilder();
        str.append("   ");
        for (GraphNode graphNode : nodeList) {
            str.append(graphNode.name).append(" ");
        }
        str.append("\n");
        for (int i=0;i<nodeList.size();i++){
            str.append(nodeList.get(i).name).append(": ");
            for (int j : adjacencyMatrix[i]){
                str.append(j).append(" ");
            }
            str.append("\n");
        }
        return str.toString();
    }

    // BFS methods


    public void bfs(){
        for (GraphNode node: nodeList){
            if (!node.isVisited){
                bfsVisit(node);
            }

        }
    }

    //BFS Internal
    void bfsVisit(GraphNode node){
        LinkedList<GraphNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            GraphNode currentNode = queue.remove();
            currentNode.isVisited=true;
            System.out.print(currentNode.name+" ");
            ArrayList<GraphNode> neighBours = getNeighbours(currentNode);
            for (GraphNode neighBour : neighBours){
                if (!neighBour.isVisited /*&& !queue.contains(neighBour)*/){ // this would also work
                    queue.add(neighBour);
                    neighBour.isVisited=true;
                }
            }
        }

    }

    // get Neighbours
    public ArrayList<GraphNode> getNeighbours(GraphNode node){
        ArrayList<GraphNode> neighbours = new ArrayList<>();
        int nodeIndex =  node.index;
        for (int i=0;i< adjacencyMatrix.length;i++){
            if (adjacencyMatrix[nodeIndex][i]==1){
                neighbours.add(nodeList.get(i));
            }
        }
        return neighbours;
    }

    public static void main(String[] args) {
        List<GraphNode> nodeList = new ArrayList<>();
        nodeList.add(new GraphNode("A",0));
        nodeList.add(new GraphNode("B",1));
        nodeList.add(new GraphNode("C",2));
        nodeList.add(new GraphNode("D",3));
        nodeList.add(new GraphNode("E",4));

        GraphUsingAdjacencyMatrix graph = new GraphUsingAdjacencyMatrix(nodeList);
        graph.addUndirectedEdge(0,1);
        graph.addUndirectedEdge(0,2);
        graph.addUndirectedEdge(0,3);
        graph.addUndirectedEdge(2,3);
        graph.addUndirectedEdge(1,4);
        graph.addUndirectedEdge(3,4);
        System.out.println(graph.printAdjacencyMatrix());
        graph.bfs();

    }
}
