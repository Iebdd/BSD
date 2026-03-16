import java.util.Comparator;

public class BikeBrandCompare implements Comparator<Bike> {

    public int compare(Bike bike1, Bike bike2) {
        String brand1 = bike1.getBrand().toLowerCase();
        String brand2 = bike2.getBrand().toLowerCase();
        return brand1.charAt(0) - brand2.charAt(0);
    }
}
