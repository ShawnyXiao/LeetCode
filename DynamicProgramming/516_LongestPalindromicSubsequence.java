public class Solution {
    public int longestPalindromeSubseq(String s) {
        int length = s.length();
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = 1;
        }
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                    continue;
                }
                dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
            }
        }
        return dp[0][length - 1];
    }
}