package com.alevel.java.nix.countbits;

public class CountBits
{
    private long number;
    public int countBits(long number) {
        int count = 0;
        if(number<0)
            number=~number-1;
        while (number != 0) {
            count++;
            number &= number - 1;
        }
        return count;
    }
}

