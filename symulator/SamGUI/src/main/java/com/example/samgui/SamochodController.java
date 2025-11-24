package com.example.samgui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class SamochodController {

    @FXML
    private ComboBox<String> comboWybierz;

    @FXML
    private Button btndodaj;

    @FXML
    private Button btnusun;

    @FXML
    private TextField FieldModel;

    @FXML
    private TextField FieldRejestracyjny;

    @FXML
    private TextField FieldWaga;

    @FXML
    private TextField FieldPredkosc;

    @FXML
    private Button btnWlacz;

    @FXML
    private Button btnWylacz;

    @FXML
    private TextField FieldSkrzyniaNazwa;

    @FXML
    private TextField FieldSkrzyniaCena;

    @FXML
    private TextField FieldSkrzyniaWaga;

    @FXML
    private TextField FieldBieg;

    @FXML
    private Button BtnBiegGora;

    @FXML
    private Button BtnBiegDol;

    @FXML
    private TextField FieldSilnikNazwa;

    @FXML
    private TextField FieldSilnikCena;

    @FXML
    private TextField FieldSilnikWaga;

    @FXML
    private TextField FieldSilnikObroty;

    @FXML
    private Button Btnzwieksz;

    @FXML
    private Button Btnzmniejsz;

    @FXML
    private TextField FieldSprzegloNazwa;

    @FXML
    private TextField FieldSprzegloCena;

    @FXML
    private TextField FieldSprzegloWaga;

    @FXML
    private TextField FieldSprzegloStan;

    @FXML
    private Button BtnWcisnij;

    @FXML
    private Button BtnZwolnij;

    @FXML
    private ImageView samochodImage;

    @FXML
    public void initialize() {
        System.out.println("Kontroler załadowany poprawnie.");

        if (FieldModel != null) {
            FieldModel.setText("Gotowy do pracy");
        }
    }
}