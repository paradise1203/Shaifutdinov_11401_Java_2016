package com.aidar.oo3;

import org.springframework.stereotype.Component;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Component
public class ComplexMatrix2x2Util {

    public static void initializeWithOneValue(ComplexNumber[][] matrix, ComplexNumber value) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = value;
            }
        }
    }

    public static ComplexNumber getComplexNumber(double re, double im) {
        ComplexNumber complexNumber = mock(ComplexNumber.class);
        when(complexNumber.getIm()).thenReturn(im);
        when(complexNumber.getRe()).thenReturn(re);
        return complexNumber;
    }

}
