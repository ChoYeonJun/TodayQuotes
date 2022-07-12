package com.choyeonjun.todayquotes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuoteController {
    private Scanner sc;
    private List<Quote> quotes;
    private int quotesLastId;

    public QuoteController(Scanner sc) {
        this.sc = sc;
        this.quotes = new ArrayList<>();
        this.quotesLastId = 0;
    }
    public void modify(Rq rq) {
        // URL에 입력된 id 얻기
        int paramId = rq.getIntParam("id", 0);

        // URL에 입력된 id가 없다면 작업중지
        if (paramId == 0) {
            System.out.println("id를 입력해주세요.");
            return;
        }

        // URL에 입력된 id에 해당하는 명언객체 찾기
        Quote foundQuote  = findById(paramId);

        // 찾지 못했다면 중지
        if (foundQuote == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", paramId);
            return;
        }

        System.out.printf("명언(기존) : %s\n", foundQuote.content);
        System.out.printf("명언 : ");
        foundQuote.content = sc.nextLine();
        System.out.printf("작가(기존) : %s\n", foundQuote.author);
        System.out.printf("작가 : ");
        foundQuote.author = sc.nextLine();

        System.out.printf("%d번 명언이 수정되었습니다.\n", paramId);
    }

    public void list(Rq rq) {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("-------------------");
        for (int i = quotes.size() - 1; i >= 0; i--) {
            Quote quote_ = quotes.get(i);
            System.out.printf("%d / %s / %s\n", quote_.id, quote_.content, quote_.author);
        }
    }

    public void write(Rq rq) {
        System.out.printf("명언 : ");
        String content = sc.nextLine().trim();
        System.out.printf("작가 : ");
        String author = sc.nextLine().trim();
        int id = ++quotesLastId; // 명언 글 번호 증가

        Quote quote = new Quote(id, content, author);
        quotes.add(quote);

        System.out.printf("%d번 명언이 등록되었습니다.\n", id);
    }

    public void remove(Rq rq) {
        // URL에 입력된 id 얻기
        int paramId = rq.getIntParam("id", 0);

        // URL에 입력된 id가 없다면 작업중지
        if (paramId == 0) {
            System.out.println("id를 입력해주세요.");
            return;
        }

        // URL에 입력된 id에 해당하는 명언객체 찾기
        Quote foundQuote  = findById(paramId);

        // 찾지 못했다면 중지
        if (foundQuote == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", paramId);
            return;
        }

        // 입력된 id에 해당하는 명언객체를 리스트에서 삭제
        quotes.remove(foundQuote);

        System.out.printf("%d번 명언이 삭제되었습니다.\n", paramId);
    }

    private Quote findById(int paramId){
        for(Quote quote: quotes){
            if(quote.id == paramId)
                return quote;
        }

        return null;
    }
}
