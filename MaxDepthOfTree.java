import java.util.LinkedList;
import java.util.Queue;

public class MaxDepthOfTree {
    
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        
        int level = 0;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            level++;
            for(int i=0; i < queue.size(); i++) {
                TreeNode node  = queue.remove();
                if(node != null && node.left != null)
                queue.add(node.left);
                if(node != null && node.right != null)
                    queue.add(node.right);
            }
        }
        return level;
    }

    public static void main(String[] args) {
        MaxDepthOfTree sol = new MaxDepthOfTree();
        TreeNode root = new TreeNode();
        root.val = 3;
        root.left = new TreeNode();
        root.left.val = 9;
        root.right = new TreeNode();
        root.right.val = 20;
        root.right.left = new TreeNode();
        root.right.left.val = 15;
        root.right.right = new TreeNode();
        root.right.right.val = 7;
        System.out.println(sol.maxDepth(root));
    }
}
