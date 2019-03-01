package se.lexicon.garage;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class Garage implements GarageInterface<Vehicle> {

    private ArrayList<Vehicle> vehicles = new ArrayList<>(72);


//    {
//
//    }
    public Garage() throws SQLException {
        vehicles = MysqlConnection.getVehiclesDB();
        for(int i=vehicles.size(); i<72; i++){
            vehicles.add(new EmptyVehicle("empty"));
        }
    }

    public int park(Vehicle vehicle){
        int lotNumber = -1;
        Vehicle tempVehic = null;

        Iterator iter = vehicles.iterator();
        boolean keepLooping = true;

        while(iter.hasNext() && keepLooping) {
            tempVehic = (Vehicle) iter.next();
            if (tempVehic instanceof EmptyVehicle) {
                lotNumber = vehicles.indexOf(tempVehic);
                vehicles.add(lotNumber, vehicle);
                keepLooping = false;

            }
        }
//        for(Vehicle v : vehicles) {
//            if(v instanceof EmptyVehicle) {
//                lotNumber = vehicles.indexOf(v);
//                vehicles.add(lotNumber, vehicle);
//                tempVehic = v;
//                return vehicles.indexOf(vehicle);
//
//            }
//        }
        if(!keepLooping){
            try {
                MysqlConnection.addVehicle(vehicle);
            } catch (SQLException e) {
                e.printStackTrace();
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
