package Labs_O.Lab_4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MainRoadAndVehiclesTests{

    PoliceMan policeMan_1;
    FireFighter FireFighter_1;
    FireFighter FireFighter_2;
    FireFighter FireFighter_3;

    Vehicle<PoliceMan> policeCar;
    Vehicle<Person> bus;
    Vehicle<FireFighter> fireTruck;
    Vehicle<Person> Taxi;

    Road road;

    @Before
    public void SetUp(){
        policeMan_1 = new PoliceMan();
        FireFighter_1 = new FireFighter();
        FireFighter_2 = new FireFighter();
        FireFighter_3 = new FireFighter();

        policeCar = new PoliceCar(1);
        bus = new Bus(3);
        fireTruck = new FireTruck(2);
        Taxi = new Taxi(3);

        road = new Road();
    }

    @Test(expected = IllegalArgumentException.class)
    public void addingMorePeopleThanCapacityToTheTaxi(){
        Taxi.addPassengerToTheVehicle(policeMan_1);
        Taxi.addPassengerToTheVehicle(FireFighter_1);
        Taxi.addPassengerToTheVehicle(FireFighter_2);
    }

    @Test
    public void CheckIfCapacityCounterWorking(){
        Taxi.addPassengerToTheVehicle(policeMan_1);
        Assert.assertEquals(Taxi.getActualAmountOfSeats(), 2);
    }

    @Test
    public void getOutPassengerListCheck(){
        fireTruck.addPassengerToTheVehicle(FireFighter_2);
        fireTruck.getOutPassengerToTheVehicle(FireFighter_2);
        assert(!fireTruck.passengerList.contains(FireFighter_2));
    }

    @Test
    public void getOutPassengerCounterCheck(){
        fireTruck.addPassengerToTheVehicle(FireFighter_2);
        fireTruck.getOutPassengerToTheVehicle(FireFighter_2);
        Assert.assertEquals(fireTruck.passengerCounter, 0);
    }

    @Test
    public void getMaxAmountOfSeatsCheck(){
        Assert.assertEquals(bus.getMaximalAmountOfSeats(), 3);
    }

    @Test
    public void RoadHumanCounterCheck(){
        fireTruck.addPassengerToTheVehicle(FireFighter_1);
        fireTruck.addPassengerToTheVehicle(FireFighter_2);
        road.addCarToRoad(fireTruck);
        Assert.assertEquals(road.getCountOfHumans(),2);
    }

    @Test
    public void RoadHumanCounterCheckIfThereAre0Human(){
        Assert.assertEquals(road.getCountOfHumans(),0);
    }

    @Test
    public void AddCarToRoadCheck(){
        fireTruck.addPassengerToTheVehicle(FireFighter_1);
        fireTruck.addPassengerToTheVehicle(FireFighter_2);
        road.addCarToRoad(fireTruck);
        assert(road.carsInRoad.contains(fireTruck));
    }
}
