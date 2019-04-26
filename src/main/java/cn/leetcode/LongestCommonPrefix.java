package cn.leetcode;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 * <p>
 * Example 1:
 * Input: ["flower","flow","flight"]    Output: "fl"
 * <p>
 * Input: ["dog","racecar","car"]    Output: ""
 * Explanation: There is no common prefix among the input strings.
 * <p>
 * Note:
 * All given inputs are in lowercase letters a-z.
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs1 = {"flower", "flow", "flight"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs1));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int minStrLenngth = strs[0].length();
        for (String str : strs) {
            if (str.length() < minStrLenngth) {
                minStrLenngth = str.length();
            }
        }
        StringBuilder sb = new StringBuilder();
        k:
        for (int i = 0; i < minStrLenngth; i++) {
            char tmp = strs[0].charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if (tmp != strs[j].charAt(i)) {
                    break k;
                }
            }
            sb.append(tmp + "");
        }
        return sb.toString();
    }
}
