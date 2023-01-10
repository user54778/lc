package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> uniquePermutation = new ArrayList<>();
        boolean[] seen = new boolean[nums.length];
        Arrays.sort(nums);  // sort the input array to more easily deal with duplicates before entering our
        // backtrack method
        backtrack(result, uniquePermutation, nums, seen);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> uniquePermutation, int[] nums, boolean[] seen) {
        // base case -> no more permutations to add to list
        if (uniquePermutation.size() == nums.length) {
            result.add(new ArrayList<>(uniquePermutation)); // create a deep copy since it will be written over
            return;
        } else {
            // loop over input array and check for permutations
            for (int i = 0; i < nums.length; i++) {
                // check duplicates
                if (seen[i] || i > 0 && nums[i] == nums[i - 1] && !seen[i - 1]) {
                    continue;
                } else {
                    seen[i] = true;
                    uniquePermutation.add(nums[i]);             // add element to our permutation
                    backtrack(result, uniquePermutation, nums, seen); // recursively add elements to permutation of given element
                    seen[i] = false;
                    uniquePermutation.remove(uniquePermutation.size() - 1); // backtrack at end of permutation
                }
            }
        }

    }
}
