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
// 👍 541 👎 0

package editor.cn;

import java.util.HashSet;
import java.util.Set;

public class _142_LinkedListCycleIi {
    public static void main(String[] args) {
        _142_LinkedListCycleIi linkedListCycleIi = new _142_LinkedListCycleIi();

        Solution solution = linkedListCycleIi.new Solution();
        ListNode node = linkedListCycleIi.generate();
        solution.detectCycle(node);
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    private void print(ListNode node) {
        System.out.print("[");
        while (node != null) {
            System.out.print(node.val + ",");
            node = node.next;
        }
        System.out.println("]");
    }

    private ListNode generate() {
        ListNode listNode = new ListNode(1);
        ListNode temp = listNode;
        for (int i = 0; i < 7; i++) {
            temp.next = new ListNode(i + 2);
            temp = temp.next;
            if (i == 6) temp.next = listNode;
        }
        return listNode;
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
//    /**
//     * 方法二 Floyd算法
//     * 时间复杂度：O（n）
//     * 空间复杂度：O（1）
//     */
//    public class Solution {
//        public ListNode detectCycle(ListNode head) {
//            if (head == null || head.next == null) return null;
//            ListNode slowNode = head, fastNode = head;
//            while (true) {
//                if (fastNode == null || fastNode.next == null) {
//                    return null;
//                }
//                slowNode = slowNode.next;
//                fastNode = fastNode.next.next;
//                if (slowNode == fastNode) break;
//            }
//            fastNode = head;
//            while (slowNode != fastNode) {
//                slowNode = slowNode.next;
//                fastNode = fastNode.next;
//            }
//            return fastNode;
//        }
//    }

    /**
     * 方法一 hash
     * 时间复杂度：O（n）
     * 空间复杂度：O（n）
     */
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            if (head == null || head.next == null) return null;
            Set<ListNode> set = new HashSet<>();
            while (head != null) {
                if (set.contains(head)) {
                    return head;
                } else {
                    set.add(head);
                }
                head = head.next;
            }
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}