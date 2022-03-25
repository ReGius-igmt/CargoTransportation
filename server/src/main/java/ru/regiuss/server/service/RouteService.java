package ru.regiuss.server.service;

import org.springframework.stereotype.Service;
import ru.regiuss.server.model.Point;
import ru.regiuss.server.repository.PointRepository;

import java.util.List;

@Service
public class RouteService {
    private final PointRepository pointRepository;

    public RouteService(PointRepository pointRepository) {
        this.pointRepository = pointRepository;
    }

    public List<Point> getAllPoints(){
        return pointRepository.findAll();
    }

    public Point getPoint(Integer id){
        return pointRepository.findById(id).orElseThrow(() -> new RuntimeException("Point nof found"));
    }

    public void save(Point point){
        pointRepository.saveAndFlush(point);
    }
}
