package com.aidar.service.impl;

import com.aidar.model.Community;
import com.aidar.model.News;
import com.aidar.repository.NewsRepository;
import com.aidar.service.NewsService;
import com.aidar.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by paradise on 30.04.16.
 */
@Service
@Transactional
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private SecurityService securityService;

    @Override
    public void add(Community community, String text) {
        News news = new News(text, community, securityService.getPersistedPrincipal());
        newsRepository.save(news);
    }

}
