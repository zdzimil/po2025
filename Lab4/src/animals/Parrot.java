import animals.Animal;

public class Parrot extends Animal {
    public Parrot(String name) {
        this.name = name;
        this.legs = 2;
    }
    public String getDescription() {
        return "Jest to kolorowy ptak ";
    }

}
