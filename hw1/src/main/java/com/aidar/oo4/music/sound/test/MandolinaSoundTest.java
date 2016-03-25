package com.aidar.oo4.music.sound.test;

import com.aidar.oo4.music.MockedObjectsFactory;
import com.aidar.oo4.music.instrument.Instrument;
import com.aidar.oo4.music.instrument.impl.Mandolina;
import com.aidar.oo4.music.sound.Sound;
import com.aidar.oo4.music.sound.impl.MandolinaSound;
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

public class MandolinaSoundTest {

    private static ApplicationContext context;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @BeforeClass
    public static void initializeContext() {
        context = new ClassPathXmlApplicationContext("010-spring-config.xml");
    }

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void defaultConstructorShouldWorkCorrect() {
        Sound sound = (MandolinaSound) context.getBean("mandolinaSound");
        assertEquals(null, sound.getNote());
        assertEquals(null, sound.getSource());
    }

    @Test
    public void parameterisedConstructorShouldWorkCorrect() {
        String note = "fa";
        Instrument mandolina = MockedObjectsFactory.getInstrument(Mandolina.class);
        Sound sound = (MandolinaSound) context.getBean("mandolinaSound1");
        assertEquals(note, sound.getNote());
        assertTrue(sound.getSource().equals(mandolina));
    }

    @Test
    public void soundShouldWork() {
        String note = "do";
        Sound sound = (Sound) context.getBean("mandolinaSound2");
        sound.sound();
        assertEquals(note, outContent.toString());
    }

    @Test
    public void equalsShouldWorkCorrect() {
        String note = "fa";
        Instrument mandolina = MockedObjectsFactory.getInstrument(Mandolina.class);
        Sound sound = (MandolinaSound) context.getBean("mandolinaSound1");
        Sound res = new MandolinaSound(note, mandolina);
        assertTrue(sound.equals(res));
    }

}
