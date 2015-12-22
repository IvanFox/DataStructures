package dataStructures.graphs;

import java.util.List;

/**
 * @author IvanLis
 * @version 1.0
 * @since 22/12/2015.
 * <p>
 * labs
 */
public abstract class Graph {
    private int numVerticies;
    private int numEdges;


    public Graph() {
        this.numEdges = 0;
        this.numVerticies = 0;
    }

    public int getNumVerticies() {
        return numVerticies;
    }

    public int getNumEdges() {
        return numEdges;
    }


    public void addVertex() {
        implementAddVertex();
        numVerticies++;
    }

    public void addEdge() {
        implementAddEdge();
        numEdges++;
    }

    public abstract void implementAddVertex();

    public abstract void implementAddEdge();

    public abstract List<Integer> getNeighbors(int v);

}
