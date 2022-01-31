package com.geekbrains.hw_4;

public class Triangle {
    double sideA;
    double sideB;
    double sideC;
    double square;

    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double getSideC() {
        return sideC;
    }

    public double getSquare(Triangle triangle) {
        return square;
    }

    public void setSideA(double sideA) {
        this.sideA = sideA;
    }

    public void setSideB(double sideB) {
        this.sideB = sideB;
    }

    public void setSideC(double sideC) {
        this.sideC = sideC;
    }

    @Override
    public String toString() {
        Triangle triangle = new Triangle(sideA, sideB,sideC);
        String message = "";
        try {
           message =  "Triangle{" +
                    "sideA=" + sideA +
                    ", sideB=" + sideB +
                    ", sideC=" + sideC +
                    ", square=" + squareOfTriangle(triangle) +
                    '}';
        } catch (isNotTriangleException e) {
            e.printStackTrace();
        }
        return message;
    }

    public static boolean isTriangle(Triangle triangle) throws isNotTriangleException {
        if (triangle.sideA <= 0 || triangle.sideB <= 0 || triangle.sideC <= 0) {
            System.out.println("Длина стороны треугольника не может быть отрицательным числом или равной нулю");
            return false;
        }
        if (triangle.sideA + triangle.sideB <= triangle.sideC ||
                triangle.sideA + triangle.sideC <= triangle.sideB ||
                triangle.sideB + triangle.sideC <= triangle.sideA) {
            System.out.println("Сумма длин двух сторон треугольника должна быть больше длины третьей");
            return false;
        } else {
            System.out.println("Треугольник со стронами а = " + triangle.sideA + ", b = " + triangle.sideB
                    + ", c = " + triangle.sideC + " построен");
            return true;
        }
    }

    public static double squareOfTriangle(Triangle triangle) throws isNotTriangleException {
        double square = 0;
        if (isTriangle(triangle)) {
            double p = (triangle.sideA + triangle.sideB + triangle.sideC) / 2;
            square = Math.sqrt(p * (p - triangle.sideA) * (p - triangle.sideB) * (p - triangle.sideC));
            System.out.printf("Площадь треугольника: " + "%.2f", square);
            return square;
        } else {
            System.out.println("Фигура не является треугольником. Плошадь не вычислена");
            return square ;
        }
    }
}