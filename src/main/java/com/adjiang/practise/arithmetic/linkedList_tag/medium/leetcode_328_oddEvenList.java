package com.adjiang.practise.arithmetic.linkedList_tag.medium;

import com.adjiang.practise.common.ListNode;

/**
 * 思路：分割链表：将链表分成两条，然后再拼接
 * @author jianad001
 * @date 2021/9/22
 * 类似题目
 * {@linkplain leetcode_86_Partition#partition(ListNode, int)}
 */
public class leetcode_328_oddEvenList {
    /**
     * 思路：
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        //1、奇数用英文表示为：odd，odd的英式发音[ɒd]，美式发音[ɑ:d] 。
        //2、偶数用英文表示为：even，even的英式发音[ˈi:vn]，美式发音[ˈivən] 。
        ListNode oddHead = new ListNode(-1);
        ListNode evenHead = new ListNode(-1);
        ListNode op = oddHead;
        ListNode ep = evenHead;
        int index = 1;
        while (head != null) {
            if (index % 2 == 1) {
                op.next = head;
                op=op.next;
            } else {
                ep.next = head;
                ep=ep.next;
            }
            head = head.next;
            index++;
        }
        ep.next=null;
        op.next = evenHead.next;
        return oddHead.next;
    }
}
