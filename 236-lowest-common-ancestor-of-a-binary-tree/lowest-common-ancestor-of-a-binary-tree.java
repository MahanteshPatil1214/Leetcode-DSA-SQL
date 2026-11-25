class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: stop if null or if we found p or q
        if (root == null || root == p || root == q) {
            return root;
        }

        // Search left and right subtrees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If p and q are in different subtrees, current node is the LCA
        if (left != null && right != null) {
            return root;
        }

        // Otherwise, propagate the non-null child (or null if neither found)
        return left != null ? left : right;
    }
}
