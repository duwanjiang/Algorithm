//LeetCode题目: 102_二叉树的层序遍历

//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 575 👎 0

package editor.cn;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class _102_BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new _102_BinaryTreeLevelOrderTraversal().new Solution();
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    /**
     * 方法一 bfs
     * 时间复杂度：O（n）
     * 空间复杂度：O（n）
     */
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            ArrayList<List<Integer>> lists = new ArrayList<>();
            if (root == null) return lists;
            Deque<TreeNode> deque = new LinkedList<TreeNode>();
            deque.addLast(root);
            while (!deque.isEmpty()) {
                ArrayList<Integer> subList = new ArrayList<>();
                int size = deque.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = deque.pollFirst();
                    subList.add(node.val);
                    if (node.left != null) deque.addLast(node.left);
                    if (node.right != null) deque.addLast(node.right);
                }
                lists.add(subList);
            }
            return lists;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}