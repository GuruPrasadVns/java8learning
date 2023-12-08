package com.model;

public class Tile {
    private String company;
    private String color;
    private int cost;

    public Tile(String company, String color, int cost){
        this.company = company;
        this.color = color;
        this.cost = cost;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Tile{" +
                "company='" + company + '\'' +
                ", color='" + color + '\'' +
                ", cost=" + cost +
                '}';
    }
}
