class Solution {
    public int[] sortedSquares(int[] nums) {
        int n= nums.length;
        int left=0;
        int right= n-1;
        int result[]= new int[n];
        int index = n-1;
        while (left<=right){
            int left_square= nums[left]*nums[left];
            int right_square=nums[right]*nums[right];
            if (left_square > right_square){
                result[index]= left_square;
                left++;
            }else{
                result[index]= right_square;
                right--;
            }
            index--;
        }
        return result;
    }
}