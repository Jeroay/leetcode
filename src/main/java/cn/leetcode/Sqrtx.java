package cn.leetcode;

/**
 * Implement int sqrt(int x).
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
 */
public class Sqrtx {

    public static void main(String[] args) {
        int target = 8;
        int result = new Sqrtx().mySqrt(target);
        System.out.println(result);
    }

    public int mySqrt(int x) {
        return (int)Math.sqrt(x);
    }
}
