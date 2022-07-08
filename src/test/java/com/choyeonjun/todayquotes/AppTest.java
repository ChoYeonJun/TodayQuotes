package com.choyeonjun.todayquotes;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {

    @Test
    public void 스캐너_테스트(){
        String input = """
                등록
                명언 1
                작가 1        
                """.stripIndent();
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner sc = new Scanner(in);

        String cmd1 = sc.nextLine().trim();
        String cmd2 = sc.nextLine().trim();
        String cmd3 = sc.nextLine().trim();

        assertEquals(cmd1, "등록");
        assertEquals(cmd2, "명언 1");
        assertEquals(cmd3, "작가 1");
    }
}
