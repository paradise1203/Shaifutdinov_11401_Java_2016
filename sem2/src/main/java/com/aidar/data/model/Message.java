package com.aidar.data.model;

import com.aidar.data.enums.MessageStatus;

import java.util.Date;

/**
 * Created by paradise on 13.04.16.
 */
public class Message {

    private long id;

    private String text;

    private User sender;

    private User recipient;

    private Date createdAt;

    private MessageStatus status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public MessageStatus getStatus() {
        return status;
    }

    public void setStatus(MessageStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message)) return false;

        Message message = (Message) o;

        if (getId() != message.getId()) return false;
        if (!getText().equals(message.getText())) return false;
        if (!getSender().equals(message.getSender())) return false;
        return getRecipient().equals(message.getRecipient());

    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + getText().hashCode();
        result = 31 * result + getSender().hashCode();
        result = 31 * result + getRecipient().hashCode();
        return result;
    }
}
