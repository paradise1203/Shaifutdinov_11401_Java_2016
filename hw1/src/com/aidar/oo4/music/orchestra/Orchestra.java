package com.aidar.oo4.music.orchestra;


import com.aidar.oo4.music.melody.Melody;
import com.aidar.oo4.music.musician.Musician;
import com.aidar.oo4.music.sound.Sound;

import java.util.List;

public interface Orchestra {

    List<Musician> getMusicians();

    List<Melody> getMelodies();

    List<Sound> playBeautifulMusic(int duration);

    void addMusician(Musician m);

    void removeMusician(Musician m);

}
