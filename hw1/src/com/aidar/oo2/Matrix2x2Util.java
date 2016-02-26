package com.aidar.oo2;

public class Matrix2x2Util {

    public static void initializeWithOneValue(double[][] matrix, double value) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = value;
            }
        }
    }

    public static void oper(Operation o, Matrix2x2 m1, Matrix2x2 m2, double[][] mas) {
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                mas[i][j] = o == Operation.ADD ?
                        m1.getMatrix()[i][j] + m2.getMatrix()[i][j] :
                        m1.getMatrix()[i][j] - m2.getMatrix()[i][j];
            }
        }
    }

    public static void mult(Matrix2x2 m, double value, double[][] mas) {
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                mas[i][j] = m.getMatrix()[i][j] * value;
            }
        }
    }

    public static void mult(Matrix2x2 m1, Matrix2x2 m2, double[][] mas) {
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[0].length; j++) {
                for (int l = 0; l < mas.length; l++) {
                    mas[i][j] += m1.getMatrix()[i][l] * m2.getMatrix()[l][j];
                }
            }
        }
    }

}
