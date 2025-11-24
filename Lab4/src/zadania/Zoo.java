package zadania;
import animals.Animal;
import animals.Parrot;
import animals.Snake;
import animals.Dog;
import java.util.Random;

public class Zoo {

    Animal[] animals = new Animal[100];


    public Zoo() {
        fill();
    }

    private void fill() {
        Random random = new Random();

        for (int i = 0; i < animals.length; i++) {
            int animalType = random.nextInt(3);
            switch (animalType) {
                case 0:
                    animals[i] = new Parrot("Tacosiński " + i);
                    break;
                case 1:
                    animals[i] = new Dog("Burek " + i);
                    break;
                case 2:
                    animals[i] = new Snake("Snake'owski " + i);
                    break;
            }
        }
    }



}

