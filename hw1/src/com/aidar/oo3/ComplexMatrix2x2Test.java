package com.aidar.oo3;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

public class ComplexMatrix2x2Test {

    private static final double EPS = 1e-9;

    @Test
    public void defaultConstructorShouldWorkCorrect() {
        ComplexMatrix2x2 matrix = new ComplexMatrix2x2();
        ComplexNumber complexNumber = ComplexMatrix2x2Util.getComplexNumber(0, 0);
        ComplexNumber[][] complexNumbers = new ComplexNumber[][]
                {{complexNumber, complexNumber}, {complexNumber, complexNumber}};
        assertTrue(Arrays.deepEquals(matrix.getMatrix(), complexNumbers));
    }

    @Test
    public void ConstructorWithComplexNumberParameterShouldWorkCorrect() {
        double re = 1, im = 2;
        ComplexNumber complexNumber = ComplexMatrix2x2Util.getComplexNumber(re, im);
        ComplexMatrix2x2 matrix = new ComplexMatrix2x2(complexNumber);
        ComplexNumber[][] complexNumbers = new ComplexNumber[][]
                {{complexNumber, complexNumber}, {complexNumber, complexNumber}};
        assertTrue(Arrays.deepEquals(matrix.getMatrix(), complexNumbers));
    }

    @Test
    public void ConstructorWithComplexNumberParametersWorkCorrect() {
        double re = 1, im = 2;
        ComplexNumber cN = ComplexMatrix2x2Util.getComplexNumber(re, im);
        ComplexMatrix2x2 matrix = new ComplexMatrix2x2(cN, cN, cN, cN);
        ComplexNumber[][] complexNumbers = new ComplexNumber[][]
                {{cN, cN}, {cN, cN}};
        assertTrue(Arrays.deepEquals(matrix.getMatrix(), complexNumbers));
    }

    @Test
    public void addShouldWorkCorrect() {
        double re1 = 5, im1 = 1;
        double re2 = 3, im2 = 4;
        ComplexNumber cN1 = ComplexMatrix2x2Util.getComplexNumber(re1, im1);
        ComplexNumber cN2 = ComplexMatrix2x2Util.getComplexNumber(re2, im2);
        ComplexMatrix2x2 matrix = new ComplexMatrix2x2(cN1, cN1, cN2, cN2);
        double re3 = 10, im3 = 2;
        double re4 = 6, im4 = 8;
        ComplexNumber cN3 = ComplexMatrix2x2Util.getComplexNumber(re3, im3);
        ComplexNumber cN4 = ComplexMatrix2x2Util.getComplexNumber(re4, im4);
        when(cN1.add(any(ComplexNumber.class))).thenReturn(cN3);
        when(cN2.add(any(ComplexNumber.class))).thenReturn(cN4);
        ComplexMatrix2x2 res = new ComplexMatrix2x2(cN3, cN3, cN4, cN4);
        assertTrue(Arrays.deepEquals(matrix.add(matrix).getMatrix(), res.getMatrix()));
    }

    @Test
    public void multShouldWorkCorrect() {
        double re = 0, im = 0;
        ComplexNumber cN = ComplexMatrix2x2Util.getComplexNumber(re, im);
        when(cN.add(any(ComplexNumber.class))).thenReturn(cN);
        when(cN.mult(any(ComplexNumber.class))).thenReturn(cN);
        ComplexMatrix2x2 matrix = new ComplexMatrix2x2(cN, cN, cN, cN);
        ComplexNumber[][] complexNumbers = new ComplexNumber[][]
                {{cN, cN}, {cN, cN}};
        assertTrue(Arrays.deepEquals(matrix.mult(matrix).getMatrix(), complexNumbers));
    }

}
