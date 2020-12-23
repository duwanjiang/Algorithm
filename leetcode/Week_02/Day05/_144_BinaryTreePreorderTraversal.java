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
// 👍 318 👎 0

package Week_02.Day05;

import java.util.ArrayList;
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
     * 方法三 莫里斯遍历
     * 时间复杂度：O（n）
     * 空间复杂度：O（n）
     */
    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList();
            while (root != null){
                if(root.left == null){ //到达最左边，此时输出并遍历右节点
                    list.add(root.val);
                    root = root.right;
                }else{
                    //开始处理下层节点
                    TreeNode childLeft = root.left;
                    //遍历到左子树的最右节点,且不能是当前节点，防止第二次遍历时产生循环
                    while (childLeft.right != null && childLeft.right != root) childLeft = childLeft.right;
                    if(childLeft.right == null){ //第一次到达左子树最右侧
                        list.add(root.val); //记录下根节点
                        childLeft.right = root; //让下层最右节点指向当前节点
                        root = root.left; //开始左子树遍历
                    }else{  //第二次当前左子树最右侧
                        childLeft.right = null; //断掉右侧的连接，恢复原有的树结构
                        root = root.right; //开始右子树遍历
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
//        public List<Integer> preorderTraversal(TreeNode root) {
//            List<Integer> list = new ArrayList();
//            helper(root, list);
//            return list;
//        }
//
//        private void helper(TreeNode root, List<Integer> list) {
//            if (root != null) {
//                list.add(root.val);
//                helper(root.left, list);
//                helper(root.right, list);
//            }
//        }
//    }

//    /**
//     * 方法二 迭代
//     * 时间复杂度：O（n）
//     * 空间复杂度：O（n）
//     */
//    class Solution {
//        public List<Integer> preorderTraversal(TreeNode root) {
//            List<Integer> list = new ArrayList();
//            if (root == null) return list;
//            LinkedList<TreeNode> deque = new LinkedList();
//            deque.addLast(root);
//            while (!deque.isEmpty()) {
//                TreeNode node = deque.pollLast();
//                list.add(node.val);
//                if (node.right != null) {
//                    deque.addLast(node.right);
//                }
//                if (node.left != null) {
//                    deque.addLast(node.left);
//                }
//            }
//            return list;
//        }
//    }
//leetcode submit region end(Prohibit modification and deletion)

}