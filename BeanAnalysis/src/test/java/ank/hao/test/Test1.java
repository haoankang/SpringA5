package ank.hao.test;

import org.junit.jupiter.api.Test;

import java.util.StringTokenizer;

public class Test1 {

    @Test
    public void test(){
        String string = "ksaf,dgd,sow";
        String delimiters = ",; ";
        StringTokenizer st = new StringTokenizer(string, delimiters);
        System.out.println(st.nextToken());
        System.out.println(st.nextToken());
        System.out.println(st);
    }
}
