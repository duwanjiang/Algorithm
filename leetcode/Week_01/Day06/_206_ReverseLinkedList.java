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
// 👍 1097 👎 0

package Week_01.Day06;

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
//    /**
//     * 方法二  迭代-双指针
//     * 时间复杂度：O（n）
//     * 空间复杂度：O（1）
//     */
//    class Solution {
//        public ListNode reverseList(ListNode head) {
//            ListNode pre = null;
//            while (head != null){
//                ListNode tempNode = head.next;
//                head.next = pre;
//                pre = head;
//                head = tempNode;
//            }
//            return pre;
//        }
//    }
    /**
     * 方法一  递归法
     * 时间复杂度：O（n）
     * 空间复杂度：O（n）
     */
    class Solution {
        public ListNode reverseList(ListNode head) {
            //终止条件
            if(head == null || head.next == null){
                return head;
            }
            //下钻
            ListNode newHead = reverseList(head.next);
            //反转
            head.next.next = head;
            head.next = null;
            return newHead;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}