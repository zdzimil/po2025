package symulator;

public class SkrzyniaBiegow extends Komponent {
    // Pola z diagramu
    private int aktualnyBieg;
    private int iloscBiegow;
    private double aktualnePrzelozenie;

    // Relacja do sprzęgła widoczna na diagramie (linia 'sprzeglo')
    private Sprzeglo sprzeglo;

    public SkrzyniaBiegow(String nazwa, double waga, double cena, String producent, String model, int iloscBiegow, Sprzeglo sprzeglo) {
        super(nazwa, waga, cena, producent, model);
        this.iloscBiegow = iloscBiegow;
        this.sprzeglo = sprzeglo;
        this.aktualnyBieg = 0; // luz
    }

    // Metody z diagramu
    public void zwiekszBieg() {
        if (sprzeglo.isWcisniete()) {
            if (aktualnyBieg < iloscBiegow) {
                aktualnyBieg++;
                System.out.println("Bieg zwiększony na: " + aktualnyBieg);
            } else {
                System.out.println("To już maksymalny bieg.");
            }
        } else {
            System.out.println("Nie można zmienić biegu! Wciśnij sprzęgło.");
        }
    }

    public void zmniejszBieg() {
        if (sprzeglo.isWcisniete()) {
            if (aktualnyBieg > 0) {
                aktualnyBieg--;
                System.out.println("Bieg zmniejszony na: " + aktualnyBieg);
            }
        } else {
            System.out.println("Nie można zmienić biegu! Wciśnij sprzęgło.");
        }
    }

    public int getAktBieg() {
        return aktualnyBieg;
    }

    public double getAktPrzelozenie() {
        // Prosta logika przełożenia (np. bieg * 1.5)
        this.aktualnePrzelozenie = aktualnyBieg * 1.5;
        return aktualnePrzelozenie;
    }

    // Metoda pomocnicza dla klasy Samochód (wymagana do metody wylacz())
    public void ustawLuz() {
        this.aktualnyBieg = 0;
    }
}