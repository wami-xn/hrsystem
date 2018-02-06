package com.wami.project.hrsystem.core.utils.test;

import org.junit.Test;

import java.util.Random;

public class TestMd5 {
    @Test
    public void testMd5(){
        Random random = new Random();
        StringBuilder sBuilder = new StringBuilder(16);
        sBuilder.append(random.nextInt(99999999)).append(random.nextInt(99999999));
        int len = sBuilder.length();
        if (len < 16) {
            for (int i = 0; i < 16 - len; i++) {
                sBuilder.append("0");
            }
        }
        System.out.println(sBuilder);
    }
}
