package srcs.TEST;

import java.io.*;
import java.util.Scanner;

public class Io {

    private static final int BUF_SIZE = 1024;
    private static final String ERR = "Error: Invalid value";

    public static boolean idx_validCheck(String idx) {
        // #2. idx가 숫자인가
        int idx_len = idx.length();
        // #2-1. idx 길이가 2자리를 넘어가면 false
        if (idx_len > 2) return false;
        // #2-2 idx 가 숫자가 아니면 false
        for (int i = 0; i < idx_len; i++) {
            if (idx.charAt(i) < '0' || idx.charAt(i) > '9') {
                return false;
            }
        }
        // #2-3 숫자 범위가 안맞으면 false
        int tmp = Integer.parseInt(idx);
        return tmp >= 0 && tmp <= 99;
    }

    public static boolean val_validCheck(String val) {
        // #1. 넣을 값의 길이가 10인가
        int len = val.length();
        if (len != 10) return false;
        // #2. val의 값이 숫자면 0~9사이인가? 알파벳이면 A~F 사이인가
        if (val.charAt(0) != '0' || val.charAt(1) != 'x') return false;
        for (int i = 2; i < len; i++) {
            char c = Character.toUpperCase(val.charAt(i));
            if ((c >= '0' && c <= '9') || (c >= 'A' && c <= 'F')) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void writeSSD(boolean flag, String val) {
        Scanner scanner = new Scanner(System.in);
        String idx = "";
        String tmp = "";
        String buf;

        if (flag) {
            tmp = val;
            for (int i = 0; i <= 5; i++) {
                buf = String.format("ssd W %d %s", i, tmp);
                try {
                    // System.out.println("write: " + buf); // Uncomment for debugging
                    Runtime.getRuntime().exec(buf);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            idx = scanner.next();
            tmp = scanner.next();
            if (val_validCheck(tmp) && idx_validCheck(idx)) {
                int id = Integer.parseInt(idx);
                buf = String.format("ssd W %d %s", id, tmp);
                try {
                    // System.out.println("write: " + buf); // Uncomment for debugging
                    Runtime.getRuntime().exec(buf);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println(ERR);
            }
        }
    }

    public static void readSSD(boolean flag) {
        Scanner scanner = new Scanner(System.in);
        String idx;
        String buf;

        if (flag) {
            for (int i = 0; i <= 5; i++) {
                buf = String.format("ssd R %d", i);
                try {
                    // System.out.println("read: " + buf); // Uncomment for debugging
                    Runtime.getRuntime().exec(buf);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            idx = scanner.next();
            if (idx_validCheck(idx)) {
                int id = Integer.parseInt(idx);
                buf = String.format("ssd R %d", id);
                try {
                    // System.out.println("read: " + buf); // Uncomment for debugging
                    Runtime.getRuntime().exec(buf);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println(ERR);
            }
        }
    }

    public static void main(String[] args) {
        // Example usage
        writeSSD(true, "0x12345678"); // Writes with the flag set to true
        readSSD(false); // Reads with the flag set to false
    }
}
