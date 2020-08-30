//LeetCode题目: 25_K 个一组翻转链表

//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。 
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 
//
// 示例： 
//
// 给你这个链表：1->2->3->4->5 
//
// 当 k = 2 时，应当返回: 2->1->4->3->5 
//
// 当 k = 3 时，应当返回: 3->2->1->4->5 
//
// 
//
// 说明： 
//
// 
// 你的算法只能使用常数的额外空间。 
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
// 
// Related Topics 链表 
// 👍 702 👎 0

package editor.cn;

public class _25_ReverseNodesInKGroup {
    public static void main(String[] args) {
        Solution solution = new _25_ReverseNodesInKGroup().new Solution();
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
    /**
     * 方法二 递归
     * 时间复杂度：O（n）
     * 空间复杂度：O（n）
     */
    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode pre = head;
            int count = 0;
            while (pre != null && count != k) { // 移动到第k个节点
                pre = pre.next;
                count++;
            }
            if (count == k) {
                // 下钻
                pre = reverseKGroup(pre, k);
                // 反转链表
                while (count != 0) {
                    count--;
                    ListNode temp = head.next;
                    head.next = pre; // pre 和 temp进行两两节点交换
                    pre = head;
                    head = temp;
                }
                head = pre; // 将新的头重新赋值给head
            }
            return head;
        }

    }
//    /**
//     * 方法一 迭代
//     * 时间复杂度：O（n）
//     * 空间复杂度：O（1）
//     */
//    class Solution {
//        public ListNode reverseKGroup(ListNode head, int k) {
//            ListNode dummy = new ListNode(-1);
//            dummy.next = head;
//            ListNode pre = dummy;
//            ListNode end = dummy;
//            while (end.next != null) {
//                // 移动end指针指向第k个节点，如果不足k个节点则退出
//                for (int i = 0; i < k; i++) {
//                    end = end.next;
//                    if (end == null) return dummy.next;
//                }
//                // 开始反转k个节点
//                ListNode start = pre.next;
//                ListNode next = end.next;
//                end.next = null;
//                pre.next = reverse(start); // 目的是让上一层的尾结点指向这一层的头节点
//                start.next = next;
//                pre = start;
//                end = pre;
//            }
//            return dummy.next;
//        }
//
//        // 翻转链表
//        private ListNode reverse(ListNode start) {
//            ListNode pre = null;
//            ListNode cur = start;
//            while (cur != null) {
//                ListNode temp = cur.next;
//                cur.next = pre;
//                pre = cur;
//                cur = temp;
//            }
//            return pre;
//        }
//    }
//leetcode submit region end(Prohibit modification and deletion)

}