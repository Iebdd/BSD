import java.util.Comparator;

public class BikeTypeCompare implements Comparator<Bike> {

    public int compare(Bike bike1, Bike bike2) {
        BikeTypes.types type1 = bike1.getType();
        BikeTypes.types type2 = bike2.getType();
        return type1.ordinal() - type2.ordinal();
    }
}
