public class Solution {
    public int climbStairs(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        int p = 1;
        int q = 2;
        int r = p + q;
        for (int i = 3; i < n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
