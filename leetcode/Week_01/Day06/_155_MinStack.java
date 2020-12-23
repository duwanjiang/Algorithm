//LeetCode题目: 155_最小栈

//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。 
//
// 
// push(x) —— 将元素 x 推入栈中。 
// pop() —— 删除栈顶的元素。 
// top() —— 获取栈顶元素。 
// getMin() —— 检索栈中的最小元素。 
// 
//
// 
//
// 示例: 
//
// 输入：
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//输出：
//[null,null,null,null,-3,null,0,-2]
//
//解释：
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
// 
//
// 
//
// 提示： 
//
// 
// pop、top 和 getMin 操作总是在 非空栈 上调用。 
// 
// Related Topics 栈 设计 
// 👍 608 👎 0

package Week_01.Day06;

import java.util.Deque;
import java.util.LinkedList;

public class _155_MinStack {
    public static void main(String[] args) {
        _155_MinStack minStack = new _155_MinStack();
        MinStack solution = minStack.new MinStack();
        solution.push(1);
        solution.push(2);
        solution.push(3);
        solution.push(1);
        solution.push(4);
        System.out.println(solution.getMin());
        solution.pop();
        solution.pop();
        System.out.println(solution.getMin());

    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 方法二 辅助栈和数据栈不同步
     * 时间复杂度：O（1）
     * 空间复杂度：O（n）
     */
    class MinStack {

        private Deque<Integer> deque;
        private Deque<Integer> minDeque;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            deque = new LinkedList<>();
            minDeque = new LinkedList<>();
        }

        public void push(int x) {
            deque.addFirst(x);
            if (minDeque.isEmpty() || minDeque.peek() >= x) {
                minDeque.addFirst(x);
            }
        }

        public void pop() {
            if (!deque.isEmpty()) {
                int top = deque.removeFirst();
                if (top == minDeque.peekFirst()) {
                    minDeque.removeFirst();
                }
            }
        }

        public int top() {
            if (deque.isEmpty()) {
                throw new RuntimeException("当前栈为空");
            }
            return deque.peekFirst();
        }

        public int getMin() {
            if (minDeque.isEmpty()) {
                throw new RuntimeException("当前栈为空");
            }
            return minDeque.peekFirst();
        }
    }
//    /**
//     * 方法一 辅助栈和数据栈同步
//     * 时间复杂度：O（1）
//     * 空间复杂度：O（n）
//     */
//    class MinStack {
//
//        private Deque<Integer> deque;
//        private Stack<Integer> minStack;
//
//        /**
//         * initialize your data structure here.
//         */
//        public MinStack() {
//            deque = new LinkedList<>();
//            minStack = new Stack<>();
//        }
//
//        public void push(int x) {
//            this.deque.addFirst(x);
//            if (!minStack.isEmpty() && minStack.peek() < x) {
//                minStack.push(minStack.peek());
//            } else {
//                minStack.push(x);
//            }
//        }
//
//        public void pop() {
//            this.deque.removeFirst();
//            this.minStack.pop();
//        }
//
//        public int top() {
//            return this.deque.peek();
//        }
//
//        public int getMin() {
//            return minStack.peek();
//        }
//    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)

}