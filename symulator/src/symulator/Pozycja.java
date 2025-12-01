<?xml version="1.0" encoding="UTF-8"?>

        <?import javafx.scene.control.*?>
        <?import javafx.scene.image.*?>
        <?import javafx.scene.layout.*?>
        <?import javafx.geometry.Insets?>

<BorderPane xmlns:fx="http://javafx.com/fxml" prefHeight="600.0" prefWidth="800.0">

    <top>
        <VBox>
            <MenuBar>
                <menus>
                    <Menu text="Plik">
                        <MenuItem text="Zamknij"/>
                    </Menu>
                    <Menu text="Edycja">
                        <MenuItem text="Wyczyść"/>
                    </Menu>
                </menus>
            </MenuBar>

            <ToolBar>
                <Label text="Samochód: "/>
                <ComboBox promptText="Wybierz samochód" prefWidth="150.0"/>
                <Button text="Dodaj nowy"/>
                <Button text="Usuń"/>
            </ToolBar>
        </VBox>
    </top>

    <left>
        <ScrollPane fitToWidth="true" prefWidth="300.0">
            <content>
                <VBox spacing="5.0">
                    <padding>
                        <Insets top="10" right="10" bottom="10" left="10"/>
                    </padding>

                    <TitledPane text="Samochód" collapsible="true" expanded="true">
                        <VBox spacing="5">
                            <Label text="Model:"/>
                            <TextField promptText="np. BMW M3"/>
                            <Label text="Nr rejestracyjny:"/>
                            <TextField promptText="np. KR 12345"/>
                            <Label text="Waga:"/>
                            <TextField promptText="0.0"/>
                            <Label text="Prędkość:"/>
                            <TextField promptText="0.0"/>
                            <HBox spacing="10" alignment="CENTER">
                                <Button text="Włącz"/>
                                <Button text="Wyłącz"/>
                            </HBox>
                        </VBox>
                    </TitledPane>

                    <TitledPane text="Skrzynia Biegów" collapsible="true" expanded="false">
                        <VBox spacing="5">
                            <Label text="Nazwa:"/>
                            <TextField/>
                            <Label text="Cena:"/>
                            <TextField/>
                            <Label text="Waga:"/>
                            <TextField/>
                            <Label text="Aktualny Bieg:"/>
                            <TextField/>
                            <HBox spacing="10" alignment="CENTER">
                                <Button text="Zwiększ bieg"/>
                                <Button text="Zmniejsz bieg"/>
                            </HBox>
                        </VBox>
                    </TitledPane>

                    <TitledPane text="Silnik" collapsible="true" expanded="false">
                        <VBox spacing="5">
                            <Label text="Nazwa:"/>
                            <TextField/>
                            <Label text="Cena:"/>
                            <TextField/>
                            <Label text="Waga:"/>
                            <TextField/>
                            <Label text="Obroty:"/>
                            <TextField/>
                            <HBox spacing="10" alignment="CENTER">
                                <Button text="Zwiększ obroty"/>
                                <Button text="Zmniejsz obroty"/>
                            </HBox>
                        </VBox>
                    </TitledPane>

                    <TitledPane text="Sprzęgło" collapsible="true" expanded="false">
                        <VBox spacing="5">
                            <Label text="Nazwa:"/>
                            <TextField/>
                            <Label text="Cena:"/>
                            <TextField/>
                            <Label text="Waga:"/>
                            <TextField/>
                            <Label text="Stan:"/>
                            <TextField/>
                            <HBox spacing="10" alignment="CENTER">
                                <Button text="Wciśnij"/>
                                <Button text="Zwolnij"/>
                            </HBox>
                        </VBox>
                    </TitledPane>

                </VBox>
            </content>
        </ScrollPane>
    </left>

    <center>
        <StackPane style="-fx-background-color: #90ee90;"> <ImageView fitHeight="200.0" fitWidth="300.0" pickOnBounds="true" preserveRatio="true">
                 </ImageView>
            <Label text="Miejsce na obrazek samochodu (ImageView)" textFill="#555555"/>
        </StackPane>
    </center>

</BorderPane>