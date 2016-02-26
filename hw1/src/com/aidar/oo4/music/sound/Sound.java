package com.aidar.oo4.music.sound;


import com.aidar.oo4.music.instrument.Instrument;

public interface Sound {

    String getNote();

    Instrument getSource();

    void sound();

    void setNote(String note);
}
