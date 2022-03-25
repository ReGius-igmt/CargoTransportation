package ru.regiuss.server.controller;

import org.springframework.web.bind.annotation.*;
import ru.regiuss.server.model.Point;
import ru.regiuss.server.service.RouteService;

import java.util.List;

@RestController
@RequestMapping("/route")
public class RouteController {

    private final RouteService service;

    public RouteController(RouteService service) {
        this.service = service;
    }

    @GetMapping("/points")
    public List<Point> getAllPoints(){
        return service.getAllPoints();
    }

    @GetMapping("/points/{id}")
    public Point get(@PathVariable Integer id){
        return service.getPoint(id);
    }

    @PostMapping("/points")
    public Point get(@RequestBody Point point){
        point.setId(null);
        service.save(point);
        return point;
    }
}
