import java.util.*;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    private void helper(TreeNode node, List<Integer> res) {
        if (node == null) return;
        helper(node.left, res);  // Visit left
        res.add(node.val);       // Visit root
        helper(node.right, res); // Visit right
    }
}
