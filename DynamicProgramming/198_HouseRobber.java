public class Solution {
    public int rob(int[] nums) {
        if (0 == nums.length) {
            return 0;
        }
        if (1 == nums.length) {
            return nums[0];
        }
        if (2 == nums.length) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }
}