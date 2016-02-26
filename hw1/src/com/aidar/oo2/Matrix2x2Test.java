package com.aidar.oo2;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class Matrix2x2Test {

    private static final double EPS = 1e-9;

    @Test
    public void defaultConstructorShouldWorkCorrect() {
        double[][] mas = {{0, 0}, {0, 0}};
        Matrix2x2 matrix = new Matrix2x2();
        Assert.assertTrue(Arrays.deepEquals(matrix.getMatrix(), mas));
    }

    @Test
    public void OnePrimitiveValueConstructorShouldWorkCorrect() {
        double testValue = 100;
        double[][] mas = {{testValue, testValue}, {testValue, testValue}};
        Matrix2x2 matrix = new Matrix2x2(testValue);
        Assert.assertTrue(Arrays.deepEquals(matrix.getMatrix(), mas));
    }

    @Test
    public void FourPrimitiveValuesConstructorShouldWorkCorrect() {
        double v1 = 10, v2 = 20, v3 = 30, v4 = 40;
        double[][] mas = {{v1, v2}, {v3, v4}};
        Matrix2x2 matrix = new Matrix2x2(v1, v2, v3, v4);
        Assert.assertTrue(Arrays.deepEquals(matrix.getMatrix(), mas));
    }

    @Test
    public void arrayValueConstructorShouldWorkCorrect() {
        double[][] mas = {{10, 20}, {30, 40}};
        Matrix2x2 matrix = new Matrix2x2(mas);
        Assert.assertTrue(Arrays.deepEquals(matrix.getMatrix(), mas));
    }

    @Test
    public void addShouldReturnSumOfMatrices() {
        Matrix2x2 arg = new Matrix2x2(10);
        Matrix2x2 res = new Matrix2x2(20);
        Assert.assertTrue(Arrays.deepEquals(arg.add(arg).getMatrix(), res.getMatrix()));
    }

    @Test
    public void add2ShouldWorkCorrect() {
        Matrix2x2 arg = new Matrix2x2(10);
        Matrix2x2 res = new Matrix2x2(20);
        arg.add2(arg);
        Assert.assertTrue(Arrays.deepEquals(arg.getMatrix(), res.getMatrix()));
    }

    @Test
    public void subShouldReturnSubtractionOfMatrices() {
        Matrix2x2 source = new Matrix2x2(20);
        Matrix2x2 arg = new Matrix2x2(15);
        Matrix2x2 res = new Matrix2x2(5);
        Assert.assertTrue(Arrays.deepEquals(source.sub(arg).getMatrix(), res.getMatrix()));
    }

    @Test
    public void sub2ShouldWorkCorrect() {
        Matrix2x2 source = new Matrix2x2(20);
        Matrix2x2 arg = new Matrix2x2(15);
        source.sub2(arg);
        Matrix2x2 res = new Matrix2x2(5);
        Assert.assertTrue(Arrays.deepEquals(source.getMatrix(), res.getMatrix()));
    }

    @Test
    public void multNumberShouldReturnMatrixMultipliedByValue() {
        Matrix2x2 source = new Matrix2x2(20);
        Matrix2x2 res = new Matrix2x2(200);
        Assert.assertTrue(Arrays.deepEquals(source.multNumber(10).getMatrix(), res.getMatrix()));
    }

    @Test
    public void multNumber2ShouldWorkCorrect() {
        Matrix2x2 source = new Matrix2x2(20);
        source.multNumber2(5);
        Matrix2x2 res = new Matrix2x2(100);
        Assert.assertTrue(Arrays.deepEquals(source.getMatrix(), res.getMatrix()));
    }

    @Test
    public void multShouldReturnMatrixMultipliedByMatrix() {
        Matrix2x2 source = new Matrix2x2(20);
        Matrix2x2 res = new Matrix2x2(800);
        Assert.assertTrue(Arrays.deepEquals(source.mult(source).getMatrix(), res.getMatrix()));
    }

    @Test
    public void mult2ShouldWorkCorrect() {
        Matrix2x2 source = new Matrix2x2(20);
        Matrix2x2 res = new Matrix2x2(800);
        source.mult2(source);
        Assert.assertTrue(Arrays.deepEquals(source.getMatrix(), res.getMatrix()));
    }

    @Test
    public void detShouldReturnMatrixDeterminant() {
        Matrix2x2 matrix = new Matrix2x2(new double[][]{{1, 3}, {4, 5}});
        Assert.assertEquals(-7, matrix.det(), EPS);
    }

    @Test
    public void transponShouldWorkCorrect() {
        Matrix2x2 matrix = new Matrix2x2(new double[][]{{1, 3}, {4, 5}});
        matrix.transpon();
        Matrix2x2 res = new Matrix2x2(new double[][]{{1, 4}, {3, 5}});
        Assert.assertTrue(Arrays.deepEquals(matrix.getMatrix(), res.getMatrix()));
    }

    @Test
    public void inverseMatrixWithZeroDetShouldThrowException() {
        Matrix2x2 matrix = new Matrix2x2();
        try {
            matrix.inverseMatrix();
            Assert.fail();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void inverseMatrixWithNonZeroDetShouldWorkCorrect() {
        Matrix2x2 matrix = new Matrix2x2(new double[][]{{3, 4}, {5, 7}});
        Matrix2x2 res = new Matrix2x2(new double[][]{{7, -4}, {-5, 3}});
        try {
            Assert.assertTrue(Arrays.deepEquals(matrix.inverseMatrix().getMatrix(), res.getMatrix()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void equivalentDiagonalShouldReturnDiagonalMatrix() {
        Matrix2x2 matrix = new Matrix2x2(new double[][]{{1, 1}, {2, 3}});
        Matrix2x2 res = new Matrix2x2(new double[][]{{1, 0}, {0, 3}});
        Assert.assertTrue(Arrays.deepEquals(matrix.equivalentDiagonal().getMatrix(), res.getMatrix()));
    }

    @Test
    public void multVectorShouldReturnCorrectVector2D() {
        Matrix2x2 matrix = new Matrix2x2(new double[][]{{2, 5}, {1, 7}});
        Vector2D vector = matrix.multVector(new Vector2D(3, 4));
        Vector2D res = new Vector2D(26, 31);
        Assert.assertEquals(res.getX(), vector.getX(), EPS);
        Assert.assertEquals(res.getY(), vector.getY(), EPS);
    }

}
