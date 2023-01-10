package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    /**
     * Time: O(N * 2^N), to generate all subsets and copy them
     * Space: O(N) We modify our subset list in place, so we don't repeatedly copy and take
     * @param nums input array
     * @return list of all possible subsets from the given input array
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(res, 0, nums, list);
        return res;
    }


    /**
     * Helper method that utilizes backtracking based on the decision to include or exclude the
     * element from the subset
     * @param res resultant list to return in our main method
     * @param decision decision index
     * @param nums input array
     * @param subset subset of our resultant list
     */
    private void backtrack(List<List<Integer>> res, int decision, int[] nums, List<Integer> subset) {
        // base case where we reach end of our input array
        if (decision >= nums.length) {
            res.add(new ArrayList<>(subset));   // also add a copy of subset to the resultant list
            return;
        } else {
            // decision to include nums[i]
            subset.add(nums[decision]); // different subset than the not include decision
            backtrack(res, decision + 1, nums, subset);

            // decision to NOT include nums[i]
            subset.remove(subset.size() - 1); // empty subset given to it
            backtrack(res, decision + 1, nums, subset);
        }
    }

    // Time: O(N * 2^N), to generate all subsets and copy them
    // Space O(N) We modify our subset list in place, so we don't repeatedly copy and take
    // up unneccessary space
    /*
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> powerSet = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        backtrack(powerSet, subset, nums, 0);
        return powerSet;
    }

    private void backtrack(List<List<Integer>> powerSet, List<Integer> subset, int[] nums, int start) {
        // don't need extra checks before loop since it will just end if we reach the end of the array
        powerSet.add(new ArrayList<>(subset));
        // iterate over all possible length of subsets
        for (int i = start; i < nums.length; i++) {
            // no extra if conditions: we simply either add the element to our subset or don't
            subset.add(nums[i]);    // add current element to the subset
            backtrack(powerSet, subset, nums, i + 1);   // add more elements to the subset
            subset.remove(subset.size() - 1);   // backtrack by removing the most recently add element
        }
    }

     */
}
