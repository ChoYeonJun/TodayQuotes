package com.choyeonjun.todayquotes;

public class Quote {
    int id;

    String content;
    String author;

    public Quote(int id, String content, String author) {
        this.id = id;
        this.content = content;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return author;
    }

    public void setWriter(String author) {
        this.author = author;
    }
}
