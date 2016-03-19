package com.aidar.oo4.music.inventor.impl;


import com.aidar.oo4.music.instrument.Instrument;
import com.aidar.oo4.music.instrument.impl.Guitar;
import com.aidar.oo4.music.instrument.impl.Mandolina;
import com.aidar.oo4.music.inventor.Inventor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SpecificInstrumentsInventor implements Inventor {

    private List<Instrument> inventedInstruments;

    @Value("Mila")
    private String name;

    private int rating;

    public SpecificInstrumentsInventor() {
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SpecificInstrumentsInventor)) return false;

        SpecificInstrumentsInventor that = (SpecificInstrumentsInventor) o;

        if (getRating() != that.getRating()) return false;
        return getName().equals(that.getName());

    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getRating();
        return result;
    }
}
