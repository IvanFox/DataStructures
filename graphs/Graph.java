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
    private int numVertices;
    private int numEdges;


    public Graph() {
        this.numEdges = 0;
        this.numVertices = 0;
    }

    public int getNumVertices() {
        return numVertices;
    }

    public int getNumEdges() {
        return numEdges;
    }

    public void addVertex() {
        implementAddVertex();
        numVertices++;
    }

    public void addEdge(int v, int w) {
        implementAddEdge(v, w);
        numEdges++;
    }

    public abstract void implementAddVertex();

    public abstract void implementAddEdge(int v, int w);

    public abstract List<Integer> getNeighbors(int v);

}
