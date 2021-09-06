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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length < 1) {
            return null;
        } else if (lists.length == 1) {
            
            return lists[0];
        } else if (lists.length == 2) {
            
            return merge2List (lists[0], lists[1]);
        } else {
            lists = mergeKListsRec (lists);
            
            return lists[0];
        }
    }
    
    
    public ListNode[] mergeKListsRec (ListNode[] lists) {
        if (lists.length == 1 ) {
            return lists;
        }
        int quotient = lists.length/2;
        int remainder = lists.length%2;
        
        int reducedLength = quotient + remainder;
        
        ListNode[] reducedLists = new ListNode[reducedLength];
        
        for (int i = 0; i < reducedLength - remainder; i ++) {
            int list1Index = 2 * i;
            int list2Index = 2 * i + 1;
            
            reducedLists[i] = merge2List (lists[list1Index], lists[list2Index]);
            
        }
        
        if (remainder == 1) {
            reducedLists[reducedLength-1] = lists[lists.length-1];
        }
        
        return mergeKListsRec(reducedLists);
    }
    
    public ListNode merge2List (ListNode list1, ListNode list2) {
        ListNode start = null;
        ListNode end = null;
        
        if (list1 == null && list2 == null) {
            return null;
        }
        
        if (list2 == null || (list1 != null && list1.val < list2.val)) {
            start = list1;
            end = list1;
            
            list1 = list1.next;
        } else {
            start = list2;
            end = list2;
            
            list2 = list2.next;
        }
        
        while (list1 != null || list2 != null) {
            
            if (list2 == null || (list1 != null && list1.val < list2.val)) {
                end.next = list1;
                end = list1;
                
                list1 = list1.next;
            } else {
                end.next = list2;
                end = list2;
                
                list2 = list2.next;
            }
        }
        
        return start;
    }
}
