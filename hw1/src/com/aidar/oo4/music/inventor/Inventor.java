package com.aidar.oo4.music.inventor;


import com.aidar.oo4.music.instrument.Instrument;

import java.util.List;

public interface Inventor {

    Instrument invent();

    void advertise(int money);

    List<Instrument> getInventedInstruments();

    String getName();

    int getRating();
}
