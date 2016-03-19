package com.aidar.oo4.music.melody;


import com.aidar.oo4.music.orchestra.Orchestra;
import com.aidar.oo4.music.sound.Sound;

import java.util.List;

public interface Melody {

    String getAuthor();

    List<Sound> getSounds();

    List<Orchestra> getPlayedByOrch();

    void addOrchestra(Orchestra o);

}
