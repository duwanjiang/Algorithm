//LeetCode题目: 144_二叉树的前序遍历

//给定一个二叉树，返回它的 前序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [1,2,3]
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 313 👎 0

package editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class _144_BinaryTreePreorderTraversal {
    public static void main(String[] args) {
        Solution solution = new _144_BinaryTreePreorderTraversal().new Solution();
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
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
    /**
     * 方法四 栈(只存右子节点)+遍历
     * 时间复杂度：O（n）
     * 空间复杂度：O（n）
     */
    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> list = new LinkedList<>();
            Deque<TreeNode> stack = new ArrayDeque<>();
            TreeNode node = root;
            while (node != null || !stack.isEmpty()) {
                if (node != null) {
                    list.add(node.val);
                    if (node.right != null) stack.push(node.right);
                    node = node.left;
                } else {
                    node = stack.pop();
                }
            }
            return list;
        }
    }
//    /**
//     * 方法三 莫里斯遍历
//     * 时间复杂度：O（n）
//     * 空间复杂度：O（n）
//     */
//    class Solution {
//        public List<Integer> preorderTraversal(TreeNode root) {
//            LinkedList<Integer> list = new LinkedList<>();
//            while (root != null) {
//                //当左子节点为空时，进行有子子节点遍历
//                if(root.left == null){
//                    list.add(root.val);
//                    root = root.right;
//                }else {
//                    TreeNode preNode = root.left;
//                    while (preNode.right != null && preNode.right != root){
//                        preNode = preNode.right;
//                    }
//                    if(preNode.right == null){
//                        list.add(root.val);
//                        preNode.right = root;
//                        root = root.left;
//                    }else {
//                        preNode.right = null;
//                        root = root.right;
//                    }
//                }
//            }
//            return list;
//        }
//    }
//    /**
//     * 方法二 栈(左右子节点)+遍历
//     * 时间复杂度：O（n）
//     * 空间复杂度：O（n）
//     */
//    class Solution {
//        public List<Integer> preorderTraversal(TreeNode root) {
//            LinkedList<Integer> list = new LinkedList<>();
//            Deque<TreeNode> stack = new LinkedList<>();
//            if (root == null) return list;
//            stack.push(root);
//            while (!stack.isEmpty()) {
//                TreeNode node = stack.pop();
//                list.add(node.val);
//                if(node.right != null){
//                    stack.push(node.right);
//                }
//                if(node.left != null){
//                    stack.push(node.left);
//                }
//            }
//            return list;
//        }
//    }
//    /**
//     * 方法一 递归
//     * 时间复杂度：O（n）
//     * 空间复杂度：O（n）
//     */
//    class Solution {
//        public List<Integer> preorderTraversal(TreeNode root) {
//            ArrayList<Integer> list = new ArrayList<>();
//            helper(root, list);
//            return list;
//        }
//        private void helper(TreeNode root, ArrayList<Integer> list) {
//            //终止条件
//            if (root != null) {
//                //根
//                list.add(root.val);
//                //左
//                helper(root.left, list);
//                //右
//                helper(root.right, list);
//            }
//        }
//    }
//leetcode submit region end(Prohibit modification and deletion)

}