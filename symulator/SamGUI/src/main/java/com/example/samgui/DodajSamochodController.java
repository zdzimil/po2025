package com.example.samgui;

import javafx.fxml.FXML;
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

    @FXML
    public void initialize() {
        engineComboBox.getItems().addAll("V8 4.0", "V6 3.0", "R4 2.0");
        gearboxComboBox.getItems().addAll("Manualna 6-biegowa", "Automatyczna");
    }

    @FXML
    private void onConfirmButton() {
        String model = modelTextField.getText();
        String registration = registrationTextField.getText();

        try {
            double weight = Double.parseDouble(weightTextField.getText());
            int speed = Integer.parseInt(speedTextField.getText());

            Sprzeglo s = new Sprzeglo("Standard", 5, 200, "Producent", "M1");
            Silnik sil = new Silnik("R4", 150, 5000, "Producent", "S1", 6000);
            SkrzyniaBiegow sk = new SkrzyniaBiegow("Manual", 30, 1000, "Producent", "B1", 5, s);

            Samochod nowy = new Samochod(registration, model, speed, sil, sk, s, new Pozycja(0,0));
            SamochodController.addCarToList(nowy);

            Stage stage = (Stage) confirmButton.getScene().getWindow();
            stage.close();
        } catch (NumberFormatException e) {
            System.out.println("Niepoprawne dane. Spróbuj ponownie.");
        }
    }

    @FXML
    private void onCancelButton() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
}