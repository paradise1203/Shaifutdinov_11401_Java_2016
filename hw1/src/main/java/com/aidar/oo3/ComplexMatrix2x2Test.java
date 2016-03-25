package com.aidar.oo3;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

import static junit.framework.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

public class ComplexMatrix2x2Test {

    private static ApplicationContext context;

    private static final double EPS = 1e-9;

    @BeforeClass
    public static void initializeContext() {
        context = new ClassPathXmlApplicationContext("oo9-spring-config.xml");
    }

    @Test
    public void defaultConstructorShouldWorkCorrect() {
        ComplexMatrix2x2 matrix = (ComplexMatrix2x2) context.getBean("zeroMatrix");
        ComplexNumber complexNumber = ComplexMatrix2x2Util.getComplexNumber(0, 0);
        ComplexNumber[][] complexNumbers = new ComplexNumber[][]
                {{complexNumber, complexNumber}, {complexNumber, complexNumber}};
        assertTrue(Arrays.deepEquals(matrix.getMatrix(), complexNumbers));
    }

    @Test
    public void ConstructorWithComplexNumberParameterShouldWorkCorrect() {
        ComplexMatrix2x2 matrix = (ComplexMatrix2x2) context.getBean("nonZeroMatrix1");
        ComplexNumber complexNumber = ComplexMatrix2x2Util.getComplexNumber(1, 2);
        ComplexNumber[][] complexNumbers = new ComplexNumber[][]
                {{complexNumber, complexNumber}, {complexNumber, complexNumber}};
        assertTrue(Arrays.deepEquals(matrix.getMatrix(), complexNumbers));
    }

    @Test
    public void ConstructorWithComplexNumberParametersWorkCorrect() {
        ComplexMatrix2x2 matrix = (ComplexMatrix2x2) context.getBean("nonZeroMatrix2");
        ComplexNumber cN = ComplexMatrix2x2Util.getComplexNumber(1, 2);
        ComplexNumber[][] complexNumbers = new ComplexNumber[][]
                {{cN, cN}, {cN, cN}};
        assertTrue(Arrays.deepEquals(matrix.getMatrix(), complexNumbers));
    }

    @Test
    public void addShouldWorkCorrect() {
        ComplexMatrix2x2 matrix = (ComplexMatrix2x2) context.getBean("nonZeroMatrix3");
        ComplexNumber cN1 = ComplexMatrix2x2Util.getComplexNumber(10, 2);
        ComplexNumber cN2 = ComplexMatrix2x2Util.getComplexNumber(6, 8);
        ComplexNumber[][] complexNumbers = new ComplexNumber[][]
                {{cN1, cN1}, {cN2, cN2}};
        assertTrue(Arrays.deepEquals(matrix.add(matrix).getMatrix(), complexNumbers));
    }

    @Test
    public void multShouldWorkCorrect() {
        ComplexMatrix2x2 matrix = (ComplexMatrix2x2) context.getBean("zeroMatrix");
        ComplexNumber cN = ComplexMatrix2x2Util.getComplexNumber(0, 0);
        when(cN.add(any(ComplexNumber.class))).thenReturn(cN);
        when(cN.mult(any(ComplexNumber.class))).thenReturn(cN);
        ComplexNumber[][] complexNumbers = new ComplexNumber[][]
                {{cN, cN}, {cN, cN}};
        assertTrue(Arrays.deepEquals(matrix.mult(matrix).getMatrix(), complexNumbers));
    }

}
