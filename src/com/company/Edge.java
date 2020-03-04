package com.company;

class Edge{

  Node start;
  Node nodeOut;
  boolean directed;

  public Edge(Node start, Node nodeOut, boolean directed){
    this.start = start;
    this.nodeOut = nodeOut;
    this.directed = directed;
  }



}
