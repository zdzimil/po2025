package com.example.samgui;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.IOException;
import symulator.*;

public class SamochodController  implements Listener {
    @FXML private Button wlaczButton, wylaczButton, zwiekszBiegButton, zmniejszBiegButton, zwiekszObrotyButton, zmniejszObrotyButton, wcisnijSprzegloButton, zwolnijSprzegloButton, dodajNowyButton, usunButton;
    @FXML private TextField modelTextField, registrationTextField, weightTextField, speedTextField, gearTextField, rpmTextField, clutchTextField;
    @FXML private TextField gearboxNameTextField, gearboxPriceTextField, gearboxWeightTextField;
    @FXML private TextField engineNameTextField, enginePriceTextField, engineWeightTextField;
    @FXML private TextField clutchNameTextField, clutchPriceTextField, clutchWeightTextField;
    @FXML private ImageView carImageView;
    @FXML private ComboBox<Samochod> carComboBox;
    @FXML private javafx.scene.layout.Pane mapa;

    private Samochod mojSamochod;
    private ObservableList<Samochod> listaSamochodow = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        Sprzeglo s = new Sprzeglo("Sport", 10, 500, "Sachs", "S1");
        Silnik sil = new Silnik("V8", 300, 10000, "BMW", "M5", 8000);
        SkrzyniaBiegow sk = new SkrzyniaBiegow("Manual", 50, 2000, "Getrag", "6B", 6, s);
        mojSamochod = new Samochod("KR 123", "BMW M3", 250, sil, sk, s, new Pozycja(0,0));

        // Obsługa myszki
        mapa.setOnMouseClicked(event -> {
            if (mojSamochod != null) {
                double x = event.getX();
                double y = event.getY();
                Pozycja nowaPozycja = new Pozycja(x, y);
                mojSamochod.jedzDo(nowaPozycja);
                refresh();
            }
        });

        listaSamochodow.add(mojSamochod);
        carComboBox.setItems(listaSamochodow);

