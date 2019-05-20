package com.demo.thirty.binarytreedemo;

import sun.reflect.generics.tree.Tree;

/**
 * @Author: sw
 * @sidereal_csday: 2019-05-20
 */
public class BinaryTree {

    //根节点
    private TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    /**
     * 插入操作
     */
    public void insert(int value) {

        TreeNode newNode = new TreeNode(value);

        if( root == null) {
            root = newNode;
            root.setLeftTreeNode(null);
            root.setRightTreeNode(null);
        } else {

            TreeNode currentNode = root;
            TreeNode parentNode;

            while (true) {

                parentNode = currentNode;
                //向右放
                if(newNode.getValue() > currentNode.getValue()) {

                    currentNode = currentNode.getRightTreeNode();

                    if (currentNode == null) {
                        parentNode.setRightTreeNode(newNode);
                        return;
                    }
                } else {
                    //往左放
                    currentNode = currentNode.getLeftTreeNode();

                    if( currentNode == null) {
                        parentNode.setLeftTreeNode(newNode);
                        return;
                    }
                }
            }
        }
    }

    /**
     * 查找
     * @param key
     * @return
     */
    public TreeNode find(int key) {

        TreeNode currentNode = root;

        if (currentNode != null) {

            while (currentNode.getValue() != key) {
                if (currentNode.getValue() > key) {
                    currentNode = currentNode.getLeftTreeNode();
                } else {
                    currentNode = currentNode.getRightTreeNode();
                }

                if (currentNode == null) {
                    return null;
                }
            }

            if (currentNode.isDelete()) {
                return null;
            } else {
                return  currentNode;
            }

        } else {
            return null;
        }
    }

    /**
     * 中序遍历
     * @param treeNode
     */
    public void inOrder(TreeNode treeNode) {

        if (treeNode != null && treeNode.isDelete() == false) {

            inOrder(treeNode.getLeftTreeNode());

            System.out.println("--" + treeNode.getValue());

            inOrder(treeNode.getRightTreeNode());
        }

    }










}
