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
// 👍 638 👎 0

package Week_01.Day05;

public class _25_ReverseNodesInKGroup {
    public static void main(String[] args) {
        _25_ReverseNodesInKGroup reverseNodesInKGroup = new _25_ReverseNodesInKGroup();
        Solution solution = reverseNodesInKGroup.new Solution();
        solution.reverseKGroup(reverseNodesInKGroup.generate(), 3);
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
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
        }
        return listNode;
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    /**
     * 方法二 迭代
     * 时间复杂度：O（n）
     * 空间复杂度：O（1）
     */
    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode pre = dummy;
            ListNode end = dummy;
            while (end.next != null) {
                //判断链表是否有K长
                for (int i = 0; i < k; i++) {
                    end = end.next;
                    if (end == null) return dummy.next;
                }

                //反转pre-end链表
                ListNode start = pre.next;
                ListNode next = end.next;
                end.next = null;
                pre.next = reverse(start);
                start.next = next;
                pre = start;
                end = pre;
            }
            return dummy.next;
        }

        private ListNode reverse(ListNode start) {
            ListNode pre = null;
            ListNode cur = start;
            while (cur != null) {
                ListNode temp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = temp;
            }
            return pre;
        }
    }
//    /**
//     * 方法一 递归
//     * 时间复杂度：O（n）
//     * 空间复杂度：O（n）
//     */
//    class Solution {
//        public ListNode reverseKGroup(ListNode head, int k) {
//            ListNode pre = head;
//            //判断链表是否有K长
//            int count = 0;
//            while (pre != null && count != k) {
//                pre = pre.next;
//                count++;
//            }
//
//            if (count == k) {
//                //下钻
//                pre = reverseKGroup(pre, k);
//                //反转
//                while (count != 0) {
//                    --count;
//                    ListNode temp = head.next;
//                    head.next = pre;
//                    pre = head;
//                    head = temp;
//                }
//                head = pre;
//            }
//            return head;
//        }
//    }
//leetcode submit region end(Prohibit modification and deletion)

}