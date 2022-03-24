package ru.regiuss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.regiuss.model.Transport;

public interface TransportRepository extends JpaRepository<Transport, Integer> {
}
