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
// 👍 591 👎 0

package editor.cn;

import java.util.ArrayList;
import java.util.List;

public class _94_BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new _94_BinaryTreeInorderTraversal().new Solution();
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
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
     * 方法一 莫里斯遍历
     *  时间复杂度：O（n）
     *  空间复杂度：O（n）
     */
    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            ArrayList<Integer> list = new ArrayList<>();
            if(root == null) return list;
            while (root != null){
                TreeNode childLeft = root.left;
                if(root.left != null) {
                    while (childLeft.right != null) childLeft = childLeft.right; //遍历到左子树的最右侧
                    TreeNode temp = root;
                    childLeft.right = root; //将左子树的最右侧几点指向当前节点
                    root = root.left; //开始左子树遍历
                    temp.left = null; //断链，防止第二次循环
                }else{ //到达最左侧节点
                    list.add(root.val);
                    root = root.right; //开始遍历其右侧节点
                }
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}