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

    private static List<Node> populateListOfNodes(List<Node> nodes, HashMap<Character, Double> hashMap){
        Iterator<Entry<Character, Double>> itr = hashMap.entrySet().iterator();
        while(itr.hasNext()){
            nodes.add(new Node(itr.next()));
        }
        return nodes;
    }
    

     private static List<Node> createTree(List<Node> nodes){
        Node lowest1, lowest2;
        while (nodes.size() != 1){
            lowest1 = nodes.stream().min(Comparator.<Node>naturalOrder()).get();
            nodes.remove(lowest1);
            lowest2 = nodes.stream().min(Comparator.<Node>naturalOrder()).get();
            nodes.remove(lowest2);
            nodes.add(new Node(lowest1, lowest2));

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


        nodes = populateListOfNodes(nodes, hashMap);
//        System.out.println(hashMap.size());


        nodes = createTree(nodes);
        Node root = nodes.get(0);
        System.out.println(root);

    }


}
