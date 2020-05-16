/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //leetcode 1367：二叉树中的列表
 //1. 在此处若能和链表第一个元素匹配下去。那么其左或右孩子要继续严格匹配链表接下来的元素。
// 2.无论是否能和链表的第一个元素匹配，均可在其左右孩子继续探索是否存在子路径
class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(root == null){
            return false;
        }
        return isSamePath(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    public boolean isSamePath(ListNode cur, TreeNode node){
        if(cur == null){
            return true;
        }
        if(node == null){
            return false;
        }
        if(cur.val == node.val){
            return isSamePath(cur.next, node.left) || isSamePath(cur.next, node.right);
        }
        return false;
    }
}