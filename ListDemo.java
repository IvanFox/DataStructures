/**
 * Created by ivan on 24/09/15.
*/
public class ListDemo {

    public static boolean isOdd(int num){
        return num % 2 != 0;
    }


    public static void main(String[] args) {
        MyList<Integer> list = new MyList<>(100);

        list.add(3);
        list.add(8);
        list.add(11);
        list.add(54);
        list.add(3232);
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(7);


        list.printElements();




//        list.remove(2);
//        System.out.println();
//        list.printElements();
//        System.out.println();
//        list.add(2, 2);
//        list.printElements();
//        System.out.println();
//        list.remove(4);
//        list.printElements();
//        System.out.println(list.isEmpty());
//        System.out.println(list.indexOf(3));

        for (int i = 0; i < list.getSize(); i++) {
            if (isOdd(list.get(i))){
                list.remove(i);
            }
        }
        System.out.println();
        list.printElements();


    }

}
