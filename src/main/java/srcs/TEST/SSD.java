package srcs.TEST;

import java.util.Scanner;

public class SSD {

    private static final String ERR = "Invalid command.";
    private static final int BUF_SIZE = 11;

    public static boolean idxValidCheck(String idx) {
        // #2. idx가 숫자인가
        int idxLen = idx.length();
        // #2-1. idx 길이가 2자리를 넘어가면 false
        if (idxLen > 2) return false;
        // #2-2 idx가 숫자가 아니면 false
        for (int i = 0; i < idxLen; i++) {
            if (idx.charAt(i) < '0' || idx.charAt(i) > '9')
                return false;
        }
        // #2-3 숫자 범위가 안맞으면 false
        int tmp = Integer.parseInt(idx);
        return tmp >= 0 && tmp <= 99;
    }

    public static boolean valValidCheck(String val) {
        // #1. 넣을 값의 길이가 10인가
        int len = val.length();
        if (len != 10)
            return false;
        // #2. val의 값이 숫자면 0~9사이인가? 알파벳이면 A~F 사이인가
        if (val.charAt(0) != '0' || val.charAt(1) != 'x')
            return false;

        for (int i = 2; i < len; i++) {
            char ch = Character.toUpperCase(val.charAt(i));
            if ((ch >= '0' && ch <= '9') || (ch >= 'A' && ch <= 'F'))
                continue;
            else
                return false;
        }
        return true;
    }

    // nand.txt에 쓰기
    public static void writeSSD(int flag, String val) {
        Scanner scanner = new Scanner(System.in);
        String idx;
        String tmp = "";

        if (flag == 1) {
            // 반복하여 쓰기
            for (int i = 0; i <= 5; i++) {
                String buf = String.format("ssd W %d %s", i, val);
                executeCommand(buf);
            }
        } else {
            // 사용자 입력 처리
            System.out.print("Enter index and value: ");
            idx = scanner.next();
            tmp = scanner.next();

            if (valValidCheck(tmp) && idxValidCheck(idx)) {
                int id = Integer.parseInt(idx);
                String buf = String.format("ssd W %d %s", id, tmp);
                executeCommand(buf);
            } else {
                System.out.println(ERR);
            }
        }
    }

    public static void readSSD(int flag) {
        Scanner scanner = new Scanner(System.in);
        String idx;

        if (flag == 1) {
            for (int i = 0; i <= 5; i++) {
                String buf = String.format("ssd R %d", i);
                executeCommand(buf);
            }
        } else {
            System.out.print("Enter index: ");
            idx = scanner.next();
            if (idxValidCheck(idx)) {
                int id = Integer.parseInt(idx);
                String buf = String.format("ssd R %d", id);
                executeCommand(buf);
            } else {
                System.out.println(ERR);
            }
        }
    }

    private static void executeCommand(String command) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("bash", "-c", command);
            Process process = processBuilder.start();
            process.waitFor();
            // 프로세스의 출력 처리
            // OutputStream, InputStream 등으로 결과를 가져와 처리 가능
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
