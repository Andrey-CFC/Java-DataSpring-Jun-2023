package entities.inheritance;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "truck")
public class Truck extends TransportationVehicle {
    private final static String type = "TRUCK";
    private int numOfContainers;

    public Truck(){ }
    public Truck(String type, int numOfContainers, int loadCapacity) {
        super(type,loadCapacity);
        this.numOfContainers = numOfContainers; }

    public int getNumOfContainers() {
        return numOfContainers;
    }

    public void setNumOfContainers(int numOfContainers) {
        this.numOfContainers = numOfContainers;
    }
}

