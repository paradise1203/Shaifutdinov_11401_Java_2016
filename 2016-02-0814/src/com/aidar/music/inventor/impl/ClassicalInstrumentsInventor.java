package com.aidar.music.inventor.impl;

import com.aidar.music.instrument.Instrument;
import com.aidar.music.instrument.impl.Piano;
import com.aidar.music.inventor.Inventor;

import java.util.List;

public class ClassicalInstrumentsInventor implements Inventor {

    private List<Instrument> inventedInstruments;

    private String name;

    private int rating;

    public ClassicalInstrumentsInventor(String name, int rating) {
        this.name = name;
        this.rating = rating;
    }

    @Override
    public Instrument invent() {
        return new Piano(this);
    }

    @Override
    public void advertise(int money) {
        while (money-- > 0) {
            System.out.println("Buy ny instrument!");
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
