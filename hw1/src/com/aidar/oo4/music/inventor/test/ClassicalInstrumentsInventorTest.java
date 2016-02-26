package com.aidar.oo4.music.inventor.test;

import com.aidar.oo4.music.instrument.Instrument;
import com.aidar.oo4.music.instrument.impl.Piano;
import com.aidar.oo4.music.inventor.Inventor;
import com.aidar.oo4.music.inventor.impl.ClassicalInstrumentsInventor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ClassicalInstrumentsInventorTest {

    private Inventor inventor;

    private String getName() {
        return "John";
    }

    private int getRating() {
        return 110;
    }

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Before
    public void initializeInventor() {
        inventor = new ClassicalInstrumentsInventor(getName(), getRating());
    }

    @Test
    public void parameterisedConstructorShouldWorkCorrect() {
        assertEquals(getName(), inventor.getName());
        assertEquals(getRating(), inventor.getRating());
    }

    @Test
    public void inventShouldWorkCorrect() {
        Instrument instrument = mock(Piano.class);
        when(instrument.inventedBy()).thenReturn(inventor);
        assertTrue(instrument.inventedBy().equals(inventor));
    }

    @Test
    public void adveritseShouldWorkCorrect() {
        inventor.advertise(1);
        assertEquals("Buy my instrument!", outContent.toString());
    }

    @Test
    public void equalsShouldWorkCorrect() {
        Inventor inventor = new ClassicalInstrumentsInventor(getName(), getRating());
        assertTrue(inventor.equals(this.inventor));
    }

}
