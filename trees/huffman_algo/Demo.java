package dataStructures.trees.huffman_algo;

import java.util.Scanner;

/**
 * Created by IvanLis on 17/11/15.
 * Student No: c00185055
 * All rights reserved
 */
public class Demo {



    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the full file location");
        Logic logic = new Logic(scanner.nextLine());
        logic.getHashMap().forEach((key, value) -> System.out.println("Character: " + key + "\tOccurrence: "  + value));
        logic.getHuffmanCodes().forEach((k,v) -> System.out.println("Character: " + k  + "\tCode: " + v));


        System.out.println("\nEncoded output:");
        System.out.println(logic.generateEncodedOutput());
        System.out.println("\nDecoded output");
        System.out.println(logic.decodeEncodedOutput(logic.generateEncodedOutput()));


    }
}
