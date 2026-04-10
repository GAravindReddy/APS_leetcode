class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] counts = new int[n];
        int[] indexes = new int[n];
        
        for (int i = 0; i < n; i++) indexes[i] = i;
        
        mergeSort(nums, indexes, counts, 0, n - 1);
        
        List<Integer> result = new ArrayList<>();
        for (int c : counts) result.add(c);
        return result;
    }
    
    private void mergeSort(int[] nums, int[] indexes, int[] counts, int left, int right) {
        if (left >= right) return;
        
        int mid = (left + right) / 2;
        mergeSort(nums, indexes, counts, left, mid);
        mergeSort(nums, indexes, counts, mid + 1, right);
        merge(nums, indexes, counts, left, mid, right);
    }
    
    private void merge(int[] nums, int[] indexes, int[] counts, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        int rightCount = 0;
        
        while (i <= mid && j <= right) {
            if (nums[indexes[j]] < nums[indexes[i]]) {
                temp[k++] = indexes[j++];
                rightCount++;
            } else {
                counts[indexes[i]] += rightCount;
                temp[k++] = indexes[i++];
            }
        }
        
        while (i <= mid) {
            counts[indexes[i]] += rightCount;
            temp[k++] = indexes[i++];
        }
        
        while (j <= right) {
            temp[k++] = indexes[j++];
        }
        
        for (int p = 0; p < temp.length; p++) {
            indexes[left + p] = temp[p];
        }
    }
}