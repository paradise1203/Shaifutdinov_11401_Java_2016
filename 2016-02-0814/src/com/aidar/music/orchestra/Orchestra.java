package com.aidar.music.orchestra;

import com.aidar.music.melody.Melody;
import com.aidar.music.musician.Musician;
import com.aidar.music.sound.Sound;

import java.util.List;

public interface Orchestra {

    List<Musician> getMusicians();

    List<Melody> getMelodies();

    List<Sound> playBeautifulMusic(int duration);

    void addMusician(Musician m);

    void removeMusician(Musician m);

}
