package cn.leetcode;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example:
 * Input: 123    Output: 321
 * Input: -123    Output: -321
 * Input: 120    Output: 21
 *
 * Note:
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1].
 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 */
public class ReverseInteger {

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(new ReverseInteger().reverse(-12));
    }

    public int reverse1(int x) {
        String preStr = "";
        if(x < 0) {
            x = -x;
            preStr = "-";
        }
        String strx = x+"";
        StringBuilder result = new StringBuilder();
        result.append(preStr);
        for (int i = strx.length() -1; i >= 0; i--) {
            result.append(strx.charAt(i));
        }
        int ret = 0;
        try {
            ret = Integer.parseInt(result.toString());
        }catch (Exception e){

        }
        return ret;
    }

    public int reverse(int x) {
        int ret = 0;
        while (x != 0) {
            int pop = x % 10;
            ret += pop;
            x /= 10;
            if (x == 0){
                return ret;
            }
            if (ret > Integer.MAX_VALUE/10 || (ret == Integer.MAX_VALUE/10 && x >7)){
                return 0;
            }
            if (ret < Integer.MIN_VALUE/10 || (ret == Integer.MIN_VALUE/10 && x<-8)){
                return 0;
            }
            ret *= 10;
        }
        return ret;
    }
}
