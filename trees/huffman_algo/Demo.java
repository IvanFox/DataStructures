package dataStructures.trees.huffman_algo;

import sun.rmi.runtime.Log;

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
        Logic.getInstance(scanner.nextLine());
        Logic.getHashMap().forEach((key, value) -> System.out.println("Character: " + key + "\tOccurrence: "  + value));
        Logic.getHuffmanCodes().forEach((k, v) -> System.out.println("Character: " + k  + "\tCode: " + v));


        System.out.println("\nEncoded output:");
        System.out.println(Logic.generateEncodedOutput());
        System.out.println("\nDecoded output");
        System.out.println(Logic.decodeEncodedOutput(Logic.generateEncodedOutput()));


    }
}
