package com.aidar.oo4.music.inventor.test;

import com.aidar.oo4.music.instrument.Instrument;
import com.aidar.oo4.music.instrument.impl.Piano;
import com.aidar.oo4.music.inventor.Inventor;
import com.aidar.oo4.music.inventor.impl.ClassicalInstrumentsInventor;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ClassicalInstrumentsInventorTest {

    private static ApplicationContext context;

    private Inventor inventor;
    private String name = "John";
    private int rating = 110;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeClass
    public static void initializeContext() {
        context = new ClassPathXmlApplicationContext("010-spring-config.xml");
    }

    @Before
    public void initializeInventor() {
        inventor = (Inventor) context.getBean("inventor");
    }

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void parameterisedConstructorShouldWorkCorrect() {
        assertEquals(name, inventor.getName());
        assertEquals(rating, inventor.getRating());
    }

    @Test
    public void inventShouldWorkCorrect() {
        Instrument instrument = inventor.invent();
        Instrument res = mock(Piano.class);
        when(res.inventedBy()).thenReturn(inventor);
        assertTrue(instrument.inventedBy().equals(res.inventedBy()));
    }

    @Test
    public void adveritseShouldWorkCorrect() {
        inventor.advertise(1);
        assertEquals("Buy my instrument!", outContent.toString());
    }

    @Test
    public void equalsShouldWorkCorrect() {
        Inventor inventor = mock(ClassicalInstrumentsInventor.class);
        when(inventor.getName()).thenReturn(name);
        when(inventor.getRating()).thenReturn(rating);
        assertTrue(this.inventor.equals(inventor));
    }

}
