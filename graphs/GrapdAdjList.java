package dataStructures.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author IvanLis
 * @version 1.0
 * @since 22/12/2015.
 * <p>
 * labs
 */
public class GrapdAdjList extends Graph {
    private Map<Integer, ArrayList<Integer>> adjListMap;


    @Override
    public void implementAddVertex() {
        int v = getNumVertices();
        ArrayList<Integer> neighbors = new ArrayList<>();
        adjListMap.put(v, neighbors);
    }

    @Override
    public void implementAddEdge(int v, int w) {
        adjListMap.get(v).add(w);
    }

    @Override
    public List<Integer> getNeighbors(int v) {
        return null;
    }
}
