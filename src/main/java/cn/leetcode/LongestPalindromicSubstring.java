package cn.leetcode;

import java.util.TreeMap;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example :
 * Input: "babad"    Output: "bab"    Note: "aba" is also a valid answer.
 * Input: "cbbd"    Output: "bb"
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("babad"));
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("cbbd"));
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("cccccc"));
        System.out.println(new LongestPalindromicSubstring().longestPalindrome(""));
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("abcdea"));
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("ccd"));
    }

    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        TreeMap<Integer, String> map = new TreeMap<>();
        int[] indexs = new int[2];
        String subStr = "";
        for (int i = 0; i < s.length(); i++) {
            getIndex(s, i, i, indexs);
            subStr = s.substring(indexs[0], indexs[1] + 1);
            map.put(subStr.length(), subStr);
            indexs[0] = 0;
            indexs[1] = 0;
        }
        for (int j = 0; j < s.length() - 1; j++) {
            getIndex(s, j, j + 1, indexs);
            subStr = s.substring(indexs[0], indexs[1] + 1);
            map.put(subStr.length(), subStr);
            indexs[0] = 0;
            indexs[1] = 0;
        }
        return map.get(map.lastKey());
    }

    /**
     * @param s      目标字符串
     * @param index1 回文字符串的中心
     * @param index2 回文字符串的中心
     * @param indexs 回文字符串的索引
     */
    public void getIndex(String s, int index1, int index2, int[] indexs) {
        if (index1 >= 0 && index2 < s.length() && s.charAt(index1) == s.charAt(index2)) {
            if (index1 - 1 >= 0 && index2 + 1 < s.length()) {
                getIndex(s, index1 - 1, index2 + 1, indexs);
            } else {
                indexs[0] = index1;
                indexs[1] = index2;
            }
        } else if (index1 + 1 <= index2 - 1 && index1 + 1 > 0 && index2 - 1 < s.length()) {
            indexs[0] = index1 + 1;
            indexs[1] = index2 - 1;
        } else {
            indexs[0] = index1;
            indexs[1] = index1;
        }
    }
}
