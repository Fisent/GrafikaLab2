package com.company.Model;

/**
 * Created by Fisent on 01.11.2017.
 */
public class Point {
    public int x, y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int distance(Point other){
        return Math.abs(x - other.x) + Math.abs(y - other.y);
    }
}
