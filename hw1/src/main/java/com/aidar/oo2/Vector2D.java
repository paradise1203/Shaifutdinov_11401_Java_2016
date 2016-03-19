package com.aidar.oo2;

public class Vector2D {

    private double x;
    private double y;

    public Vector2D() {
    }

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Vector2D add(Vector2D v) {
        Vector2D res = new Vector2D();
        res.x = this.x + v.x;
        res.y = this.y + v.y;
        return res;
    }

    public double length() {
        return Math.sqrt(x * x + y * y);
    }

}