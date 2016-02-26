package com.aidar.oo2;

public class Matrix2x2 {

    private double[][] matrix = new double[2][2];

    public Matrix2x2() {
        Matrix2x2Util.initializeWithOneValue(matrix, 0);
    }

    public Matrix2x2(double value) {
        Matrix2x2Util.initializeWithOneValue(matrix, value);
    }

    public Matrix2x2(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.arraycopy(matrix[i], 0, this.matrix[i], 0, matrix[i].length);
        }
    }

    public Matrix2x2(double v1, double v2, double v3, double v4) {
        matrix[0][0] = v1;
        matrix[0][1] = v2;
        matrix[1][0] = v3;
        matrix[1][1] = v4;
    }

    public double[][] getMatrix() {
        return matrix;
    }

    Matrix2x2 add(Matrix2x2 matrix) {
        double[][] mas = new double[2][2];
        Matrix2x2Util.oper(Operation.ADD, this, matrix, mas);
        return new Matrix2x2(mas);
    }

    void add2(Matrix2x2 matrix) {
        Matrix2x2Util.oper(Operation.ADD, this, matrix, this.matrix);
    }

    Matrix2x2 sub(Matrix2x2 matrix) {
        double[][] mas = new double[2][2];
        Matrix2x2Util.oper(Operation.SUB, this, matrix, mas);
        return new Matrix2x2(mas);
    }

    void sub2(Matrix2x2 matrix) {
        Matrix2x2Util.oper(Operation.SUB, this, matrix, this.matrix);
    }

    Matrix2x2 multNumber(double value) {
        double[][] mas = new double[2][2];
        Matrix2x2Util.mult(this, value, mas);
        return new Matrix2x2(mas);
    }

    void multNumber2(double value) {
        Matrix2x2Util.mult(this, value, this.matrix);
    }

    Matrix2x2 mult(Matrix2x2 matrix) {
        double[][] mas = new double[2][2];
        Matrix2x2Util.mult(this, matrix, mas);
        return new Matrix2x2(mas);
    }

    void mult2(Matrix2x2 matrix) {
        double[][] mas = new double[2][2];
        Matrix2x2Util.mult(this, matrix, mas);
        this.matrix = mas;
    }

    double det() {
        return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
    }

    void transpon() {
        double temp = matrix[0][1];
        matrix[0][1] = matrix[1][0];
        matrix[1][0] = temp;
    }

    Matrix2x2 inverseMatrix() throws Exception {
        if (det() == 0) {
            throw new Exception();
        }
        double[][] mas = new double[2][2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                mas[i][j] = Math.pow(-1, i + j) * matrix[(i + 1) % 2][(j + 1) % 2];
            }
        }
        Matrix2x2 m = new Matrix2x2(mas);
        m.transpon();
        m.multNumber2(1 / det());
        return m;
    }

    Matrix2x2 equivalentDiagonal() {
        double[][] mas = new double[2][2];
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
                mas[i][j] = i == j ? matrix[i][j] : 0;
            }
        }
        return new Matrix2x2(mas);
    }

    Vector2D multVector(Vector2D vector) {
        Vector2D res = new Vector2D();
        res.setX(matrix[0][0] * vector.getX() + matrix[0][1] * vector.getY());
        res.setY(matrix[1][0] * vector.getX() + matrix[1][1] * vector.getY());
        return res;
    }

}
