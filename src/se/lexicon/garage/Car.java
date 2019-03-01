package se.lexicon.garage;

public class Car extends Vehicle{

    private int topSpeed;

    public Car(String brand){
        super(brand);
    }

    public Car(String brand, int topSpeed){
        setBrand(brand);
        setTopSpeed(topSpeed);
    }

    public void setTopSpeed(int topSpeed) {
        if(topSpeed >= 0){
            this.topSpeed = topSpeed;
        }
        else{
            throw new IllegalArgumentException("Topspeed can not be negative.");
        }
    }

    public int getTopSpeed() {
        return topSpeed;
    }
}
