public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[] height = new int[matrix[0].length];
        int[] left = new int[matrix[0].length];
        int[] right = new int[matrix[0].length];
        Arrays.fill(right, matrix[0].length);
        int result = 0;
        for (int i = 0; i < matrix.length; i++) {
            int currentLeft = 0;
            int currentRight = matrix[0].length;
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    height[j]++;
                    continue;
                }
                height[j] = 0;
            }
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    left[j] = Math.max(currentLeft, left[j]);
                    continue;
                }
                left[j] = 0;
                currentLeft = j + 1;
            }
            for (int j = matrix[0].length - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(currentRight, right[j]);
                    continue;
                }
                right[j] = matrix[0].length;
                currentRight = j;
            }
            for (int j = 0; j < matrix[0].length; j++) {
                result = Math.max(result, (right[j] - left[j]) * height[j]);
            }
        }
        return result;
    }
}