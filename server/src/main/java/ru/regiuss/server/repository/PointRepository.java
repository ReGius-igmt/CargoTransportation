package ru.regiuss.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.regiuss.server.model.Point;

public interface PointRepository extends JpaRepository<Point, Integer> {
}
