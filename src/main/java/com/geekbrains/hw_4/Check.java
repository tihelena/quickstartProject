package com.geekbrains.hw_4;
import static com.geekbrains.hw_4.Triangle.squareOfTriangle;


public class Check {
    public static void main(String[] args) throws isNotTriangleException {
        Triangle item = new Triangle(5, 5,10);
        squareOfTriangle(item);
        System.out.println("======================");
        Triangle item1 = new Triangle(0,7,11);
        squareOfTriangle(item1);
        System.out.println(squareOfTriangle(item1));
        System.out.println("======================");
        Triangle item2 = new Triangle(78,60,100);
        squareOfTriangle(item2);

    }
}
