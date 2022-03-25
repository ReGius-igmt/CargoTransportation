package ru.regiuss.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.regiuss.server.model.Transport;

public interface TransportRepository extends JpaRepository<Transport, Integer> {
}
