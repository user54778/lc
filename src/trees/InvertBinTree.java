package trees;

public class InvertBinTree {
    private static class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode() {}
       TreeNode(int val) {
           this.val = val;
       }
       TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
           this.left = left;
           this.right = right;
      }
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        // swap values of left and right nodes
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    public static void main(String[] args) {
        
    }
}
