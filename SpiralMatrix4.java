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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
         int[][] matrix = new int[m][n];
        for (int[] row : matrix) {
            Arrays.fill(row, -1); 
        }
        
        if (head == null) return matrix;
        
        int top = 0, bottom = m - 1;
        int left = 0, right = n - 1;
        int direction = 0;  
        ListNode current = head;
        
        while (top <= bottom && left <= right) {
            if (direction == 0) {  
                for (int i = left; i <= right; i++) {
                    if (current != null) {
                        matrix[top][i] = current.val;
                        current = current.next;
                    }
                }
                top++;
            } else if (direction == 1) { 
                for (int i = top; i <= bottom; i++) {
                    if (current != null) {
                        matrix[i][right] = current.val;
                        current = current.next;
                    }
                }
                right--;
            } else if (direction == 2) {  
                for (int i = right; i >= left; i--) {
                    if (current != null) {
                        matrix[bottom][i] = current.val;
                        current = current.next;
                    }
                }
                bottom--;
            } else if (direction == 3) {
                for (int i = bottom; i >= top; i--) {
                    if (current != null) {
                        matrix[i][left] = current.val;
                        current = current.next;
                    }
                }
                left++;
            }
            direction = (direction + 1) % 4; 
        }
        
        return matrix;
    }
}