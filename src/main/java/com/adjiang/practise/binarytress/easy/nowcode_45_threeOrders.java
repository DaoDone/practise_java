package com.adjiang.practise.binarytress.easy;

import com.adjiang.practise.common.TreeNode;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONWriter;

import java.util.ArrayList;
import java.util.List;

/**
 * 三种二叉树遍历前中后序遍历
 *
 * @author jianad001
 * @date 2021/10/13
 */
public class nowcode_45_threeOrders {


    public static int[][] threeOrders(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> preSubRes = new ArrayList();
        preOrder(root, preSubRes);
        res.add(preSubRes);
        List<Integer> inSubRes = new ArrayList();
        inOrder(root, inSubRes);
        res.add(inSubRes);
        List<Integer> postSubRes = new ArrayList();
        postOrder(root, postSubRes);
        res.add(postSubRes);
        int[][] ans = new int[3][];
        int i=0;
        for (List<Integer> ele: res){
            ans[i]=ele.stream().mapToInt(Integer::intValue).toArray();
            i++;
        }
        return ans;

    }

    /**
     * 前序遍历
     *
     * @param root
     * @param subRes
     */
    public static void preOrder(TreeNode root, List<Integer> subRes) {
        if (root != null) {
            subRes.add(root.val);
            preOrder(root.left, subRes);
            preOrder(root.right, subRes);
        }
    }

    /**
     * 中序遍历
     *
     * @param root
     * @param subRes
     */
    public static void inOrder(TreeNode root, List<Integer> subRes) {
        if (root != null) {
            inOrder(root.left, subRes);
            subRes.add(root.val);
            inOrder(root.right, subRes);
        }
    }

    /**
     * 后序遍历
     *
     * @param root
     * @param subRes
     */
    public static void postOrder(TreeNode root, List<Integer> subRes) {
        if (root != null) {
            postOrder(root.left, subRes);
            postOrder(root.right, subRes);
            subRes.add(root.val);
        }
    }


    public static void main(String[] args) {
        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(2);
        TreeNode root = new TreeNode(1, left, right);
        System.out.println(JSONObject.toJSON(threeOrders(root)));
    }
}
