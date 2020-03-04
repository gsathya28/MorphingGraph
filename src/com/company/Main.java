package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        /*
        int[][] adjacencyTable1 = {
                {-1, 2, 5, -1},
                {2, -1, -1, 4},
                {5, -1, -1, 7},
                {-1, 4, 7, -1}
        };
         */

        int[][] adjacencyTable2 = generateRandomAdjTable(6, 10, false);

        Graph mGraph = new Graph(adjacencyTable2, false, true);
        mGraph.BFS(mGraph.nodes.get(0));
    }

    public static int[][] generateRandomAdjTable(int numNodes, int maxWeight, boolean directed){
        int[][] adjacencyTable = new int[numNodes][numNodes];

        for(int i = 0; i < numNodes; i++)
            for(int j = 0; j < numNodes; j++)
                adjacencyTable[i][j] = -1;

        for(int i = 0; i < numNodes; i++){
            int start = directed ? 0 : i + 1;
            for(int j = start; j < numNodes; j++){
                // No paths to self
                if(i == j)
                    continue;

                Random random = new Random();
                // Randomly decide if there's an edge here
                int x = random.nextInt(2);  // Check distrib later
                if(x == 1){
                    // Randomly decide the weight here
                    adjacencyTable[i][j] = random.nextInt(maxWeight - 1) + 1;
                }
            }
        }

        return adjacencyTable;
    }



}
