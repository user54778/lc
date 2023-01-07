package arrays_and_hashing;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    /**
     * Idea is to create 3 arrays:
     * Prefix, postfix, and output array.
     * Prefix calculates the product prior, and postfix calculates the product after.
     * Output array is just prefix * postfix value,
     * This solution is O(N) time and O(N) memory.
     * @param nums input array
     * @return product of the array except itself
     */
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        // calculate prefix values
        left[0] = 1;    // nothing can be to the left of the beginning of the array
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];    // product is left value * previous array value
        }

        // calculate postfix values
        right[nums.length - 1] = 1; // nothing can be to the right of the end of the array
        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        int[] output = new int[nums.length];
        for (int i = 0; i < output.length; i++) {
            output[i] = left[i] * right[i];
        }

        return output;
    }

    // O(N) Time O(1) Space solution
    public int[] productExceptSelf2(int[] nums) {
        int[] output = new int[nums.length];    // problem states output array does NOT count as extra space

        Arrays.fill(output, 1);

        // prefix
        int left = 1;
        for (int i = 0; i < nums.length; i++) {
            output[i] *= left;
            left *= nums[i];
        }

        // postfix
        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            output[i] *= right;
            right *= nums[i];
        }
        return output;
    }
}
