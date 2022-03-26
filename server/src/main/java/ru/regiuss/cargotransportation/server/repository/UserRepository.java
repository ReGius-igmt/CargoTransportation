package ru.regiuss.cargotransportation.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.regiuss.cargotransportation.server.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}