package com.aidar.web.data.model;

import java.util.Date;

/**
 * Created by paradise on 30.04.16.
 */
public class News {

    private Long id;

    private String text;

    private Community community;

    private User author;

    private Date createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Community getCommunity() {
        return community;
    }

    public void setCommunity(Community community) {
        this.community = community;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof News)) return false;

        News news = (News) o;

        if (getId() != null ? !getId().equals(news.getId()) : news.getId() != null) return false;
        if (!getText().equals(news.getText())) return false;
        if (!getCommunity().equals(news.getCommunity())) return false;
        return getAuthor().equals(news.getAuthor());

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + getText().hashCode();
        result = 31 * result + getCommunity().hashCode();
        result = 31 * result + getAuthor().hashCode();
        return result;
    }
}
