class Solution {
    public int[] shuffle(int[] nums, int n) {
        for (int i=0; i<n; i++ ){
            nums[i+n] = (nums[i+n]<<10)| nums[i];
        }
        for(int i=0;i<n;i++) {
            nums[2*i] = nums[i+n]&1023;
            nums[2*i+1] = nums[i+n]>>10;
        }
        return nums;
    }
}