package DataStructures.trees.huffman_algo;

import java.util.HashMap;

/**
 * Created by IvanLis on 17/11/15.
 * Student No: c00185055
 * All rights reserved
 */
public class Demo {

    public static void main(String[] args) {

        Logic logic = new Logic("/Users/IvanLis/test.txt");
        logic.getHuffmanCodes().forEach((k,v) -> System.out.println("Key is: " + k  + "\tValue is: " + v));
        System.out.println();
        System.out.println(logic.generateEncodedOutput());




    }
}
