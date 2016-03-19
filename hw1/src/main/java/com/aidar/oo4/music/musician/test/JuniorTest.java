package com.aidar.oo4.music.musician.test;

import com.aidar.oo4.music.instrument.Instrument;
import com.aidar.oo4.music.instrument.impl.Guitar;
import com.aidar.oo4.music.inventor.Inventor;
import com.aidar.oo4.music.inventor.impl.SpecificInstrumentsInventor;
import com.aidar.oo4.music.musician.Musician;
import com.aidar.oo4.music.musician.impl.Junior;
import com.aidar.oo4.music.orchestra.Orchestra;
import com.aidar.oo4.music.orchestra.impl.RoyalOrchestra;
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

public class JuniorTest {

    private Musician musician;
    private Instrument instrument;

    private Instrument mockInstrument() {
        String name = "George";
        int rating = 19;
        Instrument instrument = mock(Guitar.class);
        Inventor inventor = mock(SpecificInstrumentsInventor.class);
        when(inventor.getName()).thenReturn(name);
        when(inventor.getRating()).thenReturn(rating);
        when(instrument.inventedBy()).thenReturn(inventor);
        return instrument;
    }

    @Before
    public void initializeMusician() {
        instrument = mockInstrument();
        musician = new Junior(instrument);
    }

    @Test
    public void parameterisedConstructorShouldWorkCorrect() {
        assertEquals(instrument, musician.getInstrument());
    }

    @Test
    public void playShouldWorkCorrect() {
        String note1 = "do";
        String note2 = "la";
        String note3 = "si";
        List<Sound> sounds = new ArrayList<>();
        Sound sound1 = mock(GuitarSound.class);
        when(sound1.getNote()).thenReturn(note1);
        when(sound1.getSource()).thenReturn(instrument);
        sounds.add(sound1);
        Sound sound2 = mock(GuitarSound.class);
        when(sound2.getNote()).thenReturn(note2);
        when(sound2.getSource()).thenReturn(instrument);
        sounds.add(sound2);
        Sound sound3 = mock(GuitarSound.class);
        when(sound3.getNote()).thenReturn(note3);
        when(sound3.getSource()).thenReturn(instrument);
        sounds.add(sound3);
        when(instrument.makeSound()).thenReturn(sounds);
        List<Sound> res = musician.play(1);
        res.removeAll(sounds);
        assertTrue(res.size() == 0);
    }

    @Test
    public void enterOrchestraShouldWorkCorrect() {
        Orchestra orchestra = new RoyalOrchestra();
        musician.enterOrchestra(orchestra);
        assertEquals(orchestra, musician.getOrchestra());
    }

}
