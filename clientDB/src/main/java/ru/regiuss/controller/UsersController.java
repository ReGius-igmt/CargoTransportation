package ru.regiuss.controller;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Pagination;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import ru.regiuss.core.ViewHandler;
import ru.regiuss.model.User;
import ru.regiuss.viewmodel.UserVM;

public class UsersController {

    @FXML
    private Pagination pagination;
    private ViewHandler vh;
    private UserVM vm;
    private ListView<User> userListView;

    public void init(ViewHandler vh, UserVM vm){
        this.vh = vh;
        userListView = new ListView<>();
        userListView.itemsProperty().bind(vm.usersProperty());
        userListView.setCellFactory(userListView1 -> new ListCell<>(){
            private final Text name;

            {
                name = new Text();
            }

            @Override
            protected void updateItem(User user, boolean b) {
                super.updateItem(user, b);
                if(!b){
                    name.setText(user.getFistName() + " "  + user.getLastName());
                    setGraphic(name);
                } else setGraphic(null);
            }
        });
        pagination.setPageFactory(page -> {
            vm.loadPage();
            return userListView;
        });
        pagination.currentPageIndexProperty().bindBidirectional(vm.curPageProperty());
        pagination.pageCountProperty().bind(vm.pageCountProperty());
    }

}
