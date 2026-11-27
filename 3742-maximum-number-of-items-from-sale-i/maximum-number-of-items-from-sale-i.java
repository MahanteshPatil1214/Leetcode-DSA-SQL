class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int minPrice = Integer.MAX_VALUE;
        for (int[] item : items) {
            minPrice = Math.min(minPrice, item[1]);
        }

        // Calculate total copies gained from buying the FIRST copy of item i
        int[] gains = new int[n];
        for (int i = 0; i < n; i++) {
            int freeCopies = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && items[j][0] % items[i][0] == 0) {
                    freeCopies++;
                }
            }
            gains[i] = 1 + freeCopies;
        }

        // 0/1 Knapsack DP for buying at most 1 initial copy of each item
        int[] dp = new int[budget + 1];
        for (int i = 0; i < n; i++) {
            int price = items[i][1];
            int gain = gains[i];
            for (int b = budget; b >= price; b--) {
                dp[b] = Math.max(dp[b], dp[b - price] + gain);
            }
        }

        // Spend any leftover budget on the cheapest item (+1 copy per minPrice)
        int ans = 0;
        for (int b = 0; b <= budget; b++) {
            int extraCopies = (budget - b) / minPrice;
            ans = Math.max(ans, dp[b] + extraCopies);
        }

        return ans;
    }
}
