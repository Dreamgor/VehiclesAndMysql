package se.lexicon.garage;

public abstract class Vehicle {

    protected String brand;

    public Vehicle(String brand){
        setBrand(brand);
    }

  protected Vehicle() {
  }

  public void setBrand(String brand) {
        if (brand.matches("^[a-zA-ZåäöüÅÄÖÜ0-9\\s\\-]+$") && brand.length() > 0) {
            this.brand = brand;
        } else {
            throw new IllegalArgumentException("You cannot set the brand with zero or illegal characters.");
        }
    }

  public String getBrand() {
    return brand;
  }

  public String toString() {
        return brand;
    }
}
