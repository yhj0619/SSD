package srcs.TEST;

import java.io.*;
import java.util.Scanner;

public class TestShell2 {

    private static final int BUF_SIZE = 1024;
    private static final String ERR = "Error: Invalid value";

    public static void fullwrite(boolean testFlag) {
        String val = "";
        if (testFlag) {
            val = "0xFFFFFFFF";
        } else {
            Scanner scanner = new Scanner(System.in);
            val = scanner.next();
            if (!val_validCheck(val)) {
                System.out.println(ERR);
                return;
            }
        }

        for (int i = 0; i < 100; i++) {
            String buf = String.format("ssd W %d %s", i, val);
            try {
                // System.out.println("write: " + buf); // Uncomment for debugging
                Runtime.getRuntime().exec(buf);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void fullread() {
        try (BufferedReader br = new BufferedReader(new FileReader("nand.txt"))) {
            String line;
            for (int i = 0; i < 100; i++) {
                if ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Placeholder for validation logic, since the original C function is not provided
    public static boolean val_validCheck(String val) {
        // Implement your validation logic here
        return true; // Return true for now, modify as needed
    }

    public static void main(String[] args) {
        // Example usage
        fullwrite(true); // Example flag usage
        fullread(); // Read and display nand.txt contents
    }
}
