package com.aidar.oo4.music.sound.test;

import com.aidar.oo4.music.instrument.Instrument;
import com.aidar.oo4.music.instrument.impl.Mandolina;
import com.aidar.oo4.music.inventor.Inventor;
import com.aidar.oo4.music.inventor.impl.SpecificInstrumentsInventor;
import com.aidar.oo4.music.sound.Sound;
import com.aidar.oo4.music.sound.impl.MandolinaSound;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MandolinaSoundTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void defaultConstructorShouldWorkCorrect() {
        Sound sound = new MandolinaSound();
        assertEquals(null, sound.getNote());
        assertEquals(null, sound.getSource());
    }

    @Test
    public void parameterisedConstructorShouldWorkCorrect() {
        String note = "fa";
        String name = "John";
        int rating = 10;
        Instrument mandolina = mock(Mandolina.class);
        Inventor inventor = mock(SpecificInstrumentsInventor.class);
        when(inventor.getName()).thenReturn(name);
        when(inventor.getRating()).thenReturn(rating);
        when(mandolina.inventedBy()).thenReturn(inventor);
        Sound sound = new MandolinaSound(note, mandolina);
        assertEquals(note, sound.getNote());
        assertEquals(mandolina, sound.getSource());
    }

    @Test
    public void soundShouldWork() {
        String note = "do";
        Sound sound = new MandolinaSound();
        sound.setNote(note);
        sound.sound();
        assertEquals(note, outContent.toString());
    }

    @Test
    public void equalsShouldWorkCorrect() {
        String note = "fa";
        String name = "John";
        int rating = 10;
        Instrument mandolina = mock(Mandolina.class);
        Inventor inventor = mock(SpecificInstrumentsInventor.class);
        when(inventor.getName()).thenReturn(name);
        when(inventor.getRating()).thenReturn(rating);
        when(mandolina.inventedBy()).thenReturn(inventor);
        Sound sound = new MandolinaSound(note, mandolina);
        Sound sound1 = new MandolinaSound(note, mandolina);
        assertTrue(sound.equals(sound1));
    }

}
