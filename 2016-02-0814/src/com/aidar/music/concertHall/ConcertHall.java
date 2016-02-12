package com.aidar.music.concertHall;

import com.aidar.music.instrument.Instrument;
import com.aidar.music.orchestra.Orchestra;

import java.util.Date;
import java.util.List;

public interface ConcertHall {

    void arrangeConcert(Orchestra o, Date date);

    long getProfit();

    void buyInstruments(List<Instrument> instruments);

}
