/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 *	链表求和：给定两个链表，对其进行求和形成一个链表。
 *	思路：利用双指针向后遍历，每次将结果进行累计直到两个指针为Null
 *
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0;
        ListNode newHead = new ListNode(0);
        ListNode cur = newHead;
        while(l1 != null || l2 != null){
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;
            sum = num1 + num2 + sum;
            cur.next = new ListNode(sum%10);
            sum /= 10;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            cur = cur.next;
        }
        if(sum == 1){
            cur.next = new ListNode(sum);
        }
        return newHead.next;
    }
}