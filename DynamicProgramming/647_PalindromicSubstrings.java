class Solution {
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    dp[i][j] = true;
                    count++;
                    continue;
                }
                if (i + 1 <= j - 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
                } else {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                }
                if (dp[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }
}