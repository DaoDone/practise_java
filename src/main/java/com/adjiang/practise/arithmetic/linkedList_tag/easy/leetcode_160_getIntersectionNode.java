package com.adjiang.practise.arithmetic.linkedList_tag.easy;

import com.adjiang.practise.common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 *给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 * @author jianad001
 * @date 2021/9/22
 */
public class leetcode_160_getIntersectionNode {


    /**
     * 思路：
     * eg:A {1,3,4,6,7,6}  B={6,7,6} 相交点7 ,特征相交点以及后面的元素一致
     * A =A+B;
     * B =B+A;
     * A 走完接走B 走到 B中7总共走了7
     * B 走完接走A 走到 A中7总共走了7
     * 所以当PA==PB 指针指向元素相等的时候为相交点
     * 如果没有相交点则最后指向节点就会是null,结果就会返回null
     * 时间复杂度o(m+n) 空间复杂度哦o(1)
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode lA = headA;
        ListNode lB = headB;
        while (lA != lB) {
            lA = lA == null ? headB : lA.next;
            lB = lB == null ? headA : lB.next;
        }
        return lA;
    }

    /**
     * 哈希表:
     * 空间复杂度o(m)
     * 时间复杂度o(m)<=o(x)<=o(m+n)
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNodeII(ListNode headA, ListNode headB) {
        Set<ListNode>  set = new HashSet<>();
        while (headA !=null){
            set.add(headA);
            headA =headA.next;
        }
        while (headB !=null){
            if (set.contains(headB)) return headB;
            headB =headB.next;
        }
        return null;
    }



}
