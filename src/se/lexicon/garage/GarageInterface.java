package se.lexicon.garage;

public interface GarageInterface<V> {

    int park(V vehicle);

    V find(int parkingLot);

    V unpark(int parkingLot);

    @Override
    String toString();

}
