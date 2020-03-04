package com.company;
import java.util.ArrayList;

class Node{
  static int counter = 0;
  ArrayList<Edge> edges = new ArrayList<>();
  int id;
  int bfsFlag = 0;

  public Node(){
    this.id = counter;
    counter++;
  }
}
