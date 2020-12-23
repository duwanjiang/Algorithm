//LeetCode题目: 429_N叉树的层序遍历

//给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其层序遍历: 
//
// [
//     [1],
//     [3,2,4],
//     [5,6]
//]
// 
//
// 
//
// 说明: 
//
// 
// 树的深度不会超过 1000。 
// 树的节点总数不会超过 5000。 
// Related Topics 树 广度优先搜索 
// 👍 98 👎 0

package Week_02.Day01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _429_NAryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new _429_NAryTreeLevelOrderTraversal().new Solution();
    }

    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 方法二 简化的广度优先搜索
     * 时间复杂度：O（n）
     * 空间复杂度：O（n）
     */
    class Solution {
        public List<List<Integer>> levelOrder(Node root) {
            LinkedList<List<Integer>> lists = new LinkedList<>();
            if (root == null) return lists;
            List<Node> preLayer = Arrays.asList(root);
            while (!preLayer.isEmpty()) {
                ArrayList<Node> curLayer = new ArrayList<>();
                ArrayList<Integer> valueList = new ArrayList<>();
                for (Node node : preLayer) {
                    valueList.add(node.val);
                    curLayer.addAll(node.children);
                }
                lists.add(valueList);
                preLayer = curLayer;
            }
            return lists;
        }
    }
//    /**
//     * 方法一 队列 + 迭代
//     * 时间复杂度：O（n）
//     * 空间复杂度：O（n）
//     */
//    class Solution {
//        public List<List<Integer>> levelOrder(Node root) {
//            LinkedList<List<Integer>> lists = new LinkedList<>();
//            LinkedList<Node> queue = new LinkedList();
//            if (root == null) return lists;
//            queue.addLast(root);
//            while (!queue.isEmpty()) {
//                List<Integer> level = new LinkedList<>();
//                int size = queue.size();
//                for (int i = 0; i < size; i++) {
//                    Node node = queue.pollFirst();
//                    level.add(node.val);
//                    for (Node child : node.children) {
//                        queue.addLast(child);
//                    }
//                }
//                lists.add(level);
//            }
//            return lists;
//        }
//    }
//leetcode submit region end(Prohibit modification and deletion)

}