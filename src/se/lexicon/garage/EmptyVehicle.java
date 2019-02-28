package se.lexicon.garage;

public class EmptyVehicle extends Vehicle{

    public EmptyVehicle(){
        this.brand = "Empty";
    }

    public EmptyVehicle(String brand) {
        super(brand);
    }
}
