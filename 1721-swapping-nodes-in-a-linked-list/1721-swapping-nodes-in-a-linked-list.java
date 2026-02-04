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
public class Solution {

    public ListNode swapNodes(ListNode head, int k) {
        List<Integer> arr = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            arr.add(cur.val);
            cur = cur.next;
        }
        int n = arr.size();
        int temp = arr.get(k - 1);
        arr.set(k - 1, arr.get(n - k));
        arr.set(n - k, temp);
        cur = head;
        int i = 0;
        while (cur != null) {
            cur.val = arr.get(i);
            cur = cur.next;
            i++;
        }
        return head;
    }
}
