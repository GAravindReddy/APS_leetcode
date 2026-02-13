class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;

        // Step 1: Check if there are k nodes
        while (curr != null && count < k) {
            curr = curr.next;
            count++;
        }

        // Step 2: Reverse k nodes if count == k
        if (count == k) {
            curr = reverseKGroup(curr, k);

            while (count-- > 0) {
                ListNode next = head.next;
                head.next = curr;
                curr = head;
                head = next;
            }
            head = curr;
        }

        return head;
    }
}
