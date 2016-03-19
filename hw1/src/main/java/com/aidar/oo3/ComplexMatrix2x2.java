package com.aidar.oo3;

public class ComplexMatrix2x2 {

    private ComplexNumber[][] matrix = new ComplexNumber[2][2];

    public ComplexMatrix2x2() {
        ComplexMatrix2x2Util.initializeWithOneValue(matrix, new ComplexNumber(0, 0));
    }

    public ComplexMatrix2x2(ComplexNumber number) {
        ComplexMatrix2x2Util.initializeWithOneValue(matrix, number);
    }

    public ComplexMatrix2x2(ComplexNumber n1, ComplexNumber n2, ComplexNumber n3, ComplexNumber n4) {
        matrix[0][0] = n1;
        matrix[0][1] = n2;
        matrix[1][0] = n3;
        matrix[1][1] = n4;
    }

    public ComplexNumber[][] getMatrix() {
        return matrix;
    }

    ComplexMatrix2x2 add(ComplexMatrix2x2 matrix) {
        ComplexNumber[][] mas = new ComplexNumber[2][2];
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
                mas[i][j] = matrix.getMatrix()[i][j].add(this.matrix[i][j]);
            }
        }
        ComplexMatrix2x2 res = new ComplexMatrix2x2();
        res.matrix = mas;
        return res;
    }

    ComplexMatrix2x2 mult(ComplexMatrix2x2 matrix) {
        ComplexNumber[][] mas = new ComplexNumber[2][2];
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[0].length; j++) {
                for (int l = 0; l < mas.length; l++) {
                    ComplexNumber mult = this.getMatrix()[i][l].mult(matrix.getMatrix()[l][j]);
                    mas[i][j] = mas[i][j] == null ? mult : mas[i][j].add(mult);
                }
            }
        }
        ComplexMatrix2x2 res = new ComplexMatrix2x2();
        res.matrix = mas;
        return res;
    }

}
