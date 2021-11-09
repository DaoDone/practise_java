package com.adjiang.practise.arithmetic.tree.easy;

import com.adjiang.practise.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author jianad001
 * @date 2021/10/18
 */
public class leetcode_bfs_dfs_traverse {
    /**
     * 深度优先遍历
     */
    public void dfs(TreeNode root) {
        if (root != null) {
            dfs(root.left);
            dfs(root.right);
        }
    }

    /**
     * 广度优先遍历
     * @param root
     */
    public void bfs(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }

    }
}
