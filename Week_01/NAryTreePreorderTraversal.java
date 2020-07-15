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
// 👍 86 👎 0

package com.cloud._40_algorithm.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class NAryTreePreorderTraversal {
    public static void main(String[] args) {
        Solution solution = new NAryTreePreorderTraversal().new Solution();
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

    //leetcode submit region begin(Prohibit modification and deletion)

//    /**
//     * 方法三：使用迭代法-stack
//     */
//    class Solution {
//        public List<Integer> preorder(Node root) {
//            //栈是FILO
//            Stack<Node> stack = new Stack<>();
//            List<Integer> result = new ArrayList<>();
//            if (root == null) {
//                return result;
//            }
//            stack.add(root);
//            while (!stack.isEmpty()) {
//                //返回栈顶元素
//                Node node = stack.pop();
//                //存入结果链表中
//                result.add(node.val);
//                //倒叙遍历子节点
//                for (int i = node.children.size() - 1; i >= 0; i--) {
//                    stack.push(node.children.get(i));
//                }
//            }
//            return result;
//        }
//    }

    /**
     * 方法二：使用迭代法 - LinkedList
     */
    class Solution {
        public List<Integer> preorder(Node root) {
            LinkedList<Node> stack = new LinkedList();
            LinkedList<Integer> result = new LinkedList<>();
            if (root == null) {
                return result;
            }
            stack.add(root);
            while (!stack.isEmpty()) {
                //返回链表的最后一个元素
                Node node = stack.pollLast();
                //存入结果链表中
                result.add(node.val);
                //倒叙遍历子节点
                Collections.reverse(node.children);
//                for (Node item : node.children) {
//                    stack.add(item);
//                }
                for (int i = node.children.size() - 1; i >= 0; i--) {
                    stack.push(node.children.get(i));
                }
            }
            return result;
        }
    }

//    /**
//     * 方法一：使用递归方法-ArrayList
//     */
//    class Solution {
//        public List<Integer> preorder(Node root) {
//            List list = new ArrayList();
//            recur(root, list);
//            return list;
//        }
//
//        private void recur(Node root, List<Integer> list) {
//            if (root != null) {
//                //前序遍历为 根-左节点-右节点
//                list.add(root.val);
//                //遍历子节点
//                for (int i = 0; i < root.children.size(); i++) {
//                    recur(root.children.get(i), list);
//                }
//            }
//        }
//    }
//leetcode submit region end(Prohibit modification and deletion)

}