package ru.regiuss.cargotransportation.server.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.regiuss.cargotransportation.server.exception.UserNotFoundException;
import ru.regiuss.cargotransportation.server.model.User;
import ru.regiuss.cargotransportation.server.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public Page<User> getAll(int limit, int page){
        if(limit > 100)limit = 100;
        return repository.findAll(PageRequest.of(page, limit));
    }

    public User get(int id){
        return repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    public void save(User user){
        repository.saveAndFlush(user);
    }
}
