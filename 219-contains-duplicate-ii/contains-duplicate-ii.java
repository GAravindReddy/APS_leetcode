class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> window = new HashSet<>();
        int l =0;
        for(int r= 0; r < nums.length; r++) {
            if (r-l > k){
                window.remove(nums [l]);
                l++;
            }
            if (window.contains(nums[r])){
                return true;
            }
            window.add(nums[r]);
            }
        return false;
    }
}