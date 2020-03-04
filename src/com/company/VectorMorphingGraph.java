package com.company;

import java.util.ArrayList;

public class VectorMorphingGraph {

    ArrayList<Node> nodes;
    ArrayList<VWFEdge> edges;
    boolean directed;
    int duration;


    VectorMorphingGraph(int [][][] adjacencyTable, boolean directed, int duration){

        // Error Cases
        if(adjacencyTable.length == 0){
            throw new IllegalArgumentException("Empty adjacency table");
        }
        for (int[][] ints : adjacencyTable) {
            if (adjacencyTable.length != ints.length) {
                throw new IllegalArgumentException("Invalid Adjacency Table - # of Rows not equal to # of Cols");
            }
        }

        this.directed = directed;
        this.duration = duration;

        for (int[][] nodes : adjacencyTable) {
            for (int[] weightVector: nodes) {
                if (weightVector != null && weightVector.length != duration) {
                    throw new IllegalArgumentException("Inconsistent duration of weight vectors");
                }
            }
        }

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
                if(adjacencyTable[i][j] != null) {
                    Node outNode = nodes.get(j);
                    VWFEdge edge = new VWFEdge(node, outNode, directed, adjacencyTable[i][j]);
                    node.edges.add(edge);
                    if(!directed)
                        outNode.edges.add(edge);
                    edges.add(edge);
                }
            }
        }


    }
}
