package com.aidar.oo4.music.concertHall.impl;


import com.aidar.oo4.music.concertHall.ConcertHall;
import com.aidar.oo4.music.instrument.Instrument;
import com.aidar.oo4.music.orchestra.Orchestra;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class RoyalConcertHall implements ConcertHall {

    private Map<Date, Orchestra> arrangements;

    private List<Instrument> instruments;

    private long profit;

    @Override
    public void arrangeConcert(Orchestra o, Date date) {
        arrangements.put(date, o);
    }

    @Override
    public long getProfit() {
        return profit;
    }

    @Override
    public void buyInstruments(List<Instrument> i) {
        instruments.addAll(i);
    }

    public Map<Date, Orchestra> getArrangements() {
        return arrangements;
    }

    public void setArrangements(Map<Date, Orchestra> arrangements) {
        this.arrangements = arrangements;
    }

    public List<Instrument> getInstruments() {
        return instruments;
    }

    public void setInstruments(List<Instrument> instruments) {
        this.instruments = instruments;
    }

    public void setProfit(long profit) {
        this.profit = profit;
    }

}
