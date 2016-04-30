package com.aidar.service;

import com.aidar.model.Message;

import java.util.List;

/**
 * Created by paradise on 28.04.16.
 */
public interface MessageService {

    List<Message> getDialog(Long id);

    List<Message> getNew(Long id);

    Message add(Long id, String text);

}
