package ru.regiuss.cargotransportation.server.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.regiuss.cargotransportation.server.model.Point;
import ru.regiuss.cargotransportation.server.model.User;
import ru.regiuss.cargotransportation.server.repository.PointRepository;

@Service
public class RouteService {
    private final PointRepository pointRepository;

    public RouteService(PointRepository pointRepository) {
        this.pointRepository = pointRepository;
    }

    public Page<Point> getAllPoints(int limit, int page){
        if(limit > 100)limit = 100;
        return pointRepository.findAll(PageRequest.of(page, limit));
    }

    public Point getPoint(int id){
        return pointRepository.findById(id).orElseThrow(() -> new RuntimeException("Point no found"));
    }

    public void save(Point point){
        pointRepository.saveAndFlush(point);
    }
}
