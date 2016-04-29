package com.aidar.service.impl;

import com.aidar.model.Message;
import com.aidar.model.User;
import com.aidar.repository.MessageRepository;
import com.aidar.repository.UserRepository;
import com.aidar.service.MessageService;
import com.aidar.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by paradise on 28.04.16.
 */
@Service
@Transactional
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SecurityService securityService;

    @Override
    public List<Message> getDialog(Long id) {
        User principal = securityService.getPersistedPrincipal();
        User friend = userRepository.findOne(id);
        return messageRepository.getDialog(principal, friend);
    }

    @Override
    public Message add(Long id, String text) {
        User principal = securityService.getPersistedPrincipal();
        User friend = userRepository.findOne(id);
        Message message = new Message();
        message.setCreatedAt(new Date());
        message.setText(text);
        message.setSender(principal);
        message.setRecipient(friend);
        return messageRepository.save(message);
    }

}
