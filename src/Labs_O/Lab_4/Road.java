package Labs_O.Lab_4;

import java.util.ArrayList;
import java.util.List;

public class Road {
    public List<Vehicle> carsInRoad = new ArrayList<>();
    public int getCountOfHumans(){
        int humanCounter = 0;

        for(var v : carsInRoad){
            humanCounter += v.passengerCounter;
        }

        return humanCounter;
    }
    public void addCarToRoad(Vehicle vehicle) {
        carsInRoad.add(vehicle);
    }
}
