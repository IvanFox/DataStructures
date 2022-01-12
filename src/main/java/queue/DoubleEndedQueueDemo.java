package queue;

/**
 * @author IvanLis
 * @version 1.0
 * @since 22/12/2015.
 * <p>
 * labs
 */
public class DoubleEndedQueueDemo {

    public static void main(String[] args) {
        DoubleEndedQueue<Integer> deq = new DoubleEndedQueue<>(5);

        deq.pushBack(2);
        deq.pushBack(3);
        deq.pushBack(4);
        deq.pushBack(5);
        deq.pushBack(6);
        deq.pushBack(7);
        deq.pushBack(8);
        deq.pushFront(9);

        while (true) {
            Integer curr = deq.popFront();
            if (curr == null)
                return;
            else
                System.out.println(curr);
        }


    }
}
