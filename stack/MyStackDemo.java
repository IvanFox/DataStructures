package DataStructures.stack;

/**
 * Created by IvanLis on 06/10/15.
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

    }

}
