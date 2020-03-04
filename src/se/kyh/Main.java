package se.kyh;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {

    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();

    private static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int i = 0; i < bytes.length; i++) {
            int value = bytes[i] & 0xFF;
            hexChars[i * 2] = HEX_ARRAY[value >>> 4];
            hexChars[i * 2 + 1] = HEX_ARRAY[value & 0x0F];
        }
        return new String(hexChars);
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String originalString = "Alice";
        MessageDigest digest = MessageDigest.getInstance("SHA-512");

        byte[] encodedHash = digest.digest(originalString.getBytes(StandardCharsets.UTF_8));
        System.out.println(bytesToHex(encodedHash));
    }
}