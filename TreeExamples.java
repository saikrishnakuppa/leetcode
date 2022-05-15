class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class TreeExamples {

    int max_sum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode node) {
        // Base Case
        if (node == null)
            return 0;

        // l and r store maximum path sum going through left and
        // right child of root respectively
        int l = maxPathSum(node.left);
        int r = maxPathSum(node.right);
 
        // Max path for parent call of root. This path must
        // include at-most one child of root
        int max_single = Math.max(Math.max(l, r) + node.val,
                                  node.val);
 
 
        // Max Top represents the sum when the Node under
        // consideration is the root of the maxsum path and no
        // ancestors of root are there in max sum path
        int max_top = Math.max(max_single, l + r + node.val);
 
        // Store the Maximum Result.
        max_sum = Math.max(max_sum, max_top);
 
        return max_single;
    }

    public static void main(String[] args) {
        TreeExamples sol = new TreeExamples();
        TreeNode tree = new TreeNode(-10);
        tree.left = new TreeNode(9);
        tree.right = new TreeNode(20);
        tree.right.left = new TreeNode(15);
        tree.right.right = new TreeNode(7);
        // tree.right.right = new TreeNode(-25);
        // tree.right.right.left = new TreeNode(3);
        // tree.right.right.right = new TreeNode(4);
        System.out.println("maximum path sum is : " +
                            sol.maxPathSum(tree));
    }
}
