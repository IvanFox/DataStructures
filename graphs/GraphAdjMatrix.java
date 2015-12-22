package dataStructures.graphs;

import java.util.List;

/**
 * @author IvanLis
 * @version 1.0
 * @since 22/12/2015.
 * <p>
 * labs
 */
public class GraphAdjMatrix extends Graph {

    private int[][] adjMatrix;

    @Override
    public void implementAddVertex() {
        int v = getNumVertices();
        if (v >= adjMatrix.length) {
            int[][] newAdjMatrix = new int[v*2][v*2];

            for (int i = 0; i < adjMatrix.length; i++) {
                for (int j = 0; j < adjMatrix.length; j++) {
                    newAdjMatrix[i][j] = adjMatrix[i][j];
                }
            }
            adjMatrix = newAdjMatrix;
        }
        for (int i = 0; i < adjMatrix[v].length ; i++) {
            adjMatrix[v][i] = 0;
        }
    }

    public void implementAddEdge(int v, int w) {
        adjMatrix[v][w] = 1;
    }

    @Override
    public List<Integer> getNeighbors(int v) {
        return null;
    }
}
