class Solution {
    int sum=0;
    public int sumNumbers(TreeNode root) {
        if(root==null)return 0;
        int a=0;
        PreOrder(root,a);
        return sum;
    }
    void PreOrder(TreeNode root, int a){
        if(root==null)return;
        a=a*10+root.val;
        if(root.left==null &&root.right==null){
            sum+=a;
        }
        PreOrder(root.left,a);
        PreOrder(root.right,a);
    }
}
