package symulator;
import java.util.ArrayList;
import java.util.List;

public class Samochod extends Thread {
    private boolean stanWlaczenia;
    private String nrRejest;
    private String model;
    private double predkoscMax;
    private double aktualnaPredkosc;
    private Pozycja cel;

    // Komponenty składowe
    private Silnik silnik;
    private SkrzyniaBiegow skrzynia;
    private Sprzeglo sprzeglo;
    private Pozycja aktualnaPozycja;


    public Samochod(String nrRejest, String model, double predkoscMax, Silnik silnik, SkrzyniaBiegow skrzynia, Sprzeglo sprzeglo, Pozycja aktualnaPozycja) {
        this.nrRejest = nrRejest;
        this.model = model;
        this.predkoscMax = predkoscMax;
        this.silnik = silnik;
        this.skrzynia = skrzynia;
        this.sprzeglo = sprzeglo;
        this.aktualnaPozycja = aktualnaPozycja;
        this.cel = aktualnaPozycja;
        this.stanWlaczenia = false; // bo zakładamy że nowy obiekt będzie domyślnie wyłączony
        this.aktualnaPredkosc = 0;
        start();
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
        this.cel = cel;
        System.out.println("Usanowiono cel: " + cel.getX() + " " + cel.getY());
    }

    public double getWaga() {
        return silnik.getWaga() + skrzynia.getWaga() + sprzeglo.getWaga() + 1000;
    }

    public double getAktPredkosc() {
        return aktualnaPredkosc;
    }

    public Pozycja getAktPozycja() {
        return aktualnaPozycja;
    }


    // Gettery potrzebne dla klasy Zawody
    public String getModel() {
        return model;
    }

    public SkrzyniaBiegow getSkrzynia() {
        return skrzynia;
    }

    public Sprzeglo getSprzeglo() {
        return sprzeglo;
    }

    public Silnik getSilnik() { return silnik; }

    public String getNrRejest() {return nrRejest;}

    //teraz implementujemy listenera
    private List<Listener> listeners = new ArrayList<>();

    public void addListener(Listener listener) {
        listeners.add(listener);
    }

    public void removeListener(Listener listener) {
        listeners.remove(listener);
    }

    private void notifyListeners() {
        for (Listener listener : listeners) {
            listener.update();
        }
    }

    public void run() {
        double deltat = 0.1; // Krok czasowy symulacji

        while (true) {
            try {
                Thread.sleep(100);
                if (stanWlaczenia && cel != null) {
                    double x = aktualnaPozycja.getX();
                    double y = aktualnaPozycja.getY();
                    double celX = cel.getX();
                    double celY = cel.getY();

                    double odleglosc = Math.sqrt(Math.pow(celX - x, 2) + Math.pow(celY - y, 2));

                    // bo trudno jest trafić idealne w cel wiec sobie przyjmuje że gdy jest wytarczająco blisko celu.
                    if (odleglosc > 1) {
                        aktualnaPredkosc = skrzynia.getAktBieg() * 20.0;
                            if (aktualnaPredkosc > predkoscMax) {
                                aktualnaPredkosc = predkoscMax;
                            }
                        double dx = aktualnaPredkosc * deltat * (celX - x) / odleglosc;
                        double dy = aktualnaPredkosc * deltat * (celY - y) / odleglosc;

                        aktualnaPozycja.aktualizujPozycje(x + dx, y + dy);

                        notifyListeners();

                    } else {
                        //jestmsy przy celu
                        aktualnaPredkosc = 0;

                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}