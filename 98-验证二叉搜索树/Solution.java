public class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, Integer left, Integer right) {
        if(left!=null&&root.val<=left){
            return false;
        }
        if(right!=null&&root.val>=right){
            return false;
        }
        if (root.left != null && root.right != null) {
            return isValidBST(root.left, left, root.val) && isValidBST(root.right, root.val, right);
        }else if(root.left==null&&root.right!=null){
            return isValidBST(root.right,root.val,right);
        }else if(root.right==null&&root.left!=null){
            return isValidBST(root.left,left,root.val);
        }else{
            return true;
        }
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