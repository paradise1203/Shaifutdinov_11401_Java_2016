package com.aidar.music.inventor;

import com.aidar.music.instrument.Instrument;

import java.util.List;

public interface Inventor {

    Instrument invent();

    void advertise(int money);

    List<Instrument> getInventedInstruments();

}
