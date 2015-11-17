package DataStructures.trees.huffman_algo;

import java.util.HashMap;

/**
 * Created by IvanLis on 17/11/15.
 * Student No: c00185055
 * All rights reserved
 */
public class Demo {

    public static void main(String[] args) {

        HashMap<Character, Integer> hashMap = new HashMap<>();
        HashMap<Character, String> huffmanCodes = new HashMap<>();

        Logic logic = new Logic("/Users/IvanLis/test.txt");

        huffmanCodes = logic.generateHuffmanScheme(logic.createTree(logic.convertHashMapToList(
                logic.readFile(hashMap))), huffmanCodes, "");

        huffmanCodes.forEach((k,v)-> System.out.println("Char: " + k + " - Code: " + v));
        System.out.println();
        System.out.println(logic.generateEncodedOutput(huffmanCodes));




    }
}
