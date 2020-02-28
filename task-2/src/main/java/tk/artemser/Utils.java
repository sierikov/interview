package tk.artemser;

public class Utils
{
    public static String interviewRecursionTest(String s){
        if (s.length() == 0) return "";
        char head = s.charAt(0);
        String tail = s.substring(1);
        if (tail.length() > 0 && isVowel(head)) return head + "*" + interviewRecursionTest(tail);
        else {
            if(tail.length() > 0 && isVowel(tail.charAt(0))) return head + "*" + interviewRecursionTest(tail);
            else return head + interviewRecursionTest(tail);
        }
    }

    static boolean isVowel(char c){
        switch (c) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u': return true;
            default: return false;
        }
    }


}
