package com.aidar.oo4.music.musician.test;

import com.aidar.oo4.music.MockedObjectsFactory;
import com.aidar.oo4.music.instrument.Instrument;
import com.aidar.oo4.music.instrument.impl.Guitar;
import com.aidar.oo4.music.musician.Musician;
import com.aidar.oo4.music.musician.impl.Junior;
import com.aidar.oo4.music.sound.Sound;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static junit.framework.Assert.assertTrue;

public class JuniorTest {

    private static ApplicationContext context;

    private Musician musician;
    private Instrument instrument;

    @BeforeClass
    public static void initializeContext() {
        context = new ClassPathXmlApplicationContext("010-spring-config.xml");
    }


    @Before
    public void initializeMusician() {
        instrument = MockedObjectsFactory.getInstrument(Guitar.class);
        musician = (Junior) context.getBean("junior");
    }

    @Test
    public void parameterisedConstructorShouldWorkCorrect() {
        assertTrue(musician.getInstrument().equals(instrument));
    }

    @Test
    public void playShouldWorkCorrect() {
        List<Sound> sounds = MockedObjectsFactory.getSounds(instrument);
        List<Sound> res = musician.play(1);
        res.removeAll(sounds);
        assertTrue(res.size() == 0);
    }

}
