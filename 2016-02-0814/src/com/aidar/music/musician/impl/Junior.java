package com.aidar.music.musician.impl;

import com.aidar.music.instrument.Instrument;
import com.aidar.music.musician.Musician;
import com.aidar.music.orchestra.Orchestra;
import com.aidar.music.sound.Sound;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Junior implements Musician {

    private Instrument instrument;

    private Orchestra orchestra;

    private Set<Sound> bestSounds;

    public Junior(Instrument instrument) {
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
        return "I can`t afford it anymore...";
    }

    @Override
    public Instrument breakInstrument() {
        instrument.setBroken();
        return instrument;
    }

}
