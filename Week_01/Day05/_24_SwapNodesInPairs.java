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
// 👍 551 👎 0

package editor.cn;

public class _24_SwapNodesInPairs {
    public static void main(String[] args) {
        _24_SwapNodesInPairs swapNodesInPairs = new _24_SwapNodesInPairs();
        Solution solution = swapNodesInPairs.new Solution();
        ListNode node = swapNodesInPairs.generate();
        solution.swapPairs(node);
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
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
        public ListNode swapPairs(ListNode head) {
            //终止
            if (head == null || head.next == null) return head;
            ListNode newHead = new ListNode(-1);
            newHead.next = head;
            ListNode tempNode = newHead;
            while (tempNode.next != null && tempNode.next.next != null) {
                //交换
                ListNode firstNode = tempNode.next;
                ListNode secondNode = tempNode.next.next;

                tempNode.next = secondNode; //第一层循环时，也代表newHead.next = secondNode
                firstNode.next = secondNode.next;
                secondNode.next = firstNode;

                tempNode = firstNode;
            }

            return newHead.next;
        }
    }
//    /**
//     * 方法一 递归
//     * 时间复杂度：O（n）
//     * 空间复杂度：O（n）
//     */
//    class Solution {
//        public ListNode swapPairs(ListNode head) {
//            //终止
//            if(head == null || head.next == null) return head;
//            //交换
//            ListNode firstNode = head;
//            ListNode secondNode = head.next;
//            ListNode nextNode = secondNode.next;
//            secondNode.next = firstNode;
//            //下钻保留上一层头节点
//            firstNode.next = swapPairs(nextNode);
//            return secondNode;
//        }
//    }
//leetcode submit region end(Prohibit modification and deletion)

}