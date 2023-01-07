package TwoPointers;

public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length - 1;

        int numOne = 0;
        int numTwo = 0;

        // perform binary search on our array
        while (low < high) {
            numOne = numbers[low];
            numTwo = numbers[high];

            if (numOne + numTwo == target) {
                break;
            } else if (numOne + numTwo < target) {
                low++;
            } else {
                high--;
            }
        }

        return new int[] { low + 1, high + 1 };
    }
}
