class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) 
    {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(inorder, postorder, map, postorder.length - 1, 0, inorder.length - 1);
    }
    private TreeNode build(int[] inorder, int[] postorder, Map<Integer, Integer> map, int postIdx, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postIdx]);
        int inIdx = map.get(postorder[postIdx]);

        root.right = build(inorder, postorder, map, postIdx - 1, inIdx + 1, inEnd);
        root.left = build(inorder, postorder, map, postIdx - (inEnd - inIdx) - 1, inStart, inIdx - 1);

        return root;
    }
}
