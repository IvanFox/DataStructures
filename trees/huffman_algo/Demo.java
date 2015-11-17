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
        Node root;
        Logic logic = new Logic("/Users/IvanLis/test.txt");

        hashMap = logic.readFile(hashMap);
        List<Node> nodes = new ArrayList<>();


        // update hashMap
        hashMap = logic.findOccurrence(hashMap);
        // print each element
//        hashMap.forEach((k, v) -> System.out.println(k + " = " + v));

        nodes = logic.populateListOfNodes(nodes, hashMap);
        root = logic.createTree(nodes);
        huffmanCodes = logic.generateCode(root, huffmanCodes, "");

        huffmanCodes.forEach((k,v)-> System.out.println("Char: " + k + " - Code: " + v));




    }
}
