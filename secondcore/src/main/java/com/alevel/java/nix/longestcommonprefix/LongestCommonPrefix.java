package com.alevel.java.nix.longestcommonprefix;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String... strs) {
        int minLength = calcMinWordLength(strs);
        if (minLength == 0) {
            return "";
        }

        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < minLength && charsAtIndexEqual(i,strs); i++) {
            prefix.append(strs[0].charAt(i));
        }
        return prefix.toString();
    }

    private static int calcMinWordLength(String... strs) {
        if (strs.length == 0) {
            return 0;
        }
        int min = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            int len = strs[i].length();
            if (len < min) {
                min = len;
            }
        }
        return min;
    }

    private static boolean charsAtIndexEqual(int index,String... strs) {
        char c = strs[0].charAt(index);
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].charAt(index) != c) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LongestCommonPrefix lc = new LongestCommonPrefix();
        lc.longestCommonPrefix("fixol","fixed","fixor");
    }
}
