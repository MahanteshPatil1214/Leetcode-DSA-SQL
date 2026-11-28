import java.util.*;

class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] freq = new int[n + 1];
        long mn = Long.MAX_VALUE;
        for (int[] it : items) {
            freq[it[0]]++;
            mn = Math.min(mn, it[1]);
        }

        // mult[v] = number of items whose factor is a multiple of v
        int[] mult = new int[n + 1];
        for (int v = 1; v <= n; v++)
            for (int k = v; k <= n; k += v)
                mult[v] += freq[k];

        // groups of "double" units: {price, count}
        List<long[]> g = new ArrayList<>();
        for (int[] it : items) {
            long cnt = mult[it[0]] - 1;
            if (cnt > 0 && it[1] <= 2 * mn) g.add(new long[]{it[1], cnt});
        }
        g.sort((a, b) -> Long.compare(a[0], b[0]));

        long B = budget;

        // largest affordable number of doubles (cheapest first)
        long rem = B, d = 0;
        for (long[] x : g) {
            long t = Math.min(x[1], rem / x[0]);
            d += t;
            rem -= t * x[0];
            if (t < x[1]) break;
        }

        long best = 0;
        for (long dd = d; dd >= Math.max(0, d - 3); dd--) {
            long left = dd, cost = 0;
            for (long[] x : g) {
                if (left == 0) break;
                long t = Math.min(left, x[1]);
                cost += t * x[0];
                left -= t;
            }
            best = Math.max(best, 2 * dd + (B - cost) / mn);
        }
        return (int) best;
    }
}