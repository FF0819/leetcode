public class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if (n == 1) {
            return cost[0];
        }
        if (n == 2) {
            return cost[0] < cost[1] ? cost[0] : cost[1];
        }
        int a = 0;
        int b = 0;
        int r = a + cost[0] < b + cost[1] ? a + cost[0] : b + cost[1];
        for (int i = 3; i <= n; i++) {
            a = b;
            b = r;
            r = a + cost[i - 2] < b + cost[i - 1] ? a + cost[i - 2] : b + cost[i - 1];
        }
        return r;
    }
}
