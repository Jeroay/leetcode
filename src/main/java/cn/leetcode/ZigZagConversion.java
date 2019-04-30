package cn.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * <p>
 * Example :
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * <p>
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 */
public class ZigZagConversion {

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        System.out.println(new ZigZagConversion().convert(s, 3));
        System.out.println(new ZigZagConversion().convert(s, 4));
        System.out.println(new ZigZagConversion().convert("ab", 1));
    }

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        String[][] str = new String[numRows][s.length()];
        int index = 0;
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            str[index][i] = s.charAt(i) + "";
            if (index == 0 || index == numRows - 1) {
                flag = !flag;
            }
            if (flag) {
                index++;
            } else {
                index--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            String[] strs = str[i];
            List<String> list = Arrays.asList(strs);
            list.stream().filter(x -> x != null)
                    .forEach(x -> sb.append(x));
        }
        return sb.toString();
    }
}
