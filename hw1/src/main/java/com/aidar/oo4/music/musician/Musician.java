package com.aidar.oo4.music.musician;


import com.aidar.oo4.music.instrument.Instrument;
import com.aidar.oo4.music.orchestra.Orchestra;
import com.aidar.oo4.music.sound.Sound;

import java.util.List;

public interface Musician {

    List<Sound> play(int duration);

    void enterOrchestra(Orchestra o);

    String leaveOrchestra();

    public Orchestra getOrchestra();

    public Instrument getInstrument();

    Instrument breakInstrument();

}
