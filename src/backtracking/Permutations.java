package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> permutation = new ArrayList<>();
        backtrack(result, permutation, nums);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> permutation, int[] nums) {
        // base case -> reach end of array
        if (permutation.size() >= nums.length) {
            result.add(new ArrayList<>(permutation));
            return;
        } else {
            // traverse through input array
            for (int num : nums) {
                // secondary case where permutation already contains the number
                if (permutation.contains(num)) {
                    continue;
                } else {
                    /*
                     * This will add a permutation to our inner list per value, i.e.,
                     * 1 will have [1, 2, 3], AND [1, 3, 2], since in a permutation, order MATTERS.
                     */
                    permutation.add(num);   // add our index to the permutation
                    backtrack(result, permutation, nums);   // backtrack to the root of the first value and go down the other path of the state space tree
                    permutation.remove(permutation.size() - 1); // backtrack to the starting value of the permutation until no more permutations for that starting value
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3};
        System.out.println(permute(nums));
    }
}
