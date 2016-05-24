package com.aidar.service;

import com.aidar.model.Message;
import com.aidar.model.User;

import java.util.List;
import java.util.Set;

/**
 * Created by paradise on 28.04.16.
 */
public interface MessageService {

    Set<User> getMyPenFriends();

    Set<User> getMyPenFriends(User principal);

    List<Message> getDialog(Long id);

    List<Message> getDialog(Long id, User principal);

    List<Message> getNew(Long id);

    Message add(Long id, String text);

    Message add(Long id, String text, User principal);

}
