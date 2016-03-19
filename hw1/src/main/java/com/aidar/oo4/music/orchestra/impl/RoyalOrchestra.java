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
public class RoyalOrchestra implements Orchestra {

    private List<Musician> musicians;

    private List<Melody> melodies;

    @Value("200")
    private String age;

    public RoyalOrchestra() {
    }

    public RoyalOrchestra(List<Melody> melodies, List<Musician> musicians) {
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
                sounds.addAll(m.play(10));
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RoyalOrchestra)) return false;

        RoyalOrchestra that = (RoyalOrchestra) o;

        if (getMusicians() != null ? !getMusicians().equals(that.getMusicians()) : that.getMusicians() != null)
            return false;
        return getMelodies() != null ? getMelodies().equals(that.getMelodies()) : that.getMelodies() == null;

    }

    @Override
    public int hashCode() {
        int result = getMusicians() != null ? getMusicians().hashCode() : 0;
        result = 31 * result + (getMelodies() != null ? getMelodies().hashCode() : 0);
        return result;
    }
}
