public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        int half = sum / 2;
        boolean[][] dp = new boolean[nums.length + 1][half + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i < nums.length + 1; i++) {
            for (int j = 1; j < half + 1; j++) {
                dp[i][j] = dp[i - 1][j] || (((j - nums[i - 1]) >= 0) && dp[i - 1][j - nums[i - 1]]);
            }
        }
        return dp[nums.length][half];
    }
}