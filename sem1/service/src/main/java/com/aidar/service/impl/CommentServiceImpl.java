package com.aidar.service.impl;

import com.aidar.model.Comment;
import com.aidar.repository.CommentRepository;
import com.aidar.service.CommentService;
import com.aidar.service.RequestService;
import com.aidar.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by paradise on 27.04.16.
 */
@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private RequestService requestService;

    @Autowired
    private SecurityService securityService;

    @Override
    public Comment add(Long id, String text) {
        Comment comment = new Comment();
        comment.setText(text);
        comment.setRequest(requestService.getOne(id));
        comment.setAuthor(securityService.getPersistedPrincipal());
        comment.setCreatedAt(new Date());
        return commentRepository.save(comment);
    }

}
