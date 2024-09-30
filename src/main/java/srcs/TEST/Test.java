package srcs.TEST;

public class Test {

    public static void testapp1() {
        fullwrite(true);
        fullread();
    }

    public static void testapp2() {
        for (int i = 0; i < 30; i++) {
            writeSSD(true, "0xAAAABBBB");
        }
        writeSSD(true, "0x12345678");
        readSSD(true);
    }

    public static void main(String[] args) {
        // Example usage
        testapp1(); // Calls testapp1 logic
        testapp2(); // Calls testapp2 logic
    }

    // Include all previously provided methods (writeSSD, readSSD, fullwrite, fullread, etc.)
}
