package com.aidar.oo4.music.inventor.impl;


import com.aidar.oo4.music.instrument.Instrument;
import com.aidar.oo4.music.instrument.impl.Piano;
import com.aidar.oo4.music.inventor.Inventor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClassicalInstrumentsInventor implements Inventor {

    private List<Instrument> inventedInstruments;

    @Value("george")
    private String name;

    private int rating;

    public ClassicalInstrumentsInventor() {
    }

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
            System.out.print("Buy my instrument!");
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
        if (!(o instanceof ClassicalInstrumentsInventor)) return false;

        ClassicalInstrumentsInventor inventor = (ClassicalInstrumentsInventor) o;

        if (getRating() != inventor.getRating()) return false;
        return getName().equals(inventor.getName());

    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getRating();
        return result;
    }
}
