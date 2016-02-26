package com.aidar.oo4.music.musician.impl;


import com.aidar.oo4.music.instrument.Instrument;
import com.aidar.oo4.music.musician.Musician;
import com.aidar.oo4.music.orchestra.Orchestra;
import com.aidar.oo4.music.sound.Sound;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Senior implements Musician {

    private Instrument instrument;

    private Orchestra orchestra;

    private Set<Sound> bestSounds;

    public Senior(Instrument instrument) {
        this.instrument = instrument;
    }

    @Override
    public List<Sound> play(int duration) {
        List<Sound> sounds = new LinkedList<>();
        while (duration-- > 0) {
            sounds.addAll(instrument.makeSound());
        }
        return sounds;
    }

    @Override
    public void enterOrchestra(Orchestra o) {
        this.orchestra = orchestra;
    }

    @Override
    public String leaveOrchestra() {
        orchestra.removeMusician(this);
        return "You are too ordinal!";
    }

    @Override
    public Orchestra getOrchestra() {
        return orchestra;
    }

    @Override
    public Instrument getInstrument() {
        return instrument;
    }

    @Override
    public Instrument breakInstrument() {
        instrument.setBroken();
        return instrument;
    }

}
