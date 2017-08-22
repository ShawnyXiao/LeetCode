class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String longestPalindrome = "";
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    dp[i][j] = true;
                } else {
                    if (i + 1 <= j - 1) {
                        dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
                    } else {
                        dp[i][j] = s.charAt(i) == s.charAt(j);
                    }
                }
                if (dp[i][j] && j - i >= longestPalindrome.length()) {
                    longestPalindrome = s.substring(i, j + 1);
                }
            }
        }
        return longestPalindrome;
    }
}