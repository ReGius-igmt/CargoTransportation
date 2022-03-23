package ru.regiuss.model;

import com.fasterxml.jackson.annotation.JsonView;
import ru.regiuss.utils.Views;

import javax.persistence.*;

@Entity
@Table(name = "transport")
public class Transport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @JsonView(Views.Public.class)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "type_id", nullable = false)
    @JsonView(Views.Public.class)
    private TransportType type;

    @Column(name = "brand", nullable = false, length = 20)
    @JsonView(Views.Public.class)
    private String brand;

    @Column(name = "number", nullable = false, length = 10)
    @JsonView(Views.Public.class)
    private String number;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public TransportType getType() {
        return type;
    }

    public void setType(TransportType type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}