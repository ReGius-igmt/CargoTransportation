package ru.regiuss.client.core;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.regiuss.client.controller.MainController;
import ru.regiuss.client.controller.UsersController;

import java.io.IOException;

public class ViewHandler {
    private final Stage stage;
    private final ViewModelFactory vmf;
    private ObjectProperty<Node> rootNode;

    public ViewHandler(Stage stage, ViewModelFactory vmf) {
        this.stage = stage;
        this.vmf = vmf;
        this.rootNode = new SimpleObjectProperty<>();
    }

    public void init(){
        stage.setTitle("Пассажиравтотранс");
        stage.setMinWidth(800);
        stage.setMinHeight(600);
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/main.fxml"));
            Parent p = loader.load();
            ((MainController)loader.getController()).init(this);
            stage.setScene(new Scene(p));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.show();
        openUsersPage();
    }

    public void openUsersPage(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/users.fxml"));
            Parent p = loader.load();
            ((UsersController)loader.getController()).init(this, vmf.getUserVM());
            rootNode.set(p);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Node getRootNode() {
        return rootNode.get();
    }

    public ObjectProperty<Node> rootNodeProperty() {
        return rootNode;
    }
}
