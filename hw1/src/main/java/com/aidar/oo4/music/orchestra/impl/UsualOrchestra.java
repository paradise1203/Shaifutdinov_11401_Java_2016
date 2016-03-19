package com.aidar.oo4.music.orchestra.impl;


import com.aidar.oo4.music.melody.Melody;
import com.aidar.oo4.music.musician.Musician;
import com.aidar.oo4.music.orchestra.Orchestra;
import com.aidar.oo4.music.sound.Sound;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class UsualOrchestra implements Orchestra {

    private List<Musician> musicians;

    private List<Melody> melodies;

    @Value("15")
    private int age;

    public UsualOrchestra() {
    }

    public UsualOrchestra(List<Melody> melodies, List<Musician> musicians) {
        age = 0;
        this.melodies = melodies;
        this.musicians = musicians;
    }

    @Override
    public List<Musician> getMusicians() {
        return musicians;
    }

    @Override
    public List<Melody> getMelodies() {
        return melodies;
    }

    @Override
    public List<Sound> playBeautifulMusic(int duration) {
        List<Sound> sounds = new LinkedList<>();
        while (duration-- > 0) {
            for (Musician m : musicians) {
                sounds.addAll(m.play(1));
            }
            for (Melody m : melodies) {
                sounds.addAll(m.getSounds());
            }
        }
        return sounds;
    }

    @Override
    public void addMusician(Musician m) {
        musicians.add(m);
    }

    @Override
    public void removeMusician(Musician m) {
        musicians.remove(m);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
