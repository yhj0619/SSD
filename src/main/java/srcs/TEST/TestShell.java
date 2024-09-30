package srcs.TEST;
import java.util.Scanner;

import static srcs.TEST.FullSSD.fullread;
import static srcs.TEST.FullSSD.fullwrite;
import static srcs.TEST.Main.testapp1;
import static srcs.TEST.Main.testapp2;
import static srcs.TEST.SSD.readSSD;
import static srcs.TEST.SSD.writeSSD;

public class TestShell {

    private static final String CMD = "Enter command: ";
    private static final String ERR = "Invalid command.";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print(CMD);
            String qry = scanner.nextLine().trim();

            // write
            if (qry.equals("write")) {
                writeSSD(0, null);
            }
            // read
            else if (qry.equals("read")) {
                readSSD(0);
            }
            // exit -> shell 종료
            else if (qry.equals("exit")) {
                break;
            }
            // help -> 명령어 사용 방법 출력
            else if (qry.equals("help")) {
                printHelp();
            }
            // fullwrite -> 전체 LBA에 값 입력
            else if (qry.equals("fullwrite")) {
                fullwrite(0);
            }
            // fullread -> 전체 값 출력
            else if (qry.equals("fullread")) {
                fullread();
            }
            else if (qry.equals("testapp1")) {
                testapp1();
            }
            else if (qry.equals("testapp2")) {
                testapp2();
            }
            // 잘못된 명령어
            else {
                System.out.println(ERR);
            }
        }

        scanner.close();
    }

    private static void printHelp() {
        System.out.println("Usage: <command> [<args>]");
        System.out.println("    write        write <hexa_value> to <LBA>");
        System.out.println("    read         read <LBA>");
        System.out.println("    exit         terminate shell");
        System.out.println("    help         show all command and how to use");
        System.out.println("    fullwrite    write <hexa_value> to all LBA");
        System.out.println("    fullread     show all values in LBA");
        System.out.println("    testapp1     operate commands that already saved");
        System.out.println("    testapp2     operate commands that already saved");
    }
}
