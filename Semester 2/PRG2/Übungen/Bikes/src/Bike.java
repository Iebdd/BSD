import java.util.Comparator;


public class Bike implements Comparable<Bike> {

    private final String brand;
    private final int horsePower;
    private final String color;
    private final int constructionYear;
    private final BikeTypes.types type;

    public Bike(String brand, int horsePower, String color, int constructionYear, BikeTypes.types type) {
        this.brand = brand;
        this.horsePower = horsePower;
        this.color = color;
        this.constructionYear = constructionYear;
        this.type = type;
    }

    public String getBrand() {
        return this.brand;
    }

    public int getHorsePower() {
        return this.horsePower;
    }

    public String getColor() {
        return this.color;
    }

    public int getConstructionYear() {
        return this.constructionYear;
    }

    public BikeTypes.types getType() {
        return this.type;
    }

    @Override
    public int compareTo(Bike bike1) {
        return this.constructionYear - bike1.getConstructionYear();
    }
}
