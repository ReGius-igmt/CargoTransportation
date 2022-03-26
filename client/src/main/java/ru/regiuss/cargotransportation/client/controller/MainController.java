package ru.regiuss.cargotransportation.client.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import ru.regiuss.cargotransportation.client.core.ViewHandler;

public class MainController {

    @FXML
    private BorderPane root;

    @FXML
    private AnchorPane sidePanel;

    @FXML
    private ToggleGroup sidePanelTG;
    private ViewHandler vh;

    @FXML
    void exit(ActionEvent event) {
        vh.exit();
    }

    public void init(ViewHandler vh) {
        this.vh = vh;
        this.root.centerProperty().bind(vh.pageProperty());
    }
}