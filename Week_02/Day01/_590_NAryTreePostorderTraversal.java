//LeetCode题目: 590_N叉树的后序遍历

//给定一个 N 叉树，返回其节点值的后序遍历。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其后序遍历: [5,6,3,2,4,1]. 
//
// 
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树 
// 👍 85 👎 0

package editor.cn;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class _590_NAryTreePostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new _590_NAryTreePostorderTraversal().new Solution();
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
     * 方法二 栈+迭代
     * 时间复杂度：O（n）
     * 空间复杂度：O（n）
     */
    class Solution {
        public List<Integer> postorder(Node root) {
            LinkedList<Integer> list = new LinkedList<>();
            Deque<Node> deque = new LinkedList<>();
            if (root == null) return list;
            deque.addLast(root);
            while (!deque.isEmpty()) {
                Node node = deque.pollLast();
                list.addFirst(node.val);
                for (Node child : node.children) {
                    if (child != null) {
                        deque.addLast(child);
                    }
                }
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
//        public List<Integer> postorder(Node root) {
//            LinkedList<Integer> list = new LinkedList<>();
//            helper(root, list);
//            return list;
//        }
//
//        private void helper(Node root, LinkedList<Integer> list) {
//            //终止条件
//            if (root != null) {
//                //下钻
//                for (Node node : root.children) {
//                    helper(node,list);
//                }
//                //添加根节点值
//                list.add(root.val);
//            }
//        }
//    }
//leetcode submit region end(Prohibit modification and deletion)

}