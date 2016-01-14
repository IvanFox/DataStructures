package dataStructures.list;


/**
 * Created by ivan on 24/09/15.
*/
public class ListDemo {



    public static void main(String[] args) {
        MyList<Integer> list = new MyList<>();

        list.add(3);
        list.add(0,4);
        list.add(8);
        list.add(11);
        list.add(54);
        list.add(3232);
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(7);


        list.forEach(System.out::println);
        System.out.println("\n************************\n");

        list.forEach(list::remove);
        System.out.println("\n************************\n");

        for (Integer num : list) {
            System.out.println(num);
        }

//        list.printElements();
//        list.set(0,5);
//        System.out.println();
//        list.printElements();
//
//        System.out.println(list.indexOf(7));
//        System.out.println();
//
//        String s = "hello";
//        String s1 = "hello";
//        System.out.println(Objects.equals(s, s1));
//
//        System.out.println();
//        list.printElements();
    }

}
