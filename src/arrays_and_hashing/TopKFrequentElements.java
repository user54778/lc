package arrays_and_hashing;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given an integer array nums and an integer k, return the k most frequent elements.
 * You may return the answer in any order.
 */
public class TopKFrequentElements {
    /**
     * First solution.
     * Uses a Max-heap to pop k elements so is only O(klogn).
     * @param nums array of elements
     * @param k most frequent elements
     * @return k most frequent elements in array
     */
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[k];

        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1); // count occurrences of each value
        }

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>
                (Comparator.comparingInt(Map.Entry::getValue));   // create a new maxHeap

        /*
         * For each entry in our hashmap, add the occurrences to our maxheap
         */
        for (Map.Entry<Integer, Integer> in : map.entrySet()) {
            maxHeap.add(in);
            if (maxHeap.size() > k) {
                maxHeap.poll(); // pop and return element from top of maxheap
            }
        }

        /*
         * Store k most frequent elements in our result array
         */
        while (!maxHeap.isEmpty()) {
            res[--k] = maxHeap.poll().getKey();
        }

        return res;
    }
}
