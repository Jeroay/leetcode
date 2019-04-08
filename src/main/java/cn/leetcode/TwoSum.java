package cn.leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        int target = 9;

        int[] result = new TwoSum().twoSum(nums , target);
        System.out.println(Arrays.toString(result));
    }

    /**
     * 方法一：for循环嵌套
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums , int target){
        for(int i=0; i<nums.length; i++){
            for(int j = i+1; j<nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i , j};
                }
            }
        }
        return null;
    }

    /**
     * 方法二：使用基于哈希表的 map，提高检索效率
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums , int target){
        HashMap<Integer , Integer> map = new HashMap();
        for(int i = 0; i<nums.length; i++){
            map.put(nums[i],i);
        }
        for(int i = 0; i<nums.length; i++){
            int tmp = target - nums[i];
            if(map.containsKey(tmp) && map.get(map)!=i){
                return new int[]{i , map.get(tmp)};
            }
        }
        return null;
    }

}
