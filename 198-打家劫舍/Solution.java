public class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return nums[1] > nums[0] ? nums[1] : nums[0];
        }
        int a = 0;
        int b = 0;
        int r = a + nums[0] > b ? a + nums[0] : b;
        for (int i = 2; i <= n; i++) {
            a = b;
            b = r;
            r = a + nums[i - 1] > b ? a + nums[i - 1] : b;
        }
        return r;
    }
}
