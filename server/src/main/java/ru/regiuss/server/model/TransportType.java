package ru.regiuss.server.model;

import com.fasterxml.jackson.annotation.JsonView;
import ru.regiuss.server.utils.Views;

import javax.persistence.*;

@Entity
@Table(name = "transport_types")
public class TransportType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @JsonView(Views.Public.class)
    private Integer id;

    @Column(name = "name", nullable = false, length = 45)
    @JsonView(Views.Public.class)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}