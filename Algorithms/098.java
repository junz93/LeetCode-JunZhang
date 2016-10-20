/**
 * 98. Validate Binary Search Tree
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
 * (1) The left subtree of a node contains only nodes with keys less than the node's key.
 * (2) The right subtree of a node contains only nodes with keys greater than the node's key.
 * (3) Both the left and right subtrees must also be binary search trees.
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }
    
    private boolean isValidBST(TreeNode node, TreeNode lo, TreeNode hi) {
        if(node == null)
            return true;
        if((lo!=null && node.val<=lo.val) || (hi!=null && node.val>=hi.val))
            return false;
        
        return isValidBST(node.left, lo, node) && isValidBST(node.right, node, hi);
    }
}
