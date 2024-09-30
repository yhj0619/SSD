package srcs.SSD;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        VirtualSSD ssd = new VirtualSSD();
        Scanner scanner = new Scanner(System.in);

        System.out.println("명령어를 입력하세요 (예: ssd W 20 0x1289CDEF 또는 ssd R 20): ");
        String input = scanner.nextLine();
        String[] tokens = input.split(" ");

        // 'ssd'로 시작하는지 체크
        if (tokens.length > 0 && tokens[0].equalsIgnoreCase("ssd")) {
            if (tokens[1].equalsIgnoreCase("W") && tokens.length == 4) {
                int lba = Integer.parseInt(tokens[2]);
                String data = tokens[3];
                System.out.println("lba : " + lba + " data: " + data);
                ssd.write(lba, data);
                System.out.println("write done");
            } else if (tokens[1].equalsIgnoreCase("R") && tokens.length == 3) {
                int lba = Integer.parseInt(tokens[2]);
                ssd.read(lba);
            } else {
                System.out.println("잘못된 명령어입니다.");
            }
        } else {
            System.out.println("잘못된 명령어입니다.");
        }
        scanner.close();

    }
}
