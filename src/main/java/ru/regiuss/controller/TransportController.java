package ru.regiuss.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import ru.regiuss.model.Transport;
import ru.regiuss.service.TransportService;
import ru.regiuss.utils.Views;

import java.util.List;

@RestController
@RequestMapping("/transport")
public class TransportController {
    private final TransportService service;

    public TransportController(TransportService service) {
        this.service = service;
    }

    @GetMapping()
    @JsonView(Views.Public.class)
    public Page<Transport> getAll(
            @RequestParam(name = "limit", defaultValue = "100", required = false) Integer limit,
            @RequestParam(name = "page", defaultValue = "0", required = false) Integer page
    ){
        return service.getAll(PageRequest.of(page, limit));
    }

    @GetMapping("/{id}")
    @JsonView(Views.Public.class)
    public Transport get(@PathVariable Integer id){
        return service.get(id);
    }

    @PostMapping()
    @JsonView(Views.Public.class)
    public Transport save(@RequestBody Transport transport){
        transport.setId(null);
        service.save(transport);
        return transport;
    }

    @PutMapping("/{id}")
    @JsonView(Views.Public.class)
    public Transport update(@PathVariable("id") Transport transportDB, @RequestBody Transport transport){
        transportDB.setBrand(transport.getBrand());
        transportDB.setNumber(transport.getNumber());
        transportDB.setType(transport.getType());
        service.save(transportDB);
        return transportDB;
    }
}
