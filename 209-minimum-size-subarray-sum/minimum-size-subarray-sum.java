class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l=0;
        int minlen=Integer.MAX_VALUE;
        int currSum=0;
        for(int r=0;r<nums.length;r++){
            currSum +=nums[r];
            while(currSum >= target){
            minlen = Math.min(minlen,r-l+1);
            currSum -=nums[l];
            l++;
        }
        }

        return minlen==Integer.MAX_VALUE ? 0 : minlen;
    }
}