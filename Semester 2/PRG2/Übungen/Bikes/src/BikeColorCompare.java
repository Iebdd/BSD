import java.util.Comparator;

public class BikeColorCompare implements Comparator<Bike> {

    public int compare(Bike bike1, Bike bike2) {
        String color1 = bike1.getColor().toLowerCase();
        String color2 = bike2.getColor().toLowerCase();
        return color1.charAt(0) - color2.charAt(0);
    }
}
