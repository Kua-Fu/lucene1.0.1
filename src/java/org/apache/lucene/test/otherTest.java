package org.apache.lucene.test;

public class otherTest {
    public static void main(String[] args) {
        int size = 5;
        String[] match = new String[size];
        int i = 0;
        while (i < 5) {
            match[i++] = "t " + i;
            System.out.println(i);
        }
    }

}