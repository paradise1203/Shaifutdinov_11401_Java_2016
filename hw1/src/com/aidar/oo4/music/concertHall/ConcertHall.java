package com.aidar.oo4.music.concertHall;


import com.aidar.oo4.music.instrument.Instrument;
import com.aidar.oo4.music.orchestra.Orchestra;

import java.util.Date;
import java.util.List;

public interface ConcertHall {

    void arrangeConcert(Orchestra o, Date date);

    long getProfit();

    void buyInstruments(List<Instrument> instruments);

}
