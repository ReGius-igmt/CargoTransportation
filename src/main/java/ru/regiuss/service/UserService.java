package ru.regiuss.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.regiuss.model.User;
import ru.regiuss.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public Page<User> getAll(Integer limit, Integer page){
        Pageable pageable = PageRequest.of(page, limit);
        return repository.findAll(pageable);
    }

    public User get(Integer id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("User no found"));
    }

    public void save(User user) {
        repository.save(user);
    }
}
