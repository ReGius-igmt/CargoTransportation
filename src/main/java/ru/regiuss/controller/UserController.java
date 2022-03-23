package ru.regiuss.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.regiuss.model.User;
import ru.regiuss.service.UserService;
import ru.regiuss.utils.Utils;
import ru.regiuss.utils.Views;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    @JsonView(Views.Public.class)
    private User get(@PathVariable(required = true) Integer id){
        return service.get(id);
    }

    @GetMapping()
    @JsonView(Views.Public.class)
    private Page<User> getAll(
            @RequestParam(name = "limit", defaultValue = "100", required = false) Integer limit,
            @RequestParam(name = "page", defaultValue = "0", required = false) Integer page
    ){
        return service.getAll(limit, page);
    }

    @PostMapping()
    @JsonView(Views.Public.class)
    private User getAll(@RequestBody User user){
        user.setId(null);
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] bytes = digest.digest(user.getPass().getBytes(StandardCharsets.UTF_8));
            user.setPass(Utils.getHash(bytes));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        service.save(user);
        return user;
    }

    @PutMapping("/{id}")
    @JsonView(Views.Public.class)
    private User getAll(@PathVariable("id") User userDB, @RequestBody User user){
        userDB.setFistName(user.getFistName());
        userDB.setLastName(user.getLastName());
        userDB.setPatronymic(user.getPatronymic());
        userDB.setRoles(user.getRoles());
        userDB.setLogin(user.getLogin());
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] bytes = digest.digest(user.getPass().getBytes(StandardCharsets.UTF_8));
            userDB.setPass(Utils.getHash(bytes));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        service.save(userDB);
        return userDB;
    }
}
