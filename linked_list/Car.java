package dataStructures.linked_list;

/**
 * Created by IvanLis on 13/10/15.
 */
public class Car {

    private String model;
    private String type;
    private double engingeSize;


    public Car(String model, String type, double engingeSize) {
        this.model = model;
        this.type = type;
        this.engingeSize = engingeSize;
    }

    public String getModel() {
        return model;
    }

    public String getType() {
        return type;
    }

    public double getEngingeSize() {
        return engingeSize;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setEngingeSize(double engingeSize) {
        this.engingeSize = engingeSize;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", type='" + type + '\'' +
                ", engingeSize=" + engingeSize +
                '}';
    }

}
