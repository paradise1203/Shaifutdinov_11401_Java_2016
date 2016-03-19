package com.aidar.oo4.music.oo6;

import com.aidar.oo4.music.concertHall.ConcertHall;
import com.aidar.oo4.music.instrument.Instrument;
import com.aidar.oo4.music.inventor.Inventor;
import com.aidar.oo4.music.melody.Melody;
import com.aidar.oo4.music.musician.Musician;
import com.aidar.oo4.music.orchestra.Orchestra;
import com.aidar.oo4.music.sound.Sound;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

/**
 * Created by paradise on 19.03.16.
 */
public class MainXmlConfig {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        List<Inventor> inventors = (List<Inventor>) context.getBean("inventors");
        inventors.forEach(i -> {
            i.advertise(1000);
            i.getInventedInstruments();
            i.getName();
            i.getRating();
        });
        List<Instrument> instruments = (List<Instrument>) context.getBean("instruments");
        instruments.forEach(i -> {
            List<Sound> sounds = i.makeSound();
            i.inventedBy();
            i.broken();
        });
        List<Musician> musicians = (List<Musician>) context.getBean("musicians");
        musicians.forEach(m -> {
            m.play(1000);
            m.breakInstrument();
        });
        List<Melody> melodies = (List<Melody>) context.getBean("melodies");
        melodies.forEach(m -> {
            m.getSounds();
            m.getAuthor();
            m.getPlayedByOrch();
        });
        List<Orchestra> orchestres = (List<Orchestra>) context.getBean("orchestra");
        orchestres.forEach(o -> {
            o.getMelodies();
            o.playBeautifulMusic(1000);
        });
        ConcertHall royalAlbertHall = (ConcertHall) context.getBean("royalAlbertHall");
        orchestres.forEach(o -> {
            royalAlbertHall.arrangeConcert(o, new Date());
        });
        royalAlbertHall.buyInstruments(instruments);
        royalAlbertHall.getProfit();
    }

}
