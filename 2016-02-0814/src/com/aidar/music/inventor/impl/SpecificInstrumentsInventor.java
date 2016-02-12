package com.aidar.music.inventor.impl;

import com.aidar.music.instrument.Instrument;
import com.aidar.music.instrument.impl.Guitar;
import com.aidar.music.instrument.impl.Mandolina;
import com.aidar.music.inventor.Inventor;

import java.util.List;

public class SpecificInstrumentsInventor implements Inventor {

    private List<Instrument> inventedInstruments;

    private String name;

    private int rating;

    public SpecificInstrumentsInventor(String name, int rating) {
        this.name = name;
        this.rating = rating;
    }

    @Override
    public Instrument invent() {
        double p = Math.random();
        return p > 0.5 ? new Mandolina(this) : new Guitar(this);
    }

    @Override
    public void advertise(int money) {
        while (money-- > 0) {
            System.out.println("I beg, buy my instrument!");
        }
    }

    @Override
    public List<Instrument> getInventedInstruments() {
        return inventedInstruments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

}
