package Labs_O.Lab_4;

import java.util.ArrayList;
import java.util.List;


public abstract class Vehicle<T> {

    public int maximalNumberOfPassengers;
    public int passengerCounter;
    public List<T> passengerList;

    public Vehicle(int numberOfPassengers) {
        this.maximalNumberOfPassengers = numberOfPassengers;
        this.passengerCounter = 0;
        this.passengerList = new ArrayList<T>();
    }

    public void addPassengerToTheVehicle(T p){
        if(getActualAmountOfSeats() > 0){
            passengerList.add(p);
            passengerCounter++;
        }
        else throw new IllegalArgumentException();
    }

    public void getOutPassengerToTheVehicle(T p){
        if(passengerList.remove(p)){
            passengerCounter--;
        }
    }

    public int getMaximalAmountOfSeats(){
        return maximalNumberOfPassengers;
    }

    public int getActualAmountOfSeats(){
        return maximalNumberOfPassengers - passengerCounter;
    }


}
