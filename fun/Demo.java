package dataStructures.fun;

/**
 * @author IvanLis
 * @version 1.0
 * @since 10/01/2016.
 * <p>
 * labs
 */
public class Demo {

    public static void main(String[] args) {
        ArrayCollection<Integer> arrayCollection = new ArrayCollection<>();

        arrayCollection.add(2);
        arrayCollection.add(1);
        arrayCollection.add(1);
        arrayCollection.add(1);
        arrayCollection.remove(2);

        for (Integer integer : arrayCollection){
            System.out.println(integer);
        }
    }
}
