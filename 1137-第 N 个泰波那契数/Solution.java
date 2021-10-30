public class Solution {
    public int tribonacci(int n) {
        if (n < 1) {
            return 0;
        } else if (n < 3) {
            return 1;
        }
        int a = 0, b = 1, c = 1;
        int d = a + b + c;
        for (int i = 3; i < n; i++) {
            a = b;
            b = c;
            c = d;
            d = a + b + c;
        }
        return d;
    }
}
