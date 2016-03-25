package com.aidar.oo4.music.instrument.test;

import com.aidar.oo4.music.MockedObjectsFactory;
import com.aidar.oo4.music.instrument.Instrument;
import com.aidar.oo4.music.instrument.impl.Guitar;
import com.aidar.oo4.music.sound.Sound;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static junit.framework.Assert.assertTrue;

public class GuitarTest {

    private static ApplicationContext context;

    private Instrument guitar;

    @BeforeClass
    public static void initializeContext() {
        context = new ClassPathXmlApplicationContext("010-spring-config.xml");
    }

    @Before
    public void initializeGuitar() {
        guitar = (Instrument) context.getBean("guitar");
    }

    @Test
    public void parameterisedConstructorShouldWorkCorrect() {
        Instrument res = MockedObjectsFactory.getInstrument(Guitar.class);
        assertTrue(guitar.inventedBy().equals(res.inventedBy()));
    }

    @Test
    public void makeSoundShouldWorkCorrect() {
        List<Sound> sounds = MockedObjectsFactory.getSounds(guitar);
        List<Sound> res = guitar.makeSound();
        res.removeAll(sounds);
        assertTrue(res.size() == 0);
    }

    @Test
    public void equalsShouldWorkCorrect() {
        Instrument res = MockedObjectsFactory.getInstrument(Guitar.class);
        assertTrue(this.guitar.equals(res));
    }

}
