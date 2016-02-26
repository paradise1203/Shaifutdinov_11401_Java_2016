package com.aidar.oo4.music.melody.test;

import com.aidar.oo4.music.melody.Melody;
import com.aidar.oo4.music.melody.impl.FastMelody;
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

public class FastMelodyTest {

    private Melody melody;

    private String getAuthor() {
        return "Mick";
    }

    private List<Sound> getSounds() {
        String note1 = "do";
        String note2 = "la";
        String note3 = "si";
        List<Sound> sounds = new ArrayList<>();
        Sound sound1 = mock(GuitarSound.class);
        when(sound1.getNote()).thenReturn(note1);
        sounds.add(sound1);
        Sound sound2 = mock(GuitarSound.class);
        when(sound2.getNote()).thenReturn(note2);
        sounds.add(sound2);
        Sound sound3 = mock(GuitarSound.class);
        when(sound3.getNote()).thenReturn(note3);
        sounds.add(sound3);
        return sounds;
    }

    @Before
    public void initializeMelody() {
        melody = new FastMelody(getAuthor(), getSounds());
    }

    @Test
    public void parameterisedConstructorShouldWorkCorrect() {
        assertEquals(getAuthor(), melody.getAuthor());
        melody.getSounds().removeAll(getSounds());
        assertEquals(0, melody.getSounds().size());
    }

    @Test
    public void addOrchestraShouldWorkCorrect() {
        Orchestra orchestra = mock(RoyalOrchestra.class);
        melody.addOrchestra(orchestra);
        assertTrue(orchestra.equals(melody.getPlayedByOrch().get(0)));
    }

}
