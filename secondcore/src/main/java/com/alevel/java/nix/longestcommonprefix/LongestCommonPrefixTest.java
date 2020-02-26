package com.alevel.java.nix.longestcommonprefix;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class LongestCommonPrefixTest {

    LongestCommonPrefix lc;

    @BeforeEach
    void setUp()
    {
        lc = new LongestCommonPrefix();
    }

    @Test
    void longestCommonPrefix() {
        test("fix","fix","fixed","fixor");
    }

    private void test(String actual,String... expected)
    {
        assertEquals(actual,lc.longestCommonPrefix(expected));
    }
}