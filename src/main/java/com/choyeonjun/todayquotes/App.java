package com.choyeonjun.todayquotes;

import java.util.Scanner;

public class App {

    public void run(){
        System.out.println("== 명언 SSG ==");

        Scanner sc = new Scanner(System.in);

        outer: //while 문 라벨링
        while(true){
            System.out.printf("명령) ");
            String cmd = sc.nextLine().trim();
            switch (cmd){
                case "종료" :
                    break outer;
            }


        }


        sc.close();

    }
}
