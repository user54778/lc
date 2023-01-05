package arrays_and_hashing;

import java.util.HashMap;

/**
 * Given an array of integers nums and an integer target, return indices of
 * the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution,
 * and you may not use the same element twice.
 *
 * You can return the answer in any order.
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> sum = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int sub = nums[i];          // grab from array
            int secNum = target - sub;  // subtract the target number from our curr num
            // the number left will be in the array SOMEWHERE, since there HAS TO BE ONE SOLUTION

            if (sum.containsKey(secNum)) {  // if our hashmap contains the OTHER number
                return new int[] { sum.get(secNum), i};     // return its indices and the sub index
            } else {
                sum.put(sub, i);    // otherwise, put our current num in the hashmap
            }
        }

        return new int[] {};
    }
}
