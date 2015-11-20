package dataStructures.trees.huffman_algo;


/**
 * Created by IvanLis on 17/11/15.
 * Student No: c00185055
 * All rights reserved
 */
public class Demo {

    public static void main(String[] args) throws Exception {

        Logic logic = new Logic("/Users/IvanLis/test.txt");
        logic.getHashMap().forEach((key, value) -> System.out.println("Character: " + key + "\tOccurrence: "  + value));
        logic.getHuffmanCodes().forEach((k,v) -> System.out.println("Character: " + k  + "\tCode: " + v));
        System.out.println("\nEncoded output:");
        System.out.println(logic.generateEncodedOutput());
        System.out.println("\nDecoded output");
        System.out.println(logic.decodeEncodedOutput(logic.generateEncodedOutput()));



//        StringBuilder builder = new StringBuilder();


//        System.out.println(builder.length());
//        builder.append("a");
//        System.out.println(builder.deleteCharAt(0));
//        System.out.println(builder.length());

    }
}
