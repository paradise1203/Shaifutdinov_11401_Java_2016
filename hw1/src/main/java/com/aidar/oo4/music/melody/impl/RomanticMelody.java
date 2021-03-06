package com.aidar.oo4.music.melody.impl;


import com.aidar.oo4.music.melody.Melody;
import com.aidar.oo4.music.orchestra.Orchestra;
import com.aidar.oo4.music.sound.Sound;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RomanticMelody implements Melody {

    private List<Sound> sounds;

    @Value("EricClapton")
    private String author;

    List<Orchestra> playedByOrch;

    public RomanticMelody() {
    }

    public RomanticMelody(String author, List<Sound> sounds) {
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
