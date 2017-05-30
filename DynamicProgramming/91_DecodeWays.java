public class Solution {
    public static int numDecodings(String s) {
        if (s.isEmpty() || '0' == s.charAt(0)) {
            return 0;
        }
        char[] c = s.toCharArray();
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < s.length() + 1; i++) {
            int combinationNumber = Integer.parseInt("" + c[i - 2] + c[i - 1]);
            if ('0' == c[i - 1] && (10 != combinationNumber || 20 != combinationNumber)) {
                return 0;
            }
            if (10 == combinationNumber) {
                dp[i] = dp[i - 2];
            } else if (combinationNumber > 10 && combinationNumber <= 26) {
                dp[i] = dp[i - 2] + dp[i - 1];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[s.length()];
    }
}