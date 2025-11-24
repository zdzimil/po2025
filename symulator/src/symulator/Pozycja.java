package symulator;

public class Pozycja {
    // Pola z diagramu i tekstu
    private double x;
    private double y;

    public Pozycja(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Metoda z tekstu instrukcji
    public void aktualizujPozycje(double deltaX, double deltaY) {
        this.x += deltaX;
        this.y += deltaY;
    }

    // Metoda z tekstu instrukcji
    public String getPozycja() {
        return "x: " + x + ", y: " + y;
    }

    // Gettery potrzebne do obliczeń w klasie Samochód
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}