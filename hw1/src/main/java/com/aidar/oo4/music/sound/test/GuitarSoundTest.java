package com.aidar.oo4.music.sound.test;

import com.aidar.oo4.music.instrument.Instrument;
import com.aidar.oo4.music.instrument.impl.Guitar;
import com.aidar.oo4.music.inventor.Inventor;
import com.aidar.oo4.music.inventor.impl.ClassicalInstrumentsInventor;
import com.aidar.oo4.music.sound.Sound;
import com.aidar.oo4.music.sound.impl.GuitarSound;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GuitarSoundTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void defaultConstructorShouldWorkCorrect() {
        Sound sound = new GuitarSound();
        assertEquals(null, sound.getNote());
        assertEquals(null, sound.getSource());
    }

    @Test
    public void parameterisedConstructorShouldWorkCorrect() {
        String note = "fa";
        String name = "John";
        int rating = 10;
        Instrument guitar = mock(Guitar.class);
        Inventor inventor = mock(ClassicalInstrumentsInventor.class);
        when(inventor.getName()).thenReturn(name);
        when(inventor.getRating()).thenReturn(rating);
        when(guitar.inventedBy()).thenReturn(inventor);
        Sound sound = new GuitarSound(note, guitar);
        assertEquals(note, sound.getNote());
        assertEquals(guitar, sound.getSource());
    }

    @Test
    public void soundShouldWork() {
        String note = "do";
        Sound sound = new GuitarSound();
        sound.setNote(note);
        sound.sound();
        assertEquals(note, outContent.toString());
    }

    @Test
    public void equalsShouldWorkCorrect() {
        String note = "fa";
        String name = "John";
        int rating = 10;
        Instrument guitar = mock(Guitar.class);
        Inventor inventor = mock(ClassicalInstrumentsInventor.class);
        when(inventor.getName()).thenReturn(name);
        when(inventor.getRating()).thenReturn(rating);
        when(guitar.inventedBy()).thenReturn(inventor);
        Sound sound = new GuitarSound(note, guitar);
        Sound sound1 = new GuitarSound(note, guitar);
        assertTrue(sound.equals(sound1));
    }

}
