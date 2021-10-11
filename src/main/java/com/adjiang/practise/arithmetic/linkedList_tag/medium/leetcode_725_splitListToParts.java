package com.adjiang.practise.arithmetic.linkedList_tag.medium;


//给你一个头结点为 head 的单链表和一个整数 k ，请你设计一个算法将链表分隔为 k 个连续的部分。
//
// 每部分的长度应该尽可能的相等：任意两部分的长度差距不能超过 1 。这可能会导致有些部分为 null 。
//
// 这 k 个部分应该按照在链表中出现的顺序排列，并且排在前面的部分的长度应该大于或等于排在后面的长度。
//
// 返回一个由上述 k 部分组成的数组。
//
//
// 示例 1：
//
//
//输入：head = [1,2,3], k = 5
//输出：[[1],[2],[3],[],[]]
//解释：
//第一个元素 output[0] 为 output[0].val = 1 ，output[0].next = null 。
//最后一个元素 output[4] 为 null ，但它作为 ListNode 的字符串表示是 [] 。
//

import com.adjiang.practise.common.ListNode;

/**
 * 时间复杂度 O(2n) 空间复杂度 0(k) 申请k个元素的内存
 * @author jianad001
 * @date 2021/10/11
 */
public class leetcode_725_splitListToParts {

    /**
     * 思路：
     * 1、先遍历链表得到链表长度
     * 2、确定链表元素个数,
     * 先取商表示明每条链条最少有quotient个元素
     * 再取余数表示前mod链表长度需要加1
     * i表示第几条链表，从0开始
     * partsize =quotient+(i<mod?1:0)
     * 然后让curr指针向前移动partsize-1位，切断链表
     * 完成链表切割
     * @param head
     * @param k
     * @return
     */
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode tmp = head;
        //先得到链表长度
        int length = 0;
        while (tmp != null) {
            length++;
            tmp = tmp.next;
        }
        //quotient：表明每条链条最少有quotient个元素，mod：表明前mod条链表需要多个元素
        int quotient = length / k, mod = length % k;
        ListNode[] parts = new ListNode[k];
        ListNode curr = head;
        for (int i = 0; i < k && curr != null; i++) {
            parts[i] = curr;
            //前mod个元素分别加上1，mod大于等于1是因为i是从0开始
            int partsize = quotient + (mod > i ? 1 : 0);
            //j表示要走动的步数 partsize个节点需要走动partsize-1步
            for (int j = 1; j < partsize; j++) {
                curr = curr.next;
            }
            //切断链表
            ListNode next = curr.next;
            curr.next = null;
            curr = next;
        }
        return parts;
    }
}
