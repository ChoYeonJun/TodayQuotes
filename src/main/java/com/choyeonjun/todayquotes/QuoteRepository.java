package com.choyeonjun.todayquotes;

import java.util.ArrayList;
import java.util.List;

public class QuoteRepository {
    private List<Quote> quotes;
    private int quotesLastId;

    public QuoteRepository() {
        this.quotes = new ArrayList<>();
        this.quotesLastId = 0;
    }

    public Quote findById(int paramId){
        for(Quote quote: quotes){
            if(quote.id == paramId)
                return quote;
        }

        return null;
    }

    public List<Quote> findAll() {
        return quotes;

        // 다 찾기
    }

    public Quote write(String content, String author) {
        int id = ++quotesLastId;
        Quote quote = new Quote(id, content, author);
        quotes.add(quote);

        // 파일저장

        return quote;
    }

    public void remove(int paramId) {
        Quote foundQuote = findById(paramId);
        quotes.remove(foundQuote);

        // 파일 삭제
    }

    public void modify(int paramId, String content, String author) {
        Quote foundQuote = findById(paramId);
        foundQuote.content = content;
        foundQuote.author = author;

        // 파일 수정
    }
}
