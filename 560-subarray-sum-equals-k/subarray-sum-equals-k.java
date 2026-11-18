class Solution {
    public int subarraySum(int[] nums, int k) {
    Map<Integer,Integer> map = new HashMap<>();
    int count=0;
    int currSum=0;
    map.put(0,1);
    for(int num:nums){
        currSum+=num;
        int target=currSum-k;
        if(map.containsKey(target)){
            count+=map.get(target);
        }
        map.put(currSum,map.getOrDefault(currSum,0)+1);
    }
    return count;
    }
}