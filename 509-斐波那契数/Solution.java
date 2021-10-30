public class Solution {
    public int fib(int n) {
        if (n < 1) {
            return 0;
        }
        if (n < 3) {
            return 1;
        }
        int p = 1;
        int q = 1;
        int r = p + q;
        for (int i = 3; i < n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
