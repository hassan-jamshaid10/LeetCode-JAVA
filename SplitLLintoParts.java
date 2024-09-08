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
    public ListNode[] splitListToParts(ListNode head, int k) {
        
        int n = 0;
        ListNode current = head;
        while (current != null) {
            n++;
            current = current.next;
        }

        
        int baseSize = n / k;  
        int extraNodes = n % k;

        ListNode[] result = new ListNode[k];
        current = head;

        for (int i = 0; i < k; i++) {
            ListNode partHead = current;
            ListNode partTail = current;

         
            int partSize = baseSize + (extraNodes > 0 ? 1 : 0);
            extraNodes--;

           
            for (int j = 0; j < partSize - 1; j++) {
                if (partTail != null) {
                    partTail = partTail.next;
                }
            }

         
            if (partTail != null) {
                current = partTail.next;
                partTail.next = null;
            }

          
            result[i] = partHead;
        }

        return result;
    }
}