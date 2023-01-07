package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);  // sort input array to help with duplicates
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;   // don't reuse the same value twice
            }

            // two pointer solution to solve 2 Sum for remaining array
            int low = i + 1;
            int high = nums.length - 1;
            int target = 0;
            while (low < high) {
                target = nums[i] + nums[low] + nums[high]; // target value 0

                if (target > 0) {
                    high--;
                } else if (target < 0) {
                    low++;
                } else {
                    res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    low++;  // shift left pointer to avoid same sum
                    while (nums[low] == nums[low - 1] && low < high) {
                        low++;  // keep shifting left pointer to avoid same value
                    }
                }
            }
        }

        return res;
    }
}
