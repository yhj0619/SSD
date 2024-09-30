package srcs.SSD;

import java.io.*;
import java.util.*;

public class VirtualSSD {
    private static final int LBA_SIZE = 100;
    private static final String NAND_FILE = "C:\\Users\\User\\IdeaProjects\\SSD\\..\\nand.txt";
    private static final String RESULT_FILE = "../result.txt";
    private static final String DEFAULT_VALUE = "0x00000000";
    private static final String VALUE_FORMAT = "^0x[0-9A-Fa-f]{8}$";
    private static Map<Integer, String> ssdMemory = new HashMap<>();


    // 기존 파일에서 데이터를 읽어와 ssdMemory에 로드
    private void loadFromNand() {
        File file = new File(NAND_FILE);
        if (!file.exists()) {
            return; // 파일이 없으면 로드할 데이터가 없음
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length == 2) {
                    int lba = Integer.parseInt(parts[0]);
                    String data = parts[1];
                    ssdMemory.put(lba, data); // 기존 데이터를 메모리에 로드
                }
            }
            System.out.println("nand.txt에서 데이터를 불러왔습니다.");
        } catch (IOException e) {
            System.out.println("nand.txt 파일에서 데이터를 불러오는 동안 오류가 발생했습니다.");
            e.printStackTrace();
        }
    }

    // Write 명령어 처리
    public void write(int lba, String data) {
        if (!isValidLBA(lba)) {
            System.out.println("유효하지 않은 LBA 번호입니다. LBA는 0부터 99까지 가능합니다.");
            return;
        }
        if (!isValidData(data)) {
            System.out.println("유효하지 않은 데이터 형식입니다. 데이터는 '0x'로 시작하며, 8자리 16진수여야 합니다.");
            return;
        }

        // 기존 데이터를 먼저 로드하고 나서 새 데이터를 추가
        loadFromNand();

        ssdMemory.put(lba, data);
        saveToNand();
        System.out.println("LBA: " + lba + "에 데이터가 성공적으로 저장되었습니다.");
    }

    // Read 명령어 처리
    public void read(int lba) {
        if (!isValidLBA(lba)) {
            System.out.println("유효하지 않은 LBA 번호입니다. LBA는 0부터 99까지 가능합니다.");
            return;
        }
        String data = ssdMemory.getOrDefault(lba, DEFAULT_VALUE);
        saveToResult(data);
    }

    // LBA 번호의 유효성 체크
    private boolean isValidLBA(int lba) {
        return lba >= 0 && lba < LBA_SIZE;
    }

    // 데이터 형식의 유효성 체크 (0x로 시작하고 8자리 16진수여야 함)
    private boolean isValidData(String data) {
        return data.matches(VALUE_FORMAT);
    }

    // nand.txt 파일에 SSD 상태 저장
    private void saveToNand() {
        System.out.println("파일 경로: " + new File(NAND_FILE).getAbsolutePath());
        File file = new File(NAND_FILE);

        try {
            if (!file.exists()) {
                file.createNewFile(); // 파일이 없으면 생성
            }
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(NAND_FILE, true))) {
                for (Map.Entry<Integer, String> entry : ssdMemory.entrySet()) {
                    // LBA와 데이터를 올바르게 저장하도록 보장
                    bw.write(entry.getKey() + " " + entry.getValue());
                    System.out.println("확인용: " + entry.getKey() + " " + entry.getValue());
                    bw.newLine();
                }
                bw.flush();
                System.out.println("nand.txt 파일에 저장 완료.");
            } catch (IOException e) {
                System.out.println("nand.txt 파일에 저장하는 동안 오류가 발생했습니다.");
                e.printStackTrace();
            }
        } catch (IOException e) {
            System.out.println("nand.txt 파일에 저장하는 동안 오류가 발생했습니다.");
            e.printStackTrace();
        }
    }


    // result.txt 파일에 읽은 값 저장 (기존 내용은 삭제)
    private void saveToResult(String data) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(RESULT_FILE))) {
            bw.write(data);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}