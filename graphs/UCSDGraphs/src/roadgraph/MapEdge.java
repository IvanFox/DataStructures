package roadgraph;

/**
 * @author IvanLis
 * @version 1.0
 * @since 24/12/2015.
 * <p>
 * UCSDGraphs
 */
public class MapEdge {
    private MapVertex from, destination;
    private String roadName, roadType;
    private double length;

    public MapEdge(MapVertex from, MapVertex destination, String roadName, String roadType, double length) {
        this.from = from;
        this.destination = destination;
        this.roadName = roadName;
        this.roadType = roadType;
        this.length = length;
    }

    public MapVertex getFrom() {
        return from;
    }

    public MapVertex getDestination() {
        return destination;
    }

    public String getRoadName() {
        return roadName;
    }

    public void setRoadName(String roadName) {
        this.roadName = roadName;
    }

    public String getRoadType() {
        return roadType;
    }

    public void setRoadType(String roadType) {
        this.roadType = roadType;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Road between: " + from + " and " + destination + "\nvia " + roadName + "\tRoad type: " + roadType;
    }
}
