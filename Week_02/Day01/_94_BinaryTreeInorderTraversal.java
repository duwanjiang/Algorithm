//LeetCode题目: 94_二叉树的中序遍历

//给定一个二叉树，返回它的中序 遍历。 
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
//输出: [1,3,2] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表 
// 👍 584 👎 0

package editor.cn;

import java.util.LinkedList;
import java.util.List;

public class _94_BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new _94_BinaryTreeInorderTraversal().new Solution();
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
     * 方法三 莫里斯遍历
     * 时间复杂度：O（n）
     * 空间复杂度：O（n）
     */
    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            LinkedList<Integer> list = new LinkedList<>();
            TreeNode pre;
            while (root != null){
                //若current没有左子节点，则依次输出右子节点值
                if (root.left == null){
                    //1、将current添加到输出
                    list.add(root.val);
                    //2、进入右子树，亦即, current = current.right
                    root = root.right;
                }else {
                    //将当前层的点下接到下一层左子节点的最右节点下，并依次往左节点下钻
                    pre = root.left;
                    //1、找到左节点的最右节点
                    while (pre.right != null){
                        pre = pre.right;
                    }
                    //2、在current的左子树中，令current成为最右侧节点的右子节点
                    pre.right = root;
                    //保留当前节点用于清除左子节点连接
                    TreeNode temp = root;
                    //3、进入左子树，亦即，current = current.left
                    root = root.left;
                    //4、清除当前节点的左子节点连接
                    temp.left = null;
                }
            }
            return list;
        }
    }
//    /**
//     * 方法二 栈+遍历
//     * 时间复杂度：O（n）
//     * 空间复杂度：O（n）
//     */
//    class Solution {
//        public List<Integer> inorderTraversal(TreeNode root) {
//            LinkedList<Integer> list = new LinkedList<>();
//            Deque<TreeNode> deque = new LinkedList<>();
//            while (root != null || !deque.isEmpty()){
//                //先依次遍历左节点，直到最底部
//                while (root != null){
//                    deque.push(root);
//                    root = root.left;
//                }
//                //再回溯栈中节点的右节点
//                root = deque.pop();
//                list.add(root.val);
//                root = root.right;
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
//        public List<Integer> inorderTraversal(TreeNode root) {
//            LinkedList<Integer> list = new LinkedList<>();
//            helper(root, list);
//            return list;
//        }
//        private void helper(TreeNode root, LinkedList<Integer> list) {
//            //终止条件
//            if (root != null) {
//                //左
//                helper(root.left, list);
//                //根
//                list.add(root.val);
//                //右
//                helper(root.right, list);
//            }
//        }
//    }
//leetcode submit region end(Prohibit modification and deletion)

}