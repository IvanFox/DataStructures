package DataStructures.trees.huffman_algo;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.Map.Entry;


/**
 * Created by IvanLis on 15/11/15.
 * Student No: c00185055
 * All rights reserved
 */
public class Logic {

    private static int TOTAL_SIZE = 0; // Hold total length of a text doc

    private static HashMap<Character, Double> readFile(String filename, HashMap<Character, Double> hashMap){
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            double c, value;
            while ((c = bufferedReader.read()) != -1) {
                // if current char is not exist as a value in HashMap -> add it
                if(hashMap.get((char)c) == null) {
                    hashMap.put((char) c, Double.valueOf(1));
                }
                else { // else increment value
                    value = hashMap.get((char)c);
                    hashMap.put((char)c, ++value);
                }
                TOTAL_SIZE++;
            }
        }catch (Exception e){
        e.printStackTrace();
        }
        return hashMap;
    }

    private static HashMap<Character, Double> findOccurrence(HashMap<Character, Double> hashMap){
        for (Entry<Character, Double> entry : hashMap.entrySet()){
            Double value = entry.getValue();
            value /= TOTAL_SIZE;
            hashMap.put(entry.getKey(), value);
        }
        return hashMap;
    }

    private static Entry<Character, Double> findLowest (HashMap<Character, Double> hashMap){
        Iterator<Entry<Character, Double>> itr = hashMap.entrySet().iterator();
        Entry<Character, Double> lowest = itr.next();

        while(itr.hasNext()){
            Entry<Character, Double> current = itr.next();
            if (current.getValue() < lowest.getValue()){
                lowest = current;
            }
        }
        return lowest;
    }

    private static List<Node> populateSortedNodes (List<Node> nodes,
                                                  HashMap<Character, Double> hashMap){
        Entry<Character, Double> current;
        while (!hashMap.isEmpty()) {
            current = findLowest(hashMap);
            nodes.add(new Node(current));
            hashMap.remove(current.getKey());

        }
        return nodes;
    }



    public static void main(String[] args) {
        String filename = "/Users/IvanLis/test.txt";
        HashMap<Character, Double> hashMap = new HashMap<>();

        hashMap = readFile(filename, hashMap);
        List<Node> nodes = new ArrayList<>();


        // update hashMap
        hashMap = findOccurrence(hashMap);
        // print each element
        hashMap.forEach((k, v) -> System.out.println(k + " = " + v));


        nodes = populateSortedNodes(nodes, hashMap);
        System.out.println(hashMap.size());

        nodes.stream().forEach(node -> System.out.println(node));
    }
}
