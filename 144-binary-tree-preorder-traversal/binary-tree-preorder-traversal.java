import java.util.*;

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    private void helper(TreeNode node, List<Integer> res) {
        if (node == null) return;
        res.add(node.val);           // Visit root first
        helper(node.left, res);      // Traverse left
        helper(node.right, res);     // Traverse right
    }
}
