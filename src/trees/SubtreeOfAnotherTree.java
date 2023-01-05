package trees;

public class SubtreeOfAnotherTree extends TreeNode {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;   // first base case
        }

        if (isSameTree(root, subRoot)) {    // validate if subtree starts with same node as root tree
            return true;
        } else {
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot); // recursively
            // traverse in preorder on the base tree
        }
    }

    /**
     * Determine if given two trees are the same
     * @param p first tree
     * @param q second tree
     * @return true iff same
     */
    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q;
        }

        if (p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else {
            return false;
        }
    }
}
