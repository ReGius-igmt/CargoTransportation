package ru.regiuss.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.regiuss.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    //Page<User> findAll(Pageable pageable);
}
