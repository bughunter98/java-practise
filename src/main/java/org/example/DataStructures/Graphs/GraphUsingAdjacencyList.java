package org.example.DataStructures.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;


// if we know target is close use BFS
// if we know target vertex is buried very deep , use DFS

public class GraphUsingAdjacencyList {
    ArrayList<GraphNodeList> nodeList;

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
    private void dfs() {
        // as BFS already triggered before this , all the isVisited would have been true . so making them false
        // ipudu paina already bfs method main method lo call chesa kabatti anni noded ki isVisited true aipotadi so
        // adhi false cheyalo kabati kinda foreachloop raasa
        nodeList.forEach(node -> {
            if (node.isVisited) {
                node.isVisited=false;
            }}
        );
        for (GraphNodeList node : nodeList){
            if (!node.isVisited){
                dfsVisit(node);
            }
        }
    }

    private void dfsVisit(GraphNodeList node) {
        Stack<GraphNodeList> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()){
            GraphNodeList currentNode = stack.pop();
            currentNode.isVisited=true;
            System.out.print(currentNode.name+" ");
            ArrayList<GraphNodeList> neighBours = currentNode.neighbours;
            for (GraphNodeList neighBour : neighBours){
                if (!neighBour.isVisited){
                    stack.add(neighBour);
                    neighBour.isVisited=true;
                }
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
        // BFS time complexity is O(V+E) . same goes with spacce complexity as well.
    }

    public static void main(String[] args) {
        ArrayList<GraphNodeList> nodeList = new ArrayList<>();
        nodeList.add(new GraphNodeList("A", 0));
        nodeList.add(new GraphNodeList("B", 1));
        nodeList.add(new GraphNodeList("C", 2));
        nodeList.add(new GraphNodeList("D", 3));
        nodeList.add(new GraphNodeList("E", 4));

        GraphUsingAdjacencyList graph = new GraphUsingAdjacencyList(nodeList);
        graph.addUnDirectedEdge(0, 1);
        graph.addUnDirectedEdge(0, 2);
        graph.addUnDirectedEdge(0, 3);
        graph.addUnDirectedEdge(2, 3);
        graph.addUnDirectedEdge(1, 4);
        graph.addUnDirectedEdge(3, 4);

        System.out.println(graph.printAdjacencyList());
        System.out.println("Breadth First Search ");
        graph.bfs();
        System.out.println();
        System.out.println("Depth First Search");
        graph.dfs();
        System.out.println();

        ArrayList<GraphNodeList> nodeList1 = getNodeList();

        GraphUsingAdjacencyList graph1 = new GraphUsingAdjacencyList(nodeList1);
        graph1.addUnDirectedEdge(0, 1);
        graph1.addUnDirectedEdge(0, 2);
        graph1.addUnDirectedEdge(1, 3);
        graph1.addUnDirectedEdge(1, 6);
        graph1.addUnDirectedEdge(2, 3);
        graph1.addUnDirectedEdge(2, 4);
        graph1.addUnDirectedEdge(3, 5);
        graph1.addUnDirectedEdge(4, 5);
        graph1.addUnDirectedEdge(5, 6);
        System.out.println(graph1.printAdjacencyList());

        System.out.println("Breadth First Search ");
        graph1.bfs();
        System.out.println();
        System.out.println("Depth First Search");
        graph1.dfs();

    }
    private static ArrayList<GraphNodeList> getNodeList() {
        ArrayList<GraphNodeList> nodeList = new ArrayList<>();
        nodeList.add(new GraphNodeList("A",0));
        nodeList.add(new GraphNodeList("B",1));
        nodeList.add(new GraphNodeList("C",2));
        nodeList.add(new GraphNodeList("D",3));
        nodeList.add(new GraphNodeList("E",4));
        nodeList.add(new GraphNodeList("F",5));
        nodeList.add(new GraphNodeList("G",6));
        return nodeList;
    }
}
