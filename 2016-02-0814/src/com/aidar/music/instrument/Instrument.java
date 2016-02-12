package com.aidar.music.instrument;

import com.aidar.music.inventor.Inventor;
import com.aidar.music.musician.Musician;
import com.aidar.music.sound.Sound;

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
