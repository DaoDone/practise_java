package com.adjiang.practise.arithmetic.linkedList_tag.medium;

import com.adjiang.practise.common.ListNode;

import java.util.Stack;

/**
 * @author jianad001
 * @date 2021/9/23
 */
public class leetcode_445_addTwoNumber {
    /**
     * 错误解法 Long长度最多64位 而node 最高等于100个
     * @param l1
     * @param l2
     * @return
     */
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        long num1 = 0, num2 = 0;
//        while (l1 != null) {
//            num1 = num1 * 10 + l1.val;
//            l1 = l1.next;
//        }
//        while (l2 != null) {
//            num2 = num2 * 10 + l2.val;
//            l2 = l2.next;
//        }
//        long sum = num1 + num2;
//        if (sum==0){
//            return new ListNode(0);
//        }
//        System.out.println(sum);
//        ListNode dummy = new ListNode(-100);
//        while (sum / 10 != 0 || sum % 10 != 0) {
//            ListNode newNode = new ListNode((int) (sum % 10));
//            newNode.next = dummy.next;
//            dummy.next = newNode;
//            sum /= 10;
//        }
//        return dummy.next;
//    }

    /**
     * 栈实现：先让两个链表入栈，然后一一弹出
     * @param l1
     * @param l2
     * @return
     */
    public static  ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        ListNode dummy = new ListNode(-100);
        boolean addOne = false;
        //只要元素不空，或者需要进一位的时候继续循环
        while (!stack1.isEmpty() || !stack2.isEmpty() || addOne) {
            int s1=0, s2=0;
            if (!stack1.isEmpty()) {
                s1 = stack1.pop();
            }
            if (!stack2.isEmpty()) {
                s2 = stack2.pop();
            }
            int tmp = s1+s2;
            if (addOne){
                tmp+=1;
            }
            addOne = tmp>=10;
            ListNode listNode = new ListNode(tmp%10);
            listNode.next = dummy.next;
            dummy.next=listNode;
        }
        return dummy.next;
    }

    // 测试
    public static void main(String[] args) {
        ListNode n1 = new ListNode(7);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;


        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(4);

        n5.next = n6;
        n6.next = n7;

        addTwoNumbers(n1,n5);
    }
}
