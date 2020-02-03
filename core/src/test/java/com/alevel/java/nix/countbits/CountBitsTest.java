package com.alevel.java.nix.countbits;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountBitsTest {
    private CountBits countBits;

    @BeforeEach
    void setUp() {
        countBits = new CountBits();
    }

    @Test
    void countBits() {
        test(15, 15);
        test(-15, -15);
        test(0, 0);
        test(12412421431232L, 12412421431232L);
        test(-12412421431232L, -12412421431232L);
    }

    private void test(long tested, long initial) {
        assertEquals(countBits.countBits(tested), count(initial));
    }

    private int count(long testednumber) {
        var expected = new CountBits();
        return expected.countBits(testednumber);
    }
}
