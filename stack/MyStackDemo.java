package dataStructures.stack;

/**
 * @author IvanLis
 * @version 1.0
 * @since 06/10/15.
 *
 * labs
 */
public class MyStackDemo {

    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack();
        stack.push(4);
        stack.push(4);
        stack.push(4);
        stack.push(4);
        System.out.println(stack.pop());
        System.out.println(stack.getSize());

        for (Integer num : stack) {
            System.out.println(num);
        }

    }

}
