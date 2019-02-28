package se.lexicon.garage;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        Garage garage = null;
        try {
            garage = new Garage();
        } catch (SQLException e) {
            e.printStackTrace();
        }

       /* for(int i=0; i<5; i++) {
            garage.park(new Car("Volvo"));
        }*/

        //System.out.println(garage.find(0));
        
        System.out.println(garage);

        //garage.unpark(0);

        //UserInterface ui = new UserInterface(garage);
    }
}
