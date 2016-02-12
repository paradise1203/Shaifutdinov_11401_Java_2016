package com.aidar.music.orchestra.impl;

import com.aidar.music.melody.Melody;
import com.aidar.music.musician.Musician;
import com.aidar.music.orchestra.Orchestra;
import com.aidar.music.sound.Sound;

import java.util.LinkedList;
import java.util.List;

public class RoyalOrchestra implements Orchestra {

    private List<Musician> musicians;

    private List<Melody> melodies;

    private String age;

    public RoyalOrchestra(List<Melody> melodies, List<Musician> musicians) {
        this.melodies = melodies;
        this.musicians = musicians;
    }

    @Override
    public List<Musician> getMusicians() {
        return musicians;
    }

    @Override
    public List<Melody> getMelodies() {
        return melodies;
    }

    @Override
    public List<Sound> playBeautifulMusic(int duration) {
        List<Sound> sounds = new LinkedList<>();
        while (duration-- > 0) {
            for (Musician m : musicians) {
                sounds.addAll(m.play(10));
            }
            for (Melody m : melodies) {
                sounds.addAll(m.getSounds());
            }
        }
        return sounds;
    }

    @Override
    public void addMusician(Musician m) {
        musicians.add(m);
    }

    @Override
    public void removeMusician(Musician m) {
        musicians.remove(m);
    }

}
