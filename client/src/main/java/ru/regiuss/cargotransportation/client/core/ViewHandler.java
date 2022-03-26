package ru.regiuss.cargotransportation.client.core;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.regiuss.cargotransportation.client.controller.MainController;
import ru.regiuss.cargotransportation.client.controller.UsersController;

public class ViewHandler {

    private final ViewModelFactory vmf;
    private final Stage stage;
    private final ObjectProperty<Node> page;

    public ViewHandler(Stage stage, ViewModelFactory vmf) {
        this.stage = stage;
        this.vmf = vmf;
        this.page = new SimpleObjectProperty<>();
    }

    public void init() {
        stage.setTitle("Пассажиравтотранс");
        stage.setMinHeight(600);
        stage.setMinWidth(800);
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/main.fxml"));
            Parent p = loader.load();
            MainController controller = loader.getController();
            controller.init(this);
            stage.setScene(new Scene(p));
        }catch (Exception e){
            e.printStackTrace();
        }
        stage.show();
    }

    public void openUsersPage(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/users.fxml"));
            Parent p = loader.load();
            UsersController controller = loader.getController();
            controller.init(this);
            page.set(p);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Node getPage() {
        return page.get();
    }

    public ObjectProperty<Node> pageProperty() {
        return page;
    }

    public void exit() {
        stage.close();
    }
}
