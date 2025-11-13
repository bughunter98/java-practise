package org.example.DataStructures.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

// if we know target is close use BFS
// if we know target vertex is buried very deep , use DFS

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

    public void addDirectedEdge(int i , int j){
        adjacencyMatrix[i][j]=1;
    }

    void topologicalVisit(GraphNode node,Stack<GraphNode> stack){
        ArrayList<GraphNode> neighBours = getNeighbours(node);
        for (GraphNode neighbour : neighBours){
            if (!neighbour.isVisited){
                topologicalVisit(neighbour,stack);
            }
        }
        node.isVisited=true;
        stack.push(node);
    }

    void topologicalSort(){
        Stack<GraphNode> stack = new Stack<>();
        for (GraphNode node : nodeList){
            if (!node.isVisited){
                topologicalVisit(node,stack);
            }
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop().name+" ");
        }
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

    public void dfs(){
        // as BFS already triggered before this , all the isVisited would have been true . so making them false
        // ipudu paina already bfs method main method lo call chesa kabatti anni noded ki isVisited true aipotadi so
        // adhi false cheyalo kabati kinda foreachloop raasa
        nodeList.forEach(node -> {
            if (node.isVisited) {
                node.isVisited=false;
            }}
        );
        for (GraphNode node : nodeList){
            if (!node.isVisited){
                dfsVisit(node);
            }
        }
    }

    private void dfsVisit(GraphNode node){
        Stack<GraphNode> stack = new Stack<>();
        stack.add(node);
        while (!stack.isEmpty()){
            GraphNode currentNode = stack.pop();
            currentNode.isVisited=true;
            System.out.print(currentNode.name+" ");
            ArrayList<GraphNode> neighBours = getNeighbours(currentNode);
            for (GraphNode neighbour : neighBours){
                if (!neighbour.isVisited){
                    stack.push(neighbour);
                    neighbour.isVisited=true;
                }
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
        System.out.println("Breadth First Search ");
        graph.bfs();
        System.out.println();
        System.out.println("Depth First Search");
        graph.dfs();
        System.out.println();

        List<GraphNode> nodeList1 = getNodeList();

        GraphUsingAdjacencyMatrix graph1 = new GraphUsingAdjacencyMatrix(nodeList1);
        graph1.addUndirectedEdge(0,1);
        graph1.addUndirectedEdge(0,2);
        graph1.addUndirectedEdge(1,3);
        graph1.addUndirectedEdge(1,6);
        graph1.addUndirectedEdge(2,3);
        graph1.addUndirectedEdge(2,4);
        graph1.addUndirectedEdge(3,5);
        graph1.addUndirectedEdge(4,5);
        graph1.addUndirectedEdge(5,6);
        System.out.println(graph1.printAdjacencyMatrix());

        System.out.println("Breadth First Search ");
        graph1.bfs();
        System.out.println();
        System.out.println("Depth First Search");
        graph1.dfs();
        List<GraphNode> nodeList2= new ArrayList<>();
        nodeList2.add(new GraphNode("A",0));
        nodeList2.add(new GraphNode("B",1));
        nodeList2.add(new GraphNode("C",2));
        nodeList2.add(new GraphNode("D",3));
        nodeList2.add(new GraphNode("E",4));
        nodeList2.add(new GraphNode("F",5));
        nodeList2.add(new GraphNode("G",6));
        nodeList2.add(new GraphNode("H",7));

        GraphUsingAdjacencyMatrix graph2 = new GraphUsingAdjacencyMatrix(nodeList2);
        graph2.addDirectedEdge(0,2);
        graph2.addDirectedEdge(2,4);
        graph2.addDirectedEdge(4,7);
        graph2.addDirectedEdge(4,5);
        graph2.addDirectedEdge(5,6);
        graph2.addDirectedEdge(1,2);
        graph2.addDirectedEdge(1,3);
        graph2.addDirectedEdge(3,5);
        System.out.println();
        System.out.println("Topological Sort");
        graph2.topologicalSort();

    }

    private static List<GraphNode> getNodeList() {
        List<GraphNode> nodeList = new ArrayList<>();
        nodeList.add(new GraphNode("A",0));
        nodeList.add(new GraphNode("B",1));
        nodeList.add(new GraphNode("C",2));
        nodeList.add(new GraphNode("D",3));
        nodeList.add(new GraphNode("E",4));
        nodeList.add(new GraphNode("F",5));
        nodeList.add(new GraphNode("G",6));
        return nodeList;
    }
}
