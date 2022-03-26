package ru.regiuss.cargotransportation.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.regiuss.cargotransportation.server.model.Point;

public interface PointRepository extends JpaRepository<Point, Integer> {
}