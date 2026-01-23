class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode start = list1;
        for (int i = 0; i < a - 1; i++) {
            start = start.next;
        }
        
        ListNode end = start;
        for (int i = 0; i <= (b - a + 1); i++) {
            end = end.next;
        }
        
        start.next = list2;
        
        ListNode tail2 = list2;
        while (tail2.next != null) {
            tail2 = tail2.next;
        }
        
        tail2.next = end;
        
        return list1;
    }
}
