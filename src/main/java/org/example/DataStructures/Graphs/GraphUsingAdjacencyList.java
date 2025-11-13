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

    public void addDirectedEdge(int firstIndex, int secondIndex){
        GraphNodeList first = nodeList.get(firstIndex);
        GraphNodeList second = nodeList.get(secondIndex);
        first.neighbours.add(second);
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

    void topologicalVisit(GraphNodeList node,Stack<GraphNodeList> stack){
        for (GraphNodeList neighbour : node.neighbours){
            if (!neighbour.isVisited){
                topologicalVisit(neighbour,stack);
            }
        }
        node.isVisited=true;
        stack.push(node);
    }

    void topologicalSort(){
        Stack<GraphNodeList> stack = new Stack<>();
        for (GraphNodeList node : nodeList){
            if (!node.isVisited){
                topologicalVisit(node,stack);
            }
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop().name+" ");
        }
    }
    public static void main(String[] args) {
        ArrayList<GraphNodeList> nodeList = new ArrayList<>();
        nodeList.add(new GraphNodeList("A", 0));
        nodeList.add(new GraphNodeList("B", 1));
        nodeList.add(new GraphNodeList("C", 2));
        nodeList.add(new GraphNodeList("D", 3));
        nodeList.add(new GraphNodeList("E", 4));

        ArrayList<GraphNodeList> nodeList2 = new ArrayList<>();
        nodeList2.add(new GraphNodeList("A", 0));
        nodeList2.add(new GraphNodeList("B", 1));
        nodeList2.add(new GraphNodeList("C", 2));
        nodeList2.add(new GraphNodeList("D", 3));
        nodeList2.add(new GraphNodeList("E", 4));
        nodeList2.add(new GraphNodeList("F", 5));
        nodeList2.add(new GraphNodeList("G", 6));
        nodeList2.add(new GraphNodeList("H", 7));

        GraphUsingAdjacencyList graph = new GraphUsingAdjacencyList(nodeList);
        graph.addUnDirectedEdge(0, 1);
        graph.addUnDirectedEdge(0, 2);
        graph.addUnDirectedEdge(0, 3);
        graph.addUnDirectedEdge(2, 3);
        graph.addUnDirectedEdge(1, 4);
        graph.addUnDirectedEdge(3, 4);

        GraphUsingAdjacencyList graph2 = new GraphUsingAdjacencyList(nodeList2);
        graph2.addDirectedEdge(0,2);
        graph2.addDirectedEdge(2,4);
        graph2.addDirectedEdge(4,7);
        graph2.addDirectedEdge(4,5);
        graph2.addDirectedEdge(5,6);
        graph2.addDirectedEdge(1,2);
        graph2.addDirectedEdge(1,3);
        graph2.addDirectedEdge(3,5);

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

        System.out.println();
        System.out.println("Topological Sort");
        graph2.topologicalSort();

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
