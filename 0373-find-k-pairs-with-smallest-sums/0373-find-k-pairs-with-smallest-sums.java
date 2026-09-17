import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Arrays;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 || k <= 0) {
            return result;
        }
        
        // Min-heap to store: [sum, index_in_nums1, index_in_nums2]
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        
        // 1. Initialize the heap with pairs formed by each element in nums1 and the first element of nums2
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            minHeap.add(new int[]{nums1[i] + nums2[0], i, 0});
        }
        
        // 2. Extract the k smallest pairs
        while (k > 0 && !minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int i = curr[1];
            int j = curr[2];
            
            result.add(Arrays.asList(nums1[i], nums2[j]));
            
            // 3. If there is a next element in nums2 for the current nums1[i], push it into the heap
            if (j + 1 < nums2.length) {
                minHeap.add(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
            }
            
            k--;
        }
        
        return result;
    }
}