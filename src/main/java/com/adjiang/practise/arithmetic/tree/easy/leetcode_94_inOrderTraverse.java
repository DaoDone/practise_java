package com.adjiang.practise.arithmetic.tree.easy;

import com.adjiang.practise.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jianad001
 * @date 2021/10/18
 */
public class leetcode_94_inOrderTraverse {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inOrder(root, result);
        return result;
    }

    /**
     * 二叉树中序遍历  左节点  根节点  右节点
     * @param root
     * @param res
     */
    public void inOrder(TreeNode root, List<Integer> res) {
        if (root != null) {
            inOrder(root.left,res);
            res.add(root.val);
            inOrder(root.right,res);
        }
    }
}
