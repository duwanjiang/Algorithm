//LeetCode题目: 141_环形链表

//给定一个链表，判断链表中是否有环。 
//
// 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。 
//
// 
//
// 示例 1： 
//
// 输入：head = [3,2,0,-4], pos = 1
//输出：true
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 
//
// 示例 2： 
//
// 输入：head = [1,2], pos = 0
//输出：true
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 
//
// 示例 3： 
//
// 输入：head = [1], pos = -1
//输出：false
//解释：链表中没有环。
// 
//
// 
//
// 
//
// 进阶： 
//
// 你能用 O(1)（即，常量）内存解决此问题吗？ 
// Related Topics 链表 双指针 
// 👍 678 👎 0

package editor.cn;

public class _141_LinkedListCycle {
    public static void main(String[] args) {
        Solution solution = new _141_LinkedListCycle().new Solution();
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 方法一 快慢指针
     * 时间复杂度：O（n）
     * 空间复杂度：O（1）
     */
    public class Solution {
        public boolean hasCycle(ListNode head) {
            if (head == null || head.next == null) return false;
            ListNode slowNode = head;
            ListNode fastNode = head.next;
            while (slowNode != fastNode) {
                //终止条件
                if (fastNode == null || fastNode.next == null) {
                    return false;
                }
                slowNode = slowNode.next;
                fastNode = fastNode.next.next;
            }
            return true;
        }
    }
//    /**
//     * 方法一 hash
//     * 时间复杂度：O（n）
//     * 空间复杂度：O（n）
//     */
//    public class Solution {
//        public boolean hasCycle(ListNode head) {
//            if (head == null || head.next == null) return false;
//            Set<ListNode> set = new HashSet<>();
//            while (head != null){
//                if(set.contains(head)){
//                    return true;
//                }else{
//                    set.add(head);
//                }
//                head = head.next;
//            }
//            return false;
//        }
//    }
//leetcode submit region end(Prohibit modification and deletion)

}