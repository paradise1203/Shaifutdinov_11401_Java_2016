package com.aidar.music.instrument.impl;

import com.aidar.music.sound.impl.GuitarSound;
import com.aidar.music.instrument.Instrument;
import com.aidar.music.inventor.Inventor;
import com.aidar.music.musician.Musician;
import com.aidar.music.sound.Sound;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Guitar implements Instrument {

    private Inventor inventor;

    private boolean broken;

    private Set<Musician> playedByMus;

    public Guitar(Inventor inventor) {
        this.inventor = inventor;
        broken = false;
    }

    @Override
    public Inventor inventedBy() {
        return inventor;
    }

    @Override
    public List<Sound> makeSound() {
        List<Sound> sounds = new LinkedList<>();
        sounds.add(new GuitarSound("do", this));
        sounds.add(new GuitarSound("la", this));
        sounds.add(new GuitarSound("si", this));
        return sounds;
    }

    @Override
    public Set<Musician> getPlayedByMus() {
        return playedByMus;
    }

    @Override
    public void addPlayedByMus(Musician m) {
        playedByMus.add(m);
    }

    @Override
    public boolean broken() {
        return broken;
    }

    @Override
    public void setBroken() {
        broken = true;
    }

}
