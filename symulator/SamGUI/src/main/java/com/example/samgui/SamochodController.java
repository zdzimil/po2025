package com.example.samgui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.IOException;
import symulator.*;

public class SamochodController {
    @FXML private Button wlaczButton, wylaczButton, zwiekszBiegButton, zmniejszBiegButton, zwiekszObrotyButton, zmniejszObrotyButton, wcisnijSprzegloButton, zwolnijSprzegloButton, dodajNowyButton;
    @FXML private TextField modelTextField, registrationTextField, weightTextField, speedTextField, gearTextField, rpmTextField, clutchTextField;
    @FXML private ImageView carImageView;
    @FXML private ComboBox<Samochod> carComboBox;

    private Samochod mojSamochod;
    private static ObservableList<Samochod> listaSamochodow = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        Sprzeglo s = new Sprzeglo("Sport", 10, 500, "Sachs", "S1");
        Silnik sil = new Silnik("V8", 300, 10000, "BMW", "M5", 8000);
        SkrzyniaBiegow sk = new SkrzyniaBiegow("Manual", 50, 2000, "Getrag", "6B", 6, s);
        mojSamochod = new Samochod("KR 123", "BMW M3", 250, sil, sk, s, new Pozycja(0,0));

        listaSamochodow.add(mojSamochod);
        carComboBox.setItems(listaSamochodow);

        carComboBox.setCellFactory(lv -> new ListCell<>() {
            @Override
            protected void updateItem(Samochod item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? null : item.getModel());
            }
        });
        carComboBox.setButtonCell(carComboBox.getCellFactory().call(null));

        carComboBox.setOnAction(event -> {
            mojSamochod = carComboBox.getSelectionModel().getSelectedItem();
            refresh();
        });

        try {
            Image carImage = new Image(getClass().getResource("/com/example/samgui/car.png").toExternalForm());
            carImageView.setImage(carImage);
            carImageView.setFitWidth(100);
            carImageView.setPreserveRatio(true);
        } catch (Exception e) {
            System.out.println("Błąd ładowania obrazka");
        }

        refresh();
    }

    private void refresh() {
        if (mojSamochod == null) return;
        weightTextField.setText(String.valueOf(mojSamochod.getWaga()));
        registrationTextField.setText(mojSamochod.getNrRejest());
        speedTextField.setText(String.valueOf(mojSamochod.getAktPredkosc()));
        modelTextField.setText(mojSamochod.getModel());
        gearTextField.setText(String.valueOf(mojSamochod.getSkrzynia().getAktBieg()));
        rpmTextField.setText(String.valueOf(mojSamochod.getSilnik().getObroty()));
        clutchTextField.setText(mojSamochod.getSprzeglo().isWcisniete() ? "Wciśnięte" : "Zwolnione");
    }

    public static void addCarToList(Samochod s) {
        listaSamochodow.add(s);
    }

    @FXML private void onWlaczButton() {
        mojSamochod.wlacz();
        refresh();
    }

    @FXML private void onWylaczButton() {
        mojSamochod.wylacz();
        refresh();
    }

    @FXML private void onZwiekszBiegButton() {
        mojSamochod.getSkrzynia().zwiekszBieg();
        refresh();
    }

    @FXML private void onZmniejszBiegButton() {
        mojSamochod.getSkrzynia().zmniejszBieg();
        refresh();
    }

    @FXML private void onWcisnijSprzegloButton() {
        mojSamochod.getSprzeglo().wcisnij();
        refresh();
    }

    @FXML private void onZwolnijSprzegloButton() {
        mojSamochod.getSprzeglo().zwolnij();
        refresh();
    }

    @FXML private void onZwiekszObrotyButton() {
        mojSamochod.getSilnik().zwiekszObroty();
        refresh();
    }

    @FXML private void onZmniejszObrotyButton() {
        mojSamochod.getSilnik().zmniejszObroty();
        refresh();
    }

    @FXML
    private void onDodajNowyButton() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DodajSamochod.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(loader.load()));
        stage.setTitle("Dodaj nowy samochód");
        stage.show();
    }
}