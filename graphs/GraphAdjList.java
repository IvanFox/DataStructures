package dataStructures.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author IvanLis
 * @version 1.0
 * @since 22/12/2015.
 * <p>
 * labs
 */
public class GraphAdjList extends Graph {


    private Map<Integer, ArrayList<Integer>> adjListsMap;

    /**
     * Create a new empty Graph
     */
    public GraphAdjList() {
        adjListsMap = new HashMap<>();
    }

    /**
     * Implement the abstract method for adding a vertex.
     */
    public void implementAddVertex() {
        int v = getNumVertices();
        // System.out.println("Adding vertex "+v);
        ArrayList<Integer> neighbors = new ArrayList<>();
        adjListsMap.put(v, neighbors);
    }

    /**
     * Implement the abstract method for adding an edge.
     *
     * @param v the index of the start point for the edge.
     * @param w the index of the end point for the edge.
     */
    public void implementAddEdge(int v, int w) {
        (adjListsMap.get(v)).add(w);

    }

    /**
     * Implement the abstract method for finding all
     * out-neighbors of a vertex.
     * If there are multiple edges between the vertex
     * and one of its out-neighbors, this neighbor
     * appears once in the list for each of these edges.
     *
     * @param v the index of vertex.
     * @return List<Integer> a list of indices of vertices.
     */
    public List<Integer> getNeighbors(int v) {
        return new ArrayList<Integer>(adjListsMap.get(v));
    }

    /**
     * Implement the abstract method for finding all
     * in-neighbors of a vertex.
     * If there are multiple edges from another vertex
     * to this one, the neighbor
     * appears once in the list for each of these edges.
     *
     * @param v the index of vertex.
     * @return List<Integer> a list of indices of vertices.
     */
    public List<Integer> getInNeighbors(int v) {
        List<Integer> inNeighbors = new ArrayList<Integer>();
        for (int u : adjListsMap.keySet()) {
            //iterate through all edges in u's adjacency list and
            //add u to the inNeighbor list of v whenever an edge
            //with startpoint u has endpoint v.
            for (int w : adjListsMap.get(u)) {
                if (v == w) {
                    inNeighbors.add(u);
                }
            }
        }
        return inNeighbors;
    }


    /**
     * Implement the abstract method for finding all
     * vertices reachable by two hops from v.
     *
     * @param v the index of vertex.
     * @return List<Integer> a list of indices of vertices.
     */
     public List<Integer> getDistance2(int v) {
         List<Integer> reachable = getNeighbors(v);
         Set<Integer> total = new HashSet<>(getNeighbors(v));
         for (Integer i: reachable) {
             List<Integer> hop1 = getNeighbors(i);
             total.addAll(hop1);
             for (Integer j : hop1) {
                 List <Integer> hop2 = getNeighbors(j);
                 total.addAll(hop2);
             }
         }
         total.remove(v);
         return new ArrayList<>(total);
    }

    /**
     * Generate string representation of adjacency list
     *
     * @return the String
     */
    public String adjacencyString() {
        String s = "Adjacency list";
        s += " (size " + getNumVertices() + "+" + getNumEdges() + " integers):";

        for (int v : adjListsMap.keySet()) {
            s += "\n\t" + v + ": ";
            for (int w : adjListsMap.get(v)) {
                s += w + ", ";
            }
        }
        return s;
    }
}
