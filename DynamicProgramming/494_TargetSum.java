public class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum < S || (S + sum) % 2 != 0) {
            return 0;
        }
        int p = (S + sum) / 2;
        int[][] dp = new int[nums.length + 1][p + 1];
        for (int i = 0; i < nums.length + 1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < nums.length + 1; i++) {
            for (int j = 0; j < p + 1; j++) {
                dp[i][j] = dp[i - 1][j] + ((j - nums[i - 1]) >= 0 ? dp[i - 1][j - nums[i - 1]] : 0);
            }
        }
        return dp[nums.length][p];
    }
}