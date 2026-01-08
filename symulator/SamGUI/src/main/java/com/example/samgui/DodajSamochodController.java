package com.example.samgui;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import symulator.*;

public class DodajSamochodController {

    @FXML private TextField modelTextField;
    @FXML private TextField registrationTextField;
    @FXML private TextField weightTextField;
    @FXML private TextField speedTextField;
    @FXML private ComboBox<String> engineComboBox;
    @FXML private ComboBox<String> gearboxComboBox;
    @FXML private Button confirmButton;
    @FXML private Button cancelButton;

    private SamochodController mainController;

    public void setMainController(SamochodController mainController) {
        this.mainController = mainController;
    }

    @FXML
    public void initialize() {
        engineComboBox.getItems().addAll("R4 2.0", "V6 3.0", "V8 4.0", "V12 Monster");
        engineComboBox.getSelectionModel().selectFirst();

        gearboxComboBox.getItems().addAll("Manualna 6-biegowa", "Automatyczna 8-biegowa", "Sportowa DSG");
        gearboxComboBox.getSelectionModel().selectFirst();
    }

    @FXML
    private void onConfirmButton() {
        String model = modelTextField.getText();
        String registration = registrationTextField.getText();
        String wybranySilnik = engineComboBox.getValue();
        String wybranaSkrzynia = gearboxComboBox.getValue();

        try {
            double weight = Double.parseDouble(weightTextField.getText());
            int speed = Integer.parseInt(speedTextField.getText());

            Sprzeglo sprzeglo = new Sprzeglo("Standard", 5, 200, "Producent", "M1");
            Silnik silnik;
            SkrzyniaBiegow skrzynia;

            if (wybranySilnik == null) wybranySilnik = "R4 2.0";

            switch (wybranySilnik) {
                case "V12 Monster":
                    silnik = new Silnik("V12", 500, 20000, "Ferrari", "F140", 9000);
                    break;
                case "V8 4.0":
                    silnik = new Silnik("V8", 300, 10000, "BMW", "M5", 8000);
                    break;
                case "V6 3.0":
                    silnik = new Silnik("V6", 220, 8000, "Audi", "V6T", 7000);
                    break;
                case "R4 2.0":
                default:
                    silnik = new Silnik("R4", 150, 5000, "Toyota", "S1", 6000);
                    break;
            }

            if (wybranaSkrzynia == null) wybranaSkrzynia = "Manualna 6-biegowa";

            switch (wybranaSkrzynia) {
                case "Sportowa DSG":
                    skrzynia = new SkrzyniaBiegow("DSG", 60, 3000, "VW", "DSG7", 7, sprzeglo);
                    break;
                case "Automatyczna 8-biegowa":
                    skrzynia = new SkrzyniaBiegow("Automat", 50, 2500, "ZF", "8HP", 8, sprzeglo);
                    break;
                case "Manualna 6-biegowa":
                default:
                    skrzynia = new SkrzyniaBiegow("Manual", 30, 1000, "Getrag", "B1", 6, sprzeglo);
                    break;
            }

            Samochod nowy = new Samochod(registration, model, speed, silnik, skrzynia, sprzeglo, new Pozycja(0, 0));

            if (mainController != null) {
                mainController.dodajSamochod(nowy);
            }

            Stage stage = (Stage) confirmButton.getScene().getWindow();
            stage.close();

        } catch (NumberFormatException e) {
            pokazBlad("Niepoprawne dane! Waga i prędkość muszą być liczbami.");
        }
    }

    @FXML
    private void onCancelButton() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    private void pokazBlad(String wiadomosc) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Błąd");
        alert.setHeaderText(null);
        alert.setContentText(wiadomosc);
        alert.showAndWait();
    }
}