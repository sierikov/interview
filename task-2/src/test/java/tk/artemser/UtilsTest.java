package tk.artemser;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class UtilsTest
{
    @Test
    public void testIsVowel()
    {
        String vowels = "aeiou";
        for (char ch : vowels.toCharArray()){
            assertTrue(Utils.isVowel(ch));
        }
        assertFalse(Utils.isVowel('z'));
    }

    @Test
    public void testInterviewRecursion(){
        assertEquals("h*e*ll*o", Utils.interviewRecursionTest("hello"));
        assertEquals("h*e*a*l*o",Utils.interviewRecursionTest("healo"));
        assertEquals("a*bc", Utils.interviewRecursionTest("abc"));
        assertEquals("o*a*b", Utils.interviewRecursionTest("oab"));
    }

    @Test
    public void testToBinary(){
        assertEquals("011001100110111101101111", Utils.toBinary("foo"));
        assertEquals("01000111", Utils.toBinary("G"));
    }

    @Test
    public void testConverter(){
        assertEquals("00 0 0 0 00 000 0 000", Utils.converter("G"));
    }
}
