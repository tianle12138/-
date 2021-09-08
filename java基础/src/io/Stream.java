package io;

import java.io.*;

public class Stream {
    public static void main(String[] args) {
        try {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(new File("./JVM/test.txt")));
            char[] buffer = new char[1024];
            int read = isr.read(buffer);
            System.out.println(new String(buffer));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
