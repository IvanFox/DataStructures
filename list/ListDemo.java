package dataStructures.list;

import java.util.Objects;

/**
 * Created by ivan on 24/09/15.
*/
public class ListDemo {

    public static boolean isOdd(int num){
        return num % 2 != 0;
    }


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
