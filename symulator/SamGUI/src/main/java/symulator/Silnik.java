package symulator;

public class Silnik extends Komponent {
    private int maxObroty;
    private int obroty;

    public Silnik(String nazwa, double waga, double cena, String producent, String model, int maxObroty) {
        super(nazwa, waga, cena, producent, model);
        this.maxObroty = maxObroty;
        this.obroty = 0;
    }

    public void uruchom() {
        this.obroty = 800;
        System.out.println("Silnik uruchomiony. Obroty: " + obroty);
    }

    public void zatrzymaj() {
        this.obroty = 0;
        System.out.println("Silnik zatrzymany.");
    }

    public void zwiekszObroty() {
        if (obroty < maxObroty) {
            obroty += 100;
            System.out.println("Obroty zwiększone: " + obroty);
        }
    }

    public void zmniejszObroty() {
        if (obroty > 0) {
            obroty -= 100;
            System.out.println("Obroty zmniejszone: " + obroty);
        }
    }

    public int getObroty() {
        return obroty;
    }
}