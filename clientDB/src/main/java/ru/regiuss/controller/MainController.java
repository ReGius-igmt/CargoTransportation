package ru.regiuss.controller;

import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import ru.regiuss.core.ViewHandler;

public class MainController {

    @FXML
    private BorderPane root;
    private ViewHandler vh;

    public void init(ViewHandler vh){
        this.vh = vh;
        root.centerProperty().bind(vh.rootNodeProperty());
    }

}
