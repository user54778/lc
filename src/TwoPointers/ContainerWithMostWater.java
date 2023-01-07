package TwoPointers;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int res = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int width = right - left; // find the width of the container, distance between two pointers is right - left
            int area = width * Math.min(height[left], height[right]);   // height is min between both pointers
            res = Math.max(res, area);
            // move pointers based on height
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return res;
    }
}
