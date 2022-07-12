package com.choyeonjun.todayquotes;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private Scanner sc;

    public App() {
        sc = new Scanner(System.in);
    }

    public void run() {
        System.out.println("== 명언 SSG ==");
        QuoteController quoteController = new QuoteController(sc);

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
                    quoteController.write(rq);
                    break;
                case "삭제":
                    quoteController.remove(rq);
                    break;
                case "수정":
                    quoteController.modify(rq);
                    break;
                case "목록":
                    quoteController.list(rq);

            }
        }
        sc.close();
    }


}




