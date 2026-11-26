class Solution {
    public boolean canAliceWin(int n) {
        boolean aliceTurn = true;
        for (int stones = 10; stones > 0; stones--) {
            if (n < stones) {
                return !aliceTurn;
            }
            n -= stones;
            aliceTurn = !aliceTurn;
        }
        return false;
    }
}
