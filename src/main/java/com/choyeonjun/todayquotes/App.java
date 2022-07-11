package com.choyeonjun.todayquotes;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public void run() {
        System.out.println("== 명언 SSG ==");
        Scanner sc = new Scanner(System.in);

        List<Quote> quotes = new ArrayList<>();
        int count = 0;

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
                    System.out.print("명언 : ");
                    String content = sc.nextLine().trim();

                    System.out.print("작가 : ");
                    String writer = sc.nextLine().trim();
                    int id = ++count;
                    Quote quote = new Quote(id, content, writer);
                    quotes.add(quote);
//                    save(count, content, writer);
                    break;
                case "삭제":
                    // URL에 입력된 id 얻기
                    int paramId = rq.getIntParam("id", 0);

                    // URL에 입력된 id가 없다면 작업중지
                    if (paramId == 0) {
                        System.out.println("id를 입력해주세요.");
                        continue;
                    }

                    // URL에 입력된 id에 해당하는 명언객체 찾기
                    Quote quote__ = null;

                    for (Quote quote___ : quotes) {
                        if (quote___.id == paramId) {
                            quote__ = quote___;
                        }
                    }

                    // 찾지 못했다면 중지
                    if (quote__ == null) {
                        System.out.printf("%d번 명언은 존재하지 않습니다..\n", paramId);
                        continue;
                    }

                    // 입력된 id에 해당하는 명언객체를 리스트에서 삭제
                    quotes.remove(quote__);

                    System.out.printf("%d번 명언이 삭제되었습니다.\n", paramId);
                    break;
                case "목록":
                    System.out.println("번호 / 작가 / 명언");
                    System.out.println("----------------");
                    for(int i = quotes.size() - 1; i >= 0; i--){
                        Quote quote_ = quotes.get(i);
                        System.out.printf("%d / %s / %s\n", quote_.id, quote_.content, quote_.writer);
                    }

                    break;

//                    JsonObject origin = readJson();
//
//                    if(origin == null){
//                        System.out.print("저장된 명언이 없습니다.");
//                    }
            }
        }


        sc.close();

    }





}