        // Wyświetlanie modelu w liście, by nie wyskoczyły jakieś napisy gdzie jest zapisany ten obiekt
        carComboBox.setCellFactory(lv -> new ListCell<>() {
            @Override
            protected void updateItem(Samochod item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? null : item.getModel());
            }
        });
        carComboBox.setButtonCell(carComboBox.getCellFactory().call(null));

        carComboBox.setOnAction(event -> {
            if (mojSamochod != null) {
                mojSamochod.removeListener(this);
            }

            Samochod wybrany = carComboBox.getSelectionModel().getSelectedItem();
            if (wybrany != null) {
                mojSamochod = wybrany;
                mojSamochod.addListener(this);
                refresh();
            }
        });

        try {
            Image carImage = new Image(getClass().getResource("/com/example/samgui/s2.png").toExternalForm());
            carImageView.setImage(carImage);
            carImageView.setFitWidth(100);
            carImageView.setFitHeight(80);
            carImageView.setTranslateX(0);
            carImageView.setTranslateY(0);
        } catch (Exception e) {
            System.out.println("Błąd ładowania obrazka");
        }

        refresh();
    }

    private void refresh() {
        if (mojSamochod == null) return;


        Platform.runLater(() -> {
            carImageView.setTranslateX(mojSamochod.getAktPozycja().getX());
            carImageView.setTranslateY(mojSamochod.getAktPozycja().getY());

            // Podstawowe dane samochodu
            weightTextField.setText(String.valueOf(mojSamochod.getWaga()));
            registrationTextField.setText(mojSamochod.getNrRejest());
            speedTextField.setText(String.valueOf(mojSamochod.getAktPredkosc()));
            modelTextField.setText(mojSamochod.getModel());

            // Dane komponentów
            gearboxNameTextField.setText(mojSamochod.getSkrzynia().getNazwa());
            gearboxPriceTextField.setText(String.valueOf(mojSamochod.getSkrzynia().getCena()));
            gearboxWeightTextField.setText(String.valueOf(mojSamochod.getSkrzynia().getWaga()));
            gearTextField.setText(String.valueOf(mojSamochod.getSkrzynia().getAktBieg()));

            engineNameTextField.setText(mojSamochod.getSilnik().getNazwa());
            enginePriceTextField.setText(String.valueOf(mojSamochod.getSilnik().getCena()));
            engineWeightTextField.setText(String.valueOf(mojSamochod.getSilnik().getWaga()));
            rpmTextField.setText(String.valueOf(mojSamochod.getSilnik().getObroty()));

            clutchNameTextField.setText(mojSamochod.getSprzeglo().getNazwa());
            clutchPriceTextField.setText(String.valueOf(mojSamochod.getSprzeglo().getCena()));
            clutchWeightTextField.setText(String.valueOf(mojSamochod.getSprzeglo().getWaga()));
            clutchTextField.setText(mojSamochod.getSprzeglo().isWcisniete() ? "Wciśnięte" : "Zwolnione");
        });
    }

    public void dodajSamochod(Samochod nowySamochod) {
        if (mojSamochod != null) {
            mojSamochod.removeListener(this);
        }
        listaSamochodow.add(nowySamochod);
        carComboBox.getSelectionModel().select(nowySamochod);
        nowySamochod.addListener(this);
        refresh();
    }

    @FXML
    private void onUsunButton() {
        if (mojSamochod != null) {
            mojSamochod.removeListener(this);
            mojSamochod.wylacz();
            listaSamochodow.remove(mojSamochod);
            mojSamochod = null;
            if (!listaSamochodow.isEmpty()) {
                carComboBox.getSelectionModel().selectFirst();
            } else {
                System.out.println("Lista jest pusta");
            }
        }
    }

    @FXML private void onWlaczButton() {
        if (mojSamochod != null) { mojSamochod.wlacz(); refresh(); }
    }

    @FXML private void onWylaczButton() {
        if (mojSamochod != null) { mojSamochod.wylacz(); refresh(); }
    }

    @FXML private void onZwiekszBiegButton() {
        if (mojSamochod != null) {
            try {
                mojSamochod.getSkrzynia().zwiekszBieg();
                refresh();
            } catch (Exception e) {
                pokazBlad(e.getMessage());
            }
        }
    }

    @FXML
    private void onZmniejszBiegButton() {
        if (mojSamochod != null) {
            try {
                mojSamochod.getSkrzynia().zmniejszBieg();
                refresh();
            } catch (Exception e) {
                pokazBlad(e.getMessage());
            }
        }
    }

    @FXML
    private void onWcisnijSprzegloButton() {
        if (mojSamochod != null) {
            try {
                mojSamochod.getSprzeglo().wcisnij();
                refresh();
            } catch (Exception e) {
                pokazBlad(e.getMessage());
            }
        }
    }

    @FXML
    private void onZwolnijSprzegloButton() {
        if (mojSamochod != null) {
            try {
                mojSamochod.getSprzeglo().zwolnij();
                refresh();
            } catch (Exception e) {
                pokazBlad(e.getMessage());
            }
        }
    }

    @FXML private void onZwiekszObrotyButton() {
        if (mojSamochod != null) { mojSamochod.getSilnik().zwiekszObroty(); refresh(); }
    }

    @FXML private void onZmniejszObrotyButton() {
        if (mojSamochod != null) { mojSamochod.getSilnik().zmniejszObroty(); refresh(); }
    }

    private void pokazBlad(String wiadomosc) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Błąd");
        alert.setHeaderText(null);
        alert.setContentText(wiadomosc);
        alert.showAndWait();
    }

    @FXML
    private void onDodajNowyButton() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DodajSamochod.fxml"));
        Parent root = loader.load();
        DodajSamochodController dodajController = loader.getController();
        dodajController.setMainController(this);

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Dodaj nowy samochód");
        stage.show();
     }

    @Override
    public void update() {
        refresh();
    }

    }