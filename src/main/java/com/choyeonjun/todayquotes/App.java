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

            switch (cmd) {
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


        sc.close();

    }
}
