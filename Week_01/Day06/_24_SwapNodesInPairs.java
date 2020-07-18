//LeetCode题目: 24_两两交换链表中的节点

//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例: 
//
// 给定 1->2->3->4, 你应该返回 2->1->4->3.
// 
// Related Topics 链表 
// 👍 553 👎 0

package editor.cn;

public class _24_SwapNodesInPairs {
    public static void main(String[] args) {
        Solution solution = new _24_SwapNodesInPairs().new Solution();
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
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    /**
     * 方法三 迭代
     * 时间复杂度：O（n）
     * 空间复杂度：O（1）
     */
    class Solution {
        public ListNode swapPairs(ListNode head) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode pre = dummy;
            while (head != null && head.next != null){
                ListNode firstNode = head;
                ListNode secondNode  = head.next;
                //反转
                pre.next = secondNode;
                firstNode.next = secondNode.next;
                secondNode.next = firstNode;
                head = firstNode.next;
                pre = firstNode;
            }
            return dummy.next;
        }
    }
//    /**
//     * 方法二 迭代
//     * 时间复杂度：O（n）
//     * 空间复杂度：O（1）
//     */
//    class Solution {
//        public ListNode swapPairs(ListNode head) {
//            ListNode dimmy = new ListNode(0);
//            dimmy.next = head;
//            ListNode pre = dimmy;
//            while (pre.next != null && pre.next.next != null){
//                ListNode firstNode = pre.next;
//                ListNode secondNode  = pre.next.next;
//                //反转
//                pre.next = secondNode;
//                firstNode.next = secondNode.next;
//                secondNode.next = firstNode;
//                pre = firstNode;
//            }
//            return dimmy.next;
//        }
//    }
//    /**
//     * 方法一 递归
//     * 时间复杂度：O（n）
//     * 空间复杂度：O（n）
//     */
//    class Solution {
//        public ListNode swapPairs(ListNode head) {
//            //终止条件
//            if(head == null || head.next == null){
//                return head;
//            }
//            //反转
//            ListNode firstNode = head;
//            ListNode secondNode = head.next;
//            //下钻
//            firstNode.next = swapPairs(secondNode.next);
//            secondNode.next = firstNode;
//            return secondNode;
//        }
//    }
//leetcode submit region end(Prohibit modification and deletion)

}