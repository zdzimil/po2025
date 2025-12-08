package symulator;

public abstract class Komponent {
    // Pola z diagramu UML
    private String nazwa;
    private double waga;
    private double cena;

    // Pola dodatkowe z tekstu instrukcji
    private String producent;
    private String model;

    public Komponent(String nazwa, double waga, double cena, String producent, String model) {
        this.nazwa = nazwa;
        this.waga = waga;
        this.cena = cena;
        this.producent = producent;
        this.model = model;
    }

    // Metody z diagramu UML i tekstu
    public String getNazwa() {
        return nazwa;
    }

    public double getWaga() {
        return waga;
    }

    public double getCena() {
        return cena;
    }

    public String getProducent() {
        return producent;
    }

    public String getModel() {
        return model;
    }
}