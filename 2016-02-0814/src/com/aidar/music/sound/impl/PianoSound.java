package com.aidar.music.sound.impl;

import com.aidar.music.instrument.Instrument;
import com.aidar.music.sound.Sound;

public class PianoSound implements Sound {

    private String note;

    private Instrument source;

    public PianoSound(String note, Instrument source) {
        this.note = note;
        this.source = source;
    }

    @Override
    public String getNote() {
        return note;
    }

    @Override
    public Instrument getSource() {
        return source;
    }

    @Override
    public void sound() {
        System.out.println(note);
    }

}
