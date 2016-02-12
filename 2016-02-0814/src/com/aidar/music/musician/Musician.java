package com.aidar.music.musician;

import com.aidar.music.orchestra.Orchestra;
import com.aidar.music.sound.Sound;
import com.aidar.music.instrument.Instrument;

import java.util.List;

public interface Musician {

    List<Sound> play(int duration);

    void enterOrchestra(Orchestra o);

    String leaveOrchestra();

    Instrument breakInstrument();

}
