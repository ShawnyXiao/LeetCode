public class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];
        for (int k = 1; k < strs.length + 1; k++) {
            int[] zeroesOnes = calZeroesOnes(strs[k - 1]);
            for (int i = 0; i < m + 1; i++) {
                for (int j = 0; j < n + 1; j++) {
                    dp[k][i][j] = Math.max(dp[k - 1][i][j], ((i - zeroesOnes[0]) >= 0 && (j - zeroesOnes[1]) >= 0) ? (dp[k - 1][i - zeroesOnes[0]][j - zeroesOnes[1]] + 1) : 0);
                }
            }
        }
        return dp[strs.length][m][n];
    }

    private int[] calZeroesOnes(String bin) {
        int[] zeroesOnes = new int[2];
        for (int i = 0; i < bin.length(); i++) {
            char c = bin.charAt(i);
            if ('0' == c) {
                zeroesOnes[0]++;
                continue;
            }
            zeroesOnes[1]++;
        }
        return zeroesOnes;
    }
}