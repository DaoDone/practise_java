package com.adjiang.practise.arithmetic;


import com.adjiang.practise.common.ListNode;

import java.util.Stack;

/**
 * diffculty:Medium
 * Related Topics 递归 链表
 *给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * @author jianad001
 * @date 2021/9/12
 */
public class leetcode_92_ReverseListII {

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode p = null;
        for (int i=1;i<left;i++){

        }







        return  null;
    }

    // 测试
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
       ListNode res = reverseBetween(n1,1,2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

}

