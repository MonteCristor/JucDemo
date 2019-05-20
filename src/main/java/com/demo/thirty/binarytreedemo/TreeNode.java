package com.demo.thirty.binarytreedemo;


/**
 * @Author: sw
 * @sidereal_csday: 2019-05-20
 */

//@Data
public class TreeNode {

    //左节点
    private TreeNode leftTreeNode;
    //右节点
    private TreeNode rightTreeNode;
    //数据
    private int value;

    private boolean isDelete;

    public TreeNode() {
    }

    public TreeNode(int value) {
        this.value = value;
    }

    public TreeNode(TreeNode leftTreeNode, TreeNode rightTreeNode, int value, boolean isDelete) {
        this.leftTreeNode = leftTreeNode;
        this.rightTreeNode = rightTreeNode;
        this.value = value;
        this.isDelete = isDelete;
    }

    public TreeNode getLeftTreeNode() {
        return leftTreeNode;
    }

    public void setLeftTreeNode(TreeNode leftTreeNode) {
        this.leftTreeNode = leftTreeNode;
    }

    public TreeNode getRightTreeNode() {
        return rightTreeNode;
    }

    public void setRightTreeNode(TreeNode rightTreeNode) {
        this.rightTreeNode = rightTreeNode;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "leftTreeNode=" + leftTreeNode +
                ", rightTreeNode=" + rightTreeNode +
                ", value=" + value +
                ", isDelete=" + isDelete +
                '}';
    }
}
