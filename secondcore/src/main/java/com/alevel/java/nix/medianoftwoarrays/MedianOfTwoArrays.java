package com.alevel.java.nix.medianoftwoarrays;

public class MedianOfTwoArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0)
            throw new IllegalArgumentException("Arrays are empty!Fill them!");

        int mergedTillMediansLength = (nums1.length + nums2.length) / 2 + 1;

        int[] mergedTillMedians = new int[mergedTillMediansLength];

        int min;

        double resultMedian;

        int i = 0, j = 0, k = 0, num1 = 0, num2 = 0;
        while (k < mergedTillMediansLength) {
            if (i < nums1.length) {
                num1 = nums1[i];
            }

            if (j < nums2.length) {
                num2 = nums2[j];
            }

            if (num1 < num2) {
                min = num1;
                ++i;
            } else {
                min = num2;
                ++j;
            }
            mergedTillMedians[k] = min;
            ++k;
        }

        resultMedian = ((nums1.length + nums2.length) % 2 == 0)
                ? (mergedTillMedians[mergedTillMediansLength - 1] + mergedTillMedians[mergedTillMediansLength - 2]) / 2.0
                : mergedTillMedians[mergedTillMediansLength - 1];

        return resultMedian;

    }
}
