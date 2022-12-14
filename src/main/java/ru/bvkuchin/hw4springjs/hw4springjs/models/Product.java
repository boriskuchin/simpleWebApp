package ru.bvkuchin.hw4springjs.hw4springjs.models;

public class Product {

    private Integer id;
    private String name;
    private Double cost;
    private Integer quantity;





    public Product() {
    }

    public Product(Integer id, String name, Double cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.quantity = 1;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }



}
