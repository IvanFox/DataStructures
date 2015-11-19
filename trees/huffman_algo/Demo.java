package dataStructures.trees.huffman_algo;


/**
 * Created by IvanLis on 17/11/15.
 * Student No: c00185055
 * All rights reserved
 */
public class Demo {

    public static void main(String[] args) throws Exception {

        Logic logic = new Logic("/Users/IvanLis/test.txt");
        logic.getHuffmanCodes().forEach((k,v) -> System.out.println("Character: " + k  + "\tCode: " + v));
        System.out.println("\nEncoded output:");
        System.out.println(logic.generateEncodedOutput());

    }
}
