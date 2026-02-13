import java.util.*;

class Solution {
    public int longestSubarray(int[] nums, int limit) {

        Deque<Integer> maxD = new ArrayDeque<>();
        Deque<Integer> minD = new ArrayDeque<>();

        int left = 0, result = 0;

        for (int right = 0; right < nums.length; right++) {

            // Maintain max deque (decreasing)
            while (!maxD.isEmpty() && nums[maxD.peekLast()] < nums[right]) {
                maxD.pollLast();
            }
            maxD.offerLast(right);

            // Maintain min deque (increasing)
            while (!minD.isEmpty() && nums[minD.peekLast()] > nums[right]) {
                minD.pollLast();
            }
            minD.offerLast(right);

            // Shrink window if condition breaks
            while (nums[maxD.peekFirst()] - nums[minD.peekFirst()] > limit) {
                left++;

                if (maxD.peekFirst() < left) maxD.pollFirst();
                if (minD.peekFirst() < left) minD.pollFirst();
            }

            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}
