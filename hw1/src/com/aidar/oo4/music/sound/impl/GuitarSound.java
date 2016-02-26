package com.aidar.oo4.music.sound.impl;

import com.aidar.oo4.music.instrument.Instrument;
import com.aidar.oo4.music.sound.Sound;

public class GuitarSound implements Sound {

    private String note;

    private Instrument source;

    public GuitarSound() {
    }

    public GuitarSound(String note, Instrument source) {
        this.note = note;
        this.source = source;
    }

    @Override
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public Instrument getSource() {
        return source;
    }

    @Override
    public void sound() {
        System.out.print(note);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GuitarSound)) return false;

        GuitarSound sound = (GuitarSound) o;

        if (getNote() != null ? !getNote().equals(sound.getNote()) : sound.getNote() != null) return false;
        return getSource() != null ? getSource().equals(sound.getSource()) : sound.getSource() == null;

    }

    @Override
    public int hashCode() {
        int result = getNote() != null ? getNote().hashCode() : 0;
        result = 31 * result + (getSource() != null ? getSource().hashCode() : 0);
        return result;
    }
}
