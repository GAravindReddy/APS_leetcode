import java.util.*;

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, targetSum, new ArrayList<>(), result);
        return result;
    }

    private void dfs(TreeNode node, int remaining, List<Integer> path, List<List<Integer>> res) {
        if (node == null) return;

        path.add(node.val);

        // If leaf and remaining sum matches
        if (node.left == null && node.right == null && remaining == node.val) {
            res.add(new ArrayList<>(path)); // Make a copy
        } else {
            dfs(node.left, remaining - node.val, path, res);
            dfs(node.right, remaining - node.val, path, res);
        }

        // Backtrack
        path.remove(path.size() - 1);
    }
}
