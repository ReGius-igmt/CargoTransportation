package ru.regiuss.cargotransportation.server.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.regiuss.cargotransportation.server.model.Transport;
import ru.regiuss.cargotransportation.server.repository.TransportRepository;

@Service
public class TransportService {
    private final TransportRepository repository;

    public TransportService(TransportRepository repository) {
        this.repository = repository;
    }

    public Page<Transport> getAll(int limit, int page){
        if(limit > 100)limit = 100;
        return repository.findAll(PageRequest.of(page, limit));
    }

    public Transport get(int id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Transport no found"));
    }

    public void save(Transport transport){
        repository.saveAndFlush(transport);
    }
}
