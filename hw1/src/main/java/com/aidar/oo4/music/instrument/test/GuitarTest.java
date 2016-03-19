package com.aidar.oo4.music.instrument.test;

import com.aidar.oo4.music.instrument.Instrument;
import com.aidar.oo4.music.instrument.impl.Guitar;
import com.aidar.oo4.music.inventor.Inventor;
import com.aidar.oo4.music.inventor.impl.SpecificInstrumentsInventor;
import com.aidar.oo4.music.sound.Sound;
import com.aidar.oo4.music.sound.impl.GuitarSound;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GuitarTest {

    private Instrument guitar;

    private Inventor inventor;

    private Inventor mockInventor() {
        String name = "Alex";
        int rating = 100;
        Inventor inventor = mock(SpecificInstrumentsInventor.class);
        when(inventor.getName()).thenReturn(name);
        when(inventor.getRating()).thenReturn(rating);
        return inventor;
    }

    @Before
    public void initializeGuitar() {
        inventor = mockInventor();
        guitar = new Guitar(inventor);
    }

    @Test
    public void parameterisedConstructorShouldWorkCorrect() {
        assertEquals(inventor, guitar.inventedBy());
    }

    @Test
    public void makeSoundShouldWorkCorrect() {
        String note1 = "do";
        String note2 = "la";
        String note3 = "si";
        List<Sound> sounds = new ArrayList<>();
        Sound sound1 = mock(GuitarSound.class);
        when(sound1.getNote()).thenReturn(note1);
        when(sound1.getSource()).thenReturn(guitar);
        sounds.add(sound1);
        Sound sound2 = mock(GuitarSound.class);
        when(sound2.getNote()).thenReturn(note2);
        when(sound2.getSource()).thenReturn(guitar);
        sounds.add(sound2);
        Sound sound3 = mock(GuitarSound.class);
        when(sound3.getNote()).thenReturn(note3);
        when(sound3.getSource()).thenReturn(guitar);
        sounds.add(sound3);
        List<Sound> res = guitar.makeSound();
        res.removeAll(sounds);
        assertTrue(res.size() == 0);
    }

    @Test
    public void equalsShouldWorkCorrect() {
        Instrument guitar = new Guitar(inventor);
        assertTrue(this.guitar.equals(guitar));
    }

}
