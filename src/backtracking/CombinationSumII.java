package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> uniqueC = new ArrayList<>();
        Arrays.sort(candidates);  // sort input array
        backtrack(candidates, target, answer, uniqueC, 0, 0);
        return answer;
    }

    private void backtrack(int[] candidates, int target, List<List<Integer>> ans, List<Integer> uniqueC,
                           int total, int index) {
        // base case where total is equal to target
        if (total == target) {
            ans.add(new ArrayList<>(uniqueC));   // add set of numbers adding to target
        } else {
            for (int i = index; i < candidates.length; i++) {
                if (i > index && candidates[i] == candidates[i - 1]) continue; // duplicate
                else if (total > target){
                    return; // TLE if we don't check this case
                } else {
                    uniqueC.add(candidates[i]);
                    /*
                     * Find the result of all combinations that sum to target (target - candidates[i])
                     * without duplicates, (Hence, i + 1).
                     */
                    backtrack(candidates, target - candidates[i], ans, uniqueC, total, i + 1);
                    uniqueC.remove(uniqueC.size() - 1); // backtrack
                }
            }
        }
    }
}
