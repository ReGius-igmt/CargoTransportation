package ru.regiuss.viewmodel;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ru.regiuss.dao.UserDao;
import ru.regiuss.model.User;

import java.util.List;

public class UserVM {
    private final UserDao dao;
    private final ListProperty<User> users;
    private final IntegerProperty curPage;
    private final IntegerProperty pageCount;

    private final int PAGE_SIZE = 10;

    public UserVM(UserDao dao) {
        this.dao = dao;
        this.users = new SimpleListProperty<>();
        this.curPage = new SimpleIntegerProperty(0);
        this.pageCount = new SimpleIntegerProperty(0);
    }

    public List<User> getAll(){
        return dao.getAll();
    }

    public void loadPage(){
        pageCount.set((int) Math.ceil(dao.count()/(double)PAGE_SIZE));
        users.set(FXCollections.observableList(dao.getAllPage(curPage.get(), PAGE_SIZE)));
    }

    public long getCount(){
        return dao.count();
    }

    public ObservableList<User> getUsers() {
        return users.get();
    }

    public ListProperty<User> usersProperty() {
        return users;
    }

    public int getCurPage() {
        return curPage.get();
    }

    public IntegerProperty curPageProperty() {
        return curPage;
    }

    public int getPageCount() {
        return pageCount.get();
    }

    public IntegerProperty pageCountProperty() {
        return pageCount;
    }
}
