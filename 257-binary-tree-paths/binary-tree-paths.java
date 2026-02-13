import java.util.*;

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;

        dfs(root, "", result);
        return result;
    }

    private void dfs(TreeNode node, String path, List<String> res) {
        if (node == null) return;

        // Append current node
        if (path.isEmpty()) {
            path = Integer.toString(node.val);
        } else {
            path += "->" + node.val;
        }

        // If leaf, add path to result
        if (node.left == null && node.right == null) {
            res.add(path);
        } else {
            dfs(node.left, path, res);
            dfs(node.right, path, res);
        }
    }
}
