import java.util.Comparator;

public class BikeHorsePowerCompare implements Comparator<Bike> {

    public int compare(Bike bike1, Bike bike2) {
        int horsePower1 = bike1.getHorsePower();
        int horsePower2 = bike2.getHorsePower();
        return horsePower2 - horsePower1;
    }
}
