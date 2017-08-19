class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap();
        m.put(0, -1);
        int modeSum = 0;
        for (int i = 0; i < nums.length; i++) {
            modeSum += nums[i];
            if (k != 0) {
                modeSum %= k;
            }
            Integer index = m.get(modeSum);
            if (index != null) {
                if (i - index > 1) {
                    return true;
                }
            } else {
                m.put(modeSum, i);
            }
        }
        return false;
    }
}