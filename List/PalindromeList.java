/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 /**
 *	判断回文链表：利用快慢指针找到中间节点，然后反转后半部分链表，从首尾遍历判断是否值相等。
 *
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        ListNode pre = null;
        while(slow != null){
            ListNode next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        }
        ListNode cur = head;
        while(pre != null){
            if(pre.val != cur.val){
                return false;
            }
            pre = pre.next;
            cur = cur.next;
        }
        return true;
    }
}