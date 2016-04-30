package com.aidar.service.impl;

import com.aidar.model.Comment;
import com.aidar.model.Request;
import com.aidar.repository.CommentRepository;
import com.aidar.service.CommentService;
import com.aidar.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by paradise on 27.04.16.
 */
@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private SecurityService securityService;

    @Override
    public Comment add(Request request, String text) {
        Comment comment = new Comment(text, request, securityService.getPersistedPrincipal());
        return commentRepository.save(comment);
    }

}
