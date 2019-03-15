package com;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MaxDepth {

    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left=new TreeNode(2);
        head.right=new TreeNode(3);
        head.left.left=new TreeNode(4);
        head.left.right=new TreeNode(5);
        head.right.left=new TreeNode(6);
        head.right.right=new TreeNode(7);
        head.right.right.left=new TreeNode(8);
        //获得二叉树节点间的最大距离
        System.out.println(findLongest(head));
        System.out.println(getHeight(head));
        postOrder(head);

    }

    public static int findLongest(TreeNode root) {
        int[] depth = new int[1];
        return getMaxDistance(root, depth);
    }

    //递归获取两个值：一个是子树的最大深度，一个是子树的结点间最大距离。
    //其中，子树最大深度通过一个数组传引用的方式获取结果；子树的最大结点间距离则由递归函数的返回值返回
    public static int getMaxDistance(TreeNode curr,int[] depth) {
        //结点为空，则高度为0，结点最大距离为0
        if(curr == null) {
            depth[0] = 0;
            return 0;
        }
        //递归左子树获取左子树最大结点距离
        int left_child_max_distance = getMaxDistance(curr.left, depth);
        //通过数组获取左子树递归过程中统计出的子树深度
        int left_child_depth = depth[0];
        //递归右子树获取右子树最大结点距离
        int right_child_max_distance = getMaxDistance(curr.right, depth);
        //通过数组获取右子树递归过程中统计出的子树深度
        int right_child_depth = depth[0];
        //通过数组记录当前结点的高度
        depth[0] = Math.max(left_child_depth + 1, right_child_depth + 1);
        //比较 左子树最大结点距离、右子树最大结点距离、经过当前结点到达左右子树最深结点的路径距离，最大者就是当前结点为根的树的最大结点距离
        return Math.max(Math.max(left_child_max_distance, right_child_max_distance), left_child_depth + right_child_depth + 1);
    }

    public static int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return Math.max(leftHeight, rightHeight)+1;
    }

    public int TreeDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int height = 0;
        Stack<TreeNode> nodes = new Stack<>();
        Stack<Integer> tag = new Stack<>();
        while(root != null || !nodes.isEmpty()){
            while(root != null){
                nodes.push(root);
                tag.push(0);
                root = root.left;
            }
            if(tag.peek() == 1) {
                height = Math.max(height, nodes.size());
                nodes.pop();
                tag.pop();
                root = null;
            }else {
                root = nodes.peek();
                root = root.right;
                tag.pop();
                tag.push(1);
            }
        }
        return height;
    }

    public static int getHeight2(TreeNode root){
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int height = 1;
        while(!queue.isEmpty()) {
            TreeNode node = queue.peek();
            if(node.left == null && node.right == null){
                break;
            }else{
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
                queue.poll();
                height ++;
            }
        }
        return height;
    }

    public static void levelOrder(TreeNode root){
        if(root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.println(node.value);
            if(node.left != null) {
                    queue.add(node.left); }
            if(node.right != null) {
                    queue.add(node.right);
            }
        }
    }

    public static void preOrder(TreeNode root){
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while(!stack.isEmpty() || node != null) {
            if (node != null) {
                System.out.println(node.value);
                stack.push(node);
                node = node.left;
            } else {
                TreeNode node_ = stack.pop();
                node = node_.right;
            }

        }
    }

    public static void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while(!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                TreeNode node_ = stack.pop();
                System.out.println(node_.value);
                node = node_.right;
            }
        }
    }

    public static void postOrder(TreeNode root){

        Stack<TreeNode> stack = new Stack<>();
        if (root != null)
            stack.push(root);
        TreeNode pre = root;
        while(!stack.isEmpty()) {
            TreeNode cur = stack.peek();
            if (cur.right == pre || cur.left == pre || (cur.right == null && cur.left == null)) {
                System.out.println(cur.value);
                stack.pop();
                pre = cur;
            }else {
                if (cur.right != null)
                    stack.push(cur.right);
                if (cur.left != null)
                    stack.push(cur.left);
            }
        }
    }
}
