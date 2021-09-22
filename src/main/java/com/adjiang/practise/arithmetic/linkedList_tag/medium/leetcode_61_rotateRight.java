package com.adjiang.practise.arithmetic.linkedList_tag.medium;

import com.adjiang.practise.common.ListNode;

/**
 * 题目：链表向右移动k个位置
 * @author jianad001
 * @date 2021/9/17
 */
public class leetcode_61_rotateRight {

    /**
     * 思路：1、当k为0，或者是链表长度的整数时。链表保持原装态；
     * 2；k%n !=0的时候，需要先将链表成环，index =length-k%length，通过公式找到链表要断开的链接点
     *  newHead = index.next;
     *  index.next =null;
     *  return newHead;
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k==0) return head;
        ListNode tmp = head;
        //链表长度
        int lenght = 1;
        while (tmp!= null) {
            tmp = tmp.next;
            lenght++;
        }
        int index = lenght - k % lenght;
        if (index ==lenght){return head;}
        //成环
        tmp.next = head;
        //移动到链表要断开的地方
        while (index> 0) {
            head = head.next;
            index--;
        }
        ListNode   nHead = tmp.next;
        tmp.next = null;
        return nHead;
    }
}
