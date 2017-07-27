public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length < 2) {
            return nums.length;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int state = 0;
        for (int i = 1; i < nums.length; i++) {
            if (state == 0 && nums[i] - nums[i - 1] != 0 || state != 0 && (nums[i] - nums[i - 1]) * state < 0) {
                dp[i] = dp[i - 1] + 1;
                state = nums[i] - nums[i - 1];
                continue;
            }
            dp[i] = dp[i - 1];
        }
        return dp[nums.length - 1];
    }
}