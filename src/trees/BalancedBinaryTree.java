package trees;

public class BalancedBinaryTree extends TreeNode{
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;    // height = 0
        }

        // do this instead of -1 height checking
        if (root.left == null && root.right == null) {
            return true;
        }

        // recursively also check subtrees for left and right is last two edge cases
        return (Math.abs(avlCheck(root.left) - avlCheck(root.right)) <= 1)
                && isBalanced(root.left) && isBalanced(root.right);
    }

    private int avlCheck(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // basically check if it is an avl tree
        return 1 + Math.max(avlCheck(root.left), avlCheck(root.right));
    }
}
