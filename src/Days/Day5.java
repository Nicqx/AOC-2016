package Days;

import utility.FileReader;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Day5 {
    String text = new FileReader("resources/D5/input").fileReaderString();

    public Day5() {
        System.out.println("D5 - The password for door ID " + text + " : " + genPass(text));
        System.out.println("D5 - The password with the new method for door ID " + text + " : " + genPassSpecial(text));
    }

    private static String genPassSpecial(String text) {
        int answer = 0;
        StringBuilder pass = new StringBuilder("zzzzzzzz");
        int replaceCounter = 0;
        while (replaceCounter != 8) {
            while (!hashMD5(text + answer).startsWith("00000")) {
                answer++;
            }
            try {
                int coord = Integer.parseInt(String.valueOf(hashMD5(text + answer).charAt(5)));
                if (0 <= coord && 7 >= coord) {
                    if (pass.charAt(coord) == 'z') {
                        pass.setCharAt(coord, hashMD5(text + answer).charAt(6));
                        replaceCounter++;
                    }
                }
            } catch (NumberFormatException e) {

            }
            answer++;
        }
        return pass.toString();
    }

    private static String genPass(String text) {
        int answer = 0;
        StringBuilder pass = new StringBuilder();
        while (pass.toString().length() != 8) {
            while (!hashMD5(text + answer).startsWith("00000")) {
                answer++;
            }

            pass.append(hashMD5(text + answer).charAt(5));
            answer++;
        }
        return pass.toString();
    }

    private static String hashMD5(String text) {
        byte[] msg = text.getBytes();

        byte[] hash = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            hash = md.digest(msg);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        StringBuilder strBuilder = new StringBuilder();
        assert hash != null;
        for (byte b : hash) {
            strBuilder.append(String.format("%02x", b));
        }
        return strBuilder.toString();
    }
}
