import java.util.LinkedList;

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result =new LinkedList<>();
        generateInorderTraversal(result,root);
    }
}

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
