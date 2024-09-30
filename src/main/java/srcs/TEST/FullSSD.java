package srcs.TEST;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class FullSSD {
    private static final String ERR = "Invalid value.";
    private static final int BUF_SIZE = 11;

    public static void fullwrite(int testFlag) {
        Scanner scanner = new Scanner(System.in);
        String val;
        String buf;

        if (testFlag == 1) {
            val = "0xFFFFFFFF";
        } else {
            System.out.print("Enter value: ");
            val = scanner.next();
            if (!valValidCheck(val)) {
                System.out.println(ERR);
                return;
            }
        }

        for (int i = 0; i < 100; i++) {
            buf = String.format("ssd W %d %s", i, val);
            executeCommand(buf);
        }
    }

    public static void fullread() {
        try (BufferedReader reader = new BufferedReader(new FileReader("nand.txt"))) {
            String line;
            for (int i = 0; i < 100; i++) {
                line = reader.readLine();
                if (line != null) {
                    System.out.println(line);
                } else {
                    break; // 파일의 끝에 도달한 경우
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean valValidCheck(String val) {
        // #1. 넣을 값의 길이가 10인가
        int len = val.length();
        if (len != 10) {
            return false;
        }
        // #2. val의 값이 숫자면 0~9사이인가? 알파벳이면 A~F 사이인가
        if (val.charAt(0) != '0' || val.charAt(1) != 'x') {
            return false;
        }

        for (int i = 2; i < len; i++) {
            char ch = Character.toUpperCase(val.charAt(i));
            if ((ch >= '0' && ch <= '9') || (ch >= 'A' && ch <= 'F')) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    private static void executeCommand(String command) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("bash", "-c", command);
            Process process = processBuilder.start();
            process.waitFor();
            // 프로세스의 출력 처리
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}