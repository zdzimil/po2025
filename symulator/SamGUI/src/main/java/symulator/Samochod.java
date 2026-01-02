package symulator;

public class Samochod {
    private boolean stanWlaczenia;
    private String nrRejest;
    private String model;
    private double predkoscMax;

    // Komponenty składowe
    private Silnik silnik;
    private SkrzyniaBiegow skrzynia;
    private Sprzeglo sprzeglo;
    private Pozycja aktualnaPozycja;

    // Pole pomocnicze do metody getAktPredkosc
    private double aktualnaPredkosc;

    public Samochod(String nrRejest, String model, double predkoscMax, Silnik silnik, SkrzyniaBiegow skrzynia, Sprzeglo sprzeglo, Pozycja aktualnaPozycja) {
        this.nrRejest = nrRejest;
        this.model = model;
        this.predkoscMax = predkoscMax;
        this.silnik = silnik;
        this.skrzynia = skrzynia;
        this.sprzeglo = sprzeglo;
        this.aktualnaPozycja = aktualnaPozycja;
        this.stanWlaczenia = false; // bo zakładamy że nowy obiekt będzie domyślnie wyłączony
        this.aktualnaPredkosc = 0;
    }

    public void wlacz() {
        silnik.uruchom();
        stanWlaczenia = true;
        System.out.println("Samochód włączony.");
    }

    public void wylacz() {
        silnik.zatrzymaj();
        skrzynia.ustawLuz();
        stanWlaczenia = false;
        aktualnaPredkosc = 0;
        System.out.println("Samochód wyłączony.");
    }

    public void jedzDo(Pozycja cel) {
        if (stanWlaczenia) {
            // Prosta symulacja ruchu
            aktualnaPredkosc = skrzynia.getAktBieg() * 20.0;
            if (aktualnaPredkosc > predkoscMax) {
                aktualnaPredkosc = predkoscMax;
            }
            aktualnaPozycja.aktualizujPozycje(cel.getX(), cel.getY());
            System.out.println("Jadę do pozycji: " + cel.getPozycja() + " z prędkością " + aktualnaPredkosc);
        } else {
            System.out.println("Włącz silnik, aby jechać.");
        }
    }

    public double getWaga() {
        // Suma wag komponentów + waga własna karoserii (np. 1000)
        return silnik.getWaga() + skrzynia.getWaga() + sprzeglo.getWaga() + 1000;
    }

    public double getAktPredkosc() {
        return aktualnaPredkosc;
    }

    public String getAktPozycja() {
        return aktualnaPozycja.getPozycja();
    }

    // Gettery potrzebne dla klasy Zawody (żeby nie było błędów private access)
    public String getModel() {
        return model;
    }

    public SkrzyniaBiegow getSkrzynia() {
        return skrzynia;
    }

    public Sprzeglo getSprzeglo() {
        return sprzeglo;
    }
}