package com.adjiang.practise.arithmetic;


import com.adjiang.practise.common.ListNode;

import java.util.Stack;

/**
 * diffculty:Easy
 * Related Topics 递归 链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * @author jianad001
 * @date 2021/9/12
 */
public class leetcode_206_ReverseList {

    /**
     * 反转链表方法一
     * 利用栈来实现反转链表
     * 核心思路见方法内部注释
     * 时间复杂度：一次入栈，一次出栈 两次遍历 O(2n)
     * stack的入栈 push{@linkplain Stack#push(Object)} 和 pop{@linkplain Stack#pop()}时间复杂度均为O(1)}
     * 空间复杂度：额外申请Stack 数据结构，stack 底层也是数组
     *
     * @param head 头部指针
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        //避免head为空，造成空栈异常
        if (stack.isEmpty()) {
            return head;
        }
        //重点：定义两指针
        ListNode newHead = stack.pop();
        ListNode node = newHead;
        /**
         *  注：犯过错，用了peek做stack的空判
         *  这里不用peek方法检查元素是不是为空，一直pop会造成stack empty
         *  peek{@linkplain Stack#peek()}适用于检查栈顶元素，如果stack为空，一样会报空栈异常
         */
        while (!stack.isEmpty()) {
            ListNode next = stack.pop();
            node.next = next;
            node = node.next;
        }
        //最后一个节点next节点要置空，不然成环，因为前面没有处理
        node.next = null;
        return newHead;
    }

    /**
     * 利用双指针思路，
     * prev比curr指针慢走一步
     * prev和curr走之前，先要将curr指针指向prev节点
     * curr每走一步，先要赋值给prev
     *
     * @param head
     * @return
     */
    public static ListNode reverseList1(ListNode head) {
        //初始化两个指针，prev指向前一个节点 curr指向当前节
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        return prev;
    }

    /**
     * 递归实现反转链表
     * 假设链表 n1 n2 n3 ......nk nk+1......nm
     * 此时已经将反转到 n1->n2->n3 ....nk->nk+1<-....nm
     * 此时节点正在nk,要让nk+1指向nk就只能是
     * nk.next.next =head
     * nk.next =null
     *
     * @param head
     * @return
     */
    public static ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode nHead = reverseList3(head.next);
        head.next.next = head;
        head.next = null;
        return nHead;
    }


    // 测试
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        ListNode res = reverseList3(n1);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

}

