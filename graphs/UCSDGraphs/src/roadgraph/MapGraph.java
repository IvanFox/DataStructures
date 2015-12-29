/**
 * @author UCSD MOOC development team and YOU
 * <p>
 * A class which reprsents a graph of geographic locations
 * Nodes in the graph are intersections between
 */
package roadgraph;


import geography.GeographicPoint;
import util.GraphLoader;

import java.util.*;
import java.util.function.Consumer;

/**
 * @author UCSD MOOC development team and YOU
 *         <p>
 *         A class which represents a graph of geographic locations
 *         Nodes in the graph are intersections between
 */
public class MapGraph {
    private Map<GeographicPoint, MapVertex> geoPointToVertex;
    private int numEdges = 0;
    //TODO: Add your member variables here in WEEK 2


    /**
     * Create a new empty MapGraph
     */
    public MapGraph() {
        geoPointToVertex = new HashMap<>();
    }

    /**
     * Get the number of vertices (road intersections) in the graph
     *
     * @return The number of vertices in the graph.
     */
    public int getNumVertices() {//TODO: Implement this method in WEEK 2
        return geoPointToVertex.keySet().size();
    }

    /**
     * Return the intersections, which are the vertices in this graph.
     *
     * @return The vertices in this graph as GeographicPoints
     */
    public Set<GeographicPoint> getVertices() {
        return geoPointToVertex.keySet();
    }

    /**
     * Get the number of road segments in the graph
     *
     * @return The number of edges in the graph.
     */
    public int getNumEdges() {
        //TODO: Implement this method in WEEK 2
        return numEdges;
    }


    /**
     * Add a node corresponding to an intersection at a Geographic Point
     * If the location is already in the graph or null, this method does
     * not change the graph.
     *
     * @param location The location of the intersection
     * @return true if a node was added, false if it was not (the node
     * was already in the graph, or the parameter is null).
     */
    public boolean addVertex(GeographicPoint location) {
        if (getVertices().contains(location)) {
            return false;
        }
        geoPointToVertex.put(location, new MapVertex(location));
        return true;
    }

    /**
     * Adds a directed edge to the graph from pt1 to pt2.
     * Precondition: Both GeographicPoints have already been added to the graph
     *
     * @param from     The starting point of the edge
     * @param to       The ending point of the edge
     * @param roadName The name of the road
     * @param roadType The type of the road
     * @param length   The length of the road, in km
     * @throws IllegalArgumentException If the points have not already been
     *                                  added as nodes to the graph, if any of the arguments is null,
     *                                  or if the length is less than 0.
     */
    public void addEdge(GeographicPoint from, GeographicPoint to, String roadName, String roadType,
                        double length) throws IllegalArgumentException {
        MapVertex vertexFrom = geoPointToVertex.get(from);
        MapVertex vertexTo = geoPointToVertex.get(to);

        if (!edgeValidator(vertexFrom, vertexTo, roadName, roadType, length)) {
            throw new IllegalArgumentException();
        }

        vertexFrom.addEdge(new MapEdge(vertexFrom, vertexTo, roadName, roadType, length));
        numEdges++;
    }

    private boolean edgeValidator(MapVertex from, MapVertex to, String roadName, String roadType,
                                  double length) {
        // check if two graphic points are already exist in the set of vertices
        if (from == null || to == null) {
            return false;
        } else if (roadName == null || roadType == null) {
            System.out.println("Road name or road type is not initialised");
            return false;
        } else if (length < 0) {
            System.out.println("Length argument is incorrect");
            return false;
        }
        return true;

    }

    /**
     * Find the path from start to goal using breadth first search
     *
     * @param start The starting location
     * @param goal  The goal location
     * @return The list of intersections that form the shortest (unweighted)
     * path from start to goal (including both start and goal).
     */
    public List<GeographicPoint> bfs(GeographicPoint start, GeographicPoint goal) {
        // Dummy variable for calling the search algorithms
        Consumer<GeographicPoint> temp = (x) -> {
        };
        return bfs(start, goal, temp);
    }

    /**
     * Find the path from start to goal using breadth first search
     *
     * @param start        The starting location
     * @param goal         The goal location
     * @param nodeSearched A hook for visualization.  See assignment instructions for how to use it.
     * @return The list of intersections that form the shortest (unweighted)
     * path from start to goal (including both start and goal).
     */
    public List<GeographicPoint> bfs(GeographicPoint start,
                                     GeographicPoint goal, Consumer<GeographicPoint> nodeSearched) {

        Map<MapVertex, MapVertex> parentMap = new HashMap<>();
        boolean found = bfsSearch(start, goal, parentMap, nodeSearched);

        if (!found) {
            System.out.println("No path exists");
            return null;
        }
        return constructPath(parentMap, geoPointToVertex.get(goal), geoPointToVertex.get(start));
    }

