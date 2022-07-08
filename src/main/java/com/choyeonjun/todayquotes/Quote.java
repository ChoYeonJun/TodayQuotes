package com.choyeonjun.todayquotes;

public class Quote {
    int id;

    String content;
    String writer;

    public Quote(int id, String content, String writer) {
        this.id = id;
        this.content = content;
        this.writer = writer;
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
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }
}
