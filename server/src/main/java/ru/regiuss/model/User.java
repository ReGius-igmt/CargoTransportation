package ru.regiuss.model;

import com.fasterxml.jackson.annotation.JsonView;
import ru.regiuss.utils.Views;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @JsonView(Views.Public.class)
    private Integer id;

    @Column(name = "last_name", nullable = false, length = 15)
    @JsonView(Views.Public.class)
    private String lastName;

    @Column(name = "fist_name", nullable = false, length = 15)
    @JsonView(Views.Public.class)
    private String fistName;

    @Column(name = "patronymic", length = 15)
    @JsonView(Views.Public.class)
    private String patronymic;

    @Column(name = "login", nullable = false, length = 10)
    @JsonView(Views.Full.class)
    private String login;

    @Column(name = "pass", nullable = false, length = 256)
    @JsonView(Views.Full.class)
    private String pass;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name="user_roles")
    @Column(name="role")
    @JsonView(Views.Public.class)
    private List<Role> roles;

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}