    private boolean bfsSearch(GeographicPoint start, GeographicPoint goal, Map<MapVertex, MapVertex> parent, Consumer<GeographicPoint>
            nodeSearched) {
        MapVertex startVertex = geoPointToVertex.get(start);
        MapVertex goalVertex = geoPointToVertex.get(goal);
        boolean pathExist = false;

        Set<MapVertex> visited = new HashSet<>();
        Queue<MapVertex> unVisited = new LinkedList<>();
        unVisited.add(startVertex);
        while (!unVisited.isEmpty()) {
            MapVertex curr = unVisited.remove();
            nodeSearched.accept(curr.getLocation());
            if (curr == goalVertex) {
                pathExist = true;
                break;
            }
            Set<MapVertex> neighbours = curr.getNeighbours();
            neighbours.stream().forEach(el -> {
                if (!visited.contains(el)) {
                    visited.add(el);
                    parent.put(el, curr);
                    unVisited.add(el);
                }
            });
        }
        return pathExist;
    }

    private List<GeographicPoint> constructPath(Map<MapVertex, MapVertex> parentMap, MapVertex goal, MapVertex start) {

        LinkedList<GeographicPoint> path = new LinkedList<>();
        MapVertex curr = goal;
        while (curr != start) {
            path.addFirst(curr.getLocation());
            curr = parentMap.get(curr);

        }
        path.addFirst(start.getLocation());
        return path;
    }


    /**
     * Find the path from start to goal using Dijkstra's algorithm
     *
     * @param start The starting location
     * @param goal  The goal location
     * @return The list of intersections that form the shortest path from
     * start to goal (including both start and goal).
     */
    public List<GeographicPoint> dijkstra(GeographicPoint start, GeographicPoint goal) {
        // Dummy variable for calling the search algorithms
        // You do not need to change this method.
        Consumer<GeographicPoint> temp = (x) -> {
        };
        return dijkstra(start, goal, temp);
    }

    /**
     * Find the path from start to goal using Dijkstra's algorithm
     *
     * @param start        The starting location
     * @param goal         The goal location
     * @param nodeSearched A hook for visualization.  See assignment instructions for how to use it.
     * @return The list of intersections that form the shortest path from
     * start to goal (including both start and goal).
     */
    public List<GeographicPoint> dijkstra(GeographicPoint start,
                                          GeographicPoint goal, Consumer<GeographicPoint> nodeSearched) {
        // TODO: Implement this method in WEEK 3

        // Hook for visualization.  See writeup.
        //nodeSearched.accept(next.getLocation());

        return null;
    }

    /**
     * Find the path from start to goal using A-Star search
     *
     * @param start The starting location
     * @param goal  The goal location
     * @return The list of intersections that form the shortest path from
     * start to goal (including both start and goal).
     */
    public List<GeographicPoint> aStarSearch(GeographicPoint start, GeographicPoint goal) {
        // Dummy variable for calling the search algorithms
        Consumer<GeographicPoint> temp = (x) -> {
        };
        return aStarSearch(start, goal, temp);
    }

    /**
     * Find the path from start to goal using A-Star search
     *
     * @param start        The starting location
     * @param goal         The goal location
     * @param nodeSearched A hook for visualization.  See assignment instructions for how to use it.
     * @return The list of intersections that form the shortest path from
     * start to goal (including both start and goal).
     */
    public List<GeographicPoint> aStarSearch(GeographicPoint start,
                                             GeographicPoint goal, Consumer<GeographicPoint> nodeSearched) {
        // TODO: Implement this method in WEEK 3

        // Hook for visualization.  See writeup.
        //nodeSearched.accept(next.getLocation());

        return null;
    }


    public static void main(String[] args) {
        System.out.print("Making a new map...");
        MapGraph theMap = new MapGraph();
        System.out.print("DONE. \nLoading the map...");
        GraphLoader.loadRoadMap("/users/ivanlis/IdeaProjects/UCSDGraphs/data/maps/new_york.map", theMap);
        System.out.println("DONE.");

        System.out.println("Num nodes: " + theMap.getNumVertices());
        System.out.println("Num edges: " + theMap.getNumEdges());


        Iterator<GeographicPoint> it = theMap.getVertices().iterator();
        GeographicPoint last = null;
        while (it.hasNext()) {
            last = it.next();
        }
        System.out.println("Start is: " + theMap.getVertices().iterator().next());
        System.out.println("Goal is:" + last);
        System.out.println(theMap.bfs(theMap.getVertices().iterator().next(), last));


        // You can use this method for testing.

		/* Use this code in Week 3 End of Week Quiz
        MapGraph theMap = new MapGraph();
		System.out.print("DONE. \nLoading the map...");
		GraphLoader.loadRoadMap("data/maps/utc.map", theMap);
		System.out.println("DONE.");

		GeographicPoint start = new GeographicPoint(32.868629, -117.215393);
		GeographicPoint end = new GeographicPoint(32.868629, -117.215393);
		
		List<GeographicPoint> route = theMap.dijkstra(start,end);
		List<GeographicPoint> route2 = theMap.aStarSearch(start,end);

		*/

    }

}
