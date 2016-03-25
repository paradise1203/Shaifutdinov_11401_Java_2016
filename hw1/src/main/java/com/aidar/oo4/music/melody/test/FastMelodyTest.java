package com.aidar.oo4.music.melody.test;

import com.aidar.oo4.music.MockedObjectsFactory;
import com.aidar.oo4.music.melody.Melody;
import com.aidar.oo4.music.orchestra.Orchestra;
import com.aidar.oo4.music.orchestra.impl.RoyalOrchestra;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class FastMelodyTest {

    private static ApplicationContext context;

    private Melody melody;

    @BeforeClass
    public static void initializeContext() {
        context = new ClassPathXmlApplicationContext("010-spring-config.xml");
    }

    @Before
    public void initializeMelody() {
        melody = (Melody) context.getBean("fastMelody");
    }

    @Test
    public void parameterisedConstructorShouldWorkCorrect() {
        String author = "Mick";
        assertEquals(author, melody.getAuthor());
        melody.getSounds().removeAll(MockedObjectsFactory.getSounds(null));
        assertEquals(0, melody.getSounds().size());
    }

    @Test
    public void addOrchestraShouldWorkCorrect() {
        Orchestra orchestra = mock(RoyalOrchestra.class);
        melody.addOrchestra(orchestra);
        assertTrue(orchestra.equals(melody.getPlayedByOrch().get(0)));
    }

}
