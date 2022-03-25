package ru.regiuss.client.model;

public class Point extends ru.regiuss.routelibrary.Point {

    protected Integer id;

    public Point(double x, double y) {
        super(x, y);
    }

    public Point(Integer id, double x, double y) {
        super(x, y);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
