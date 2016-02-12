package com.aidar.music.melody;

import com.aidar.music.orchestra.Orchestra;
import com.aidar.music.sound.Sound;

import java.util.List;

public interface Melody {

    String getAuthor();

    List<Sound> getSounds();

    List<Orchestra> getPlayedByOrch();

    void addOrchestra(Orchestra o);

}
