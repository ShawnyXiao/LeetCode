public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        int[] dp = new int[length];
        for (int i = 0; i < length; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        int result = 1;
        for (int i = 0; i < length; i++) {
            if (result < dp[i]) {
                result = dp[i];
            }
        }
        return result;
    }
}