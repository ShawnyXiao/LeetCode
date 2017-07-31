public class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        Stack<Integer> dp = new Stack();
        int result = 0;
        int i = 0;
        while (i < heights.length) {
            if (dp.empty() || heights[dp.peek()] <= heights[i]) {
                dp.push(i++);
                continue;
            }
            int top = dp.peek();
            dp.pop();
            result = Math.max(result, heights[top] * (dp.empty() ? i : (i - dp.peek() - 1)));
        }
        while (!dp.empty()) {
            int top = dp.peek();
            dp.pop();
            result = Math.max(result, heights[top] * (dp.empty() ? i : (i - dp.peek() - 1)));
        }
        return result;
    }
}