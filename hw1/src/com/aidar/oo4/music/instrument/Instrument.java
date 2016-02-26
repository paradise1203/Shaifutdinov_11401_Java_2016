package com.aidar.oo4.music.instrument;


import com.aidar.oo4.music.inventor.Inventor;
import com.aidar.oo4.music.musician.Musician;
import com.aidar.oo4.music.sound.Sound;

import java.util.List;
import java.util.Set;

public interface Instrument {

    Inventor inventedBy();

    List<Sound> makeSound();

    Set<Musician> getPlayedByMus();

    void addPlayedByMus(Musician m);

    boolean broken();

    void setBroken();

}
