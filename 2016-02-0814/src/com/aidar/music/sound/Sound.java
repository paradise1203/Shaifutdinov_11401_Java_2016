package com.aidar.music.sound;

import com.aidar.music.instrument.Instrument;

public interface Sound {

    String getNote();

    Instrument getSource();

    void sound();

}
