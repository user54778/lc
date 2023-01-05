package trees;

public class SameTree extends TreeNode{
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q;      // return true iff both null else ret false
        }

        if (p.val == q.val) {   // traverse left and right subtrees iff both values are the same
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else {
            return false;       // cannot be valid if we make it here
        }
    }
}
