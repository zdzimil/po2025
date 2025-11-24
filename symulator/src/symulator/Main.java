package symulator;

public class Main {
    public static void main(String[] args) {
        // 1. Tworzenie komponentów
        Pozycja pozycjaStartowa = new Pozycja(0, 0);
        Sprzeglo sprzeglo = new Sprzeglo("Sprzęgło Sport", 10, 500, "Sachs", "S1");
        Silnik silnik = new Silnik("V8", 300, 10000, "BMW", "M5", 8000);
        SkrzyniaBiegow skrzynia = new SkrzyniaBiegow("Manualna", 50, 2000, "Getrag", "6B", 6, sprzeglo);

        // 2. Tworzenie samochodu
        Samochod mojSamochod = new Samochod("KR 12345", "BMW M3", 250, silnik, skrzynia, sprzeglo, pozycjaStartowa);

        // 3. Testowanie (zgodnie z instrukcją)
        System.out.println("--- TESTY ---");
        mojSamochod.wlacz();

        // Zmiana biegów
        sprzeglo.wcisnij();
        skrzynia.zwiekszBieg();
        sprzeglo.zwolnij();

        // Jazda
        Pozycja cel = new Pozycja(50, 50);
        mojSamochod.jedzDo(cel);

        // Wyświetlanie stanu
        System.out.println("Aktualna pozycja: " + mojSamochod.getAktPozycja());
        System.out.println("Aktualna prędkość: " + mojSamochod.getAktPredkosc());

        mojSamochod.wylacz();

        // 4. Test Zawodów (opcjonalnie, bo jest klasa Zawody)
        System.out.println("\n--- ZAWODY ---");
        Zawody wyscig = new Zawody("Grand Prix", "2025-01-01");
        wyscig.dodajUczestnika(mojSamochod);
        wyscig.rozegrajZawody();
    }
}