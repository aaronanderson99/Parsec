package com.example.parsec.model;

public class Coordinate {
    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }

    public double getDistance(Coordinate p2) {
        return Math.sqrt((this.x - p2.x)*(this.x - p2.x) + (this.y - p2.y)*(this.y - p2.y));
    }
}
