package com.company;

public class WeightedEdge extends Edge {

    int weight;

    public WeightedEdge(Node startNode, Node outNode, boolean directed, int weight){
        super(startNode, outNode, directed);
        this.weight = weight;
    }

}
