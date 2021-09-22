package com.adjiang.practise.arithmetic.linkedList_tag.medium;

import com.adjiang.practise.common.ListNode;

/**
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，
 * 请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
 * /输入：head = [1,2,3,3,4,4,5]
 * //输出：[1,2,5]
 * //
 * //
 * // 示例 2：
 * //
 * //
 * //输入：head = [1,1,1,2,3]
 * //输出：[2,3]
 * //
 * //
 * @author jianad001
 * @date 2021/9/20
 */
public class leetcode_82_DeletDuplicaties {

    /**
     * 思路：
     * <p>
     * 如果left.next.val == right.next.val 如果为true
     * 先让right一直移动，移动到最后一个重复的值的地方
     * 然后 left.next =right.next;
     *     right=right.next
     * 若不相等
     * 则left。和right同时移动一步，间距相差一
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-101, head);
        ListNode left = dummy, right = dummy.next;
        while (right != null && right.next != null) {
            if (right.next.val == left.next.val) {
                right = moveRight(right, left.next.val);
                left.next = right.next;
                right = right.next;
            } else {
                left = right;
                right = right.next;
            }
        }
        return  dummy.next;
    }

    ListNode   moveRight(ListNode right,int leftVal) {
        while (right != null && right.next != null && right.next.val == leftVal) {
            right = right.next;
        }
        return right;
    }
}
