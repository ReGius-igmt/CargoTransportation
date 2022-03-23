package ru.regiuss.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.regiuss.model.Transport;
import ru.regiuss.repository.TransportRepository;

import java.util.List;

@Service
public class TransportService {
    private final TransportRepository repository;

    public TransportService(TransportRepository repository) {
        this.repository = repository;
    }

    public Page<Transport> getAll(Pageable pageable){
        return repository.findAll(pageable);
    }

    public Transport get(Integer id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Transport no found"));
    }

    public void save(Transport transport) {
        repository.save(transport);
    }
}
