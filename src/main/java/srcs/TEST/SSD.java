package srcs.TEST;

import srcs.SSD.VirtualSSD; // 다른 패키지의 클래스 임포트

import java.util.Scanner;

public class SSD {

    private static final String ERR = "Invalid command.";
    private static final int BUF_SIZE = 11;

    // VirtualSSD 객체 생성
    private static VirtualSSD virtualSSD = new VirtualSSD();

    public static boolean idxValidCheck(String idx) {
        int idxLen = idx.length();
        if (idxLen > 2) return false;
        for (int i = 0; i < idxLen; i++) {
            if (idx.charAt(i) < '0' || idx.charAt(i) > '9')
                return false;
        }
        int tmp = Integer.parseInt(idx);
        return tmp >= 0 && tmp <= 99;
    }

    public static boolean valValidCheck(String val) {
        int len = val.length();
        if (len != 10) return false;
        if (val.charAt(0) != '0' || val.charAt(1) != 'x') return false;
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
        if (flag == 1) {
            for (int i = 0; i < 5; i++) {
                // VirtualSSD의 write 메서드 사용
                virtualSSD.write(i, val);
            }
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.print("설마 여기서 되는겨? Enter index and value: ");
            String idx = scanner.next();
            String tmp = scanner.next();

            if (valValidCheck(tmp) && idxValidCheck(idx)) {
                int id = Integer.parseInt(idx);
                // VirtualSSD의 write 메서드 사용
                virtualSSD.write(id, tmp);
            } else {
                System.out.println(ERR);
            }
        }
    }

    public static void readSSD(int flag) {
        if (flag == 1) {
            for (int i = 0; i <= 5; i++) {
                // VirtualSSD의 read 메서드 사용
                virtualSSD.read(i);
            }
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter index: ");
            String idx = scanner.next();
            if (idxValidCheck(idx)) {
                int id = Integer.parseInt(idx);
                // VirtualSSD의 read 메서드 사용
                virtualSSD.read(id);
            } else {
                System.out.println(ERR);
            }
        }
    }
}
