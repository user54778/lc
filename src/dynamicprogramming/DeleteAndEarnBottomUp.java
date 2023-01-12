package dynamicprogramming;

import java.util.HashMap;

public class DeleteAndEarnBottomUp {
    public int deleteAndEarn(int[] nums) {
        HashMap<Integer, Integer> points = new HashMap<>(); // compute points per element
        int maxNum = 0;

        // precompute all points for each element in our nums array
        for (int n : nums) {
            points.put(n, points.getOrDefault(n, 0) + n);
            maxNum = Math.max(maxNum, n);
        }

        int[] maxPoints = new int[maxNum + 1]; // store max points to gain
        maxPoints[1] = points.getOrDefault(1, 0);   // base case

        for (int i = 2; i < maxPoints.length; i++) {
            int gain = points.getOrDefault(i, 0);   // gain
            maxPoints[i] = Math.max(maxPoints[i - 1], maxPoints[i - 2] + gain);
        }

        return maxPoints[maxNum];
    }
}
