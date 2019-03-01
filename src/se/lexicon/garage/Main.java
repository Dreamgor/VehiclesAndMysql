package se.lexicon.garage;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Garage garage = null;
        Scanner sc = new Scanner(System.in);

        try {
            garage = new Garage();
        } catch (SQLException e) {
            e.printStackTrace();
        }

       /* for(int i=0; i<5; i++) {
            garage.park(new Car("Volvo"));
        }*/

        //System.out.println(garage.find(0));

        String tempBrand = sc.nextLine();
        int tempTopSpeed = sc.nextInt();

        Car c = new Car(tempBrand, tempTopSpeed);

        garage.park(c);

        System.out.println(garage);

        //garage.unpark(0);

        //UserInterface ui = new UserInterface(garage);
    }
}
