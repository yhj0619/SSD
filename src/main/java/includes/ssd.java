import java.util.Arrays;

public class ssd {

    // 상수 정의 (BUF_SIZE)
    public static final int BUF_SIZE = 256;

    // LBA에 값 쓰기 메서드
    public static void writeLBA(int num, String val) {
        // 실제로 데이터를 LBA에 쓰는 로직
        System.out.println("Writing value: " + val + " to LBA: " + num);
    }

    // LBA에서 값 읽기 메서드
    public static void readLBA(int num) {
        // 실제로 데이터를 LBA에서 읽는 로직
        System.out.println("Reading value from LBA: " + num);
    }

    public static void main(String[] args) {
        // 예시로 writeLBA와 readLBA 호출
        writeLBA(1, "0xFF");
        readLBA(1);
    }
}
