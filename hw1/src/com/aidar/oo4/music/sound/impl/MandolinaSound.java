package com.aidar.oo4.music.sound.impl;


import com.aidar.oo4.music.instrument.Instrument;
import com.aidar.oo4.music.sound.Sound;

public class MandolinaSound implements Sound {

    private String note;

    private Instrument source;

    public MandolinaSound() {
    }

    public MandolinaSound(String note, Instrument source) {
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
        System.out.print(note);
    }

    @Override
    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MandolinaSound)) return false;

        MandolinaSound that = (MandolinaSound) o;

        if (!getNote().equals(that.getNote())) return false;
        return getSource().equals(that.getSource());

    }

    @Override
    public int hashCode() {
        int result = getNote().hashCode();
        result = 31 * result + getSource().hashCode();
        return result;
    }

}
