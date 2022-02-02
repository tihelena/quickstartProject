package com.geekbrains.hw_4;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TriangleTest {
    Triangle triangle;
    private static Logger logger = LoggerFactory.getLogger("TriangleTest.class");

    @BeforeAll
    static void beforeAll() {

        logger.info("log data");
        logger.trace("trace log data");
        logger.error("err log data");
    }

    @ParameterizedTest
    @MethodSource("triangleDataProvider")
    @DisplayName("Площадь треугольника вычислена")
    void squareTriangleComputed(Triangle test) throws isNotTriangleException {
        assertTrue(Triangle.squareOfTriangle(test) > 0);
    }

    private static List<Triangle> triangleDataProvider() {
        return Arrays.asList(new Triangle(1, 1, 1), new Triangle(100, 200, 150),
                new Triangle(777, 500, 278));
    }

    @ParameterizedTest
    @MethodSource("DataProviderWithNullSide")
    @DisplayName("Длина одной или нескольких сторон = 0")
    void squareTriangleWithNullSide(Triangle test) throws isNotTriangleException {
        assertTrue(Triangle.squareOfTriangle(test) == 0);
    }

    private static List<Triangle> DataProviderWithNullSide() {
        return Arrays.asList(new Triangle(0, 0, 0), new Triangle(0, 200, 150),
                new Triangle(777, 0, 276), new Triangle(8,7,0));
    }

    @ParameterizedTest
    @MethodSource("DataProviderWithNegativeSide")
    @DisplayName("Длина одной или нескольких сторон < 0")
    void squareTriangleWithNegativeSide(Triangle test) throws isNotTriangleException {
        assertTrue(Triangle.squareOfTriangle(test) == 0);
    }

    private static List<Triangle> DataProviderWithNegativeSide() {
        return Arrays.asList(new Triangle(-6, -5, -3), new Triangle(-1000, 800, 300),
                new Triangle(777, -600, 276), new Triangle(8,7,-9));
    }

    @ParameterizedTest
    @MethodSource("DataProviderDegenerate")
    @DisplayName("Вырожденный треугольник")
    void squareTriangleDegenerate(Triangle test) throws isNotTriangleException {
        assertTrue(Triangle.squareOfTriangle(test) == 0);
    }

    private static List<Triangle> DataProviderDegenerate() {
        return Arrays.asList(new Triangle(6, 5, 11), new Triangle(200, 600, 300),
                new Triangle(15, 4, 10));
    }


}
