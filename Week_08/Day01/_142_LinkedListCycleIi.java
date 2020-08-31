//LeetCode题目: 142_环形链表 II

//给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。 
//
// 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。 
//
// 说明：不允许修改给定的链表。 
//
// 
//
// 示例 1： 
//
// 输入：head = [3,2,0,-4], pos = 1
//输出：tail connects to node index 1
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 
//
// 示例 2： 
//
// 输入：head = [1,2], pos = 0
//输出：tail connects to node index 0
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 
//
// 示例 3： 
//
// 输入：head = [1], pos = -1
//输出：no cycle
//解释：链表中没有环。
// 
//
// 
//
// 
//
// 进阶： 
//你是否可以不用额外空间解决此题？ 
// Related Topics 链表 双指针 
// 👍 599 👎 0

package editor.cn;

public class _142_LinkedListCycleIi {
    public static void main(String[] args) {
        Solution solution = new _142_LinkedListCycleIi().new Solution();
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
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
    /**
     * 方法一  Floyd算法长短步
     * 时间复杂度：O（n）
     * 空间复杂度：O（1）
     */
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            if (head == null || head.next == null) return null;
            ListNode slowNode = head, fastNode = head;
            // 通过长短步判断是否有环
            while (true) {
                if (fastNode == null || fastNode.next == null) return null;
                slowNode = slowNode.next;
                fastNode = fastNode.next.next;
                if (slowNode == fastNode) break;
            }
            // 此时slow到环入口的步数与head到入口的步数相同
            fastNode = head;
            // 寻找入口
            while (slowNode != fastNode) {
                slowNode = slowNode.next;
                fastNode = fastNode.next;
            }
            return fastNode;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}