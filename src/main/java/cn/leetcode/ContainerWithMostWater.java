package cn.leetcode;

/**
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 *
 * Note: You may not slant the container and n is at least 2.
 *
 * Example:
 * Input: [1,8,6,2,5,4,8,3,7]     Output: 49
 */
public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] ints = {1,8,6,2,5,4,8,3,7};
        System.out.println(new ContainerWithMostWater().maxArea(ints));

    }

    public int maxArea(int[] height) {
        int result = 0;
        int tmp = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                tmp = Math.abs(i - j) * Math.min(height[i], height[j]);
                result = Math.max(result , tmp);
            }
        }
        return result;
    }
}
