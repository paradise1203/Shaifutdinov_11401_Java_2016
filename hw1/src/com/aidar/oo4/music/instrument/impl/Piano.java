package com.aidar.oo4.music.instrument.impl;

import com.aidar.oo4.music.instrument.Instrument;
import com.aidar.oo4.music.inventor.Inventor;
import com.aidar.oo4.music.musician.Musician;
import com.aidar.oo4.music.sound.Sound;
import com.aidar.oo4.music.sound.impl.PianoSound;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Piano implements Instrument {

    private Inventor inventor;

    private boolean broken;

    private Set<Musician> playedByMus;

    public Piano(Inventor inventor) {
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
        sounds.add(new PianoSound("do", this));
        sounds.add(new PianoSound("la", this));
        sounds.add(new PianoSound("si", this));
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Piano)) return false;

        Piano piano = (Piano) o;

        return inventor != null ? inventor.equals(piano.inventor) : piano.inventor == null;

    }

    @Override
    public int hashCode() {
        return inventor != null ? inventor.hashCode() : 0;
    }
}
