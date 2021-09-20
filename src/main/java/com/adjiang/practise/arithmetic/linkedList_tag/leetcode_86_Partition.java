package com.adjiang.practise.arithmetic.linkedList_tag;

import com.adjiang.practise.common.ListNode;

/**
 * 题目：
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔
 *  ，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * 你应当 保留 两个分区中每个节点的初始相对位置
 * @author jianad001
 * @date 2021/9/21
 */
public class leetcode_86_Partition {

    /**
     * 将大于等于目标的值的节点分成一组链表 large
     * 将小于目标的值的节点分成一组链表 small
     * 最后拼接
     * 时间复杂度o(n) 空间o(1)
     * @param head
     * @param x
     * @return
     */
    public static ListNode partition(ListNode head, int x) {
        ListNode samll = new ListNode(-101);
        ListNode large = new ListNode(-101);
        ListNode smallHead = samll;
        ListNode largeHead = large;
        while (head != null) {
            if (head.val >= x) {
                largeHead.next = head;
                largeHead = head;
            } else {
                smallHead.next = head;
                smallHead = head;
            }
            head = head.next;
        }
        largeHead.next = null;
        smallHead.next = large.next;
        return samll.next;
    }


    public static void main(String[] args) {
        ListNode l7 =  new ListNode(2,null);
        ListNode l6 =  new ListNode(5,l7);
        ListNode l5 =  new ListNode(2,l6);
        ListNode l4 =  new ListNode(0,l5);
        ListNode l3 =  new ListNode(3,l4);
        ListNode l2 =  new ListNode(4,l3);
        ListNode l1=  new ListNode(1,l2);
        partition(l1, 3);
    }

}
