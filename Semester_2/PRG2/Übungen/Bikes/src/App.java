import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Comparator<Bike>> comparators = new ArrayList<>();
        List<Bike> bikes = new ArrayList<>();
        List<String> strings = new ArrayList<>();
        strings.add("brand name");
        strings.add("color");
        strings.add("horsepower");
        strings.add("type");
        comparators.add(new BikeBrandCompare());
        comparators.add(new BikeColorCompare());
        comparators.add(new BikeHorsePowerCompare());
        comparators.add(new BikeTypeCompare());
        bikes.add(new Bike("KTM", 50, "black", 1990, BikeTypes.types.dirt));
        bikes.add(new Bike("Yamaha", 150, "yellow", 2005, BikeTypes.types.street));
        bikes.add(new Bike("Ducati", 100, "blue", 2024, BikeTypes.types.smoto));
        bikes.add(new Bike("Harley-Davidson", 200, "grey", 2000, BikeTypes.types.chopper));
        bikes.add(new Bike("BMW", 34, "red", 1975, BikeTypes.types.smoto));

        System.out.println("Default bike list (not sorted)%n");
        printStats(bikes);
        System.out.printf("%n%s%n", "-".repeat(55));
        System.out.printf("Sorted bike list by construction year%n");
        for (int index = 0; index <= comparators.size(); index++) {
            System.out.printf("%n%s%n", "-".repeat(55));
            System.out.printf("Sorted bike list by %s%n", strings.get(index));
            printStats(bikes);
            bikes.sort(comparators.get(index));
        }
    }

    private static void printStats(List<Bike> list) {
        for (Bike bike : list) {
            System.out.printf("Brand: %s | Horse Power: %d | Construction Year: %d | Type: %s | Color: %s%n",
                    bike.getBrand(), bike.getHorsePower(), bike.getConstructionYear(),
                    bike.getType(), bike.getColor());
        }
    }
}
