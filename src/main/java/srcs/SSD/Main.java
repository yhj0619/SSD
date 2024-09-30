package srcs.SSD;
<<<<<<< HEAD

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
=======
import java.io.*;

public class Main {
    public static void main(String[] args) {
        // 1. 인자의 개수가 4개면 write
        // 2. 인자의 개수가 3개면 read
        // 공통적인 부분 -> LBA
        if (args.length < 3) {
            System.out.println("Usage: java Main <command> <LBA> [value]");
            return;
        }

        int LBA = Integer.parseInt(args[1]);

        if (args.length == 4) {
            // Write operation
            VirtualSSD.writeLBA(LBA, args[2]);
        } else if (args.length == 3) {
            // Read operation
            VirtualSSD.readLBA(LBA);
        } else {
            System.out.println("Invalid number of arguments.");
        }
>>>>>>> 6ab5b5f23b29f527691770f8e3575647bd231e80
    }
}
