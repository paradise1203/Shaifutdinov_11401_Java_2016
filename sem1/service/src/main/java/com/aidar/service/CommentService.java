package com.aidar.service;

import com.aidar.model.Comment;
import com.aidar.model.Request;

/**
 * Created by paradise on 27.04.16.
 */
public interface CommentService {

    Comment add(Request request, String text);

}
