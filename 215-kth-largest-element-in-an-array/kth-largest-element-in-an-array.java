import java.util.PriorityQueue;

public class Solution {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums){
            minHeap.add(num);
            // Keep only the top k largest elements in the heap
            if (minHeap.size() > k) {
                minHeap.poll(); // Removes the smallest element
            }
        }

        // The root of the min-heap is the kth largest element
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(findKthLargest(nums, k)); // Output: 5
    }
}
