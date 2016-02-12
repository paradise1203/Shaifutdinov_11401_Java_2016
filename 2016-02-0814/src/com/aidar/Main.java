package com.aidar;

import com.aidar.music.concertHall.ConcertHall;
import com.aidar.music.concertHall.impl.RoyalConcertHall;
import com.aidar.music.instrument.Instrument;
import com.aidar.music.inventor.Inventor;
import com.aidar.music.inventor.impl.ClassicalInstrumentsInventor;
import com.aidar.music.inventor.impl.SpecificInstrumentsInventor;
import com.aidar.music.melody.Melody;
import com.aidar.music.melody.impl.FastMelody;
import com.aidar.music.melody.impl.RomanticMelody;
import com.aidar.music.melody.impl.WeddingMelody;
import com.aidar.music.musician.Musician;
import com.aidar.music.musician.impl.Junior;
import com.aidar.music.musician.impl.Senior;
import com.aidar.music.orchestra.Orchestra;
import com.aidar.music.orchestra.impl.RoyalOrchestra;
import com.aidar.music.orchestra.impl.UsualOrchestra;
import com.aidar.music.sound.Sound;
import com.aidar.music.sound.impl.GuitarSound;
import com.aidar.music.sound.impl.MandolinaSound;
import com.aidar.music.sound.impl.PianoSound;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Main {

    private static List<Inventor> makeInventors() {
        List<Inventor> inventors = new LinkedList<>();
        inventors.add(new ClassicalInstrumentsInventor("Mike", 100));
        inventors.add(new ClassicalInstrumentsInventor("George", 1000));
        inventors.add(new SpecificInstrumentsInventor("Mila", 100000));
        return inventors;
    }

    private static List<Instrument> makeInstruments(List<Inventor> inventors) {
        List<Instrument> instruments = new LinkedList<>();
        inventors.forEach(i -> {
            instruments.add(i.invent());
            i.advertise(1000);
        });
        return instruments;
    }

    private static List<Musician> makeMusicians(List<Instrument> instruments) {
        List<Musician> musicians = new LinkedList<>();
        instruments.forEach(i -> {
            double p = Math.random();
            if (p > 0.5) {
                musicians.add(new Junior(i));
            } else {
                musicians.add(new Senior(i));
            }
        });
        return musicians;
    }

    private static List<Sound> makeSounds(List<Instrument> instruments) {
        List<Sound> sounds = new LinkedList<>();
        instruments.forEach(i -> {
            if (i instanceof GuitarSound) {
                sounds.add(new GuitarSound("do", i));
                sounds.add(new GuitarSound("sol", i));
                sounds.add(new GuitarSound("sol", i));
            }
            if (i instanceof PianoSound) {
                sounds.add(new PianoSound("re", i));
                sounds.add(new PianoSound("fa", i));
                sounds.add(new PianoSound("fa", i));
            }
            if (i instanceof MandolinaSound) {
                sounds.add(new MandolinaSound("re", i));
                sounds.add(new MandolinaSound("fa", i));
                sounds.add(new MandolinaSound("fa", i));
            }
        });
        return sounds;
    }

    private static List<Melody> makeMelodies(List<List<Sound>> listSound) {
        List<Melody> melodies = new LinkedList<>();
        listSound.forEach(ls -> {
                    double p = Math.random();
                    if (p < 0.3) {
                        melodies.add(new FastMelody("Mozart", ls));
                    } else if (p < 0.6) {
                        melodies.add(new RomanticMelody("Bethoven", ls));
                    } else {
                        melodies.add(new WeddingMelody("Zimmer", ls));
                    }
                }
        );
        return melodies;
    }

    private static List<Orchestra> makeOrchestres(List<Musician> musicians, List<Melody> melodies) {
        List<Orchestra> orchestres = new LinkedList<>();
        orchestres.add(new RoyalOrchestra(melodies, musicians));
        orchestres.add(new UsualOrchestra(melodies, musicians));
        return orchestres;
    }

    public static void main(String[] args) {
        List<Inventor> inventors = makeInventors();
        List<Instrument> instruments = makeInstruments(inventors);
        instruments.forEach(i -> {
            List<Sound> sounds = i.makeSound();
            i.inventedBy();
            i.broken();
        });
        List<Musician> musicians = makeMusicians(instruments);
        musicians.forEach(m -> {
            m.play(1000);
            m.breakInstrument();
        });
        List<List<Sound>> listSounds = new LinkedList<>();
        listSounds.add(makeSounds(instruments));
        listSounds.add(makeSounds(instruments));
        listSounds.add(makeSounds(instruments));
        List<Melody> melodies = makeMelodies(listSounds);
        melodies.forEach(m -> {
            m.getSounds();
            m.getAuthor();
            m.getPlayedByOrch();
        });
        List<Orchestra> orchestres = makeOrchestres(musicians, melodies);
        orchestres.forEach(o -> {
            o.getMelodies();
            o.playBeautifulMusic(1000);
        });
        ConcertHall royalAlbertHall = new RoyalConcertHall();
        orchestres.forEach(o -> {
            royalAlbertHall.arrangeConcert(o, new Date());
        });
        royalAlbertHall.buyInstruments(instruments);
        royalAlbertHall.getProfit();
    }

}
