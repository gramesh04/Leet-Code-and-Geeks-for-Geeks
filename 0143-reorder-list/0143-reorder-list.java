class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        int size = stack.size();
        cur = head;
        for (int i = 0; i < size / 2; i++) {
            ListNode nextNode = cur.next;
            ListNode lastNode = stack.pop();
            
            cur.next = lastNode;
            lastNode.next = nextNode;
            cur = nextNode;
        }

        cur.next = null;
    }
}
