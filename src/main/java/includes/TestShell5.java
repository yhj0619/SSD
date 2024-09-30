// 상수 정의 및 메서드 정의를 포함하는 클래스
public class TestShell5 {

    // 상수 정의
    public static final int BUF_SIZE = 256;
    public static final String CMD = "Shell >> ";
    public static final String ERR = "INVALID COMMAND";

    // io 관련 메서드들
    public static boolean idxValidCheck(String idx) {
        // 인덱스가 유효한지 확인하는 로직 구현
        return idx != null && !idx.isEmpty();
    }

    public static boolean valValidCheck(String val) {
        // 값이 유효한지 확인하는 로직 구현
        return val != null && !val.isEmpty();
    }

    public static void writeSSD(int flag, String val) {
        // SSD에 쓰는 로직 구현
        System.out.println("Writing to SSD with flag: " + flag + " and value: " + val);
    }

    public static void readSSD(int flag) {
        // SSD에서 읽는 로직 구현
        System.out.println("Reading from SSD with flag: " + flag);
    }

    // full_io 관련 메서드들
    public static void fullwrite(int testFlag) {
        // 전체 LBA에 쓰는 로직 구현
        System.out.println("Writing to all LBAs with testFlag: " + testFlag);
    }

    public static void fullread() {
        // 전체 LBA에서 읽는 로직 구현
        System.out.println("Reading all values from LBA");
    }

    // test 관련 메서드들
    public static void testapp1() {
        // testapp1 실행 로직
        System.out.println("Running testapp1");
    }

    public static void testapp2() {
        // testapp2 실행 로직
        System.out.println("Running testapp2");
    }
}
