public class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int[][] dp = new int[2][nums.length];
        dp[0][0] = nums[0];
        dp[1][0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[0][i] = Math.max(Math.max(dp[0][i - 1] * nums[i], dp[1][i - 1] * nums[i]), nums[i]);
            dp[1][i] = Math.min(Math.min(dp[0][i - 1] * nums[i], dp[1][i - 1] * nums[i]), nums[i]);
            max = Math.max(dp[0][i], max);
        }
        return max;
    }
}