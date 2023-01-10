package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> powerSet = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(nums);  // sort input array to help deal with duplicate inputs
        backtrack(powerSet, subset, nums, 0);
        return powerSet;
    }

    private void backtrack(List<List<Integer>> powerSet, List<Integer> subset, int[] nums, int start) {
        // add subset to the powerset
        powerSet.add(new ArrayList<>(subset));  // make a deep copy of the subset since it will be overwritten
        for (int i = start; i < nums.length; i++) {
            // check if we have a duplicate before continuing
            if (i > start && nums[i] == nums[i - 1]) {
                continue;   // duplicate
            }
            subset.add(nums[i]);
            backtrack(powerSet, subset, nums, i + 1);   // all subsets not including nums[i]
            subset.remove(subset.size() - 1);   // backtrack
        }
    }
}
