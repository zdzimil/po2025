package symulator;

import java.util.ArrayList;
import java.util.List;

public class Zawody {
    private String nazwa;
    private String data;
    private List<Samochod> uczestnicy;

    public Zawody(String nazwa, String data) {
        this.nazwa = nazwa;
        this.data = data;
        this.uczestnicy = new ArrayList<>();
    }

    public void dodajUczestnika(Samochod auto) {
        uczestnicy.add(auto);
    }

    public void rozegrajZawody() {
        System.out.println("Rozpoczynam zawody: " + nazwa);
        Pozycja meta = new Pozycja(100, 100);

        for (Samochod auto : uczestnicy) {
            System.out.println("Startuje: " + auto.getModel());
            auto.wlacz();

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