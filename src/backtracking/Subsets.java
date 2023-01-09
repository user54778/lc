package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

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
}
