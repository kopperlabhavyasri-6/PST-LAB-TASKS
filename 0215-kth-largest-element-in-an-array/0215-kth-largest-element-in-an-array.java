import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        // 1. Create a min-heap to store the k largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        // 2. Iterate through every number in the array
        for (int num : nums) {
            minHeap.add(num);
            
            // If the heap size exceeds k, remove the smallest element
            // This ensures the heap only keeps the k largest elements seen so far
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        // 3. The root of the min-heap is now the kth largest element
        return minHeap.peek();
    }
}