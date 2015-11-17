package DataStructures.trees.huffman_algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by IvanLis on 17/11/15.
 * Student No: c00185055
 * All rights reserved
 */
public class Demo {


    public static void main(String[] args) {

        HashMap<Character, Double> hashMap = new HashMap<>();
        HashMap<Character, String> huffmanCodes = new HashMap<>();
        List<Node> nodes = new ArrayList<>();
        Logic logic = new Logic("/Users/IvanLis/test.txt");


        huffmanCodes = logic.generateCode(logic.createTree(logic.convertHashMapToList(nodes,
                logic.findOccurrence(logic.readFile(hashMap)))), huffmanCodes, "");

        huffmanCodes.forEach((k,v)-> System.out.println("Char: " + k + " - Code: " + v));




    }
}
