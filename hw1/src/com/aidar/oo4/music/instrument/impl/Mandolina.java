package com.aidar.oo4.music.instrument.impl;

import com.aidar.oo4.music.instrument.Instrument;
import com.aidar.oo4.music.inventor.Inventor;
import com.aidar.oo4.music.musician.Musician;
import com.aidar.oo4.music.sound.Sound;
import com.aidar.oo4.music.sound.impl.MandolinaSound;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mandolina)) return false;

        Mandolina mandolina = (Mandolina) o;

        if (broken != mandolina.broken) return false;
        return inventor != null ? inventor.equals(mandolina.inventor) : mandolina.inventor == null;

    }

    @Override
    public int hashCode() {
        int result = inventor != null ? inventor.hashCode() : 0;
        result = 31 * result + (broken ? 1 : 0);
        return result;
    }
}
