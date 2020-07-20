//LeetCode题目: 589_N叉树的前序遍历

//给定一个 N 叉树，返回其节点值的前序遍历。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其前序遍历: [1,3,5,6,2,4]。 
//
// 
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树 
// 👍 89 👎 0

package editor.cn;

import java.util.LinkedList;
import java.util.List;

public class _589_NAryTreePreorderTraversal {
    public static void main(String[] args) {
        Solution solution = new _589_NAryTreePreorderTraversal().new Solution();
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
     * 方法二 迭代+栈
     * 时间复杂度：O（n）
     * 空间复杂度：O（n）
     */
    class Solution {
        public List<Integer> preorder(Node root) {
            LinkedList<Integer> list = new LinkedList<>();
            LinkedList<Node> stack = new LinkedList<>();
            if (root == null) return list;
            stack.add(root);
            while (!stack.isEmpty()) {
                Node node = stack.pollLast();
                list.addLast(node.val);
                for (int i = node.children.size() - 1; i >= 0; i--) {
                    Node child = node.children.get(i);
                    if (child != null) {
                        stack.addLast(child);
                    }
                }
//                Collections.reverse(node.children);
//                for (Node child : node.children) {
//                    if (child != null) {
//                        stack.addLast(child);
//                    }
//                }
            }
            return list;
        }
    }
//    /**
//     * 方法一 递归
//     * 时间复杂度：O（n）
//     * 空间复杂度：O（n）
//     */
//    class Solution {
//        public List<Integer> preorder(Node root) {
//            LinkedList<Integer> list = new LinkedList<>();
//            helper(root, list);
//            return list;
//        }
//
//        private void helper(Node root, LinkedList<Integer> list) {
//            //终止条件
//            if (root != null) {
//                list.add(root.val);
//                for (Node node : root.children) {
//                    if (node != null) {
//                        helper(node, list);
//                    }
//                }
//            }
//        }
//    }
//leetcode submit region end(Prohibit modification and deletion)

}