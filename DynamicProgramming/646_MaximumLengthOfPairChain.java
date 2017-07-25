public class Solution {
    public int findLongestChain(int[][] pairs) {
        int length = pairs.length;
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return 1;
        }
        Arrays.sort(pairs, (p1, p2) -> p1[0] - p2[0]);
        int[] dp = new int[length];
        for (int i = 0; i < length; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1] && dp[i] < dp[j] + 1) {
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