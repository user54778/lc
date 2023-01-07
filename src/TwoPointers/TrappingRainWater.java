package TwoPointers;

public class TrappingRainWater {

    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        int trappedRainWater = 0;

        while (left < right) {
            // case where leftmax < rightmax
            if (leftMax < rightMax) {
                /*
                 * Don't need to check for neg since we already updated max left value before calculating
                 * trapped rain water.
                 */
                left++; // increment left's pointer
                leftMax = Math.max(leftMax, height[left]);  // check for new left max
                trappedRainWater += leftMax - height[left]; // amount of water that can be trapped at
                // curr position
            } else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                trappedRainWater += rightMax - height[right];
            }
        }

        return trappedRainWater;
    }

    public int trapLinear(int[] height) {
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        int maxHeight = height[0];
        int rainWater = 0;

        // find the max left value for each position
        for (int i = 0; i < height.length; i++) {
            maxLeft[i] = Math.max(height[i], maxHeight);
            maxHeight = maxLeft[i];
        }

        maxHeight = height[height.length - 1];  // reset maxHeight's value
        // find max right value for each position
        for (int i = height.length - 1; i >= 0; i--) {
            maxRight[i] = Math.max(height[i], maxHeight);
            maxHeight = maxRight[i];
        }

        // calculate the minimum of the maxLeft and maxRight to help calculate water we can trap
        for (int i = 0; i < height.length; i++) {
            // min(L, R) - h[i]
            rainWater = rainWater + Math.min(maxLeft[i], maxRight[i]) - height[i];
        }

        return rainWater;
    }
}
