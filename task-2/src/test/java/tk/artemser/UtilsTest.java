package tk.artemser;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class UtilsTest
{
    private UtilsTest utils;

    @Before
    public void setUp(){
        utils = new UtilsTest();
    }

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
}
