package com.company;
import java.util.*;

class Graph {

  ArrayList<Node> nodes;
  ArrayList<Edge> edges;
  boolean directed;
  boolean weighted;

  public Graph(ArrayList<Node> nodes, ArrayList<Edge> edges){
    this.nodes = nodes;
    this.edges = edges;
    // Check validity later.
  }

  public Graph(int[][] adjacencyTable, boolean directed, boolean weighted){

    // Error Cases
    if(adjacencyTable.length == 0){
      throw new IllegalArgumentException("Empty adjacency table");
    }
    for (int[] ints : adjacencyTable) {
      if (adjacencyTable.length != ints.length) {
        throw new IllegalArgumentException("Invalid Adjacency Table - # of Rows not equal to # of Cols");
      }
    }

    this.directed = directed;
    this.weighted = weighted;

    // Generate Nodes
    this.nodes = new ArrayList<>();
    for(int i = 0; i < adjacencyTable.length; i++)
      nodes.add(new Node());

    // Generate Edges
    this.edges = new ArrayList<>();
    for(int i = 0; i < nodes.size(); i++) {
      Node node = nodes.get(i);
      int start = directed ? 0 : i + 1;
      for(int j = start; j < nodes.size(); j++){
        if(adjacencyTable[i][j] > -1) {
          Node outNode = nodes.get(j);
          Edge edge = weighted ?
                  new WeightedEdge(node, outNode, directed, adjacencyTable[i][j]):
                  new Edge(node, outNode, directed);
          node.edges.add(edge);
          if(!directed)
            outNode.edges.add(edge);
          edges.add(edge);
        }
      }
    }
  }

  public void BFS(Node start){

    BFSQueue<Node> queue = new BFSQueue<>();
    queue.enqueue(start);
    start.bfsFlag = 1;

    while(!queue.isEmpty()){
      Node node = queue.dequeue();
      if(Debug.PRINT)
        System.out.print("Node " + node.id + ":\t");

      for (Edge edge : node.edges) {
        if(edge.nodeOut.bfsFlag == 0) {
          if(Debug.PRINT)
            System.out.print("Node " + edge.nodeOut.id + "\t");
          queue.enqueue(edge.nodeOut);
          edge.nodeOut.bfsFlag = 1;
        }
      }

      if(Debug.PRINT)
        System.out.println();
    }

    for (Node node : nodes) {
      node.bfsFlag = 0;
    }

  }

  @Override
  public String toString() {
    return "MorphingGraph{" +
            "nodes=" + nodes +
            '}';
  }


}

