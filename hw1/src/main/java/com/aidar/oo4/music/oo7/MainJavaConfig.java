package com.aidar.oo4.music.oo7;

import com.aidar.oo4.music.concertHall.ConcertHall;
import com.aidar.oo4.music.instrument.Instrument;
import com.aidar.oo4.music.inventor.Inventor;
import com.aidar.oo4.music.melody.Melody;
import com.aidar.oo4.music.musician.Musician;
import com.aidar.oo4.music.orchestra.Orchestra;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by paradise on 19.03.16.
 */
public class MainJavaConfig {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);

        List<Inventor> inventors = new ArrayList<>();
        inventors.add((Inventor) context.getBean("classicalInstrumentsInventor"));
        inventors.add((Inventor) context.getBean("specificInstrumentsInventor"));

        List<Instrument> instruments = new ArrayList<>();
        instruments.add((Instrument) context.getBean("guitar"));
        instruments.add((Instrument) context.getBean("piano"));
        instruments.add((Instrument) context.getBean("mandolina"));

        List<Musician> musicians = new ArrayList<>();
        musicians.add((Musician) context.getBean("junior"));
        musicians.add((Musician) context.getBean("senior"));

        List<Melody> melodies = new ArrayList<>();
        melodies.add((Melody) context.getBean("fastMelody"));
        melodies.add((Melody) context.getBean("romanticMelody"));
        melodies.add((Melody) context.getBean("weddingMelody"));

        List<Orchestra> orchestra = new ArrayList<>();
        orchestra.add((Orchestra)context.getBean("royalOrchestra"));
        orchestra.add((Orchestra)context.getBean("usualOrchestra"));

        ConcertHall concertHall = (ConcertHall) context.getBean("royalConcertHall");
    }

}
