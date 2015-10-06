package DataStructures.list;
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
        list.add(8);
        list.add(11);
        list.add(54);
        list.add(3232);
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(7);


        list.printElements();



        System.out.println(list.indexOf(7));
        System.out.println();

        int i = 0;
        while (i < list.getSize()){
            if (isOdd(list.get(i))){
                list.remove(i);
            }
            else{
                i++;
            }
        }

        System.out.println();
        list.printElements();


    }

}
