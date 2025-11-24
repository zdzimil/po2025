package symulator;

public class Sprzeglo extends Komponent {
    // Pole z diagramu
    private boolean stanSprzegla; // false - wyłączone, true - włączone

    public Sprzeglo(String nazwa, double waga, double cena, String producent, String model) {
        super(nazwa, waga, cena, producent, model);
        this.stanSprzegla = false;
    }

    // Metody z diagramu
    public void wcisnij() {
        this.stanSprzegla = true;
        System.out.println("Sprzęgło wciśnięte.");
    }

    public void zwolnij() {
        this.stanSprzegla = false;
        System.out.println("Sprzęgło zwolnione.");
    }

    // Metoda pomocnicza, żeby inne klasy wiedziały w jakim stanie jest sprzęgło
    public boolean isWcisniete() {
        return stanSprzegla;
    }
}