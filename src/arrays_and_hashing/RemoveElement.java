package arrays_and_hashing;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        int right = nums.length - 1;

        // want to change mid index
        while (k <= right) {
            if (nums[k] == val) {
                swap(nums, k, right);
                right--;
            } else {
                k++;
            }
        }
        return k;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        RemoveElement removeElement = new RemoveElement();
        System.out.println(removeElement.removeElement(new int[] {3, 2, 2, 3}, 3));
    }
}
