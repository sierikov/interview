package tk.artemser;

import java.util.Collections;

public class Utils {
    public static String interviewRecursionTest(String s) {
        if (s.length() == 0) return "";
        char head = s.charAt(0);
        String tail = s.substring(1);
        if (tail.length() > 0 && isVowel(head)) return head + "*" + interviewRecursionTest(tail);
        else {
            if (tail.length() > 0 && isVowel(tail.charAt(0))) return head + "*" + interviewRecursionTest(tail);
            else return head + interviewRecursionTest(tail);
        }
    }

    static boolean isVowel(char c) {
        switch (c) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return true;
            default:
                return false;
        }
    }

    /**
     * Takes @param String s, takes binary. Then check every byte in bit.
     * If highest bit is set - append 1
     * else - append 0
     *
     * Example: G -> 01000111
     *
     * @param s - original message
     * @return String - binary output
     */
    static String toBinary(String s) {
        byte[] bytes = s.getBytes();
        StringBuilder binary = new StringBuilder();
        for (byte b : bytes) {
            int val = b;
            for (int i = 0; i < 8; ++i) {
                binary.append((val & 128) == 0 ? 0 : 1);
                val <<= 1;
            }
        }
        return binary.toString();
    }

    public static String converter(String s) {
        String binary = toBinary(s);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < binary.length(); i++) {
            int count = 1;
            while (i + 1 < binary.length() && binary.charAt(i) == binary.charAt(i + 1)) {
                i++;
                count++;
            }
            if (binary.charAt(i) == '0') result.append("00").append(" ");
            else result.append("0").append(" ");
            result.append(String.join("", Collections.nCopies(count, "0"))).append(" ");
        }

        return result.toString().trim();
    }
}
