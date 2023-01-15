package dynamicprogramming;

import java.util.Arrays;

/**
 * You are given an integer array coins representing coins of different denominations
 * and an integer amount representing a total amount of money.
 *
 * Return the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * You may assume that you have an infinite number of each kind of coin.
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        // i can only think of a solution bottom up
        if (amount < 0 || coins.length == 0) {
            return 0;
        }

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);    // give each value a default value of the amount + 1
        dp[0] = 0;  // base case -> amount of 0 takes 0 coins

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                // for all coins available, get to i from i - coin as long as i >= 0
                if (i - coin >= 0) {
                    // add 1 to signal current coin
                    // i - coin is coins remaining from i as long as i - coin >= 0
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        if (dp[amount] != amount + 1) {
            return dp[amount];
        } else {
            return -1;
        }
    }
}
