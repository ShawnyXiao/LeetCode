public class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length < 3) {
            return 0;
        }
        int result = 0;
        int length = 2;
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] != A[i - 1] - A[i - 2]) {
                result += calculate(length);
                length = 2;
                continue;
            }
            length++;
        }
        if (length > 2) {
            result += calculate(length);
        }
        return result;
    }
    public int calculate(int n) {
        return (n - 1) * (n - 2) / 2;
    }
}