package com.aidar.oo4.music.instrument.impl;


import com.aidar.oo4.music.instrument.Instrument;
import com.aidar.oo4.music.inventor.Inventor;
import com.aidar.oo4.music.musician.Musician;
import com.aidar.oo4.music.sound.Sound;
import com.aidar.oo4.music.sound.impl.GuitarSound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Component
public class Guitar implements Instrument {

    @Autowired
    @Qualifier("specificInstrumentsInventor")
    private Inventor inventor;

    private boolean broken;

    private Set<Musician> playedByMus;

    public Guitar() {
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Guitar)) return false;

        Guitar guitar = (Guitar) o;

        return inventor.equals(guitar.inventedBy());

    }

    @Override
    public int hashCode() {
        return inventor.hashCode();
    }
}
