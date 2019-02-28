package se.lexicon.garage;

import java.sql.SQLException;
import java.util.ArrayList;

public class Garage implements GarageInterface<Vehicle> {

    private ArrayList<Vehicle> vehicles = new ArrayList<>(72);


//    {
//        for(int i=0; i<72; i++){
//            vehicles.add(new EmptyVehicle("empty"));
//        }
//    }
    public Garage() throws SQLException {
        vehicles = MysqlConnection.getVehiclesDB();
    }

    public int park(Vehicle vehicle){
        int lotNumber = -1;
        for(Vehicle v : vehicles) {
            if(v instanceof EmptyVehicle) {
                lotNumber = vehicles.indexOf(v);
                vehicles.add(lotNumber, vehicle);
                return vehicles.indexOf(vehicle);
            }
        }
        return lotNumber;
    }

    public Vehicle find(int parkingLot){
        return vehicles.get(parkingLot);
    }

    public Vehicle unpark(int parkingLot){
        Vehicle temp = vehicles.get(parkingLot);
        vehicles.remove(parkingLot);
        vehicles.add(parkingLot, new EmptyVehicle("empty"));
        return temp;
    }

    public ArrayList<Vehicle> getVehicles(){
        return vehicles;
    }

    public String toString() {
        String output = "";
        for(Vehicle vehicle : vehicles){
            output += "Lot nr "+vehicles.indexOf(vehicle)+": "+vehicle + "\n";
        }
        return output;
    }
}
