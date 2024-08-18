package org.example.leetcode;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // nums = 4 , 5 , 6 , 7   target = 11
        int a = 0, b = 0;
        int sum = 0;
        int[] output = new int[2];
        for (int i = 0; i < nums.length; i++) {
            a = nums[i];
            boolean found = false;
            for (int j = 1; j < nums.length; j++) {
                b = nums[j];
                sum = a + b;
                if (sum == target && (i != j)) {
                    output[0] = i;
                    output[1] = j;
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }
        return output;
    }

    public int[] twoSumSecondApproach(int[] nums, int target) {
        // nums = 4 , 5 , 6 , 7   target = 11
        for (int i = 0; i < nums.length; i++) {
            Map<Integer, Integer> map = new HashMap<>();

            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two Sum Solution");
    }

}

public class SumOfTwo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = new int[]{2, 5, 5, 11};
        System.out.println(Arrays.toString(solution.twoSum(array, 10)));
    }
}
