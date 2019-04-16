package cn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 * <p>
 * Example :
 * Input: "()"    Output: true
 * Input: "{[]}"    Output: true
 * Input: "([)]"    Output: false
 * Input: "()[]{}"    Output: true
 */
public class ValidParentheses {

    public static void main(String[] args) {
        ValidParentheses vp = new ValidParentheses();
        System.out.println(vp.isValid("){"));

    }

    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        s = s.replace('(', '1')
                .replace('[', '2')
                .replace('{', '3')
                .replace('}', '4')
                .replace(']', '5')
                .replace(')', '6');
        ArrayList<Integer> list = new ArrayList();
        Arrays.asList(s.split("")).stream().forEach(x -> list.add(Integer.parseInt(x)));
        Stack<Integer> tmp = new Stack<>();
        int num_pre = 0, num_pro = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > 3) {
                num_pro++;
                if (tmp.empty() || list.get(i) + tmp.pop() != 7) {
                    return false;
                }
            } else {
                num_pre++;
                tmp.push(list.get(i));
            }
        }
        if (num_pre != num_pro) {
            return false;
        }
        return true;
    }
}
