package stack;

/**
 * @author IvanLis
 * @version 1.0
 * @since 06/10/15.
 * <p>
 * labs
 */
public class MyStackDemo {

    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);

        for (Integer num : stack) {
            System.out.println(num);
        }

    }

}
