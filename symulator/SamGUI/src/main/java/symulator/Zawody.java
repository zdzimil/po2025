package symulator;

import java.util.ArrayList;
import java.util.List;

public class Zawody {
    // Pola z diagramu
    private String nazwa;
    private String data;

    // Relacja "uczestnicy" z diagramu (0..*)
    private List<Samochod> uczestnicy;

    public Zawody(String nazwa, String data) {
        this.nazwa = nazwa;
        this.data = data;
        this.uczestnicy = new ArrayList<>();
    }

    // Metoda pomocnicza do dodawania aut
    public void dodajUczestnika(Samochod auto) {
        uczestnicy.add(auto);
    }

    // Metoda z diagramu
    public void rozegrajZawody() {
        System.out.println("Rozpoczynam zawody: " + nazwa);
        Pozycja meta = new Pozycja(100, 100);

        for (Samochod auto : uczestnicy) {
            System.out.println("Startuje: " + auto.getModel());

            // Symulacja przejazdu
            auto.wlacz();

            // Zmiana biegów (korzystamy z getterów dodanych do Samochodu)
            auto.getSprzeglo().wcisnij();
            auto.getSkrzynia().zwiekszBieg();
            auto.getSprzeglo().zwolnij();

            auto.jedzDo(meta);
            auto.wylacz();
            System.out.println("---");
        }
        System.out.println("Koniec zawodów.");
    }
}