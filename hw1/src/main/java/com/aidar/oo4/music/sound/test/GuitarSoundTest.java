package com.aidar.oo4.music.sound.test;

import com.aidar.oo4.music.MockedObjectsFactory;
import com.aidar.oo4.music.instrument.Instrument;
import com.aidar.oo4.music.instrument.impl.Guitar;
import com.aidar.oo4.music.sound.Sound;
import com.aidar.oo4.music.sound.impl.GuitarSound;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class GuitarSoundTest {

    private static ApplicationContext context;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeClass
    public static void initializeContext() {
        context = new ClassPathXmlApplicationContext("010-spring-config.xml");
    }

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void defaultConstructorShouldWorkCorrect() {
        Sound sound = (Sound) context.getBean("guitarSound");
        assertEquals(null, sound.getNote());
        assertEquals(null, sound.getSource());
    }

    @Test
    public void parameterisedConstructorShouldWorkCorrect() {
        String note = "fa";
        Instrument guitar = MockedObjectsFactory.getInstrument(Guitar.class);
        Sound sound = (Sound) context.getBean("guitarSound1");
        assertEquals(note, sound.getNote());
        assertTrue(sound.getSource().equals(guitar));
    }

    @Test
    public void soundShouldWork() {
        String note = "do";
        Sound sound = (Sound) context.getBean("guitarSound2");
        sound.sound();
        assertEquals(note, outContent.toString());
    }

    @Test
    public void equalsShouldWorkCorrect() {
        String note = "fa";
        Instrument guitar = MockedObjectsFactory.getInstrument(Guitar.class);
        Sound sound = (Sound) context.getBean("guitarSound1");
        Sound res = new GuitarSound(note, guitar);
        assertTrue(sound.equals(res));
    }

}
