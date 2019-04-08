package cn.leetcode;


/**
 * Given two binary trees, write a function to check if they are the same or not.
 * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 */
public class SameTree {

    public static void main(String[] args){
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(1);

        TreeNode t2 = new TreeNode(1);
        t2.left = new TreeNode(2);
        t2.right = new TreeNode(1);

        boolean result = new SameTree().isSameTree(t1 , t2);
        System.out.println(result);
    }

    public boolean isSameTree(TreeNode p, TreeNode q){
        if(p == null || q == null){
            if(p == q){
                return true;
            }else{
                return false;
            }
        }

        if(p.val == q.val){
            if(isSameTree(p.left,q.left) && isSameTree(p.right,q.right)){
                return true;
            }
        }
        return false;
    }

}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val = val;
    }
}
