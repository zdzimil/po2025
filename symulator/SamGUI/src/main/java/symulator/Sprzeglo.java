package symulator;

public class Sprzeglo extends Komponent {
    private boolean stanSprzegla; // false - wyłączone, true - włączone

    public Sprzeglo(String nazwa, double waga, double cena, String producent, String model) {
        super(nazwa, waga, cena, producent, model);
        this.stanSprzegla = false;
    }

    public void wcisnij() {
        this.stanSprzegla = true;
        System.out.println("Sprzęgło wciśnięte.");
    }

    public void zwolnij() {
        this.stanSprzegla = false;
        System.out.println("Sprzęgło zwolnione.");
    }
    // potrzebne do skrzyni biegów
    public boolean isWcisniete() {
        return stanSprzegla;
    }
}