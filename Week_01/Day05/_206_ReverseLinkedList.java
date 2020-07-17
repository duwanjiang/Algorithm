//LeetCode题目: 206_反转链表

//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表 
// 👍 1095 👎 0

package editor.cn;

public class _206_ReverseLinkedList {
    public static void main(String[] args) {
        Solution solution = new _206_ReverseLinkedList().new Solution();
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
     * 方法四 魔幻化双指针
     * 时间复杂度：O（n）
     * 空间复杂度：O（1）
     */
    class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode pre = head;
            while (head.next != null) {
                ListNode nextNode = head.next.next;
                head.next.next = pre;
                pre = head.next;
                head.next = nextNode;
            }
            return pre;
        }
    }
//    /**
//     * 方法三 迭代-双指针
//     * 时间复杂度：O（n）
//     * 空间复杂度：O（1）
//     */
//    class Solution {
//        public ListNode reverseList(ListNode head) {
//            if (head == null || head.next == null) return head;
//            ListNode newHead = null;
//            while (head != null) {
//                ListNode nextNode = head.next;
//                head.next = newHead;
//                newHead = head;
//                head = nextNode;
//            }
//            return newHead;
//        }
//    }
//    /**
//     * 方法二 迭代-双指针
//     * 时间复杂度：O（n）
//     * 空间复杂度：O（1）
//     */
//    class Solution {
//        public ListNode reverseList(ListNode head) {
//            if (head == null || head.next == null) return head;
//            ListNode cur = null, pre = head;
//            while (pre != null) {
//                ListNode nextNode = pre.next;
//                pre.next = cur;
//                cur = pre;
//                pre = nextNode;
//            }
//            return cur;
//        }
//    }
//    /**
//     * 方法一 递归
//     * 时间复杂度：O（n）
//     * 空间复杂度：O（n）
//     */
//    class Solution {
//        public ListNode reverseList(ListNode head) {
//            if(head == null || head.next == null) return head;
//            ListNode newHead = reverseList(head.next);
//            head.next.next = head;
//            head.next = null;
//            return newHead;
//        }
//    }
//leetcode submit region end(Prohibit modification and deletion)

}