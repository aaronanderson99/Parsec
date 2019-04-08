package com.example.parsec.model;

/**
 * The type Coordinate.
 */
public class Coordinate {
    private int x;
    private int y;

    /**
     * Instantiates a new Coordinate.
     *
     * @param x the x
     * @param y the y
     */
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Sets x.
     *
     * @param x the x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Sets y.
     *
     * @param y the y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Gets x.
     *
     * @return the x
     */
    public int getX() {
        return this.x;
    }

    /**
     * Gets y.
     *
     * @return the y
     */
    public int getY() {
        return this.y;
    }

    /**
     * Gets distance.
     *
     * @param p2 the p 2
     * @return the distance
     */
    public double getDistance(Coordinate p2) {
        return Math.sqrt((this.x - p2.x)*(this.x - p2.x) + (this.y - p2.y)*(this.y - p2.y));
    }
}
