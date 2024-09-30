package srcs.TEST;

import java.util.Scanner;

public class TestShell3 {

    // 명령 프롬프트와 에러 메시지 상수
    private static final String CMD = "cmd> ";
    private static final String ERR = "Invalid command";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print(CMD);
            String qry = scanner.next();

            switch (qry) {
                case "write":
                    writeSSD(0, 0);
                    break;

                case "read":
                    readSSD(0);
                    break;

                case "exit":
                    scanner.close();
                    return;

                case "help":
                    showHelp();
                    break;

                case "fullwrite":
                    fullwrite(0);
                    break;

                case "fullread":
                    fullread();
                    break;

                case "testapp1":
                    testapp1();
                    break;

                case "testapp2":
                    testapp2();
                    break;

                default:
                    System.out.println(ERR);
                    break;
            }
        }
    }

    // 각 명령어에 대응하는 메서드들 (구현은 실제 기능에 맞게 작성해야 합니다)
    private static void writeSSD(int lba, int value) {
        // 실제 write 기능 구현
        System.out.println("Writing value to SSD");
    }

    private static void readSSD(int lba) {
        // 실제 read 기능 구현
        System.out.println("Reading value from SSD");
    }

    private static void fullwrite(int value) {
        // 전체 LBA에 값 쓰기
        System.out.println("Writing value to all LBA");
    }

    private static void fullread() {
        // 전체 LBA에서 값 읽기
        System.out.println("Reading all values from LBA");
    }

    private static void testapp1() {
        // testapp1 실행
        System.out.println("Executing testapp1");
    }

    private static void testapp2() {
        // testapp2 실행
        System.out.println("Executing testapp2");
    }

    private static void showHelp() {
        System.out.println("Usage: <command> [<args>]");
        System.out.println("    write       write <hexa_value> to <LBA>");
        System.out.println("    read        read <LBA>");
        System.out.println("    exit        terminate shell");
        System.out.println("    help        show all command and how to use");
        System.out.println("    fullwrite   write <hexa_value> to all LBA");
        System.out.println("    fullread    show all values in LBA");
        System.out.println("    testapp1    operate commands that already saved");
        System.out.println("    testapp2    operate commands that already saved");
    }
}
