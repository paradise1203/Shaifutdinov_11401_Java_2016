package com.aidar.music.melody.impl;

import com.aidar.music.melody.Melody;
import com.aidar.music.orchestra.Orchestra;
import com.aidar.music.sound.Sound;

import java.util.List;

public class FastMelody implements Melody {

    private List<Sound> sounds;

    private String author;

    List<Orchestra> playedByOrch;

    public FastMelody(String author, List<Sound> sounds) {
        this.author = author;
        this.sounds = sounds;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public List<Sound> getSounds() {
        return sounds;
    }

    @Override
    public List<Orchestra> getPlayedByOrch() {
        return playedByOrch;
    }

    @Override
    public void addOrchestra(Orchestra o) {
        playedByOrch.add(o);
    }

}
