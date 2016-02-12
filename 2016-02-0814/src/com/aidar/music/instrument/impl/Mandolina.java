package com.aidar.music.instrument.impl;

import com.aidar.music.instrument.Instrument;
import com.aidar.music.inventor.Inventor;
import com.aidar.music.musician.Musician;
import com.aidar.music.sound.Sound;
import com.aidar.music.sound.impl.MandolinaSound;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Mandolina implements Instrument {

    private Inventor inventor;

    private boolean broken;

    private Set<Musician> playedByMus;

    public Mandolina(Inventor inventor) {
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
        sounds.add(new MandolinaSound("re", this));
        sounds.add(new MandolinaSound("la", this));
        sounds.add(new MandolinaSound("si", this));
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
