package com.alevel.java.nix.medianoftwoarrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class MedianOfTwoArraysTest {
    MedianOfTwoArrays medianOfTwoArrays;
    @BeforeEach
    void setUp(){
        medianOfTwoArrays = new MedianOfTwoArrays();
    }
    @Test
    void findMedianSortedArrays() {
        int[] num1 = {1, 3, 6, 11, 16};
        int[] num2 = {2, 4, 12, 14, 15};
        test(8.5,num1,num2);
//        int[] num11 = {};
//        int[] num22 = {};
//        test(0,num11,num22);
    }
    private void test(double actual,int[] nums1,int[] nums2)
    {
        assertEquals(actual,medianOfTwoArrays.findMedianSortedArrays(nums1,nums2));
    }
}