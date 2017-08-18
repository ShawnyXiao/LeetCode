class Solution {
    public int integerBreak(int n) {
        if (2 == n) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                if (dp[i] < j * Math.max(dp[i - j], i - j)) {
                    dp[i] = j * Math.max(dp[i - j], i - j);
                }
            }
        }
        return dp[n];
    }
}