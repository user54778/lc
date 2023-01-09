package backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        backtrack(candidates, target, 0, 0, result, curr);
        return result;
    }

    private void backtrack(int[] candidates, int target, int total, int index,
                           List<List<Integer>> result, List<Integer> curr) {
        // decision succeeds
        if (target == total) {
            result.add(new ArrayList<>(curr));  // add our current sum
            return;
        }

        // base case with invalid combinations
        if (index >= candidates.length || total > target) {
            return;
        } else {    // backtrack
            curr.add(candidates[index]);    // add candidate to our candidate list
            /*
             * Index stays the same since we don't want to restrict
             * which candidate to choose from here.
             * We subtract target - candidates[index] to find the result of all combinations
             * that sum to the given target
             */
            backtrack(candidates, target - candidates[index], total, index, result, curr);

            // decision to not include candidate[index], so we DO want to increment index
            curr.remove(curr.size() - 1);
            backtrack(candidates, target, total, index + 1, result, curr);
        }
    }
}
