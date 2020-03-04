package com.company;


/**
 * Vector Weight Function Edge
 */
public class VWFEdge extends Edge {

    int[] weightVector;

    VWFEdge(Node start, Node nodeOut, boolean directed, int[] weights){
        super(start, nodeOut, directed);
        this.weightVector = weights;
    }


}
