package ru.regiuss.cargotransportation.server.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.regiuss.cargotransportation.server.model.User;
import ru.regiuss.cargotransportation.server.service.UserService;
import ru.regiuss.cargotransportation.server.utils.ResponseInfo;
import ru.regiuss.cargotransportation.server.utils.Utils;
import ru.regiuss.cargotransportation.server.utils.Views;

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

    @GetMapping()
    @JsonView(Views.Public.class)
    public ResponseInfo getAll(
            @RequestParam(name = "limit", defaultValue = "100") Integer limit,
            @RequestParam(name = "page", defaultValue = "0") Integer page
    ){
        return new ResponseInfo(true, service.getAll(limit, page));
    }

    @GetMapping("/{id}")
    @JsonView(Views.Public.class)
    public ResponseInfo get(@PathVariable Integer id){
        return new ResponseInfo(true, service.get(id));
    }

    @PostMapping()
    @JsonView(Views.Public.class)
    public ResponseInfo save(@RequestBody User user){
        user.setId(null);
        if(user.getPass() != null){
            try {
                MessageDigest digest = MessageDigest.getInstance("SHA-256");
                byte[] bytes = digest.digest(user.getPass().getBytes(StandardCharsets.UTF_8));
                user.setPass(Utils.getHash(bytes));
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        service.save(user);
        return new ResponseInfo(true, user);
    }

    @PutMapping("/{id}")
    @JsonView(Views.Public.class)
    public ResponseInfo update(@PathVariable("id") User userDB, @RequestBody User user){
        userDB.setFistName(user.getFistName());
        userDB.setLastName(user.getLastName());
        userDB.setPatronymic(user.getPatronymic());
        userDB.setRoles(user.getRoles());
        if(user.getPass() != null){
            try {
                MessageDigest digest = MessageDigest.getInstance("SHA-256");
                byte[] bytes = digest.digest(user.getPass().getBytes(StandardCharsets.UTF_8));
                userDB.setPass(Utils.getHash(bytes));
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        service.save(userDB);
        return new ResponseInfo(true, userDB);
    }
}
