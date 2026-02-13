import java.util.*;

class Solution {

    class NodeInfo {
        int col, row, val;
        NodeInfo(int c, int r, int v) { col = c; row = r; val = v; }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<NodeInfo> nodeList = new ArrayList<>();
        dfs(root, 0, 0, nodeList);

        // Sort by col, then row, then val
        Collections.sort(nodeList, (a, b) -> {
            if (a.col != b.col) return a.col - b.col;
            if (a.row != b.row) return a.row - b.row;
            return a.val - b.val;
        });

        List<List<Integer>> res = new ArrayList<>();
        int prevCol = Integer.MIN_VALUE;
        for (NodeInfo ni : nodeList) {
            if (ni.col != prevCol) {
                res.add(new ArrayList<>());
                prevCol = ni.col;
            }
            res.get(res.size() - 1).add(ni.val);
        }

        return res;
    }

    private void dfs(TreeNode node, int row, int col, List<NodeInfo> list) {
        if (node == null) return;
        list.add(new NodeInfo(col, row, node.val));
        dfs(node.left, row + 1, col - 1, list);
        dfs(node.right, row + 1, col + 1, list);
    }
}
