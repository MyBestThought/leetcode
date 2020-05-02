/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 /**
 *	给定一个链表，删除链表中重复的节点
 * 	输入：[1, 2, 3, 3, 2, 1]
 *	输出：[1, 2, 3]
 *
 */
class Solution {
	//方式一：借助额外空间进行判断
    public ListNode removeDuplicateNodes(ListNode head) {
        Set<Integer> set = new TreeSet<>();
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode temp = newHead;
        while(temp.next != null){
            if(!set.contains(temp.next.val)){
                set.add(temp.next.val);
                temp = temp.next;
            }else{
                temp.next = temp.next.next;
            }
        }
        return newHead.next;
    }
	//方式二：时间换空间
	public ListNode removeDuplicateNodes2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        while (pre.next != null) {
            ListNode cur = pre.next;
            while (cur.next != null) {
                if (pre.next.val == cur.next.val) {
                    cur.next = cur.next.next;
                } else {
                    cur = cur.next;
                }
            }
            pre = pre.next;
        }
        
}