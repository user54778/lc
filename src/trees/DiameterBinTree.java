package trees;

public class DiameterBinTree extends TreeNode{

    private int diameter = 0;   // use a global variable diameter

    public int diameterOfBinaryTree(TreeNode root) {
        findMaxDepth(root);
        return diameter;
    }


    /**
     * Find the Max depth on our tree.
     * @param root root
     * @return diameter
     */
    private int findMaxDepth(TreeNode root) {
        if (root == null) { // height of nothing is 0
            return 0;
        }

        // dfs with postorder traversal l->ri->ro
        int leftDiameter = findMaxDepth(root.left);     // find height left subtree
        int rightDiameter = findMaxDepth(root.right);   // height right subtree

        // determine if there is a new global max
        diameter = Math.max(diameter, leftDiameter + rightDiameter);

        return Math.max(leftDiameter, rightDiameter) + 1;   // return height of tree rooted at current node
    }
}
