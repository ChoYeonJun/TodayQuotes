package com.choyeonjun.todayquotes;

import java.util.ArrayList;
import java.util.List;

public class QuoteRepository {
    public List<Quote> quotes;
    public int quotesLastId;

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
}
