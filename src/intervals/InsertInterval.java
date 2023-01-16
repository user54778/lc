package intervals;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();

        for (int[] interval : intervals) {
            // no overlap
            if (interval[1] < newInterval[0]) {
                ans.add(interval);
            } else if (interval[0] > newInterval[1]) {  // no overlap
                ans.add(newInterval);
                ans.add(interval);
            } else {
                // overlap, take min value for ascending order
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
        }

        ans.add(newInterval);
        return ans.toArray(new int[ans.size()][]);
    }
}
