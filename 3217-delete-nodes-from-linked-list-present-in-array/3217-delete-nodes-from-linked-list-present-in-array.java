/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> forbiddenValues = new HashSet<>();
        for (int num : nums) {
            forbiddenValues.add(num);
        }
        ListNode anchor = new ListNode(0, head);
        ListNode current = anchor;
        while (current.next != null) {
            if (forbiddenValues.contains(current.next.val)) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return anchor.next;
    }
}
