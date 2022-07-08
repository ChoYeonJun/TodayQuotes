package com.choyeonjun.todayquotes;

import org.junit.Test;

import java.io.*;
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

    @Test
    public void 표준출력을_리다이렉션하여_결과를_문자열로_받기() throws IOException {
        // 표준출력을 리다이렉션
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        System.out.println("안녕");

        String rs = output.toString().trim();

        // 표준출력을 원상복구
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        output.close();

        assertEquals("안녕", rs);
    }
}
