package ru.regiuss.server.model;

import javax.persistence.*;

@Entity
@Table(name = "points")
@Embeddable
public class Point extends ru.regiuss.routelibrary.Point {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    public Point() {}

    public Point(double x, double y) {
        super(x, y);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}