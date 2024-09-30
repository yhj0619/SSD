package srcs.TEST;

import java.util.Scanner;

import static srcs.TEST.FullSSD.fullread;
import static srcs.TEST.FullSSD.fullwrite;
import static srcs.TEST.SSD.readSSD;
import static srcs.TEST.SSD.writeSSD;

public class Main {

    public static void testapp1() {
        fullwrite(1);
        fullread();
    }

    public static void testapp2() {
        for (int i = 0; i < 30; i++) {
            writeSSD(1, "0xAAAABBBB");
        }
        writeSSD(1, "0x12345678");
        readSSD(1);
    }

}
