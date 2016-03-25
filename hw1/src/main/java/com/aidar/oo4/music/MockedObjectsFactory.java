package com.aidar.oo4.music;

import com.aidar.oo4.music.instrument.Instrument;
import com.aidar.oo4.music.inventor.Inventor;
import com.aidar.oo4.music.inventor.impl.ClassicalInstrumentsInventor;
import com.aidar.oo4.music.sound.Sound;
import com.aidar.oo4.music.sound.impl.GuitarSound;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by paradise on 23.03.16.
 */
@Component
public class MockedObjectsFactory {

    public static Instrument getInstrument(Class<? extends Instrument> c) {
        String name = "John";
        int rating = 110;
        Instrument instrument = mock(c);
        Inventor inventor = mock(ClassicalInstrumentsInventor.class);
        when(inventor.getName()).thenReturn(name);
        when(inventor.getRating()).thenReturn(rating);
        when(instrument.inventedBy()).thenReturn(inventor);
        return instrument;
    }

    private static Sound getSound(String note, Instrument source) {
        Sound sound = mock(GuitarSound.class);
        when(sound.getNote()).thenReturn(note);
        when(sound.getSource()).thenReturn(source);
        return sound;
    }

    public static List<Sound> getSounds(Instrument guitar) {
        List<Sound> sounds = new ArrayList<>();
        sounds.add(getSound("do", guitar));
        sounds.add(getSound("la", guitar));
        sounds.add(getSound("si", guitar));
        return sounds;
    }

}
