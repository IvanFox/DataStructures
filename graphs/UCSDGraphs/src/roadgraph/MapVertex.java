package roadgraph;

import geography.GeographicPoint;

import java.util.HashSet;
import java.util.Set;

/**
 * @author IvanLis
 * @version 1.0
 * @since 28/12/2015.
 * <p>
 * UCSDGraphs
 */
public class MapVertex {
    private GeographicPoint location;
    private Set<MapEdge> adjEdges;

    public MapVertex(GeographicPoint location) {
        this.location = location;
        this.adjEdges = new HashSet<>();
    }

    public GeographicPoint getLocation() {
        return location;
    }


    public void addEdge(MapEdge edge) {
        adjEdges.add(edge);
    }

    public Set<MapEdge> getAdjEdges() {
        return adjEdges;
    }

    public Set<MapVertex> getNeighbours() {
        Set<MapVertex> set = new HashSet<>();
        adjEdges.stream().forEach(el -> set.add(el.getDestination()));
        return set;
    }

    @Override
    public String toString() {
        return "Vertex: " + location + "\nNeighbours: " + getNeighbours();
    }
}
