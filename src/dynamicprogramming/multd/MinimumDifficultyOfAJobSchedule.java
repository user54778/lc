package dynamicprogramming.multd;

import java.util.Arrays;

/**
 * You want to schedule a list of jobs in d days. Jobs are dependent (i.e To work on the ith job,
 * you have to finish all the jobs j where 0 <= j < i).
 *
 * You have to finish at least one task every day. The difficulty of a job schedule is the sum
 * of difficulties of each day of the d days.
 * The difficulty of a day is the maximum difficulty of a job done on that day.
 *
 * You are given an integer array jobDifficulty and an integer d.
 * The difficulty of the ith job is jobDifficulty[i].
 *
 * Return the minimum difficulty of a job schedule.
 * If you cannot find a schedule for the jobs return -1.
 */
public class MinimumDifficultyOfAJobSchedule {
    /**
     * Time Complexity: visit d * (n - d) states, each state iterates n - d / 2 times. O(d * (n - d)^2)
     * Space Complexity: O((n - d) * d)
     * @param jobDifficulty job difficulty
     * @param d days
     * @return minimum difficulty of job schedule; -1 if no schedule is possible
     */
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (n < d) {
            return -1;  // impossible to create schedule
        }

        // return max job diff between job i and end of array
        int[] hardestJobRemaining = new int[n];
        int hardestJob = 0;
        for (int i = n - 1; i >= 0; i--) {
            hardestJob = Math.max(hardestJob, jobDifficulty[i]);
            hardestJobRemaining[i] = hardestJob;
        }

        // initialize our cache to have values of -1 to represent no schedule
        int[][] cache = new int[n][d + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(cache[i], -1);
        }

        // start TOP LEFT of our 2d dp array
        return dp(0, 1, hardestJobRemaining, cache, jobDifficulty, d);
    }


    /**
     * At each state, we are on day currentDay, and need to do job i. Then, we choose to do
     * d - day jobs, so ALL future days have AT LEAST one job that can be scheduled on that day.
     * @param i job
     * @param currentDay current day we are on
     * @param hardestJobRemaining precalculated hardest difficulty job remaining per element in jobdifficulty
     * @param cache cache for our two states
     * @param jobDifficulty job difficulty
     * @param d days for each job
     * @return minimum difficulty of a given job schedule
     */
    private int dp(int i, int currentDay, int[] hardestJobRemaining, int[][] cache, int[] jobDifficulty, int d) {
        // base case -> last day, finish all remaining jobs
        if (currentDay == d) {
            return hardestJobRemaining[i];
        }

        // haven't computed job schedule current day
        if (cache[i][currentDay] == -1) {
            int hardestJobCurrDay = 0;      // nothing found yet
            int best = Integer.MAX_VALUE;   //
            for (int j = i; j < jobDifficulty.length - (d - currentDay); j++) {
                hardestJobCurrDay = Math.max(hardestJobCurrDay, jobDifficulty[j]);

                // begin our recurrence relation
                best = Math.min(best, hardestJobCurrDay + dp(j + 1, currentDay + 1,
                        hardestJobRemaining, cache, jobDifficulty, d));
            }
            cache[i][currentDay] = best;
        }

        return cache[i][currentDay];
    }
}
