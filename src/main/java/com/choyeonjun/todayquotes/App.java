package com.choyeonjun.todayquotes;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private Scanner sc;
    private List<Quote> quotes;
    private int quotesLastId;

    public App() {
        sc = new Scanner(System.in);
        quotes = new ArrayList<>();
        quotesLastId = 0;
    }

    public void run() {
        System.out.println("== 명언 SSG ==");

        outer:
        //while 문 라벨링
        while (true) {
            System.out.printf("명령) ");
            String cmd = sc.nextLine().trim();

            Rq rq = new Rq(cmd);

            switch (rq.getPath()){
                case "종료":
                    break outer;
                case "등록":
                   write(rq);
                    break;
                case "삭제":
                    remove(rq);
                    break;
                case "목록":
                    list(rq);

            }
        }
        sc.close();
    }

    private void list(Rq rq) {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("-------------------");
        for (int i = quotes.size() - 1; i >= 0; i--) {
            Quote quote_ = quotes.get(i);
            System.out.printf("%d / %s / %s\n", quote_.id, quote_.content, quote_.author);
        }
    }

    private void write(Rq rq) {
        System.out.printf("명언 : ");
        String content = sc.nextLine().trim();
        System.out.printf("작가 : ");
        String author = sc.nextLine().trim();
        int id = ++quotesLastId; // 명언 글 번호 증가

        Quote quote = new Quote(id, content, author);
        quotes.add(quote);

        System.out.printf("%d번 명언이 등록되었습니다.\n", id);
    }

    private void remove(Rq rq) {
        // URL에 입력된 id 얻기
        int paramId = rq.getIntParam("id", 0);

        // URL에 입력된 id가 없다면 작업중지
        if (paramId == 0) {
            System.out.println("id를 입력해주세요.");
            return;
        }

        // URL에 입력된 id에 해당하는 명언객체 찾기
        Quote foundQuote = null;

        for (Quote quote : quotes) {
            if (quote.id == paramId) {
                foundQuote = quote;
            }
        }

        // 찾지 못했다면 중지
        if (foundQuote == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다..\n", paramId);
            return;
        }

        // 입력된 id에 해당하는 명언객체를 리스트에서 삭제
        quotes.remove(foundQuote);

        System.out.printf("%d번 명언이 삭제되었습니다.\n", paramId);
    }
}



}
