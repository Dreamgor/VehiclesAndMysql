package se.lexicon.garage;

import org.junit.Test;
import se.lexicon.garage.Car;
import se.lexicon.garage.Garage;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;


class GarageTest extends Garage{

  public GarageTest() throws SQLException {
  }

  @Test
  void parkTest() {
    Garage g = null;
    try {
      g = new Garage();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    Car c = new Car("Mercedes");
    assertEquals(72, g.getVehicles().size());
    g.park(c);
    assertEquals(72, g.getVehicles().size());
  }

  @Test
  void find(){
    Garage testGarage = null;
    try {
      testGarage = new Garage();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    Car testCar1 = new Car("TestOne");
    Car testCar2 = new Car("TestTwo");
    Car testCar3 = new Car("TestThree");
    Car testCar4 = new Car("TestFour");

    int ticket1 = testGarage.park(testCar1);
    int ticket2 = testGarage.park(testCar2);
    int ticket3 = testGarage.park(testCar3);
    int ticket4 = testGarage.park(testCar4);

    testGarage.unpark(ticket1);

    Vehicle target = testGarage.find(ticket3);

    testGarage.unpark(ticket1);
    testGarage.unpark(ticket2);

    assertEquals(testGarage.find(ticket2), testCar2);
  }
}