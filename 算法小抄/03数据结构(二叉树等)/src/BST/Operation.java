package BST;


import domain.TreeNode;

public class Operation {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,null,null);
    }

    private boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if(root == null) return true;
        if(min != null && root.val <= min.val) return false;
        if(max != null && root.val >= max.val) return false;

        return isValidBST(root.left,min,root) && isValidBST(root.right, root, max);
    }


    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(root.val == key) {
            //root为叶子节点
            if(root.right == null && root.left == null) {
                root = null;
                return null;
            }
            else if(root.left!=null){
                //需要把root的右子树放到左子树的最右边
                insert(root.left,root.right);
                //返回root的左子树
                return root.left;
            }
            else {
                return root.right;
            }
        }
        if(root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        else {
            root.left = deleteNode(root.left, key);
        }
        return root;
    }
    public void insert(TreeNode root, TreeNode val) {
        if(val == null) return;
        if(root.right == null) {
            root.right = val;
            return;
        }
        insert(root.right, val);
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        if(root.val == val) return root;
        if(root.val < val) {
             root.right = insertIntoBST(root.right, val);
        }
        else {
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }
    //利用BST树性质
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return null;
        if(root.val == val) return root;
        if(root.val < val) {
            return searchBST(root.right, val);
        }
        else {
            return searchBST(root.left, val);
        }
    }


    //框架思路
    // public TreeNode searchBST(TreeNode root, int val) {
    //     if(root == null) return null;
    //     if(root.val == val) return root;
    //     TreeNode left = searchBST(root.left, val);
    //     TreeNode right = searchBST(root.right, val);
    //     return left != null? left : right;
    // }

}
