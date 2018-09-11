package jp.co.training.util;

import java.security.SecureRandom;

public class BookUtil {

    private BookUtil() {
    }

    public static String generateID(int digit) {
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[digit / 2];
        random.nextBytes(bytes);
        StringBuilder sb = new StringBuilder();
        for (byte d : bytes) {
            sb.append(String.format("%02X", d));
        }
        return sb.toString();
    }

}
