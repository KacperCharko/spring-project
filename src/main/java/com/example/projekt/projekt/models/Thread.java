package com.example.projekt.projekt.models;

import org.apache.catalina.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.util.Date;

@Entity
public class

Thread {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long threadId;
    private String threadName;
    private Date creationDate;
    private Long authorId;
    private Long categoryId;

    public Long getCategorId() {
        return categoryId;
    }

    public void setCategorId(Long categorId) {
        this.categoryId = categorId;
    }

    private boolean threadState;

    public boolean isThreadState() {
        return threadState;
    }

    public void setThreadState(boolean threadState) {
        this.threadState = threadState;
    }

    public Thread(){}

    public Long getThreadId() {
        return threadId;
    }

    public void setThreadId(Long threadId) {
        this.threadId = threadId;
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }
}
