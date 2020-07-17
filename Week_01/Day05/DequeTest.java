package editor.cn;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName DequeTest
 * @Description TODO
 * @Author duwanjiang
 * @Date 2020/7/17 15:44
 * Version 1.0
 **/
public class DequeTest {
    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<>();
        deque.addLast("a");
        deque.addLast("b");
        deque.addLast("c");
        deque.addLast("d");
        System.out.println(deque);

        String str = deque.peek();
        System.out.println(str);
        System.out.println(deque);

        while (deque.size() > 0) {
            System.out.println(deque.pop());
        }
        System.out.println(deque);
    }
}
