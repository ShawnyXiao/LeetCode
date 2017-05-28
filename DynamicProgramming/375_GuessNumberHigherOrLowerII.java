public class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 2][n + 2];
        for (int j = 1; j < n + 1; j++) {
            for (int i = j - 1; i > 0; i--) {
                int globalMin = Integer.MAX_VALUE;
                for (int k = i; k < j + 1; k++) {
                    int localMax = Math.max(k + dp[i][k - 1], k + dp[k + 1][j]);
                    globalMin = Math.min(globalMin, localMax);
                }
                dp[i][j] = globalMin;
            }
        }
        return dp[1][n];
    }
}