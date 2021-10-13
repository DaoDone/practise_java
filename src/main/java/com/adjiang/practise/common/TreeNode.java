package com.adjiang.practise.common;

/**
 * @author jianad001
 * @date 2021/10/13
 */
public class TreeNode {

    /**
     * 节点value
     */
    public int val = 0;
    /**
     * 左子树
     */
    public TreeNode left ;
    /**
     * 右子树
     */
    public TreeNode right ;

    public TreeNode(int val,TreeNode left,TreeNode right){
        this.val = val;
        this.left=left;
        this.right= right;
    }

    public TreeNode(int val){
        this.val = val;
    }
}
